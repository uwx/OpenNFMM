import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequencer;

class RadicalMidi implements RadicalMusic {

	private BufferedInputStream is;
	private Sequencer sequencer;
	private boolean paused;
	private final String s;
	private FileInputStream fi;
	//File fl;

	//String filePath;

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
	public RadicalMidi(final String fn) {
		// then it must be a midi!
		s = fn;
		try {
			fi = new FileInputStream(new File(fn));
		} catch (final FileNotFoundException ex) {
			System.out.println(Messages.getString("RadicalMidi.0") + fn + Messages.getString("RadicalMidi.1")); //$NON-NLS-1$ //$NON-NLS-2$
			ex.printStackTrace();
		}
		try {
			// Obtains the default Sequencer connected to a default device.
			sequencer = MidiSystem.getSequencer();

			// Opens the device, indicating that it should now acquire any
			// system resources it requires and become operational.
			sequencer.open();

		} catch (final Exception ex) {
			System.out.println(Messages.getString("RadicalMidi.2") + fn + Messages.getString("RadicalMidi.3")); //$NON-NLS-1$ //$NON-NLS-2$
			ex.printStackTrace();
		}
		try {
			// create a stream from a file
			is = new BufferedInputStream(fi);

		} catch (final Exception ex) {
			System.out.println(Messages.getString("RadicalMidi.4") + fn + Messages.getString("RadicalMidi.5")); //$NON-NLS-1$ //$NON-NLS-2$
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
			System.out.println(Messages.getString("RadicalMidi.6")); //$NON-NLS-1$
			ex.printStackTrace();
		} catch (final Exception ex) {
			System.out.println(Messages.getString("RadicalMidi.7")); //$NON-NLS-1$
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
			System.out.println(Messages.getString("RadicalMidi.8")); //$NON-NLS-1$
			System.out.println(Messages.getString("RadicalMidi.9")); //$NON-NLS-1$
			ex.printStackTrace();
		} catch (final java.lang.IllegalStateException ex) {
			System.out.println(Messages.getString("RadicalMidi.10") + s + Messages.getString("RadicalMidi.11")); //$NON-NLS-1$ //$NON-NLS-2$
			ex.printStackTrace();
		} catch (final Exception ex) {
			System.out.println(Messages.getString("RadicalMidi.12")); //$NON-NLS-1$
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
		System.out.println(Messages.getString("RadicalMidi.13")); //$NON-NLS-1$
		try {
			sequencer.stop();
		} catch (final Exception ex) {
			System.out.println(Messages.getString("RadicalMidi.14")); //$NON-NLS-1$
			ex.printStackTrace();
		}
	}

	/**
	 * Closes the midi sequencer.
	 */
	@Override
	public void unload() {
		System.out.println(Messages.getString("RadicalMidi.15")); //$NON-NLS-1$
		try {
			sequencer.stop();
		} catch (final Exception ex) {
			System.out.println(Messages.getString("RadicalMidi.16")); //$NON-NLS-1$
			ex.printStackTrace();
		}
		System.out.println(Messages.getString("RadicalMidi.17")); //$NON-NLS-1$
		try {
			is.close();
		} catch (final Exception ex) {
			System.out.println(Messages.getString("RadicalMidi.18")); //$NON-NLS-1$
			ex.printStackTrace();
		}
		System.gc();
	}

	@Override
	public int getType() {
		return RadicalMusic.TYPE_MIDI;
	}
}