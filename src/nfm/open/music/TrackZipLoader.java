package nfm.open.music;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

/**
 * This class is used to load music files for NativeBASS from a .zip. <br>
 * <br>
 * This is a utility class, so it can't be inherited.
 *
 * @author Rafael
 */
public final class TrackZipLoader {

    public static RadicalMusic loadLegacy(final int stage, final String songURL, final int i52) {

        // The Mad Party uses 'party.XXX' file name.
        final String tFile = stage == 27 ? "music/party" : "music/stage" + stage;

        // first, try loading from a regular file, not a .zip.
        if (stage > 0) { // obviously can't be done on custom maps.
            try {
                if (new File(tFile + ".mid").exists())
                    return new RadicalMidi(tFile + ".mid");

                if (new File(tFile + ".mp3").exists())
                    return new RadicalMp3(tFile + ".mp3");

                if (new File(tFile + ".ogg").exists())
                    return new RadicalOgg(tFile + ".ogg");
            } catch (Exception e) {
                e.printStackTrace();
                // keep going, we'll try something else...
            }
        }

        // then, try loading using RadicalBASS.
        try {
            if (stage > 0) {
                return loadZip(tFile + ".zip", false);
            }
            // else {
            if (!"".equals(songURL)) {
                if (stage != -2) {
                    return loadZip("mystages/mymusic/" + songURL + ".zip", false);
                }
                // else {
                return loadZip(songURL, true);
            }
        } catch (Exception e) {
            e.printStackTrace();
            // keep going, we'll try something else...
        }

        try {
            if (stage == 1) {
                return new RadicalMod(tFile + ".zip", 240, 8400, 135, false, false);
            } if (stage == 2) {
                return new RadicalMod(tFile + ".zip", 190, 9000, 145, false, false);
            } if (stage == 3) {
                return new RadicalMod(tFile + ".zip", 170, 8500, 145, false, false);
            } if (stage == 4) {
                return new RadicalMod(tFile + ".zip", 205, 7500, 125, false, false);
            } if (stage == 5) {
                return new RadicalMod(tFile + ".zip", 170, 7900, 125, false, false);
            } if (stage == 6) {
                return new RadicalMod(tFile + ".zip", 370, 7900, 125, false, false);
            } if (stage == 7) {
                return new RadicalMod(tFile + ".zip", 205, 7500, 125, false, false);
            } if (stage == 8) {
                return new RadicalMod(tFile + ".zip", 230, 7900, 125, false, false);
            } if (stage == 9) {
                return new RadicalMod(tFile + ".zip", 180, 7900, 125, false, false);
            } if (stage == 10) {
                return new RadicalMod(tFile + ".zip", 280, 8100, 145, false, false);
            } if (stage == 11) {
                return new RadicalMod(tFile + ".zip", 120, 8000, 125, false, false);
            } if (stage == 12) {
                return new RadicalMod(tFile + ".zip", 260, 7200, 125, false, false);
            } if (stage == 13) {
                return new RadicalMod(tFile + ".zip", 270, 8000, 125, false, false);
            } if (stage == 14) {
                return new RadicalMod(tFile + ".zip", 190, 8000, 125, false, false);
            } if (stage == 15) {
                return new RadicalMod(tFile + ".zip", 162, 7800, 125, false, false);
            } if (stage == 16) {
                return new RadicalMod(tFile + ".zip", 220, 7600, 125, false, false);
            } if (stage == 17) {
                return new RadicalMod(tFile + ".zip", 300, 7500, 125, false, false);
            } if (stage == 18) {
                return new RadicalMod(tFile + ".zip", 200, 7900, 125, false, false);
            } if (stage == 19) {
                return new RadicalMod(tFile + ".zip", 200, 7900, 125, false, false);
            } if (stage == 20) {
                return new RadicalMod(tFile + ".zip", 232, 7300, 125, false, false);
            } if (stage == 21) {
                return new RadicalMod(tFile + ".zip", 370, 7900, 125, false, false);
            } if (stage == 22) {
                return new RadicalMod(tFile + ".zip", 290, 7900, 125, false, false);
            } if (stage == 23) {
                return new RadicalMod(tFile + ".zip", 222, 7600, 125, false, false);
            } if (stage == 24) {
                return new RadicalMod(tFile + ".zip", 230, 8000, 125, false, false);
            } if (stage == 25) {
                return new RadicalMod(tFile + ".zip", 220, 8000, 125, false, false);
            } if (stage == 26) {
                return new RadicalMod(tFile + ".zip", 261, 8000, 125, false, false);
            } if (stage == 27) {
                return new RadicalMod(tFile + ".zip", 400, 7600, 125, false, false);
            } if (stage == 28) {
                return new RadicalMod(tFile + ".zip", 182, 8000, 125, false, false);
            } if (stage == 29) {
                return new RadicalMod(tFile + ".zip", 220, 8000, 125, false, false);
            } if (stage == 30) {
                return new RadicalMod(tFile + ".zip", 200, 8000, 125, false, false);
            } if (stage == 31) {
                return new RadicalMod(tFile + ".zip", 350, 7900, 125, false, false);
            } if (stage == 32) {
                return new RadicalMod(tFile + ".zip", 310, 8000, 125, false, false);
            } if (stage > 32) {
                return new RadicalMod(tFile + ".zip", 550, 8000, 125, false, false);
            }
            if (stage < 0) {
                if (!"".equals(songURL)) {
                    if (stage != -2) {
                        return new RadicalMod("mystages/mymusic/" + songURL + ".zip", i52, 8000, 125, false, false);
                    }
                    // else {
                    return new RadicalMod(songURL, i52, 8000, 125, false, true);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            // keep going, we'll try something else...
        }

        // we've failed - return an empty RadicalMusic.
        System.err.println("Could not load soundtrack! Using empty placeholder instead.");
        return new RadicalAdapter();
    }

    public static RadicalMusic loadZip(final String file, final boolean download) throws IOException {

        if (download) {
            final byte[] sbytes = downloadMusic(file);
            return new RadicalBASS(sbytes);
        }

        final File song = new File(file);

        if (!song.exists())
            throw new FileNotFoundException("music file " + file + " does not exist");

        // Nah.
        //if (file.toLowerCase().endsWith(".mid"))
        //    return new RadicalMidi(file);

        return new RadicalBASS(song);

        // old fallback method
        //return new RadicalMod(file, 550, 8000, 125, false, false);

    }

    private static byte[] downloadMusic(final String songname) throws IOException {
        //prepares download
        final String string = "http://multiplayer.needformadness.com/tracks/music/" + songname.replace(' ', '_') + ".zip";
        final URL url = new URL(string);
        final int connLength = url.openConnection().getContentLength();

        //writes to file
        final DataInputStream datainputstream = new DataInputStream(url.openStream());
        final byte[] is = new byte[connLength];
        datainputstream.readFully(is);
        datainputstream.close();
        return is;
    }
}
