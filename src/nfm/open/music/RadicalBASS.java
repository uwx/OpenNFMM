package nfm.open.music;

import jouvieje.bass.BassInit;
import jouvieje.bass.BassUtils;
import jouvieje.bass.callbacks.SYNCPROC;
import jouvieje.bass.structures.HMUSIC;
import jouvieje.bass.structures.HSTREAM;
import nfm.open.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static jouvieje.bass.Bass.*;
import static jouvieje.bass.defines.BASS_ATTRIB.BASS_ATTRIB_VOL;
import static jouvieje.bass.defines.BASS_MUSIC.*;
import static jouvieje.bass.defines.BASS_POS.BASS_POS_BYTE;
import static jouvieje.bass.defines.BASS_SYNC.BASS_SYNC_END;
import static jouvieje.bass.defines.BASS_SYNC.BASS_SYNC_MIXTIME;
import static jouvieje.bass.examples.util.Device.forceFrequency;
import static jouvieje.bass.examples.util.Device.forceNoSoundDevice;

public class RadicalBASS implements RadicalMusic {

    /**
     * Displays error messages
     *
     * @param text The error message to be displayed
     */
    public static void error(final String text) {

        final int errCode = BASS_ErrorGetCode();
        final String errStr;
        final String errDesc;

        if (errCode == 0) {
            errStr = "BASS_OK";
            errDesc = "All is OK";
        } else if (errCode == 1) {
            errStr = "BASS_ERROR_MEM";
            errDesc = "Memory error";
        } else if (errCode == 2) {
            errStr = "BASS_ERROR_FILEOPEN";
            errDesc = "Can't open the file";
        } else if (errCode == 3) {
            errStr = "BASS_ERROR_DRIVER";
            errDesc = "Can't find a free/valid driver";
        } else if (errCode == 4) {
            errStr = "BASS_ERROR_BUFLOST";
            errDesc = "The sample buffer was lost";
        } else if (errCode == 5) {
            errStr = "BASS_ERROR_HANDLE";
            errDesc = "Invalid handle";
        } else if (errCode == 6) {
            errStr = "BASS_ERROR_FORMAT";
            errDesc = "Unsupported sample format";
        } else if (errCode == 7) {
            errStr = "BASS_ERROR_POSITION";
            errDesc = "Invalid playback position";
        } else if (errCode == 8) {
            errStr = "BASS_ERROR_INIT";
            errDesc = "BASS_Init has not been successfully called";
        } else if (errCode == 9) {
            errStr = "BASS_ERROR_START";
            errDesc = "BASS_Start has not been successfully called";
        } else if (errCode == 12) {
            errStr = "BASS_ERROR_NOCD";
            errDesc = "No CD in drive";
        } else if (errCode == 13) {
            errStr = "BASS_ERROR_CDTRACK";
            errDesc = "Invalid track number";
        } else if (errCode == 14) {
            errStr = "BASS_ERROR_ALREADY";
            errDesc = "Already initialized/paused/whatever";
        } else if (errCode == 16) {
            errStr = "BASS_ERROR_NOPAUSE";
            errDesc = "Not paused";
        } else if (errCode == 17) {
            errStr = "BASS_ERROR_NOTAUDIO";
            errDesc = "Not an audio track";
        } else if (errCode == 18) {
            errStr = "BASS_ERROR_NOCHAN";
            errDesc = "Can't get a free channel";
        } else if (errCode == 19) {
            errStr = "BASS_ERROR_ILLTYPE";
            errDesc = "An illegal type was specified";
        } else if (errCode == 20) {
            errStr = "BASS_ERROR_ILLPARAM";
            errDesc = "An illegal parameter was specified";
        } else if (errCode == 21) {
            errStr = "BASS_ERROR_NO3D";
            errDesc = "No 3D support";
        } else if (errCode == 22) {
            errStr = "BASS_ERROR_NOEAX";
            errDesc = "No EAX support";
        } else if (errCode == 23) {
            errStr = "BASS_ERROR_DEVICE";
            errDesc = "Illegal device number";
        } else if (errCode == 24) {
            errStr = "BASS_ERROR_NOPLAY";
            errDesc = "Not playing";
        } else if (errCode == 25) {
            errStr = "BASS_ERROR_FREQ";
            errDesc = "Illegal sample rate";
        } else if (errCode == 27) {
            errStr = "BASS_ERROR_NOTFILE";
            errDesc = "The stream is not a file stream";
        } else if (errCode == 29) {
            errStr = "BASS_ERROR_NOHW";
            errDesc = "No hardware voices available";
        } else if (errCode == 31) {
            errStr = "BASS_ERROR_EMPTY";
            errDesc = "The MOD music has no sequence data";
        } else if (errCode == 32) {
            errStr = "BASS_ERROR_NONET";
            errDesc = "No internet connection could be opened";
        } else if (errCode == 33) {
            errStr = "BASS_ERROR_CREATE";
            errDesc = "Couldn't create the file";
        } else if (errCode == 34) {
            errStr = "BASS_ERROR_NOFX";
            errDesc = "Effects are not available";
        } else if (errCode == 35) {
            errStr = "BASS_ERROR_PLAYING";
            errDesc = "The channel is playing";
        } else if (errCode == 37) {
            errStr = "BASS_ERROR_NOTAVAIL";
            errDesc = "Requested data is not available";
        } else if (errCode == 38) {
            errStr = "BASS_ERROR_DECODE";
            errDesc = "The channel is a 'decoding channel'";
        } else if (errCode == 39) {
            errStr = "BASS_ERROR_DX";
            errDesc = "A sufficient DirectX version is not installed";
        } else if (errCode == 40) {
            errStr = "BASS_ERROR_TIMEOUT";
            errDesc = "Connection timedout";
        } else if (errCode == 41) {
            errStr = "BASS_ERROR_FILEFORM";
            errDesc = "Unsupported file format";
        } else if (errCode == 42) {
            errStr = "BASS_ERROR_SPEAKER";
            errDesc = "Unavailable speaker";
        } else if (errCode == 43) {
            errStr = "BASS_ERROR_VERSION";
            errDesc = "Invalid BASS version (used by add-ons)";
        } else if (errCode == 44) {
            errStr = "BASS_ERROR_CODEC";
            errDesc = "Codec is not available/supported";
        } else if (errCode == 45) {
            errStr = "BASS_ERROR_ENDED";
            errDesc = "The channel/file has ended";
        } else if (errCode == 46) {
            errStr = "BASS_ERROR_BUSY";
            errDesc = "The device is busy (eg. in \"exclusive\" use by another process)";
        } else if (errCode == -1) {
            errStr = "BASS_ERROR_UNKNOWN";
            errDesc = "Some other mystery error";
        } else if (errCode == 1000) {
            errStr = "BASS_ERROR_WMA_LICENSE";
            errDesc = "BassWma: the file is protected";
        } else if (errCode == 1001) {
            errStr = "BASS_ERROR_WMA_WM9";
            errDesc = "BassWma: WM9 is required";
        } else if (errCode == 1002) {
            errStr = "BASS_ERROR_WMA_DENIED";
            errDesc = "BassWma: access denied (user/pass is invalid)";
        } else if (errCode == 1003) {
            errStr = "BASS_ERROR_WMA_CODEC";
            errDesc = "BassWma: no appropriate codec is installed";
        } else if (errCode == 1004) {
            errStr = "BASS_ERROR_WMA_INDIVIDUAL";
            errDesc = "BassWma: individualization is needed";
        } else if (errCode == 2000) {
            errStr = "BASS_ERROR_ACM_CANCEL";
            errDesc = "BassEnc: ACM codec selection cancelled";
        } else if (errCode == 2100) {
            errStr = "BASS_ERROR_CAST_DENIED";
            errDesc = "BassEnc: Access denied (invalid password)";
        } else if (errCode == 3000) {
            errStr = "BASS_VST_ERROR_NOINPUTS";
            errDesc = "BassVst: the given effect has no inputs and is probably a VST instrument and no effect";
        } else if (errCode == 3001) {
            errStr = "BASS_VST_ERROR_NOOUTPUTS";
            errDesc = "BassVst: the given effect has no outputs";
        } else if (errCode == 3002) {
            errStr = "BASS_VST_ERROR_NOREALTIME";
            errDesc = "BassVst: the given effect does not support realtime processing";
        } else if (errCode == 5000) {
            errStr = "BASS_ERROR_WASAPI";
            errDesc = "BASSWASAPI: no WASAPI available";
        } else if (errCode == 6000) {
            errStr = "BASS_ERROR_MP4_NOSTREAM";
            errDesc = "BASS_AAC: non-streamable due to MP4 atom order ('mdat' before 'moov') ";
        } else {
            errStr = "<Unknown>";
            errDesc = "No info available";
        }

        System.err.println("BASS error " + errCode + " (" + errStr + "): " + text + "\n - Info: " + errDesc);
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

    public static boolean init = false;
    private boolean deinit = false;

    /**
     * The channel that NativeBASS will play to
     */
    public int chan;

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

    private byte[] song;
    private int songSize;

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

        if (file != null) {
            try (ZipInputStream z = new ZipInputStream(new FileInputStream(file))) {
                final ZipEntry zipentry = z.getNextEntry();

                if (zipentry == null)
                    throw new IllegalArgumentException("\"file\" is not a valid .zip file, or is corrupted");

                int entrySize = (int) zipentry.getSize();
                if (entrySize == -1) {
                    final Utility.UnsafeByteArrayOutputStream ubos = Utility.streamNoSize(z, zipentry, entrySize);
                    song = ubos.getDataBuffer();

                    songSize = ubos.getByteCount();

                    //if (entrySize <= 0) System.out.println("entry size is " + songSize);

                } else {
                    //if (entrySize <= 0) System.out.println("entry size is " + entrySize);

                    song = new byte[entrySize];
                    songSize = entrySize; //up here

                    int totalBytes = 0;
                    int readByte;
                    for (; entrySize > 0; entrySize -= readByte) {
                        readByte = z.read(song, totalBytes, entrySize);
                        totalBytes += readByte;
                    }
                }

            } catch (final IOException e) {
                error("Couldn't load song file: " + e);
                e.printStackTrace();
                end();
            }
        }

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

        System.out.println("songsize " + songSize);

        final HSTREAM stream = BassUtils.BASS_StreamCreateFile_FromBytes(true, song, 0, songSize, 0);
        HMUSIC music = null;

        if (stream == null) { // it's a MOD/MO3 file
            //error("Can't play file (stream)");

            music = BassUtils.BASS_MusicLoad_FromBytes(true, song, 0, songSize, BASS_MUSIC_RAMPS | BASS_MUSIC_POSRESET | BASS_MUSIC_PRESCAN, 0);
            if (music == null) { // invalid file
                error("Can't play file (music)");
                return false; // can't load the file
            }
        }

        chan = stream != null ? stream.asInt() : music.asInt();

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
     * @param songFile a .zip file containing a media file supported by BASS
     */
    public RadicalBASS(final File songFile) {
        file = songFile;
        //run();
    }

    /**
     * Constructs an empty RadicalBASS
     */
    public RadicalBASS() {
        file = null;
    }

    /**
     * Constructs a RadicalBASS from an array of byte
     */
    public RadicalBASS(final byte[] buf) {
        file = null;
        song = buf;
        songSize = buf.length;
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
