package ibxm;

public class Envelope {
   public boolean enabled = false;
   public boolean sustain = false;
   public boolean looped = false;
   public int sustainTick = 0;
   public int loopStartTick = 0;
   public int loopEndTick = 0;
   public int numPoints = 1;
   public int[] pointsTick = new int[1];
   public int[] pointsAmpl = new int[1];

   public int nextTick(int tick, boolean keyOn) {
      ++tick;
      if(this.looped && tick >= this.loopEndTick) {
         tick = this.loopStartTick;
      }

      if(this.sustain && keyOn && tick >= this.sustainTick) {
         tick = this.sustainTick;
      }

      return tick;
   }

   public int calculateAmpl(int tick) {
      int ampl = this.pointsAmpl[this.numPoints - 1];
      if(tick < this.pointsTick[this.numPoints - 1]) {
         int point = 0;

         int dt;
         for(dt = 1; dt < this.numPoints; ++dt) {
            if(this.pointsTick[dt] <= tick) {
               point = dt;
            }
         }

         dt = this.pointsTick[point + 1] - this.pointsTick[point];
         int da = this.pointsAmpl[point + 1] - this.pointsAmpl[point];
         ampl = this.pointsAmpl[point];
         ampl += (da << 24) / dt * (tick - this.pointsTick[point]) >> 24;
      }

      return ampl;
   }

   public void toStringBuffer(StringBuffer out) {
      out.append("Enabled: " + this.enabled + '\n');
      out.append("Sustain: " + this.sustain + '\n');
      out.append("Looped: " + this.looped + '\n');
      out.append("Sustain Tick: " + this.sustainTick + '\n');
      out.append("Loop Start Tick: " + this.loopStartTick + '\n');
      out.append("Loop End Tick: " + this.loopEndTick + '\n');
      out.append("Num Points: " + this.numPoints + '\n');
      out.append("Points: ");

      for(int point = 0; point < this.numPoints; ++point) {
         out.append("(" + this.pointsTick[point] + ", " + this.pointsAmpl[point] + "), ");
      }

      out.append('\n');
   }
}
