
interface RadicalMusic {

    //SuperClip sClip = null;
    static final int TYPE_BASS = 4;
    static final int TYPE_OGG = 3;
    static final int TYPE_MP3 = 2;
    static final int TYPE_MIDI = 1;
    static final int TYPE_MOD = 0;

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
