package nfm.open;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequencer;
import java.io.*;

class RadicalMidi implements RadicalMusic {

    private BufferedInputStream is;
    private Sequencer sequencer;
    private boolean paused;
    private final String s;
    private FileInputStream fi;
    //File fl;

    //String filePath;

    /**
     * Sets up the nfm.open.RadicalMidi for playback. Use load() to load the file; Use
     * play() to play (and loop) the file; use setPaused(true/false) to
     * pause/resume the file; Use unload() to unload the file, then (preferably)
     * set nfm.open.RadicalMidi to null; Use playMidi() or playMidi(int gain) or
     * playMidi(int gain, int loops) to manually play a midi file.
     *
     * @param fn the file name of the file to load.
     */
    public RadicalMidi(final String fn) {
        // then it must be a midi!
        s = fn;
        try {
            fi = new FileInputStream(new File(fn));
        } catch (final FileNotFoundException ex) {
            System.out.println("Midi file \"" + fn + "\" not found!");
            ex.printStackTrace();
        }
        try {
            // Obtains the default Sequencer connected to a default device.
            sequencer = MidiSystem.getSequencer();

            // Opens the device, indicating that it should now acquire any
            // system resources it requires and become operational.
            sequencer.open();

        } catch (final Exception ex) {
            System.out.println("Error loading Midi file \"" + fn + "\":");
            ex.printStackTrace();
        }
        try {
            // create a stream from a file
            is = new BufferedInputStream(fi);

        } catch (final Exception ex) {
            System.out.println("Error buffering Midi file \"" + fn + "\":");
            ex.printStackTrace();
        }

    }

    @Deprecated
    @Override
    /**
     * Resumes playback of the midi.
     */
    public void resume() {
        try {
            fi = new FileInputStream(new File(s));
            is = new BufferedInputStream(fi);
        } catch (final IOException ex) {
            System.out.println("Midi file not found!");
            ex.printStackTrace();
        } catch (final Exception ex) {
            System.out.println("Error buffering Midi file:");
            ex.printStackTrace();
        }
        play();
    }

    /**
     * Begins playing the midi.
     */
    @Override
    public void play() {

        try {
            // Sets the current sequence on which the sequencer operates.
            // The stream must point to MIDI file data.
            sequencer.setSequence(is);

            // loop forever
            sequencer.setLoopCount(9999);

            // Starts playback of the MIDI data in the currently loaded
            // sequence.
            sequencer.start();
        } catch (final IllegalArgumentException ex) {
            System.out.println("There is a mistake in your Midi code,");
            System.out.println("please re-check!");
            ex.printStackTrace();
        } catch (final java.lang.IllegalStateException ex) {
            System.out.println("Error playing Midi file " + s + ", check if the file exists!");
            ex.printStackTrace();
        } catch (final Exception ex) {
            System.out.println("Error playing Midi file:");
            ex.printStackTrace();
        }
    }

    /**
     * Sets the paused state. Music may not immediately pause.
     */
    @Override
    public void setPaused(final boolean paused) {
        if (this.paused != paused && sequencer != null && sequencer.isOpen()) {
            this.paused = paused;
            if (paused)
                sequencer.stop();
            else
                sequencer.start();
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
        System.out.println("Stopping Midi file...");
        try {
            sequencer.stop();
        } catch (final Exception ex) {
            System.out.println("Error stopping Midi file:");
            ex.printStackTrace();
        }
    }

    /**
     * Closes the midi sequencer.
     */
    @Override
    public void unload() {
        System.out.println("Stopping Midi file...");
        try {
            sequencer.stop();
        } catch (final Exception ex) {
            System.out.println("Error stopping Midi file:");
            ex.printStackTrace();
        }
        System.out.println("Unloading Midi file...");
        try {
            is.close();
        } catch (final Exception ex) {
            System.out.println("Error unloading Midi file:");
            ex.printStackTrace();
        }
        System.gc();
    }

    @Override
    public int getType() {
        return RadicalMusic.TYPE_MIDI;
    }
}