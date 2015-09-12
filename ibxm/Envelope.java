/*    */ package ibxm;
/*    */ 
/*    */ public class Envelope
/*    */ {
/*  5 */   public boolean enabled = false; public boolean sustain = false; public boolean looped = false;
/*  6 */   public int sustainTick = 0; public int loopStartTick = 0; public int loopEndTick = 0;
/*  7 */   public int numPoints = 1;
/*  8 */   public int[] pointsTick = new int[1];
/*  9 */   public int[] pointsAmpl = new int[1];
/*    */   
/*    */   public int nextTick(int tick, boolean keyOn) {
/*    */     
/* 13 */     if ((this.looped) && (tick >= this.loopEndTick)) tick = this.loopStartTick;
/* 14 */     if ((this.sustain) && (keyOn) && (tick >= this.sustainTick)) tick = this.sustainTick;
/* 15 */     return tick;
/*    */   }
/*    */   
/*    */   public int calculateAmpl(int tick) {
/* 19 */     int ampl = this.pointsAmpl[(this.numPoints - 1)];
/* 20 */     if (tick < this.pointsTick[(this.numPoints - 1)]) {
/* 21 */       int point = 0;
/* 22 */       for (int idx = 1; idx < this.numPoints; idx++)
/* 23 */         if (this.pointsTick[idx] <= tick) point = idx;
/* 24 */       int dt = this.pointsTick[(point + 1)] - this.pointsTick[point];
/* 25 */       int da = this.pointsAmpl[(point + 1)] - this.pointsAmpl[point];
/* 26 */       ampl = this.pointsAmpl[point];
/* 27 */       ampl += ((da << 24) / dt * (tick - this.pointsTick[point]) >> 24);
/*    */     }
/* 29 */     return ampl;
/*    */   }
/*    */   
/*    */   public void toStringBuffer(StringBuffer out) {
/* 33 */     out.append("Enabled: " + this.enabled + '\n');
/* 34 */     out.append("Sustain: " + this.sustain + '\n');
/* 35 */     out.append("Looped: " + this.looped + '\n');
/* 36 */     out.append("Sustain Tick: " + this.sustainTick + '\n');
/* 37 */     out.append("Loop Start Tick: " + this.loopStartTick + '\n');
/* 38 */     out.append("Loop End Tick: " + this.loopEndTick + '\n');
/* 39 */     out.append("Num Points: " + this.numPoints + '\n');
/* 40 */     out.append("Points: ");
/* 41 */     for (int point = 0; point < this.numPoints; point++) {
/* 42 */       out.append("(" + this.pointsTick[point] + ", " + this.pointsAmpl[point] + "), ");
/*    */     }
/* 44 */     out.append('\n');
/*    */   }
/*    */ }


/* Location:              E:\Games\Need For Madness\data\madapp.jar!\ibxm\Envelope.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */