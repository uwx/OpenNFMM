package ibxm;

import ds.nfm.xm.IBXModSlayer;
import ibxm.Channel;
import ibxm.GlobalVol;
import ibxm.Module;
import ibxm.Note;
import ibxm.Pattern;

/*
	ProTracker, Scream Tracker 3, FastTracker 2 Replay (c)2016 mumart@gmail.com
*/
public class IBXM {
   public static final String VERSION = "a69 (c)2014 mumart@gmail.com";
   private Module module;
   private int[] rampBuf;
   private Channel[] channels;
   private int sampleRate;
   private int interpolation;
   private int seqPos;
   private int breakSeqPos;
   private int row;
   private int nextRow;
   private int tick;
   private int speed;
   private int tempo;
   private int plCount;
   private int plChannel;
   private GlobalVol globalVol;
   private Note note;
   private IBXModSlayer slayer;
   private boolean mustNotify = false;

   public IBXM(Module module, int samplingRate) {
      this.module = module;
      this.setSampleRate(samplingRate);
      this.interpolation = 1;
      this.rampBuf = new int[128];
      this.channels = new Channel[module.numChannels];
      this.globalVol = new GlobalVol();
      this.note = new Note();
      this.setSequencePos(0);
   }

   public void connect(IBXModSlayer slayer) {
      this.slayer = slayer;
      slayer.patternOffsets = new int[this.module.sequenceLength];
   }

   public int getSampleRate() {
      return this.sampleRate;
   }

   public void setSampleRate(int rate) {
      if(rate >= 8000 && rate <= 128000) {
         this.sampleRate = rate;
      } else {
         throw new IllegalArgumentException("Unsupported sampling rate!");
      }
   }

   public void setInterpolation(int interpolation) {
      this.interpolation = interpolation;
   }

   public int getMixBufferLength() {
      return (this.calculateTickLen(32, 128000) + 65) * 4;
   }

   public int getRow() {
      return this.row;
   }

   public int getSequencePos() {
      return this.seqPos;
   }

   public void setSequencePos(int pos) {
      if(pos >= this.module.sequenceLength) {
         pos = 0;
      }

      this.breakSeqPos = pos;
      this.nextRow = 0;
      this.tick = 1;
      this.globalVol.volume = this.module.defaultGVol;
      this.speed = this.module.defaultSpeed > 0?this.module.defaultSpeed:6;
      this.tempo = this.module.defaultTempo > 0?this.module.defaultTempo:125;
      this.plCount = this.plChannel = -1;

      int idx;
      for(idx = 0; idx < this.module.numChannels; ++idx) {
         this.channels[idx] = new Channel(this.module, idx, this.globalVol);
      }

      for(idx = 0; idx < 128; ++idx) {
         this.rampBuf[idx] = 0;
      }

      this.tick();
   }

   public int calculateSongDuration() {
      int duration = 0;
      this.setSequencePos(0);

      for(boolean songEnd = false; !songEnd; songEnd = this.tick()) {
         duration += this.calculateTickLen(this.tempo, this.sampleRate);
      }

      this.setSequencePos(0);
      return duration;
   }

   public int seek(int samplePos) {
      this.setSequencePos(0);
      int currentPos = 0;

      for(int tickLen = this.calculateTickLen(this.tempo, this.sampleRate); samplePos - currentPos >= tickLen; tickLen = this.calculateTickLen(this.tempo, this.sampleRate)) {
         for(int idx = 0; idx < this.module.numChannels; ++idx) {
            this.channels[idx].updateSampleIdx(tickLen * 2, this.sampleRate * 2);
         }

         currentPos += tickLen;
         this.tick();
      }

      return currentPos;
   }

   public void seekSequencePos(int sequencePos, int sequenceRow) {
      this.setSequencePos(0);
      if(sequencePos < 0 || sequencePos >= this.module.sequenceLength) {
         sequencePos = 0;
      }

      if(sequenceRow >= this.module.patterns[this.module.sequence[sequencePos]].numRows) {
         sequenceRow = 0;
      }

      do {
         if(this.seqPos >= sequencePos && this.row >= sequenceRow) {
            return;
         }

         int tickLen = this.calculateTickLen(this.tempo, this.sampleRate);

         for(int idx = 0; idx < this.module.numChannels; ++idx) {
            this.channels[idx].updateSampleIdx(tickLen * 2, this.sampleRate * 2);
         }
      } while(!this.tick());

      this.setSequencePos(sequencePos);
   }

   public int getAudio(int[] outputBuf) {
      int tickLen = this.calculateTickLen(this.tempo, this.sampleRate);
      int chanIdx = 0;

      for(int chan = (tickLen + 65) * 4; chanIdx < chan; ++chanIdx) {
         outputBuf[chanIdx] = 0;
      }

      for(chanIdx = 0; chanIdx < this.module.numChannels; ++chanIdx) {
         Channel var5 = this.channels[chanIdx];
         var5.resample(outputBuf, 0, (tickLen + 65) * 2, this.sampleRate * 2, this.interpolation);
         var5.updateSampleIdx(tickLen * 2, this.sampleRate * 2);
      }

      this.downsample(outputBuf, tickLen + 64);
      this.volumeRamp(outputBuf, tickLen);
      this.tick();
      return tickLen;
   }

   private int calculateTickLen(int tempo, int samplingRate) {
      return samplingRate * 5 / (tempo * 2);
   }

   private void volumeRamp(int[] mixBuf, int tickLen) {
      int rampRate = 524288 / this.sampleRate;
      int idx = 0;

      for(int a1 = 0; a1 < 256; a1 += rampRate) {
         int a2 = 256 - a1;
         mixBuf[idx] = mixBuf[idx] * a1 + this.rampBuf[idx] * a2 >> 8;
         mixBuf[idx + 1] = mixBuf[idx + 1] * a1 + this.rampBuf[idx + 1] * a2 >> 8;
         idx += 2;
      }

      System.arraycopy(mixBuf, tickLen * 2, this.rampBuf, 0, 128);
   }

   private void downsample(int[] buf, int count) {
      int outLen = count * 2;
      int inIdx = 0;

      for(int outIdx = 0; outIdx < outLen; outIdx += 2) {
         buf[outIdx] = (buf[inIdx] >> 2) + (buf[inIdx + 2] >> 1) + (buf[inIdx + 4] >> 2);
         buf[outIdx + 1] = (buf[inIdx + 1] >> 2) + (buf[inIdx + 3] >> 1) + (buf[inIdx + 5] >> 2);
         inIdx += 4;
      }

   }

   private boolean tick() {
      boolean songEnd = false;
      if(--this.tick <= 0) {
         this.tick = this.speed;
         songEnd = this.row();
      } else {
         for(int idx = 0; idx < this.module.numChannels; ++idx) {
            this.channels[idx].tick();
         }
      }

      return songEnd;
   }

   private boolean row() {
      boolean songEnd = false;
      if(this.breakSeqPos >= 0) {
         if(this.breakSeqPos >= this.module.sequenceLength) {
            this.breakSeqPos = this.nextRow = 0;
            songEnd = true;
         }

         while(this.module.sequence[this.breakSeqPos] >= this.module.numPatterns) {
            ++this.breakSeqPos;
            if(this.breakSeqPos >= this.module.sequenceLength) {
               this.breakSeqPos = this.nextRow = 0;
            }
         }

         if(this.breakSeqPos <= this.seqPos) {
            songEnd = true;
            if(this.slayer != null && this.slayer.patternOffsets[this.breakSeqPos] != 0) {
               this.slayer.loopMark = true;
               this.slayer.rollBack = this.breakSeqPos;
               this.slayer.rollBackPos = this.slayer.patternOffsets[this.breakSeqPos];
            }
         }

         this.seqPos = this.breakSeqPos;

         for(int pattern = 0; pattern < this.module.numChannels; ++pattern) {
            this.channels[pattern].plRow = 0;
         }

         this.breakSeqPos = -1;
      }

      Pattern var6 = this.module.patterns[this.module.sequence[this.seqPos]];
      this.row = this.nextRow;
      if(this.row >= var6.numRows) {
         this.row = 0;
      }

      if(this.row == 0) {
         this.mustNotify = true;
      }

      if(this.mustNotify) {
         if(this.slayer != null && this.breakSeqPos < this.module.sequenceLength) {
            this.slayer.offMark(this.seqPos);
         }

         this.mustNotify = false;
      }

      this.nextRow = this.row + 1;
      if(this.nextRow >= var6.numRows) {
         this.breakSeqPos = this.seqPos + 1;
         this.nextRow = 0;
      }

      int noteIdx = this.row * this.module.numChannels;

      for(int chanIdx = 0; chanIdx < this.module.numChannels; ++chanIdx) {
         Channel channel = this.channels[chanIdx];
         var6.getNote(noteIdx + chanIdx, this.note);
         if(this.note.effect == 14) {
            this.note.effect = 112 | this.note.param >> 4;
            this.note.param &= 15;
         }

         if(this.note.effect == 147) {
            this.note.effect = 240 | this.note.param >> 4;
            this.note.param &= 15;
         }

         if(this.note.effect == 0 && this.note.param > 0) {
            this.note.effect = 138;
         }

         channel.row(this.note);
         switch(this.note.effect) {
         case 11:
         case 130:
            if(this.plCount < 0) {
               this.breakSeqPos = this.note.param;
               this.nextRow = 0;
               this.mustNotify = true;
            }
            break;
         case 13:
         case 131:
            if(this.plCount < 0) {
               this.breakSeqPos = this.seqPos + 1;
               this.nextRow = (this.note.param >> 4) * 10 + (this.note.param & 15);
               this.mustNotify = true;
            }
            break;
         case 15:
            if(this.note.param > 0) {
               if(this.note.param < 32) {
                  this.tick = this.speed = this.note.param;
               } else {
                  this.tempo = this.note.param;
               }
            }
            break;
         case 118:
         case 251:
            if(this.note.param == 0) {
               channel.plRow = this.row;
            }

            if(channel.plRow < this.row) {
               if(this.plCount < 0) {
                  this.plCount = this.note.param;
                  this.plChannel = chanIdx;
               }

               if(this.plChannel == chanIdx) {
                  if(this.plCount == 0) {
                     channel.plRow = this.row + 1;
                  } else {
                     this.nextRow = channel.plRow;
                     this.breakSeqPos = -1;
                  }

                  --this.plCount;
               }
            }
            break;
         case 126:
         case 254:
            this.tick = this.speed + this.speed * this.note.param;
            break;
         case 129:
            if(this.note.param > 0) {
               this.tick = this.speed = this.note.param;
            }
            break;
         case 148:
            if(this.note.param > 32) {
               this.tempo = this.note.param;
            }
         }
      }

      return songEnd;
   }
}
