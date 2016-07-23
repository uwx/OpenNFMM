package nfm.open.music;

import jouvieje.bass.BassInit;
import jouvieje.bass.callbacks.SYNCPROC;
import jouvieje.bass.structures.HMUSIC;
import jouvieje.bass.structures.HSTREAM;

import java.io.File;

import static jouvieje.bass.Bass.*;
import static jouvieje.bass.defines.BASS_ATTRIB.BASS_ATTRIB_VOL;
import static jouvieje.bass.defines.BASS_MUSIC.*;
import static jouvieje.bass.defines.BASS_POS.BASS_POS_BYTE;
import static jouvieje.bass.defines.BASS_SYNC.BASS_SYNC_END;
import static jouvieje.bass.defines.BASS_SYNC.BASS_SYNC_MIXTIME;
import static jouvieje.bass.examples.util.Device.forceFrequency;
import static jouvieje.bass.examples.util.Device.forceNoSoundDevice;

/**
 * RadicalBASS implementation that loads from regular files, not .zips
 *
 * @author Rafael
 * @deprecated Replaced by modern RadicalBASS.java, kept here for completion's sake
 */
@Deprecated
public class RadicalBASS_file implements RadicalMusic {

    /**
     * Displays error messages
     *
     * @param text The error message to be displayed
     */
    private static void error(final String text) {

        final int errCode = BASS_ErrorGetCode();
        final String errStr;

        if (errCode == 0) {
            errStr = "BASS_OK";
        } else if (errCode == 1) {
            errStr = "BASS_ERROR_MEM";
        } else if (errCode == 2) {
            errStr = "BASS_ERROR_FILEOPEN";
        } else if (errCode == 3) {
            errStr = "BASS_ERROR_DRIVER";
        } else if (errCode == 4) {
            errStr = "BASS_ERROR_BUFLOST";
        } else if (errCode == 5) {
            errStr = "BASS_ERROR_HANDLE";
        } else if (errCode == 6) {
            errStr = "BASS_ERROR_FORMAT";
        } else if (errCode == 7) {
            errStr = "BASS_ERROR_POSITION";
        } else if (errCode == 8) {
            errStr = "BASS_ERROR_INIT";
        } else if (errCode == 9) {
            errStr = "BASS_ERROR_START";
        } else if (errCode == 10) {
            errStr = "BASS_ERROR_SSL";
        } else if (errCode == 14) {
            errStr = "BASS_ERROR_ALREADY";
        } else if (errCode == 18) {
            errStr = "BASS_ERROR_NOCHAN";
        } else if (errCode == 19) {
            errStr = "BASS_ERROR_ILLTYPE";
        } else if (errCode == 20) {
            errStr = "BASS_ERROR_ILLPARAM";
        } else if (errCode == 21) {
            errStr = "BASS_ERROR_NO3D";
        } else if (errCode == 22) {
            errStr = "BASS_ERROR_NOEAX";
        } else if (errCode == 23) {
            errStr = "BASS_ERROR_DEVICE";
        } else if (errCode == 24) {
            errStr = "BASS_ERROR_NOPLAY";
        } else if (errCode == 25) {
            errStr = "BASS_ERROR_FREQ";
        } else if (errCode == 27) {
            errStr = "BASS_ERROR_NOTFILE";
        } else if (errCode == 29) {
            errStr = "BASS_ERROR_NOHW";
        } else if (errCode == 31) {
            errStr = "BASS_ERROR_EMPTY";
        } else if (errCode == 32) {
            errStr = "BASS_ERROR_NONET";
        } else if (errCode == 33) {
            errStr = "BASS_ERROR_CREATE";
        } else if (errCode == 34) {
            errStr = "BASS_ERROR_NOFX";
        } else if (errCode == 37) {
            errStr = "BASS_ERROR_NOTAVAIL";
        } else if (errCode == 38) {
            errStr = "BASS_ERROR_DECODE";
        } else if (errCode == 39) {
            errStr = "BASS_ERROR_DX";
        } else if (errCode == 40) {
            errStr = "BASS_ERROR_TIMEOUT";
        } else if (errCode == 41) {
            errStr = "BASS_ERROR_FILEFORM";
        } else if (errCode == 42) {
            errStr = "BASS_ERROR_SPEAKER";
        } else if (errCode == 43) {
            errStr = "BASS_ERROR_VERSION";
        } else if (errCode == 44) {
            errStr = "BASS_ERROR_CODEC";
        } else if (errCode == 45) {
            errStr = "BASS_ERROR_ENDED";
        } else if (errCode == 46) {
            errStr = "BASS_ERROR_BUSY";
        } else if (errCode == -1) {
            errStr = "BASS_ERROR_UNKNOWN";
        } else {
            errStr = "Unknown error";
        }

        System.err.println("BASS error: " + text + "\nError code: " + errCode + "\nError data: " + errStr);
    }

    /**
     * Prints a formatted message then ends playback
     *
     * @param format String to be formatted
     * @param args   Formatting arguments
     */
    private void printfExit(final String format, final Object... args) {
        System.out.println(String.format(format, args));
        end();
    }

    private static final boolean init = false;
    private boolean deinit = false;

    /**
     * The channel that NativeBASS will play to
     */
    private int chan;

    /**
     * Prevents BASS_Free errors
     */
    private static boolean bassLibLoaded = false;

    /**
     * Looping sync
     */
    private static final SYNCPROC loopSyncProc = (handle, channel, data, user) -> {
        BASS_ChannelSetPosition(channel, 0, BASS_POS_BYTE); //Go to start of file
    };

    /**
     * Load the media file
     */
    private void run() {
        System.out.println("BASS init state: " + init);
        System.out.println("BASS loaded: " + bassLibLoaded);

        if (!init)
            return;

        if (bassLibLoaded) {
            /* The device has already been initialized. BASS_Free must be called before it can be initialized again. */
            freeResources();
        }

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
        bassLibLoaded = true;

        if (!playFile()) {
            //Start a file playing
            end();
        }
    }

    /**
     * Begins playback
     *
     * @return false if the file can't be played to the channel, true otherwise
     */
    private boolean playFile() {
        final HSTREAM stream = BASS_StreamCreateFile(false, file.getPath(), 0, 0, 0);
        if (stream == null) {
            error("Can't play file");
            return false; // Can't load the file
        }

        final HMUSIC music = BASS_MusicLoad(false, file.getPath(), 0, 0, BASS_MUSIC_RAMPS | BASS_MUSIC_POSRESET | BASS_MUSIC_PRESCAN, 0);
        if (music == null) {
            error("Can't play file");
            return false; // Can't load the file
        }

        chan = stream != null ? stream.asInt() : music != null ? music.asInt() : 0;

        BASS_ChannelSetAttribute(chan, BASS_ATTRIB_VOL, 0.8F);

        BASS_ChannelSetSync(chan, BASS_SYNC_END | BASS_SYNC_MIXTIME, 0, loopSyncProc, null); //Set sync to loop at end
        BASS_ChannelPlay(chan, false); //Start playing
        return true;
    }

    public boolean isRunning() {
        return deinit;
    }

    private void end() {
        if (!init || deinit)
            return;
        deinit = true;

        freeResources();
    }

    private void freeResources() {
        BASS_Free();
        bassLibLoaded = false;
    }

    /* Graphical stuff */

    private final File file;
    private boolean started = false;
    private final boolean paused = false;

    /**
     * Constructs a new RadicalBASS
     *
     * @param songFile a media file supported by BASS
     */
    public RadicalBASS_file(final File songFile) {
        file = songFile;
        //run();
    }

    @Override
    public Type getType() {
        return Type.TYPE_BASS;
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
