package ibxm;

import ibxm.Envelope;
import ibxm.Sample;

public class Instrument {
   public String name = "";
   public int numSamples = 1;
   public int vibratoType = 0;
   public int vibratoSweep = 0;
   public int vibratoDepth = 0;
   public int vibratoRate = 0;
   public int volumeFadeOut = 0;
   public Envelope volumeEnvelope = new Envelope();
   public Envelope panningEnvelope = new Envelope();
   public int[] keyToSample = new int[97];
   public Sample[] samples = new Sample[]{new Sample()};

   public void toStringBuffer(StringBuffer out) {
      out.append("Name: " + this.name + '\n');
      if(this.numSamples > 0) {
         out.append("Num Samples: " + this.numSamples + '\n');
         out.append("Vibrato Type: " + this.vibratoType + '\n');
         out.append("Vibrato Sweep: " + this.vibratoSweep + '\n');
         out.append("Vibrato Depth: " + this.vibratoDepth + '\n');
         out.append("Vibrato Rate: " + this.vibratoRate + '\n');
         out.append("Volume Fade Out: " + this.volumeFadeOut + '\n');
         out.append("Volume Envelope:\n");
         this.volumeEnvelope.toStringBuffer(out);
         out.append("Panning Envelope:\n");
         this.panningEnvelope.toStringBuffer(out);

         int keyIdx;
         for(keyIdx = 0; keyIdx < this.numSamples; ++keyIdx) {
            out.append("Sample " + keyIdx + ":\n");
            this.samples[keyIdx].toStringBuffer(out);
         }

         out.append("Key To Sample: ");

         for(keyIdx = 1; keyIdx < 97; ++keyIdx) {
            out.append(this.keyToSample[keyIdx] + ", ");
         }

         out.append('\n');
      }

   }
}
