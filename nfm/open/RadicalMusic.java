package nfm.open;

interface RadicalMusic {

	//nfm.open.SuperClip sClip = null;
	int TYPE_OGG = 3;
	int TYPE_MP3 = 2;
	int TYPE_MIDI = 1;
	int TYPE_MOD = 0;

	int getType();

	@Deprecated
	/**
	 * Pauses the file playback. Deprecated: Use setPaused instead.
	 */
	void stop();

	@Deprecated
	/**
	 * Resumes playback of the file. Deprecated: Use setPaused instead.
	 */
	void resume();

	/**
	 * Unloads the file and forcefully stops playback.
	 */
	void unload();

	/**
	 * Begin playback of the file.
	 */
	void play();

	/**
	 * Sets the paused state. Music may not immediately pause.
	 */
	void setPaused(boolean pause);

	/**
	 * Returns the paused state.
	 */
	boolean isPaused();
}
