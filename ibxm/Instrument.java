/*    */ package ibxm;
/*    */ 
/*    */ public class Instrument
/*    */ {
/*  5 */   public String name = "";
/*  6 */   public int numSamples = 1;
/*  7 */   public int vibratoType = 0; public int vibratoSweep = 0; public int vibratoDepth = 0; public int vibratoRate = 0;
/*  8 */   public int volumeFadeOut = 0;
/*  9 */   public Envelope volumeEnvelope = new Envelope();
/* 10 */   public Envelope panningEnvelope = new Envelope();
/* 11 */   public int[] keyToSample = new int[97];
/* 12 */   public Sample[] samples = { new Sample() };
/*    */   
/*    */   public void toStringBuffer(StringBuffer out) {
/* 15 */     out.append("Name: " + name + '\n');
/* 16 */     if (numSamples > 0) {
/* 17 */       out.append("Num Samples: " + numSamples + '\n');
/* 18 */       out.append("Vibrato Type: " + vibratoType + '\n');
/* 19 */       out.append("Vibrato Sweep: " + vibratoSweep + '\n');
/* 20 */       out.append("Vibrato Depth: " + vibratoDepth + '\n');
/* 21 */       out.append("Vibrato Rate: " + vibratoRate + '\n');
/* 22 */       out.append("Volume Fade Out: " + volumeFadeOut + '\n');
/* 23 */       out.append("Volume Envelope:\n");
/* 24 */       volumeEnvelope.toStringBuffer(out);
/* 25 */       out.append("Panning Envelope:\n");
/* 26 */       panningEnvelope.toStringBuffer(out);
/* 27 */       for (int samIdx = 0; samIdx < numSamples; samIdx++) {
/* 28 */         out.append("Sample " + samIdx + ":\n");
/* 29 */         samples[samIdx].toStringBuffer(out);
/*    */       }
/* 31 */       out.append("Key To Sample: ");
/* 32 */       for (int keyIdx = 1; keyIdx < 97; keyIdx++)
/* 33 */         out.append(keyToSample[keyIdx] + ", ");
/* 34 */       out.append('\n');
/*    */     }
/*    */   }
/*    */ }


/* Location:              E:\Games\Need For Madness\data\madapp.jar!\ibxm\Instrument.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */