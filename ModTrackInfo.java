/* ModTrackInfo - Decompiled by JODE extended
 * DragShot Software
 * JODE (c) 1998-2001 Jochen Hoenicke
 */
class ModTrackInfo {
    int[] arp;
    int arpindex;
    int effect;
    int error;
    int finetune_rate;
    int length;
    int old_position;
    int oldperiod = 1;
    int oldsampofs;
    int period;
    int period_high_limit;
    int period_low_limit;
    int pitch;
    int port_down;
    int port_inc;
    int port_up;
    int portto;
    int position;
    int repeat;
    int replen;
    byte retrig;
    byte[] samples;
    int start_period;
    int step;
    int trem_depth;
    int trem_rate;
    int trempos;
    int vib_depth;
    int vib_rate;
    int vibpos;
    int vol_slide;
    int volume;

    ModTrackInfo() {
        arp = new int[3];
    }
}
