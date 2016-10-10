package nfm.open;

/**
 * Created by Rafael on 24/07/2016. TODO integrate fully (currently only Mad)
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

    public Stat(final int[] swits, final float[] acelf, final int handb, final float airs, final int airc, final int turn, final float grip, final float bounce, final float simag, final float moment, final float comprad, final int push, final int revpush, final int lift, final int revlift, final int powerloss, final int flipy, final int msquash, final int clrad, final float dammult, final int maxmag, final float dishandle, final float outdam, final int cclass, final String names, final int enginsignature, final boolean include, final String createdby, final int publish) {
        this(swits, acelf, handb, airs, airc, turn, grip, bounce, simag, moment, comprad, push, revpush, lift, revlift, powerloss, flipy, msquash, clrad, dammult, maxmag, dishandle, outdam, cclass, names, enginsignature);

        this.include = include;
        this.createdby = createdby;
        this.publish = publish;
    }

    public Stat(final int[] swits, final float[] acelf, final int handb, final float airs, final int airc, final int turn, final float grip, final float bounce, final float simag, final float moment, final float comprad, final int push, final int revpush, final int lift, final int revlift, final int powerloss, final int flipy, final int msquash, final int clrad, final float dammult, final int maxmag, final float dishandle, final float outdam, final int cclass, final String names, final int enginsignature) {
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

    public Stat(final Stat clone) {
        swits = clone.swits.clone();
        acelf = clone.acelf.clone();

        handb = clone.handb;
        airs = clone.airs;
        airc = clone.airc;
        turn = clone.turn;
        grip = clone.grip;
        bounce = clone.bounce;
        simag = clone.simag;
        moment = clone.moment;
        comprad = clone.comprad;
        push = clone.push;
        revpush = clone.revpush;
        lift = clone.lift;
        revlift = clone.revlift;
        powerloss = clone.powerloss;
        flipy = clone.flipy;
        msquash = clone.msquash;
        clrad = clone.clrad;
        dammult = clone.dammult;
        maxmag = clone.maxmag;
        dishandle = clone.dishandle;
        outdam = clone.outdam;
        cclass = clone.cclass;
        names = clone.names;
        enginsignature = clone.enginsignature;
    }

    public Stat(final int cn) {
        swits = CarDefine.swits[cn].clone();
        acelf = CarDefine.acelf[cn].clone();

        handb = CarDefine.handb[cn];
        airs = CarDefine.airs[cn];
        airc = CarDefine.airc[cn];
        turn = CarDefine.turn[cn];
        grip = CarDefine.grip[cn];
        bounce = CarDefine.bounce[cn];
        simag = CarDefine.simag[cn];
        moment = CarDefine.moment[cn];
        comprad = CarDefine.comprad[cn];
        push = CarDefine.push[cn];
        revpush = CarDefine.revpush[cn];
        lift = CarDefine.lift[cn];
        revlift = CarDefine.revlift[cn];
        powerloss = CarDefine.powerloss[cn];
        flipy = CarDefine.flipy[cn];
        msquash = CarDefine.msquash[cn];
        clrad = CarDefine.clrad[cn];
        dammult = CarDefine.dammult[cn];
        maxmag = CarDefine.maxmag[cn];
        dishandle = CarDefine.dishandle[cn];
        outdam = CarDefine.outdam[cn];
        cclass = CarDefine.cclass[cn];
        names = CarDefine.names[cn];
        enginsignature = CarDefine.enginsignature[cn];

        if (cn >= CarDefine.SIXTEEN) {
            include = CarDefine.include[cn];
            createdby = CarDefine.createdby[cn];
            publish = CarDefine.publish[cn];
        }
    }
}
