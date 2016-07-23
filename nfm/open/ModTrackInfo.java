package nfm.open;

/* nfm.open.ModTrackInfo - Decompiled by JODE extended
 * DragShot Software
 * JODE (c) 1998-2001 Jochen Hoenicke
 */
class ModTrackInfo {
    private final int[] arp;
    int arpindex;
    int effect;
    int error;
    int finetuneRate;
    int length;
    int oldPosition;
    int oldperiod = 1;
    int oldsampofs;
    int period;
    int periodHighLimit;
    int periodLowLimit;
    int pitch;
    int portDown;
    int portInc;
    int portUp;
    int portto;
    int position;
    int repeat;
    int replen;
    byte retrig;
    byte[] samples;
    int startPeriod;
    int step;
    int tremDepth;
    int tremRate;
    int trempos;
    int vibDepth;
    int vibRate;
    int vibpos;
    int volSlide;
    int volume;

    ModTrackInfo() {
        arp = new int[3];
    }
}
