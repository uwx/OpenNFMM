package nfm.open.music;

/**
 * Created by Rafael on 15/07/2016.
 * <p>
 * Sample adapter for RadicalMusic. Does nothing.
 */
public class RadicalAdapter implements RadicalMusic {


    public int loaded;
    public SuperClip sClip;
    public float rvol;
    public boolean playing;

    public RadicalAdapter() {
        /**/
    }

    @Override
    public Type getType() {
        return Type.TYPE_UNKNOWN;
    }

    @Override
    public void stop() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void unload() {

    }

    @Override
    public void play() {

    }

    @Override
    public void setPaused(boolean pause) {

    }

    @Override
    public boolean isPaused() {
        return false;
    }
}
