package nfm.open;

import static nfm.open.CarDefine.getSvalue;
import static nfm.open.Utility.getvalue;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.InputStreamReader;

/**
 * Created by Rafael on 24/07/2016. TODO integrate fully (currently only Mad)
 */
public class Stat {
    static final int[][] nfmm_swits = {
            {
                    50, 185, 282
            }, {
                    100, 200, 310
            }, {
                    60, 180, 275
            }, {
                    76, 195, 298
            }, {
                    70, 170, 275
            }, {
                    70, 202, 293
            }, {
                    60, 170, 289
            }, {
                    70, 206, 291
            }, {
                    90, 210, 295
            }, {
                    90, 190, 276
            }, {
                    70, 200, 295
            }, {
                    50, 160, 270
            }, {
                    90, 200, 305
            }, {
                    50, 130, 210
            }, {
                    80, 200, 300
            }, {
                    70, 210, 290
            }
    };

    static final float[][] nfmm_acelf = {
            {
                    11.0F, 5.0F, 3.0F
            }, {
                    14.0F, 7.0F, 5.0F
            }, {
                    10.0F, 5.0F, 3.5F
            }, {
                    11.0F, 6.0F, 3.5F
            }, {
                    10.0F, 5.0F, 3.5F
            }, {
                    12.0F, 6.0F, 3.0F
            }, {
                    7.0F, 9.0F, 4.0F
            }, {
                    11.0F, 5.0F, 3.0F
            }, {
                    12.0F, 7.0F, 4.0F
            }, {
                    12.0F, 7.0F, 3.5F
            }, {
                    11.5F, 6.5F, 3.5F
            }, {
                    9.0F, 5.0F, 3.0F
            }, {
                    13.0F, 7.0F, 4.5F
            }, {
                    7.5F, 3.5F, 3.0F
            }, {
                    11.0F, 7.5F, 4.0F
            }, {
                    12.0F, 6.0F, 3.5F
            }
    };

    int[] swits;
    float[] acelf;
    int handb;
    float airs;
    int airc;
    int turn;
    float grip;
    float bounce;
    float simag;
    float moment;
    float comprad;
    int push;
    int revpush;
    int lift;
    int revlift;
    int powerloss;
    int flipy;
    int msquash;
    int clrad;
    float dammult;
    int maxmag;
    float dishandle;
    float outdam;
    int cclass;
    String names;
    int enginsignature;

    boolean include = false;
    String createdby = "";
    int publish = 0;

    public Stat(int[] swits, float[] acelf, int handb, float airs, int airc, int turn, float grip, float bounce, float simag, float moment, float comprad, int push, int revpush, int lift, int revlift, int powerloss, int flipy, int msquash, int clrad, float dammult, int maxmag, float dishandle, float outdam, int cclass, String names, int enginsignature, boolean include, String createdby, int publish) {
        this(swits, acelf, handb, airs, airc, turn, grip, bounce, simag, moment, comprad, push, revpush, lift, revlift, powerloss, flipy, msquash, clrad, dammult, maxmag, dishandle, outdam, cclass, names, enginsignature);

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

    // byte[], "", bco[i].maxR, bco[i].roofat, bco[i].wh
    public Stat(final byte[] byteData, final String name, final int radius, final int maxy, final int wheelat) {
        int[] swits = new int[3];
        float[] acelf = new float[3];
        int handb = 0;
        float airs = 0;
        int airc = 0;
        int turn = 0;
        float grip = 0;
        float bounce = 0;
        float simag = 0;
        float moment = 0;
        float comprad = 0;
        int push = 0;
        int revpush = 0;
        int lift = 0;
        int revlift = 0;
        int powerloss = 0;
        int flipy = 0;
        int msquash = 0;
        int clrad = 0;
        float dammult = 0;
        int maxmag = 0;
        float dishandle = 0;
        float outdam = 0;
        int cclass = 0;
        String names = "";
        int enginsignature = 0;
        
        //

        names = name;
        boolean bool = false;
        boolean bool3 = false;
        String line;
        final int[] statValues = {
                128, 128, 128, 128, 128
        };
        int i6 = 640;
        final int[] physicsValues = {
                50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50
        };
        final int[] is8 = {
                50, 50, 50
        };
        enginsignature = 0;
        float f = 0.0F;
        publish = 0;
        createdby = "Unkown User";
        try {
            final BufferedReader statReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(byteData)));
            while ((line = statReader.readLine()) != null) {
                line = line.trim();
                if (line.startsWith("stat(")) {
                    try {
                        i6 = 0;
                        for (int i9 = 0; i9 < 5; i9++) {
                            statValues[i9] = getvalue("stat", line, i9);
                            if (statValues[i9] > 200) {
                                statValues[i9] = 200;
                            }
                            if (statValues[i9] < 16) {
                                statValues[i9] = 16;
                            }
                            i6 += statValues[i9];
                        }
                        bool = true;
                    } catch (final Exception exception) {
                        bool = false;
                    }
                }
                if (line.startsWith("physics(")) {
                    try {
                        for (int i10 = 0; i10 < 11; i10++) {
                            physicsValues[i10] = getvalue("physics", line, i10);
                            if (physicsValues[i10] > 100) {
                                physicsValues[i10] = 100;
                            }
                            if (physicsValues[i10] < 0) {
                                physicsValues[i10] = 0;
                            }
                        }
                        for (int i11 = 0; i11 < 3; i11++) {
                            is8[i11] = getvalue("physics", line, i11 + 11);
                            if (i11 != 0 && is8[i11] > 100) {
                                is8[i11] = 100;
                            }
                            if (is8[i11] < 0) {
                                is8[i11] = 0;
                            }
                        }
                        enginsignature = getvalue("physics", line, 14);
                        if (enginsignature > 4) {
                            enginsignature = 0;
                        }
                        if (enginsignature < 0) {
                            enginsignature = 0;
                        }
                        f = getvalue("physics", line, 15);
                        if (f > 0.0F) {
                            bool3 = true;
                        }
                    } catch (final Exception exception) {
                        bool3 = false;
                    }
                }
                if (line.startsWith("handling(")) {
                    try {
                        int i12 = getvalue("handling", line, 0);
                        if (i12 > 200) {
                            i12 = 200;
                        }
                        if (i12 < 50) {
                            i12 = 50;
                        }
                        dishandle = i12 / 200.0F;
                    } catch (final Exception ignored) {

                    }
                }
                if (line.startsWith("carmaker(")) {
                    createdby = getSvalue("carmaker", line, 0);
                }
                if (line.startsWith("publish(")) {
                    publish = getvalue("publish", line, 0);
                }
            }
            statReader.close();
        } catch (final Exception exception) {
            System.out.println("Error Loading Car Stat: " + exception);
        }
        if (bool && bool3) {
            int i13 = 0;
            if (i6 > 680) {
                i13 = 680 - i6;
            }
            if (i6 > 640 && i6 < 680) {
                i13 = 640 - i6;
            }
            if (i6 > 600 && i6 < 640) {
                i13 = 600 - i6;
            }
            if (i6 > 560 && i6 < 600) {
                i13 = 560 - i6;
            }
            if (i6 > 520 && i6 < 560) {
                i13 = 520 - i6;
            }
            if (i6 < 520) {
                i13 = 520 - i6;
            }
            while (i13 != 0) {
                for (int i14 = 0; i14 < 5; i14++) {
                    if (i13 > 0 && statValues[i14] < 200) {
                        statValues[i14]++;
                        i13--;
                    }
                    if (i13 < 0 && statValues[i14] > 16) {
                        statValues[i14]--;
                        i13++;
                    }
                }
            }
            i6 = 0;
            for (int i15 = 0; i15 < 5; i15++) {
                i6 += statValues[i15];
            }
            if (i6 == 520) {
                cclass = 0;
            }
            if (i6 == 560) {
                cclass = 1;
            }
            if (i6 == 600) {
                cclass = 2;
            }
            if (i6 == 640) {
                cclass = 3;
            }
            if (i6 == 680) {
                cclass = 4;
            }
            int i16 = 0;
            int i17 = 0;
            float f18 = 0.5F;
            if (statValues[0] == 200) {
                i16 = 1;
                i17 = 1;
            }
            if (statValues[0] > 192 && statValues[0] < 200) {
                i16 = 12;
                i17 = 1;
                f18 = (statValues[0] - 192) / 8.0F;
            }
            if (statValues[0] == 192) {
                i16 = 12;
                i17 = 12;
            }
            if (statValues[0] > 148 && statValues[0] < 192) {
                i16 = 14;
                i17 = 12;
                f18 = (statValues[0] - 148) / 44.0F;
            }
            if (statValues[0] == 148) {
                i16 = 14;
                i17 = 14;
            }
            if (statValues[0] > 133 && statValues[0] < 148) {
                i16 = 10;
                i17 = 14;
                f18 = (statValues[0] - 133) / 15.0F;
            }
            if (statValues[0] == 133) {
                i16 = 10;
                i17 = 10;
            }
            if (statValues[0] > 112 && statValues[0] < 133) {
                i16 = 15;
                i17 = 10;
                f18 = (statValues[0] - 112) / 21.0F;
            }
            if (statValues[0] == 112) {
                i16 = 15;
                i17 = 15;
            }
            if (statValues[0] > 107 && statValues[0] < 112) {
                i16 = 11;
                i17 = 15;
                f18 = (statValues[0] - 107) / 5.0F;
            }
            if (statValues[0] == 107) {
                i16 = 11;
                i17 = 11;
            }
            if (statValues[0] > 88 && statValues[0] < 107) {
                i16 = 13;
                i17 = 11;
                f18 = (statValues[0] - 88) / 19.0F;
            }
            if (statValues[0] == 88) {
                i16 = 13;
                i17 = 13;
            }
            if (statValues[0] > 88) {
                swits[0] = (int) ((nfmm_swits[i17][0] - nfmm_swits[i16][0]) * f18 + nfmm_swits[i16][0]);
                swits[1] = (int) ((nfmm_swits[i17][1] - nfmm_swits[i16][1]) * f18 + nfmm_swits[i16][1]);
                swits[2] = (int) ((nfmm_swits[i17][2] - nfmm_swits[i16][2]) * f18 + nfmm_swits[i16][2]);
            } else {
                f18 = statValues[0] / 88.0F;
                if (f18 < 0.76) {
                    f18 = 0.76F;
                }
                swits[0] = (int) (50.0F * f18);
                swits[1] = (int) (130.0F * f18);
                swits[2] = (int) (210.0F * f18);
            }
            i16 = 0;
            i17 = 0;
            f18 = 0.5F;
            if (statValues[1] == 200) {
                i16 = 1;
                i17 = 1;
            }
            if (statValues[1] > 150 && statValues[1] < 200) {
                i16 = 14;
                i17 = 1;
                f18 = (statValues[1] - 150) / 50.0F;
            }
            if (statValues[1] == 150) {
                i16 = 14;
                i17 = 14;
            }
            if (statValues[1] > 144 && statValues[1] < 150) {
                i16 = 9;
                i17 = 14;
                f18 = (statValues[1] - 144) / 6.0F;
            }
            if (statValues[1] == 144) {
                i16 = 9;
                i17 = 9;
            }
            if (statValues[1] > 139 && statValues[1] < 144) {
                i16 = 6;
                i17 = 9;
                f18 = (statValues[1] - 139) / 5.0F;
            }
            if (statValues[1] == 139) {
                i16 = 6;
                i17 = 6;
            }
            if (statValues[1] > 128 && statValues[1] < 139) {
                i16 = 15;
                i17 = 6;
                f18 = (statValues[1] - 128) / 11.0F;
            }
            if (statValues[1] == 128) {
                i16 = 15;
                i17 = 15;
            }
            if (statValues[1] > 122 && statValues[1] < 128) {
                i16 = 10;
                i17 = 15;
                f18 = (statValues[1] - 122) / 6.0F;
            }
            if (statValues[1] == 122) {
                i16 = 10;
                i17 = 10;
            }
            if (statValues[1] > 119 && statValues[1] < 122) {
                i16 = 3;
                i17 = 10;
                f18 = (statValues[1] - 119) / 3.0F;
            }
            if (statValues[1] == 119) {
                i16 = 3;
                i17 = 3;
            }
            if (statValues[1] > 98 && statValues[1] < 119) {
                i16 = 5;
                i17 = 3;
                f18 = (statValues[1] - 98) / 21.0F;
            }
            if (statValues[1] == 98) {
                i16 = 5;
                i17 = 5;
            }
            if (statValues[1] > 81 && statValues[1] < 98) {
                i16 = 0;
                i17 = 5;
                f18 = (statValues[1] - 81) / 17.0F;
            }
            if (statValues[1] == 81) {
                i16 = 0;
                i17 = 0;
            }
            if (statValues[1] <= 80) {
                i16 = 2;
                i17 = 2;
            }
            if (statValues[0] <= 88) {
                i16 = 13;
                i17 = 13;
            }
            acelf[0] = (nfmm_acelf[i17][0] - nfmm_acelf[i16][0]) * f18 + nfmm_acelf[i16][0];
            acelf[1] = (nfmm_acelf[i17][1] - nfmm_acelf[i16][1]) * f18 + nfmm_acelf[i16][1];
            acelf[2] = (nfmm_acelf[i17][2] - nfmm_acelf[i16][2]) * f18 + nfmm_acelf[i16][2];
            if (statValues[1] <= 70 && statValues[0] > 88) {
                acelf[0] = 9.0F;
                acelf[1] = 4.0F;
                acelf[2] = 3.0F;
            }
            f18 = (statValues[2] - 88) / 109.0F;
            if (f18 > 1.0F) {
                f18 = 1.0F;
            }
            if (f18 < -0.55) {
                f18 = -0.55F;
            }
            airs = 0.55F + 0.45F * f18 + 0.4F * (physicsValues[9] / 100.0F);
            if (airs < 0.3) {
                airs = 0.3F;
            }
            airc = (int) (10.0F + 70.0F * f18 + 30.0F * (physicsValues[10] / 100.0F));
            if (airc < 0) {
                airc = 0;
            }
            int i19 = (int) (670.0F - (physicsValues[9] + physicsValues[10]) / 200.0F * 420.0F);
            if (statValues[0] <= 88) {
                i19 = (int) (1670.0F - (physicsValues[9] + physicsValues[10]) / 200.0F * 1420.0F);
            }
            if (statValues[2] > 190 && i19 < 300) {
                i19 = 300;
            }
            powerloss = i19 * 10000;
            moment = 0.7F + (statValues[3] - 16) / 184.0F * 1.0F;
            if (statValues[0] < 110) {
                moment = 0.75F + (statValues[3] - 16) / 184.0F * 1.25F;
            }
            if (statValues[3] == 200 && statValues[4] == 200 && statValues[0] <= 88) {
                moment = 3.0F;
            }
            float f20 = 0.9F + (statValues[4] - 90) * 0.01F;
            if (f20 < 0.6) {
                f20 = 0.6F;
            }
            if (statValues[4] == 200 && statValues[0] <= 88) {
                f20 = 3.0F;
            }
            maxmag = (int) (f * f20);
            outdam = 0.35F + (f20 - 0.6F) * 0.5F;
            if (outdam < 0.35) {
                outdam = 0.35F;
            }
            if (outdam > 1.0F) {
                outdam = 1.0F;
            }
            clrad = (int) (is8[0] * is8[0] * 1.5);
            if (clrad < 1000) {
                clrad = 1000;
            }
            dammult = 0.3F + is8[1] * 0.005F;
            msquash = (int) (2.0 + is8[2] / 7.6);
            flipy = maxy;
            handb = (int) (7.0F + physicsValues[0] / 100.0F * 8.0F);
            turn = (int) (4.0F + physicsValues[1] / 100.0F * 6.0F);
            grip = 16.0F + physicsValues[2] / 100.0F * 14.0F;
            if (grip < 21.0F) {
                swits[0] += 40.0F * ((21.0F - grip) / 5.0F);
                if (swits[0] > 100) {
                    swits[0] = 100;
                }
            }
            bounce = 0.8F + physicsValues[3] / 100.0F * 0.6F;
            if (physicsValues[3] > 67) {
                airs *= 0.76F + (1.0F - physicsValues[3] / 100.0F) * 0.24F;
                airc *= 0.76F + (1.0F - physicsValues[3] / 100.0F) * 0.24F;
            }
            lift = (int) ((float) physicsValues[5] * (float) physicsValues[5] / 10000.0F * 30.0F);
            revlift = (int) (physicsValues[6] / 100.0F * 32.0F);
            push = (int) (2.0F + physicsValues[7] / 100.0F * 2.0F * ((30 - lift) / 30));
            revpush = (int) (1.0F + physicsValues[8] / 100.0F * 2.0F);
            comprad = radius / 400.0F + (statValues[3] - 16) / 184.0F * 0.2F;
            if (comprad < 0.4) {
                comprad = 0.4F;
            }
            simag = (wheelat - 17) * 0.0167F + 0.85F;
        } else {
            names = "";
        }
        
        //

        this.swits = swits;
        this.acelf = acelf;

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
}
