import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.PausablePlayer;

class RadicalMp3 implements RadicalMusic {

    //BufferedInputStream is;
    private boolean paused;
    private boolean loaded;
    private boolean playing;
    private String s;
    private FileInputStream fi;
    private File fl;

    private PausablePlayer player;
    String filePath;

    /**
     * Sets up the RadicalMidi for playback. Use load() to load the file; Use
     * play() to play (and loop) the file; use setPaused(true/false) to
     * pause/resume the file; Use unload() to unload the file, then (preferably)
     * set RadicalMidi to null; Use playMidi() or playMidi(int gain) or
     * playMidi(int gain, int loops) to manually play a midi file.
     *
     * @param fn
     *            the file name of the file to load.
     */
    public RadicalMp3(final String fn) {
        loaded = false;
        playing = false;
        s = fn;
        fl = new File(fn);
        try {
            fi = new FileInputStream(fl);
            player = new PausablePlayer(fi);
        } catch (JavaLayerException | FileNotFoundException ex) {
            System.out.println("Error loading Mp3!");
            ex.printStackTrace();
        }
    }

    @Deprecated
    @Override
    /**
     * Resumes playback of the midi.
     */
    public void resume() {
        player.resume();
    }

    /**
     * Begins playing the midi.
     */
    @Override
    public void play() {
        try {
            player.play();
        } catch (final JavaLayerException e) {
            e.printStackTrace();
        }
    }

    /**
     * Sets the paused state. Music may not immediately pause.
     */
    @Override
    public void setPaused(final boolean paused) {
        this.paused = paused;
        if (paused)
            player.pause();
        else
            player.resume();
    }

    /**
     * Returns the paused state.
     */
    @Override
    public boolean isPaused() {
        return paused;
    }

    /**
     * Stops the midi sequencer.
     */
    @Override
    @Deprecated
    public void stop() {
        player.pause();
    }

    /**
     * Closes the midi sequencer.
     */
    @Override
    public void unload() {
        player.close();
        System.gc();
    }

    @Override
    public int getType() {
        return RadicalMusic.TYPE_MP3;
    }
}
