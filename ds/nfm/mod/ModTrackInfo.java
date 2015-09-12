/*    */ package ds.nfm.mod;
/*    */ 
/*    */ 
/*    */ class ModTrackInfo
/*    */ {
/*    */   byte[] samples;
/*    */   
/*    */   int position;
/*    */   
/*    */   int length;
/*    */   
/*    */   int repeat;
/*    */   
/*    */   int replen;
/*    */   int volume;
/*    */   int error;
/*    */   int pitch;
/*    */   int old_position;
/*    */   int start_period;
/*    */   int period;
/*    */   int step;
/*    */   int effect;
/*    */   int portto;
/*    */   int vibpos;
/*    */   int trempos;
/*    */   int oldsampofs;
/*    */   int[] arp;
/*    */   int arpindex;
/*    */   int oldperiod;
/*    */   int vol_slide;
/*    */   int port_inc;
/*    */   int port_up;
/*    */   int port_down;
/*    */   int vib_rate;
/*    */   int vib_depth;
/*    */   int trem_rate;
/*    */   int trem_depth;
/*    */   byte retrig;
/*    */   int finetune_rate;
/*    */   int period_low_limit;
/*    */   int period_high_limit;
/* 42 */   int noterestart = -1;
/*    */   
/* 44 */   int notelimit = -1;
/*    */   
/*    */   ModTrackInfo() {
/* 47 */     this.oldperiod = 1;
/* 48 */     this.arp = new int[3];
/*    */   }
/*    */ }


/* Location:              E:\Games\Need For Madness\data\madapp.jar!\ds\nfm\mod\ModTrackInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */