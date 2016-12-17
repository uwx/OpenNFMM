package ds.nfm.xm;

import ds.nfm.ModuleSlayer;
import ds.nfm.xm.IBXMod;
import ibxm.IBXM;
import ibxm.Module;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class IBXModSlayer extends ModuleSlayer {
   private Module module;
   private IBXM ibxm;
   private int samplePos;
   private int duration;
   private int gain = 300;
   public boolean offMark = false;
   public int offIndex = -1;
   public int[] patternOffsets;

   public IBXModSlayer(IBXMod pmod, int smpl, int gn, int bpmflex) {
      this.module = pmod.refMod;
      if(this.module.defaultTempo == 125) {
         this.module.defaultTempo = bpmflex;
      }

      this.ibxm = new IBXM(this.module, smpl / 2);
      this.ibxm.connect(this);
      this.ibxm.setInterpolation(1);
      this.gain = gn;
      this.duration = this.ibxm.calculateSongDuration();
   }

   public void offMark(int index) {
      this.offIndex = index;
      this.offMark = true;
   }

   public byte[] turnbytesNorm(boolean calvol) throws IOException {
      ByteArrayOutputStream out = new ByteArrayOutputStream();
      int[] mixBuf = new int[this.ibxm.getMixBufferLength()];
      byte[] outBuf = new byte[mixBuf.length * 2];
      this.oln = 0;
      int olniu = 1;
      boolean niu = false;
      boolean cav = false;
      int maxsize = Math.min(24000000, this.duration * 2);

      while(this.oln < maxsize) {
         int count = this.getAudio(mixBuf);
         if(this.offMark) {
            if(this.patternOffsets[this.offIndex] == 0) {
               this.patternOffsets[this.offIndex] = this.oln;
            }

            this.offMark = false;
         }

         int var15 = 0;
         int var14 = 0;
         int outIdx = 0;
         int mixIdx = 0;

         for(int mixEnd = count * 2; mixIdx < mixEnd; ++mixIdx) {
            if(mixIdx % 2 == 0) {
               int ampl = (int)((float)mixBuf[mixIdx] * ((float)this.gain / 300.0F));
               if(ampl > 32767) {
                  ampl = 32767;
               }

               if(ampl < -32768) {
                  ampl = -32768;
               }

               outBuf[outIdx++] = (byte)(ampl & 255);
               outBuf[outIdx++] = (byte)(ampl >> 8);
               this.oln += 2;
               if(calvol) {
                  var15 += Math.abs(ampl);
                  ++var14;
               }
            }
         }

         if(calvol && var14 != 0) {
            var15 /= var14;
            this.olav += var15;
            ++olniu;
         }

         out.write(outBuf, 0, outIdx);
         if(this.loopMark) {
            this.rollBackTrig = this.oln;
            this.loopMark = false;
         }
      }

      if(calvol) {
         this.olav /= olniu;
      }

      if(this.oln % 2 != 0) {
         ++this.oln;
      }

      return out.toByteArray();
   }

//   private synchronized void seek(int pos) {
//      this.samplePos = this.ibxm.seek(pos);
//   }

   private synchronized int getAudio(int[] mixBuf) {
      int count = this.ibxm.getAudio(mixBuf);
      this.samplePos += count;
      return count;
   }
}
