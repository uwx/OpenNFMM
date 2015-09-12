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
/* 13 */     if ((looped) && (tick >= loopEndTick)) tick = loopStartTick;
/* 14 */     if ((sustain) && (keyOn) && (tick >= sustainTick)) tick = sustainTick;
/* 15 */     return tick;
/*    */   }
/*    */   
/*    */   public int calculateAmpl(int tick) {
/* 19 */     int ampl = pointsAmpl[(numPoints - 1)];
/* 20 */     if (tick < pointsTick[(numPoints - 1)]) {
/* 21 */       int point = 0;
/* 22 */       for (int idx = 1; idx < numPoints; idx++)
/* 23 */         if (pointsTick[idx] <= tick) point = idx;
/* 24 */       int dt = pointsTick[(point + 1)] - pointsTick[point];
/* 25 */       int da = pointsAmpl[(point + 1)] - pointsAmpl[point];
/* 26 */       ampl = pointsAmpl[point];
/* 27 */       ampl += ((da << 24) / dt * (tick - pointsTick[point]) >> 24);
/*    */     }
/* 29 */     return ampl;
/*    */   }
/*    */   
/*    */   public void toStringBuffer(StringBuffer out) {
/* 33 */     out.append("Enabled: " + enabled + '\n');
/* 34 */     out.append("Sustain: " + sustain + '\n');
/* 35 */     out.append("Looped: " + looped + '\n');
/* 36 */     out.append("Sustain Tick: " + sustainTick + '\n');
/* 37 */     out.append("Loop Start Tick: " + loopStartTick + '\n');
/* 38 */     out.append("Loop End Tick: " + loopEndTick + '\n');
/* 39 */     out.append("Num Points: " + numPoints + '\n');
/* 40 */     out.append("Points: ");
/* 41 */     for (int point = 0; point < numPoints; point++) {
/* 42 */       out.append("(" + pointsTick[point] + ", " + pointsAmpl[point] + "), ");
/*    */     }
/* 44 */     out.append('\n');
/*    */   }
/*    */ }


/* Location:              E:\Games\Need For Madness\data\madapp.jar!\ibxm\Envelope.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */