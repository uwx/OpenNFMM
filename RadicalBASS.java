
import static jouvieje.bass.Bass.BASS_ChannelPlay;
import static jouvieje.bass.Bass.BASS_ChannelSetPosition;
import static jouvieje.bass.Bass.BASS_ChannelSetSync;
import static jouvieje.bass.Bass.BASS_Free;
import static jouvieje.bass.Bass.BASS_GetVersion;
import static jouvieje.bass.Bass.BASS_Init;
import static jouvieje.bass.Bass.BASS_MusicLoad;
import static jouvieje.bass.Bass.BASS_Pause;
import static jouvieje.bass.Bass.BASS_SetVolume;
import static jouvieje.bass.Bass.BASS_Start;
import static jouvieje.bass.Bass.BASS_StreamCreateFile;
import static jouvieje.bass.defines.BASS_MUSIC.BASS_MUSIC_POSRESET;
import static jouvieje.bass.defines.BASS_MUSIC.BASS_MUSIC_PRESCAN;
import static jouvieje.bass.defines.BASS_MUSIC.BASS_MUSIC_RAMPS;
import static jouvieje.bass.defines.BASS_POS.BASS_POS_BYTE;
import static jouvieje.bass.defines.BASS_SYNC.BASS_SYNC_END;
import static jouvieje.bass.defines.BASS_SYNC.BASS_SYNC_MIXTIME;
import static jouvieje.bass.examples.util.Device.forceFrequency;
import static jouvieje.bass.examples.util.Device.forceNoSoundDevice;

import java.io.File;

import jouvieje.bass.BassInit;
import jouvieje.bass.callbacks.SYNCPROC;
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
        final String s = String.format(format, args);
        System.out.println(s);
        end();
    }

    static boolean init = false;
    private boolean deinit = false;

    //private final int WIDTH = 600; //Display width
    //private final int HEIGHT = 201; //Height (odd number for centre line)

    private int chan;
    //private long bpp; //Bytes per pixel
    private final long[] loop = new long[2]; //Loop start & end
    //private HSYNC lsync; //Looping sync

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

        BASS_SetVolume(0.1F);
        //Set update timer (10hz)
        //timer.start();
    }

    private boolean playFile() {
        HSTREAM stream = null;
        HMUSIC music = null;

        if ((stream = BASS_StreamCreateFile(false, file.getPath(), 0, 0, 0)) == null && (music = BASS_MusicLoad(false, file.getPath(), 0, 0, BASS_MUSIC_RAMPS | BASS_MUSIC_POSRESET | BASS_MUSIC_PRESCAN, 0)) == null) {
            error("Can't play file");
            return false; // Can't load the file
        }

        chan = stream != null ? stream.asInt() : music != null ? music.asInt() : 0;

        /*bpp = (int) (BASS_ChannelGetLength(chan, BASS_POS_BYTE) / WIDTH); //Bytes per pixel
        if (bpp < BASS_ChannelSeconds2Bytes(chan, 0.02f)) { //Minimum 20ms per pixel (BASS_ChannelGetLevel scans 20ms)
            bpp = (int) BASS_ChannelSeconds2Bytes(chan, 0.02f);
        }*/
        BASS_ChannelSetSync(chan, BASS_SYNC_END | BASS_SYNC_MIXTIME, 0, loopSyncProc, null); //Set sync to loop at end
        BASS_ChannelPlay(chan, false); //Start playing
        return true;
    }

    public boolean isRunning() {
        return deinit;
    }

    public void end() {
        if (!init || deinit)
            return;
        deinit = true;

        BASS_Free();
    }

    /* Graphical stuff */

    private final File file;
    private boolean started = false;
    private final boolean paused = false;

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
        if (pause) {
            stop();
        } else {
            resume();
        }

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
