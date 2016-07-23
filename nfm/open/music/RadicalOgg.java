package nfm.open.music;

import java.io.IOException;

import org.newdawn.easyogg.OggClip;

class RadicalOgg implements RadicalMusic {

    private boolean paused;
    private OggClip ogg;

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
    public RadicalOgg(final String fn) {
        try {
            ogg = new OggClip(fn);
        } catch (final IOException e) {
            System.out.println("Error loading Ogg!");
            e.printStackTrace();
        }
    }

    @Deprecated
    @Override
    /**
     * Resumes playback of the midi.
     */
    public void resume() {
        ogg.resume();
    }

    /**
     * Begins playing the midi.
     */
    @Override
    public void play() {
        ogg.loop();
    }

    /**
     * Sets the paused state. Music may not immediately pause.
     */
    @Override
    public void setPaused(final boolean paused) {
        this.paused = paused;
        if (paused) {
            ogg.pause();
        } else {
            ogg.resume();
        }
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
        ogg.pause();
    }

    /**
     * Closes the midi sequencer.
     */
    @Override
    public void unload() {
        ogg.stop();
        ogg.close();
        System.gc();
    }

    @Override
    public Type getType() {
        return Type.TYPE_OGG;
    }
}
