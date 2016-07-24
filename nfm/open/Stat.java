package nfm.open;

/**
 * Created by Rafael on 24/07/2016.
 *
 * TODO integrate fully (currently only Mad)
 */
public class Stat {
    final int[] swits;
    final float[] acelf;
    final int handb;
    final float airs;
    final int airc;
    final int turn;
    final float grip;
    final float bounce;
    final float simag;
    final float moment;
    final float comprad;
    final int push;
    final int revpush;
    final int lift;
    final int revlift;
    final int powerloss;
    final int flipy;
    final int msquash;
    final int clrad;
    final float dammult;
    final int maxmag;
    final float dishandle;
    final float outdam;
    final int cclass;
    final String names;
    final int enginsignature;

    boolean include = false;
    String createdby = "";
    int publish = 0;

    public Stat(int[] swits, float[] acelf, int handb, float airs, int airc, int turn, float grip, float bounce, float simag, float moment, float comprad, int push, int revpush, int lift, int revlift, int powerloss, int flipy, int msquash, int clrad, float dammult, int maxmag, float dishandle, float outdam, int cclass, String names, int enginsignature,
                boolean include, String createdby, int publish) {
        this(swits,
             acelf,
             handb,
             airs,
             airc,
             turn,
             grip,
             bounce,
             simag,
             moment,
             comprad,
             push,
             revpush,
             lift,
             revlift,
             powerloss,
             flipy,
             msquash,
             clrad,
             dammult,
             maxmag,
             dishandle,
             outdam,
             cclass,
             names,
             enginsignature);

        this.include = include;
        this.createdby = createdby;
        this.publish = publish;
    }

    public Stat(int[] swits, float[] acelf, int handb, float airs, int airc, int turn, float grip, float bounce, float simag, float moment, float comprad, int push, int revpush, int lift, int revlift, int powerloss, int flipy, int msquash, int clrad, float dammult, int maxmag, float dishandle, float outdam, int cclass, String names, int enginsignature) {
        this.swits = swits.clone();
        this.acelf = acelf.clone();

        this.handb = handb;
        this.airs = airs;
        this.airc = airc;
        this.turn = turn;
        this.grip = grip;
        this.bounce = bounce;
        this.simag = simag;
        this.moment = moment;
        this.comprad = comprad;
        this.push = push;
        this.revpush = revpush;
        this.lift = lift;
        this.revlift = revlift;
        this.powerloss = powerloss;
        this.flipy = flipy;
        this.msquash = msquash;
        this.clrad = clrad;
        this.dammult = dammult;
        this.maxmag = maxmag;
        this.dishandle = dishandle;
        this.outdam = outdam;
        this.cclass = cclass;
        this.names = names;
        this.enginsignature = enginsignature;
    }

    public Stat(Stat clone) {
        this.swits = clone.swits.clone();
        this.acelf = clone.acelf.clone();

        this.handb = clone.handb;
        this.airs = clone.airs;
        this.airc = clone.airc;
        this.turn = clone.turn;
        this.grip = clone.grip;
        this.bounce = clone.bounce;
        this.simag = clone.simag;
        this.moment = clone.moment;
        this.comprad = clone.comprad;
        this.push = clone.push;
        this.revpush = clone.revpush;
        this.lift = clone.lift;
        this.revlift = clone.revlift;
        this.powerloss = clone.powerloss;
        this.flipy = clone.flipy;
        this.msquash = clone.msquash;
        this.clrad = clone.clrad;
        this.dammult = clone.dammult;
        this.maxmag = clone.maxmag;
        this.dishandle = clone.dishandle;
        this.outdam = clone.outdam;
        this.cclass = clone.cclass;
        this.names = clone.names;
        this.enginsignature = clone.enginsignature;
    }

    public Stat(int cn, CarDefine cd) {
        this.swits = cd.swits[cn].clone();
        this.acelf = cd.acelf[cn].clone();

        this.handb = cd.handb[cn];
        this.airs = cd.airs[cn];
        this.airc = cd.airc[cn];
        this.turn = cd.turn[cn];
        this.grip = cd.grip[cn];
        this.bounce = cd.bounce[cn];
        this.simag = cd.simag[cn];
        this.moment = cd.moment[cn];
        this.comprad = cd.comprad[cn];
        this.push = cd.push[cn];
        this.revpush = cd.revpush[cn];
        this.lift = cd.lift[cn];
        this.revlift = cd.revlift[cn];
        this.powerloss = cd.powerloss[cn];
        this.flipy = cd.flipy[cn];
        this.msquash = cd.msquash[cn];
        this.clrad = cd.clrad[cn];
        this.dammult = cd.dammult[cn];
        this.maxmag = cd.maxmag[cn];
        this.dishandle = cd.dishandle[cn];
        this.outdam = cd.outdam[cn];
        this.cclass = cd.cclass[cn];
        this.names = cd.names[cn];
        this.enginsignature = cd.enginsignature[cn];

        if (cn >= CarDefine.SIXTEEN) {
            include = cd.include[cn];
            createdby = cd.createdby[cn];
            publish = cd.publish[cn];
        }
    }
}
