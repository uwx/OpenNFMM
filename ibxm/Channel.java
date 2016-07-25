package ibxm;

import ibxm.GlobalVol;
import ibxm.Instrument;
import ibxm.Module;
import ibxm.Note;
import ibxm.Sample;

public class Channel {
   public static final int NEAREST = 0;
   public static final int LINEAR = 1;
   public static final int SINC = 2;
   private static final int[] periodTable = new int[]{29021, 28812, 28605, 28399, 28195, 27992, 27790, 27590, 27392, 27195, 26999, 26805, 26612, 26421, 26231, 26042, 25855, 25669, 25484, 25301, 25119, 24938, 24758, 24580, 24403, 24228, 24054, 23881, 23709, 23538, 23369, 23201, 23034, 22868, 22704, 22540, 22378, 22217, 22057, 21899, 21741, 21585, 21429, 21275, 21122, 20970, 20819, 20670, 20521, 20373, 20227, 20081, 19937, 19793, 19651, 19509, 19369, 19230, 19091, 18954, 18818, 18682, 18548, 18414, 18282, 18150, 18020, 17890, 17762, 17634, 17507, 17381, 17256, 17132, 17008, 16886, 16765, 16644, 16524, 16405, 16287, 16170, 16054, 15938, 15824, 15710, 15597, 15485, 15373, 15263, 15153, 15044, 14936, 14828, 14721, 14616, 14510, 14406, 14302, 14199, 14097, 13996, 13895, 13795, 13696, 13597, 13500, 13403, 13306, 13210, 13115, 13021, 12927, 12834, 12742, 12650, 12559, 12469, 12379, 12290, 12202, 12114, 12027, 11940, 11854, 11769, 11684, 11600};
   private static final int[] freqTable = new int[]{267616, 269555, 271509, 273476, 275458, 277454, 279464, 281489, 283529, 285584, 287653, 289738, 291837, 293952, 296082, 298228, 300389, 302566, 304758, 306966, 309191, 311431, 313688, 315961, 318251, 320557, 322880, 325220, 327576, 329950, 332341, 334749, 337175, 339618, 342079, 344558, 347055, 349570, 352103, 354655, 357225, 359813, 362420, 365047, 367692, 370356, 373040, 375743, 378466, 381209, 383971, 386754, 389556, 392379, 395222, 398086, 400971, 403877, 406803, 409751, 412720, 415711, 418723, 421758, 424814, 427892, 430993, 434116, 437262, 440430, 443622, 446837, 450075, 453336, 456621, 459930, 463263, 466620, 470001, 473407, 476838, 480293, 483773, 487279, 490810, 494367, 497949, 501557, 505192, 508853, 512540, 516254, 519995, 523763, 527558, 531381, 535232, 539111, 543017, 546952, 550915, 554908, 558929, 562979};
   private static final short[] sineTable = new short[]{0, 24, 49, 74, 97, 120, 141, 161, 180, 197, 212, 224, 235, 244, 250, 253, 255, 253, 250, 244, 235, 224, 212, 197, 180, 161, 141, 120, 97, 74, 49, 24};
   private Module module;
   private GlobalVol globalVol;
   private Instrument instrument;
   private Sample sample;
   private boolean keyOn;
   private int noteKey;
   private int noteIns;
   private int noteVol;
   private int noteEffect;
   private int noteParam;
   private int sampleOffset;
   private int sampleIdx;
   private int sampleFra;
   private int freq;
   private int ampl;
   private int pann;
   private int volume;
   private int panning;
   private int fadeOutVol;
   private int volEnvTick;
   private int panEnvTick;
   private int period;
   private int portaPeriod;
   private int retrigCount;
   private int fxCount;
   private int autoVibratoCount;
   private int portaUpParam;
   private int portaDownParam;
   private int tonePortaParam;
   private int offsetParam;
   private int finePortaUpParam;
   private int finePortaDownParam;
   private int extraFinePortaParam;
   private int arpeggioParam;
   private int vslideParam;
   private int globalVslideParam;
   private int panningSlideParam;
   private int fineVslideUpParam;
   private int fineVslideDownParam;
   private int retrigVolume;
   private int retrigTicks;
   private int tremorOnTicks;
   private int tremorOffTicks;
   private int vibratoType;
   private int vibratoPhase;
   private int vibratoSpeed;
   private int vibratoDepth;
   private int tremoloType;
   private int tremoloPhase;
   private int tremoloSpeed;
   private int tremoloDepth;
   private int tremoloAdd;
   private int vibratoAdd;
   private int arpeggioAdd;
   private int id;
   private int randomSeed;
   public int plRow;

   public Channel(Module module, int id, GlobalVol globalVol) {
      this.module = module;
      this.id = id;
      this.globalVol = globalVol;
      this.panning = module.defaultPanning[id];
      this.instrument = new Instrument();
      this.sample = this.instrument.samples[0];
      this.randomSeed = (id + 1) * 11259375;
   }

   public void resample(int[] outBuf, int offset, int length, int sampleRate, int interpolation) {
      if(this.ampl > 0) {
         int lAmpl = this.ampl * 255 >> 8;
         int rAmpl = this.ampl * 255 >> 8;
         int step = (this.freq << 12) / (sampleRate >> 3);
         switch(interpolation) {
         case 0:
            this.sample.resampleNearest(this.sampleIdx, this.sampleFra, step, lAmpl, rAmpl, outBuf, offset, length);
            break;
         case 1:
         default:
            this.sample.resampleLinear(this.sampleIdx, this.sampleFra, step, lAmpl, rAmpl, outBuf, offset, length);
            break;
         case 2:
            this.sample.resampleSinc(this.sampleIdx, this.sampleFra, step, lAmpl, rAmpl, outBuf, offset, length);
         }

      }
   }

   public void updateSampleIdx(int length, int sampleRate) {
      int step = (this.freq << 12) / (sampleRate >> 3);
      this.sampleFra += step * length;
      this.sampleIdx = this.sample.normaliseSampleIdx(this.sampleIdx + (this.sampleFra >> 15));
      this.sampleFra &= 32767;
   }

   public void row(Note note) {
      this.noteKey = note.key;
      this.noteIns = note.instrument;
      this.noteVol = note.volume;
      this.noteEffect = note.effect;
      this.noteParam = note.param;
      ++this.retrigCount;
      this.vibratoAdd = this.tremoloAdd = this.arpeggioAdd = this.fxCount = 0;
      if(this.noteEffect != 125 && this.noteEffect != 253 || this.noteParam <= 0) {
         this.trigger();
      }

      label157:
      switch(this.noteEffect) {
      case 1:
      case 134:
         if(this.noteParam > 0) {
            this.portaUpParam = this.noteParam;
         }

         this.portamentoUp(this.portaUpParam);
         break;
      case 2:
      case 133:
         if(this.noteParam > 0) {
            this.portaDownParam = this.noteParam;
         }

         this.portamentoDown(this.portaDownParam);
         break;
      case 3:
      case 135:
         if(this.noteParam > 0) {
            this.tonePortaParam = this.noteParam;
         }
         break;
      case 4:
      case 136:
         if(this.noteParam >> 4 > 0) {
            this.vibratoSpeed = this.noteParam >> 4;
         }

         if((this.noteParam & 15) > 0) {
            this.vibratoDepth = this.noteParam & 15;
         }

         this.vibrato(false);
         break;
      case 5:
      case 140:
         if(this.noteParam > 0) {
            this.vslideParam = this.noteParam;
         }

         this.volumeSlide();
         break;
      case 6:
      case 139:
         if(this.noteParam > 0) {
            this.vslideParam = this.noteParam;
         }

         this.vibrato(false);
         this.volumeSlide();
         break;
      case 7:
      case 146:
         if(this.noteParam >> 4 > 0) {
            this.tremoloSpeed = this.noteParam >> 4;
         }

         if((this.noteParam & 15) > 0) {
            this.tremoloDepth = this.noteParam & 15;
         }

         this.tremolo();
         break;
      case 8:
         this.panning = this.noteParam < 128?this.noteParam << 1:255;
         break;
      case 10:
      case 132:
         if(this.noteParam > 0) {
            this.vslideParam = this.noteParam;
         }

         this.volumeSlide();
         break;
      case 12:
         this.volume = this.noteParam >= 64?64:this.noteParam & 63;
         break;
      case 16:
      case 150:
         this.globalVol.volume = this.noteParam >= 64?64:this.noteParam & 63;
         break;
      case 17:
         if(this.noteParam > 0) {
            this.globalVslideParam = this.noteParam;
         }
         break;
      case 20:
         this.keyOn = false;
         break;
      case 21:
         this.volEnvTick = this.panEnvTick = this.noteParam & 255;
         break;
      case 25:
         if(this.noteParam > 0) {
            this.panningSlideParam = this.noteParam;
         }
         break;
      case 27:
      case 145:
         if(this.noteParam >> 4 > 0) {
            this.retrigVolume = this.noteParam >> 4;
         }

         if((this.noteParam & 15) > 0) {
            this.retrigTicks = this.noteParam & 15;
         }

         this.retrigVolSlide();
         break;
      case 29:
      case 137:
         if(this.noteParam >> 4 > 0) {
            this.tremorOnTicks = this.noteParam >> 4;
         }

         if((this.noteParam & 15) > 0) {
            this.tremorOffTicks = this.noteParam & 15;
         }

         this.tremor();
         break;
      case 33:
         if(this.noteParam > 0) {
            this.extraFinePortaParam = this.noteParam;
         }

         switch(this.extraFinePortaParam & 240) {
         case 16:
            this.portamentoUp(224 | this.extraFinePortaParam & 15);
            break label157;
         case 32:
            this.portamentoDown(224 | this.extraFinePortaParam & 15);
         default:
            break label157;
         }
      case 113:
         if(this.noteParam > 0) {
            this.finePortaUpParam = this.noteParam;
         }

         this.portamentoUp(240 | this.finePortaUpParam & 15);
         break;
      case 114:
         if(this.noteParam > 0) {
            this.finePortaDownParam = this.noteParam;
         }

         this.portamentoDown(240 | this.finePortaDownParam & 15);
         break;
      case 116:
      case 243:
         if(this.noteParam < 8) {
            this.vibratoType = this.noteParam;
         }
         break;
      case 119:
      case 244:
         if(this.noteParam < 8) {
            this.tremoloType = this.noteParam;
         }
         break;
      case 122:
         if(this.noteParam > 0) {
            this.fineVslideUpParam = this.noteParam;
         }

         this.volume += this.fineVslideUpParam;
         if(this.volume > 64) {
            this.volume = 64;
         }
         break;
      case 123:
         if(this.noteParam > 0) {
            this.fineVslideDownParam = this.noteParam;
         }

         this.volume -= this.fineVslideDownParam;
         if(this.volume < 0) {
            this.volume = 0;
         }
         break;
      case 124:
      case 252:
         if(this.noteParam <= 0) {
            this.volume = 0;
         }
         break;
      case 138:
         if(this.noteParam > 0) {
            this.arpeggioParam = this.noteParam;
         }
         break;
      case 149:
         if(this.noteParam >> 4 > 0) {
            this.vibratoSpeed = this.noteParam >> 4;
         }

         if((this.noteParam & 15) > 0) {
            this.vibratoDepth = this.noteParam & 15;
         }

         this.vibrato(true);
         break;
      case 248:
         this.panning = this.noteParam * 17;
      }

      this.autoVibrato();
      this.calculateFrequency();
      this.calculateAmplitude();
      this.updateEnvelopes();
   }

   public void tick() {
      this.vibratoAdd = 0;
      ++this.fxCount;
      ++this.retrigCount;
      if(this.noteEffect != 125 || this.fxCount > this.noteParam) {
         switch(this.noteVol & 240) {
         case 96:
            this.volume -= this.noteVol & 15;
            if(this.volume < 0) {
               this.volume = 0;
            }
            break;
         case 112:
            this.volume += this.noteVol & 15;
            if(this.volume > 64) {
               this.volume = 64;
            }
            break;
         case 176:
            this.vibratoPhase += this.vibratoSpeed;
            this.vibrato(false);
            break;
         case 208:
            this.panning -= this.noteVol & 15;
            if(this.panning < 0) {
               this.panning = 0;
            }
            break;
         case 224:
            this.panning += this.noteVol & 15;
            if(this.panning > 255) {
               this.panning = 255;
            }
            break;
         case 240:
            this.tonePortamento();
         }
      }

      switch(this.noteEffect) {
      case 1:
      case 134:
         this.portamentoUp(this.portaUpParam);
         break;
      case 2:
      case 133:
         this.portamentoDown(this.portaDownParam);
         break;
      case 3:
      case 135:
         this.tonePortamento();
         break;
      case 4:
      case 136:
         this.vibratoPhase += this.vibratoSpeed;
         this.vibrato(false);
         break;
      case 5:
      case 140:
         this.tonePortamento();
         this.volumeSlide();
         break;
      case 6:
      case 139:
         this.vibratoPhase += this.vibratoSpeed;
         this.vibrato(false);
         this.volumeSlide();
         break;
      case 7:
      case 146:
         this.tremoloPhase += this.tremoloSpeed;
         this.tremolo();
         break;
      case 10:
      case 132:
         this.volumeSlide();
         break;
      case 17:
         this.globalVol.volume += (this.globalVslideParam >> 4) - (this.globalVslideParam & 15);
         if(this.globalVol.volume < 0) {
            this.globalVol.volume = 0;
         }

         if(this.globalVol.volume > 64) {
            this.globalVol.volume = 64;
         }
         break;
      case 25:
         this.panning += (this.panningSlideParam >> 4) - (this.panningSlideParam & 15);
         if(this.panning < 0) {
            this.panning = 0;
         }

         if(this.panning > 255) {
            this.panning = 255;
         }
         break;
      case 27:
      case 145:
         this.retrigVolSlide();
         break;
      case 29:
      case 137:
         this.tremor();
         break;
      case 121:
         if(this.fxCount >= this.noteParam) {
            this.fxCount = 0;
            this.sampleIdx = this.sampleFra = 0;
         }
         break;
      case 124:
      case 252:
         if(this.noteParam == this.fxCount) {
            this.volume = 0;
         }
         break;
      case 125:
      case 253:
         if(this.noteParam == this.fxCount) {
            this.trigger();
         }
         break;
      case 138:
         if(this.fxCount > 2) {
            this.fxCount = 0;
         }

         if(this.fxCount == 0) {
            this.arpeggioAdd = 0;
         }

         if(this.fxCount == 1) {
            this.arpeggioAdd = this.arpeggioParam >> 4;
         }

         if(this.fxCount == 2) {
            this.arpeggioAdd = this.arpeggioParam & 15;
         }
         break;
      case 149:
         this.vibratoPhase += this.vibratoSpeed;
         this.vibrato(true);
      }

      this.autoVibrato();
      this.calculateFrequency();
      this.calculateAmplitude();
      this.updateEnvelopes();
   }

   private void updateEnvelopes() {
      if(this.instrument.volumeEnvelope.enabled) {
         if(!this.keyOn) {
            this.fadeOutVol -= this.instrument.volumeFadeOut;
            if(this.fadeOutVol < 0) {
               this.fadeOutVol = 0;
            }
         }

         this.volEnvTick = this.instrument.volumeEnvelope.nextTick(this.volEnvTick, this.keyOn);
      }

      if(this.instrument.panningEnvelope.enabled) {
         this.panEnvTick = this.instrument.panningEnvelope.nextTick(this.panEnvTick, this.keyOn);
      }

   }

   private void autoVibrato() {
      int depth = this.instrument.vibratoDepth & 127;
      if(depth > 0) {
         int sweep = this.instrument.vibratoSweep & 127;
         int rate = this.instrument.vibratoRate & 127;
         int type = this.instrument.vibratoType;
         if(this.autoVibratoCount < sweep) {
            depth = depth * this.autoVibratoCount / sweep;
         }

         this.vibratoAdd += this.waveform(this.autoVibratoCount * rate >> 2, type + 4) * depth >> 8;
         ++this.autoVibratoCount;
      }

   }

   private void volumeSlide() {
      int up = this.vslideParam >> 4;
      int down = this.vslideParam & 15;
      if(down == 15 && up > 0) {
         if(this.fxCount == 0) {
            this.volume += up;
         }
      } else if(up == 15 && down > 0) {
         if(this.fxCount == 0) {
            this.volume -= down;
         }
      } else if(this.fxCount > 0 || this.module.fastVolSlides) {
         this.volume += up - down;
      }

      if(this.volume > 64) {
         this.volume = 64;
      }

      if(this.volume < 0) {
         this.volume = 0;
      }

   }

   private void portamentoUp(int param) {
      switch(param & 240) {
      case 224:
         if(this.fxCount == 0) {
            this.period -= param & 15;
         }
         break;
      case 240:
         if(this.fxCount == 0) {
            this.period -= (param & 15) << 2;
         }
         break;
      default:
         if(this.fxCount > 0) {
            this.period -= param << 2;
         }
      }

      if(this.period < 0) {
         this.period = 0;
      }

   }

   private void portamentoDown(int param) {
      if(this.period > 0) {
         switch(param & 240) {
         case 224:
            if(this.fxCount == 0) {
               this.period += param & 15;
            }
            break;
         case 240:
            if(this.fxCount == 0) {
               this.period += (param & 15) << 2;
            }
            break;
         default:
            if(this.fxCount > 0) {
               this.period += param << 2;
            }
         }

         if(this.period > '\uffff') {
            this.period = '\uffff';
         }
      }

   }

   private void tonePortamento() {
      if(this.period > 0) {
         if(this.period < this.portaPeriod) {
            this.period += this.tonePortaParam << 2;
            if(this.period > this.portaPeriod) {
               this.period = this.portaPeriod;
            }
         } else {
            this.period -= this.tonePortaParam << 2;
            if(this.period < this.portaPeriod) {
               this.period = this.portaPeriod;
            }
         }
      }

   }

   private void vibrato(boolean fine) {
      this.vibratoAdd = this.waveform(this.vibratoPhase, this.vibratoType & 3) * this.vibratoDepth >> (fine?7:5);
   }

   private void tremolo() {
      this.tremoloAdd = this.waveform(this.tremoloPhase, this.tremoloType & 3) * this.tremoloDepth >> 6;
   }

   private int waveform(int phase, int type) {
      boolean amplitude = false;
      int amplitude1;
      switch(type) {
      case 1:
      case 7:
         amplitude1 = 255 - ((phase + 32 & 63) << 3);
         break;
      case 2:
      case 5:
         amplitude1 = (phase & 32) > 0?255:-255;
         break;
      case 3:
      case 8:
         amplitude1 = (this.randomSeed >> 20) - 255;
         this.randomSeed = this.randomSeed * 65 + 17 & 536870911;
         break;
      case 4:
      default:
         amplitude1 = sineTable[phase & 31];
         if((phase & 32) > 0) {
            amplitude1 = -amplitude1;
         }
         break;
      case 6:
         amplitude1 = ((phase + 32 & 63) << 3) - 255;
      }

      return amplitude1;
   }

   private void tremor() {
      if(this.retrigCount >= this.tremorOnTicks) {
         this.tremoloAdd = -64;
      }

      if(this.retrigCount >= this.tremorOnTicks + this.tremorOffTicks) {
         this.tremoloAdd = this.retrigCount = 0;
      }

   }

   private void retrigVolSlide() {
      if(this.retrigCount >= this.retrigTicks) {
         this.retrigCount = this.sampleIdx = this.sampleFra = 0;
         switch(this.retrigVolume) {
         case 1:
            --this.volume;
            break;
         case 2:
            this.volume -= 2;
            break;
         case 3:
            this.volume -= 4;
            break;
         case 4:
            this.volume -= 8;
            break;
         case 5:
            this.volume -= 16;
            break;
         case 6:
            this.volume -= this.volume / 3;
            break;
         case 7:
            this.volume >>= 1;
         case 8:
         default:
            break;
         case 9:
            ++this.volume;
            break;
         case 10:
            this.volume += 2;
            break;
         case 11:
            this.volume += 4;
            break;
         case 12:
            this.volume += 8;
            break;
         case 13:
            this.volume += 16;
            break;
         case 14:
            this.volume += this.volume >> 1;
            break;
         case 15:
            this.volume <<= 1;
         }

         if(this.volume < 0) {
            this.volume = 0;
         }

         if(this.volume > 64) {
            this.volume = 64;
         }
      }

   }

   private void calculateFrequency() {
      int per;
      if(this.module.linearPeriods) {
         per = this.period + this.vibratoAdd - (this.arpeggioAdd << 6);
         if(per < 28 || per > 7680) {
            per = 7680;
         }

         int tone = 7680 - per;
         int i = (tone >> 3) % 96;
         int c = freqTable[i];
         int m = freqTable[i + 1] - c;
         int x = tone & 7;
         int y = (m * x >> 3) + c;
         this.freq = y >> 9 - tone / 768;
      } else {
         per = this.period + this.vibratoAdd;
         per = per * (periodTable[(this.arpeggioAdd & 15) << 3] << 1) / periodTable[0];
         per = (per >> 1) + (per & 1);
         if(per < 28) {
            per = periodTable[0];
         }

         this.freq = this.module.c2Rate * 1712 / per;
      }

   }

   private void calculateAmplitude() {
      int envVol = this.keyOn?64:0;
      if(this.instrument.volumeEnvelope.enabled) {
         envVol = this.instrument.volumeEnvelope.calculateAmpl(this.volEnvTick);
      }

      int vol = this.volume + this.tremoloAdd;
      if(vol > 64) {
         vol = 64;
      }

      if(vol < 0) {
         vol = 0;
      }

      vol = vol * this.module.gain * '耀' >> 13;
      vol = vol * this.fadeOutVol >> 15;
      this.ampl = vol * this.globalVol.volume * envVol >> 12;
      int envPan = 32;
      if(this.instrument.panningEnvelope.enabled) {
         envPan = this.instrument.panningEnvelope.calculateAmpl(this.panEnvTick);
      }

      int panRange = this.panning < 128?this.panning:255 - this.panning;
      this.pann = this.panning + (panRange * (envPan - 32) >> 5);
   }

   private void trigger() {
      if(this.noteIns > 0 && this.noteIns <= this.module.numInstruments) {
         this.instrument = this.module.instruments[this.noteIns];
         Sample isPorta = this.instrument.samples[this.instrument.keyToSample[this.noteKey < 97?this.noteKey:0]];
         this.volume = isPorta.volume >= 64?64:isPorta.volume & 63;
         if(isPorta.panning >= 0) {
            this.panning = isPorta.panning & 255;
         }

         if(this.period > 0 && isPorta.looped()) {
            this.sample = isPorta;
         }

         this.sampleOffset = this.volEnvTick = this.panEnvTick = 0;
         this.fadeOutVol = '耀';
         this.keyOn = true;
      }

      if(this.noteEffect == 9 || this.noteEffect == 143) {
         if(this.noteParam > 0) {
            this.offsetParam = this.noteParam;
         }

         this.sampleOffset = this.offsetParam << 8;
      }

      if(this.noteVol >= 16 && this.noteVol < 96) {
         this.volume = this.noteVol < 80?this.noteVol - 16:64;
      }

      switch(this.noteVol & 240) {
      case 128:
         this.volume -= this.noteVol & 15;
         if(this.volume < 0) {
            this.volume = 0;
         }
         break;
      case 144:
         this.volume += this.noteVol & 15;
         if(this.volume > 64) {
            this.volume = 64;
         }
         break;
      case 160:
         if((this.noteVol & 15) > 0) {
            this.vibratoSpeed = this.noteVol & 15;
         }
         break;
      case 176:
         if((this.noteVol & 15) > 0) {
            this.vibratoDepth = this.noteVol & 15;
         }

         this.vibrato(false);
         break;
      case 192:
         this.panning = (this.noteVol & 15) * 17;
         break;
      case 240:
         if((this.noteVol & 15) > 0) {
            this.tonePortaParam = this.noteVol & 15;
         }
      }

      if(this.noteKey > 0) {
         if(this.noteKey > 96) {
            this.keyOn = false;
         } else {
            boolean isPorta1 = (this.noteVol & 240) == 240 || this.noteEffect == 3 || this.noteEffect == 5 || this.noteEffect == 135 || this.noteEffect == 140;
            if(!isPorta1) {
               this.sample = this.instrument.samples[this.instrument.keyToSample[this.noteKey]];
            }

            int fineTune = this.sample.fineTune;
            if(this.noteEffect == 117 || this.noteEffect == 242) {
               fineTune = (this.noteParam & 15) << 4;
               if(fineTune > 127) {
                  fineTune -= 256;
               }
            }

            int key = this.noteKey + this.sample.relNote;
            if(key < 1) {
               key = 1;
            }

            if(key > 120) {
               key = 120;
            }

            int per = keyToPeriod(key, fineTune, this.module.linearPeriods);
            per = this.module.c2Rate * per * 2 / this.sample.c2Rate;
            this.portaPeriod = (per >> 1) + (per & 1);
            if(!isPorta1) {
               this.period = this.portaPeriod;
               this.sampleIdx = this.sampleOffset;
               this.sampleFra = 0;
               if(this.vibratoType < 4) {
                  this.vibratoPhase = 0;
               }

               if(this.tremoloType < 4) {
                  this.tremoloPhase = 0;
               }

               this.retrigCount = this.autoVibratoCount = 0;
            }
         }
      }

   }

   public static int keyToPeriod(int key, int fineTune, boolean linear) {
      if(linear) {
         return 7744 - (key << 6) - (fineTune >> 1);
      } else {
         int tone = (key << 6) + (fineTune >> 1);
         int i = (tone >> 3) % 96;
         int c = periodTable[i] * 2;
         int m = periodTable[i + 1] * 2 - c;
         int x = tone & 7;
         int y = (m * x >> 3) + c >> tone / 768;
         return (y >> 1) + (y & 1);
      }
   }

   public static int periodToKey(int period) {
      int key = 0;

      int oct;
      for(oct = 0; period < periodTable[96]; ++oct) {
         period <<= 1;
      }

      while(key < 12) {
         int d1 = periodTable[key << 3] - period;
         int d2 = period - periodTable[key + 1 << 3];
         if(d2 >= 0) {
            if(d2 < d1) {
               ++key;
            }
            break;
         }

         ++key;
      }

      return oct * 12 + key;
   }
}
