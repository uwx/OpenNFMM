package nfm.open;
import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import paulscode.sound.SoundSystemConfig;

class SoundClip {
    int rollBackPos;
    int rollBackTrig;
    private static int srccnt = 0;
    private String sourceName;
    static Point3D source = new _Point3D();
    static Point3DX player = new _Point3DX();
    //private static final ListenerData LISTENER_DATA = Madness.ss.getListenerData();
    static List<SoundClip> masterList = new ArrayList<>(57);
    boolean playing = false;
    static int playingSources = 0;

    SoundClip(String path) {        
        boolean priority = false; 
        // TODO array of sources for each racer
        sourceName = "Source " + (srccnt++); 
        boolean loop = false; 
        float x = 0; 
        float y = 0; 
        float z = 0; 
        int aModel = SoundSystemConfig.ATTENUATION_ROLLOFF / 10000; 
        float rFactor = SoundSystemConfig.getDefaultRolloff(); 
        try {
            Madness.ss.newSource(priority, sourceName, new File(path).toURI().toURL(), path.substring(path.lastIndexOf('/')+1), loop, x, y, z, aModel, rFactor);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        masterList.add(this);
    }

    void checkopen() {
        // unused
    }

    void loop() {
        Madness.ss.setLooping(sourceName, true);
        play();
    }

    void play() {
        Madness.ss.setPosition(sourceName, source.x(), source.y(), source.z());
        Madness.ss.getListenerData().setPosition(player.x(), player.y(), player.z());
        Madness.ss.setListenerAngle((float) Math.toRadians(player.xz()));
        
        Madness.ss.play(sourceName);
        playing=true;
//        playingSources++;
    }

    void stop() {
        if (playing/*&&Madness.ss.millisecondsPlayed(sourceName)<=0&&playingSources<=28*/) {
            Madness.ss.stop(sourceName);
            playing=false;
//            playingSources--;
        }
        
    }

    public static void stopAll() {
        for (SoundClip s : masterList) {
            Madness.ss.stop(s.sourceName);
            s.playing=false;
        }
    }
}
