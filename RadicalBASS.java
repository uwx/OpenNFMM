
import static jouvieje.bass.Bass.BASS_ChannelGetLength;
import static jouvieje.bass.Bass.BASS_ChannelGetLevel;
import static jouvieje.bass.Bass.BASS_ChannelGetPosition;
import static jouvieje.bass.Bass.BASS_ChannelIsActive;
import static jouvieje.bass.Bass.BASS_ChannelPlay;
import static jouvieje.bass.Bass.BASS_ChannelSeconds2Bytes;
import static jouvieje.bass.Bass.BASS_ChannelSetPosition;
import static jouvieje.bass.Bass.BASS_ChannelSetSync;
import static jouvieje.bass.Bass.BASS_Free;
import static jouvieje.bass.Bass.BASS_GetVersion;
import static jouvieje.bass.Bass.BASS_Init;
import static jouvieje.bass.Bass.BASS_MusicFree;
import static jouvieje.bass.Bass.BASS_MusicLoad;
import static jouvieje.bass.Bass.BASS_Pause;
import static jouvieje.bass.Bass.BASS_Start;
import static jouvieje.bass.Bass.BASS_StreamCreateFile;
import static jouvieje.bass.Bass.BASS_StreamFree;
import static jouvieje.bass.defines.BASS_ACTIVE.BASS_ACTIVE_STOPPED;
import static jouvieje.bass.defines.BASS_MUSIC.BASS_MUSIC_DECODE;
import static jouvieje.bass.defines.BASS_MUSIC.BASS_MUSIC_POSRESET;
import static jouvieje.bass.defines.BASS_MUSIC.BASS_MUSIC_PRESCAN;
import static jouvieje.bass.defines.BASS_MUSIC.BASS_MUSIC_RAMPS;
import static jouvieje.bass.defines.BASS_POS.BASS_POS_BYTE;
import static jouvieje.bass.defines.BASS_STREAM.BASS_STREAM_DECODE;
import static jouvieje.bass.defines.BASS_SYNC.BASS_SYNC_END;
import static jouvieje.bass.defines.BASS_SYNC.BASS_SYNC_MIXTIME;
import static jouvieje.bass.examples.util.Device.forceFrequency;
import static jouvieje.bass.examples.util.Device.forceNoSoundDevice;

import java.awt.image.BufferedImage;
import java.io.File;
import java.lang.reflect.Field;

import jouvieje.bass.BassInit;
import jouvieje.bass.callbacks.SYNCPROC;
import jouvieje.bass.exceptions.BassException;
import jouvieje.bass.structures.HMUSIC;
import jouvieje.bass.structures.HSTREAM;
import jouvieje.bass.structures.HSYNC;
import jouvieje.bass.utils.Pointer;

class RadicalBASS implements RadicalMusic {

    /* display error messages */
    private final void error(final String text) {
        System.err.println("RadicalBASS error: " + text);
    }

    private final void printfExit(final String format, final Object... args) {
        String s = String.format(format, args);
        System.out.println(s);
        end();
    }

    static boolean init = false;
    private boolean deinit = false;

    private final int WIDTH = 600; //Display width
    private final int HEIGHT = 201; //Height (odd number for centre line)

    private Thread scan = null;
    private boolean killScan = false;

    private int chan;
    private long bpp; //Bytes per pixel
    private final long[] loop = new long[2]; //Loop start & end
    private HSYNC lsync; //Looping sync

    private BufferedImage wavebuf = null;

    private final SYNCPROC loopSyncProc = new SYNCPROC() {
        @Override
        public void SYNCPROC(final HSYNC handle, final int channel, final int data, final Pointer user) {
            if (!BASS_ChannelSetPosition(channel, loop[0], BASS_POS_BYTE)) { //Try seeking to loop start
                BASS_ChannelSetPosition(channel, 0, BASS_POS_BYTE); //Failed, go to start of file instead
            }
        }
    };

    public void run() {
        if (!init)
            return;

        // check the correct BASS was loaded
        if ((BASS_GetVersion() & 0xFFFF0000) >> 16 != BassInit.BASSVERSION()) {
            printfExit("An incorrect version of BASS.DLL was loaded");
            return;
        }

        //Initialize BASS
        if (!BASS_Init(forceNoSoundDevice(-1), forceFrequency(44100), 0, null, null)) {
            error("Can't initialize device");
            end();
        }
        if (!playFile()) {
            //Start a file playing
            end();
        }
        //Set update timer (10hz)
        //timer.start();
    }

    private boolean playFile() {
        //int result = getFileChooser().showOpenDialog(CustLoop.this);
        /*if(result != JFileChooser.APPROVE_OPTION) {
            return false;
        }*/

        HSTREAM stream = null;
        HMUSIC music = null;

        //String file = getFileChooser().getSelectedFile().getPath();
        if ((stream = BASS_StreamCreateFile(false, file.getPath(), 0, 0, 0)) == null && (music = BASS_MusicLoad(false, file.getPath(), 0, 0, BASS_MUSIC_RAMPS | BASS_MUSIC_POSRESET | BASS_MUSIC_PRESCAN, 0)) == null) {
            error("Can't play file");
            return false; // Can't load the file
        }

        chan = stream != null ? stream.asInt() : music != null ? music.asInt() : 0;

        bpp = (int) (BASS_ChannelGetLength(chan, BASS_POS_BYTE) / WIDTH); //Bytes per pixel
        if (bpp < BASS_ChannelSeconds2Bytes(chan, 0.02f)) { //Minimum 20ms per pixel (BASS_ChannelGetLevel scans 20ms)
            bpp = (int) BASS_ChannelSeconds2Bytes(chan, 0.02f);
        }
        BASS_ChannelSetSync(chan, BASS_SYNC_END | BASS_SYNC_MIXTIME, 0, loopSyncProc, null); //Set sync to loop at end
        BASS_ChannelPlay(chan, false); //Start playing

        /*
         * Jouvieje note:
         * Open a second time the music and scan it
         */
        {
            final HSTREAM stream2;
            final HMUSIC music2;

            stream2 = BASS_StreamCreateFile(false, file.getPath(), 0, 0, BASS_STREAM_DECODE);
            if (stream2 == null) {
                music2 = BASS_MusicLoad(false, file.getPath(), 0, 0, BASS_MUSIC_DECODE, 0);
            } else {
                music2 = null;
            }

            final int chan2 = stream2 != null ? stream2.asInt() : music2 != null ? music2.asInt() : 0;

            scan = new Thread() {
                @Override
                public void run() {
                    int cpos = 0;
                    final long[] peak = new long[2];
                    wavebuf = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

                    while (!killScan) {
                        final long level = BASS_ChannelGetLevel(chan2); //Scan peaks

                        int pos = (int) (BASS_ChannelGetPosition(chan2, BASS_POS_BYTE) / bpp);
                        if (peak[0] < (level & 0x0000FFFF)) {
                            peak[0] = level & 0x0000FFFF; //Set left peak
                        }
                        if (peak[1] < (level & 0xFFFF0000) >> 16) {
                            peak[1] = (level & 0xFFFF0000) >> 16; //Set right peak
                        }
                        if (BASS_ChannelIsActive(chan2) == BASS_ACTIVE_STOPPED) {
                            pos = -1; //Reached the end
                        }
                        /*else
                            pos = (int)(BASS_ChannelGetPosition(chan2, BASS_POS_BYTE) / bpp);*/

                        if (pos > cpos) {
                            for (int a = 0; a < peak[0] * (HEIGHT / 2) / 32768; a++) {
                                wavebuf.setRGB(cpos, HEIGHT / 2 - 1 - a, getIndexColor(1 + a)); //Draw left peak
                            }
                            for (int a = 0; a < peak[1] * (HEIGHT / 2) / 32768; a++) {
                                wavebuf.setRGB(cpos, HEIGHT / 2 + 1 + a, getIndexColor(1 + a)); //Draw right peak
                            }
                            if (pos >= WIDTH) {
                                break; //Gone off end of display
                            }
                            cpos = pos;
                            peak[0] = peak[1] = 0;
                        }
                    }
                    BASS_StreamFree(stream2); //Free the decoder
                    BASS_MusicFree(music2); //Jouvieje note: Missing line from c example ?
                }
            };
            scan.start();
        }
        return true;
    }

    public boolean isRunning() {
        return deinit;
    }

    public void end() {
        if (!init || deinit)
            return;
        deinit = true;

        //timer.stop();
        if (scan != null && scan.isAlive()) {
            killScan = true;
            while (scan.isAlive()) {
                try {
                    Thread.sleep(5);
                } catch (final InterruptedException e) {
                }
            }
        }
        BASS_Free();
    }

    private int getIndexColor(final int index) {
        if (index == 0)
            return 0;
        final int r = 255 * index / (HEIGHT / 2);
        return (r << 16) + (255 - r << 8);
    }

    /* Graphical stuff */

    private final File file;
    private boolean started = false;
    private boolean paused = false;

    public RadicalBASS(final File songFile) {
        file = songFile;
        //run();
    }

    @Override
    public int getType() {
        return TYPE_BASS;
    }

    @Override
    public void resume() {
        play();
    }

    @Override
    public void unload() {
        end();
    }

    @Override
    public void play() {
        if (started) {
            /* Resume output */
            BASS_Start();
        } else {
            run();
            started = true;
        }
    }

    @Override
    public void setPaused(final boolean pause) {
        if (pause)
            resume();
        else
            stop();

    }

    @Override
    public boolean isPaused() {
        return paused;
    }

    @Override
    public void stop() {
        /* Pause output */
        BASS_Pause();
    }

    /*private JFileChooser getFileChooser() {
        if(fileChooser == null) {
            fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("."));
            fileChooser.setMultiSelectionEnabled(false);
            fileChooser.resetChoosableFileFilters();
            //fileChooser.addChoosableFileFilter(FileFilters.allFiles);
            //fileChooser.addChoosableFileFilter(FileFilters.playableFiles);
            fileChooser.setDialogTitle("Open a music");
        }
        return fileChooser;
    }*/

}
