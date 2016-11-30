package ibxm;

import ibxm.Channel;
import ibxm.Data;
import ibxm.Envelope;
import ibxm.Instrument;
import ibxm.Pattern;
import ibxm.Sample;
import java.io.IOException;
import java.io.InputStream;

public class Module {
   public String songName;
   public int numChannels;
   public int numInstruments;
   public int numPatterns;
   public int sequenceLength;
   public int restartPos;
   public int defaultGVol;
   public int defaultSpeed;
   public int defaultTempo;
   public int c2Rate;
   public int gain;
   public boolean linearPeriods;
   public boolean fastVolSlides;
   public int[] defaultPanning;
   public int[] sequence;
   public Pattern[] patterns;
   public Instrument[] instruments;

   public Module() {
      this.songName = "Blank";
      this.numChannels = 4;
      this.numInstruments = 1;
      this.numPatterns = 1;
      this.sequenceLength = 1;
      this.restartPos = 0;
      this.defaultGVol = 64;
      this.defaultSpeed = 6;
      this.defaultTempo = 125;
      this.c2Rate = 8287;
      this.gain = 64;
      this.linearPeriods = false;
      this.fastVolSlides = false;
      this.defaultPanning = new int[]{51, 204, 204, 51};
      this.sequence = new int[]{0};
      this.patterns = new Pattern[]{new Pattern(4, 64)};
      this.instruments = new Instrument[]{new Instrument(), new Instrument()};
   }

   public Module(InputStream inputStream) throws IOException {
      this(new Data(inputStream));
   }

   public Module(Data moduleData) throws IOException {
      this.songName = "Blank";
      this.numChannels = 4;
      this.numInstruments = 1;
      this.numPatterns = 1;
      this.sequenceLength = 1;
      this.restartPos = 0;
      this.defaultGVol = 64;
      this.defaultSpeed = 6;
      this.defaultTempo = 125;
      this.c2Rate = 8287;
      this.gain = 64;
      this.linearPeriods = false;
      this.fastVolSlides = false;
      this.defaultPanning = new int[]{51, 204, 204, 51};
      this.sequence = new int[]{0};
      this.patterns = new Pattern[]{new Pattern(4, 64)};
      this.instruments = new Instrument[]{new Instrument(), new Instrument()};
      if(moduleData.strLatin1(0, 17).equals("Extended Module: ")) {
         this.loadXM(moduleData);
      } else if(moduleData.strLatin1(44, 4).equals("SCRM")) {
         this.loadS3M(moduleData);
      } else {
         this.loadMod(moduleData);
      }

   }

   public Module(byte[] moduleData) throws IOException {
      this(new Data(moduleData));
   }

   private void loadMod(Data moduleData) throws IOException {
      this.songName = moduleData.strLatin1(0, 20);
      this.sequenceLength = moduleData.uByte(950) & 127;
      this.restartPos = moduleData.uByte(951) & 127;
      if(this.restartPos >= this.sequenceLength) {
         this.restartPos = 0;
      }

      this.sequence = new int[128];

      int moduleDataIdx;
      int instIdx;
      for(moduleDataIdx = 0; moduleDataIdx < 128; ++moduleDataIdx) {
         instIdx = moduleData.uByte(952 + moduleDataIdx) & 127;
         this.sequence[moduleDataIdx] = instIdx;
         if(instIdx >= this.numPatterns) {
            this.numPatterns = instIdx + 1;
         }
      }

      switch(moduleData.ubeShort(1082)) {
      case 17224:
         this.numChannels = (moduleData.uByte(1080) - 48) * 10;
         this.numChannels += moduleData.uByte(1081) - 48;
         this.c2Rate = 8363;
         this.gain = 32;
         break;
      case 18510:
         this.numChannels = moduleData.uByte(1080) - 48;
         this.c2Rate = 8363;
         this.gain = 32;
         break;
      case 19233:
      case 19246:
      case 21556:
         this.numChannels = 4;
         this.c2Rate = 8287;
         this.gain = 64;
         break;
      default:
         throw new IllegalArgumentException("MOD Format not recognised!");
      }

      this.defaultGVol = 64;
      this.defaultSpeed = 6;
      this.defaultTempo = 125;
      this.defaultPanning = new int[this.numChannels];

      for(moduleDataIdx = 0; moduleDataIdx < this.numChannels; ++moduleDataIdx) {
         this.defaultPanning[moduleDataIdx] = 51;
         if((moduleDataIdx & 3) == 1 || (moduleDataIdx & 3) == 2) {
            this.defaultPanning[moduleDataIdx] = 204;
         }
      }

      moduleDataIdx = 1084;
      this.patterns = new Pattern[this.numPatterns];

      int sampleLength;
      int fineTune;
      int volume;
      int loopStart;
      for(instIdx = 0; instIdx < this.numPatterns; ++instIdx) {
         Pattern instrument = this.patterns[instIdx] = new Pattern(this.numChannels, 64);

         for(int sample = 0; sample < instrument.data.length; sample += 5) {
            sampleLength = (moduleData.uByte(moduleDataIdx) & 15) << 8;
            sampleLength = (sampleLength | moduleData.uByte(moduleDataIdx + 1)) * 4;
            if(sampleLength > 112) {
               instrument.data[sample] = (byte)Channel.periodToKey(sampleLength);
            }

            fineTune = (moduleData.uByte(moduleDataIdx + 2) & 240) >> 4;
            fineTune |= moduleData.uByte(moduleDataIdx) & 16;
            instrument.data[sample + 1] = (byte)fineTune;
            volume = moduleData.uByte(moduleDataIdx + 2) & 15;
            loopStart = moduleData.uByte(moduleDataIdx + 3);
            if(loopStart == 0 && (volume < 3 || volume == 10)) {
               volume = 0;
            }

            if(loopStart == 0 && (volume == 5 || volume == 6)) {
               volume -= 2;
            }

            if(volume == 8 && this.numChannels == 4) {
               loopStart = 0;
               volume = 0;
            }

            instrument.data[sample + 3] = (byte)volume;
            instrument.data[sample + 4] = (byte)loopStart;
            moduleDataIdx += 4;
         }
      }

      this.numInstruments = 31;
      this.instruments = new Instrument[this.numInstruments + 1];
      this.instruments[0] = new Instrument();

      for(instIdx = 1; instIdx <= this.numInstruments; ++instIdx) {
         Instrument var11 = this.instruments[instIdx] = new Instrument();
         Sample var12 = var11.samples[0];
         var11.name = moduleData.strLatin1(instIdx * 30 - 10, 22);
         sampleLength = moduleData.ubeShort(instIdx * 30 + 12) * 2;
         fineTune = (moduleData.uByte(instIdx * 30 + 14) & 15) << 4;
         var12.fineTune = fineTune < 128?fineTune:fineTune - 256;
         volume = moduleData.uByte(instIdx * 30 + 15) & 127;
         var12.volume = volume <= 64?volume:64;
         var12.panning = -1;
         var12.c2Rate = this.c2Rate;
         loopStart = moduleData.ubeShort(instIdx * 30 + 16) * 2;
         int loopLength = moduleData.ubeShort(instIdx * 30 + 18) * 2;
         if(loopStart + loopLength > sampleLength) {
            loopLength = sampleLength - loopStart;
         }

         if(loopLength < 4) {
            loopStart = sampleLength;
            loopLength = 0;
         }

         var12.setSampleData(moduleData.samS8(moduleDataIdx, sampleLength), loopStart, loopLength, false);
         moduleDataIdx += sampleLength;
      }

   }

   private void loadS3M(Data moduleData) throws IOException {
      this.songName = moduleData.strCp850(0, 28);
      this.sequenceLength = moduleData.uleShort(32);
      this.numInstruments = moduleData.uleShort(34);
      this.numPatterns = moduleData.uleShort(36);
      int flags = moduleData.uleShort(38);
      int version = moduleData.uleShort(40);
      this.fastVolSlides = (flags & 64) == 64 || version == 4864;
      boolean signedSamples = moduleData.uleShort(42) == 1;
      if(moduleData.uleInt(44) != 1297236819) {
         throw new IllegalArgumentException("Not an S3M file!");
      } else {
         this.defaultGVol = moduleData.uByte(48);
         this.defaultSpeed = moduleData.uByte(49);
         this.defaultTempo = moduleData.uByte(50);
         this.c2Rate = 8363;
         this.gain = moduleData.uByte(51) & 127;
         boolean stereoMode = (moduleData.uByte(51) & 128) == 128;
         boolean defaultPan = moduleData.uByte(53) == 252;
         int[] channelMap = new int[32];

         int moduleDataIdx;
         for(moduleDataIdx = 0; moduleDataIdx < 32; ++moduleDataIdx) {
            channelMap[moduleDataIdx] = -1;
            if(moduleData.uByte(64 + moduleDataIdx) < 16) {
               channelMap[moduleDataIdx] = this.numChannels++;
            }
         }

         this.sequence = new int[this.sequenceLength];

         for(moduleDataIdx = 0; moduleDataIdx < this.sequenceLength; ++moduleDataIdx) {
            this.sequence[moduleDataIdx] = moduleData.uByte(96 + moduleDataIdx);
         }

         moduleDataIdx = 96 + this.sequenceLength;
         this.instruments = new Instrument[this.numInstruments + 1];
         this.instruments[0] = new Instrument();

         int chanIdx;
         int rowIdx;
         int token;
         int noteKey;
         int noteIns;
         int noteVol;
         for(chanIdx = 1; chanIdx <= this.numInstruments; ++chanIdx) {
            Instrument panning = this.instruments[chanIdx] = new Instrument();
            Sample panFlags = panning.samples[0];
            rowIdx = moduleData.uleShort(moduleDataIdx) << 4;
            moduleDataIdx += 2;
            panning.name = moduleData.strCp850(rowIdx + 48, 28);
            if(moduleData.uByte(rowIdx) == 1 && moduleData.uleShort(rowIdx + 76) == 17235) {
               token = moduleData.uByte(rowIdx + 13) << 20;
               token += moduleData.uleShort(rowIdx + 14) << 4;
               noteKey = moduleData.uleInt(rowIdx + 16);
               noteIns = moduleData.uleInt(rowIdx + 20);
               noteVol = moduleData.uleInt(rowIdx + 24) - noteIns;
               panFlags.volume = moduleData.uByte(rowIdx + 28);
               panFlags.panning = -1;
               boolean noteEffect = moduleData.uByte(rowIdx + 30) != 0;
               boolean noteParam = (moduleData.uByte(rowIdx + 31) & 1) == 1;
               if(noteIns + noteVol > noteKey) {
                  noteVol = noteKey - noteIns;
               }

               if(noteVol < 1 || !noteParam) {
                  noteIns = noteKey;
                  noteVol = 0;
               }

               boolean chanIdx1 = (moduleData.uByte(rowIdx + 31) & 2) == 2;
               boolean noteOffset = (moduleData.uByte(rowIdx + 31) & 4) == 4;
               if(noteEffect) {
                  throw new IllegalArgumentException("Packed samples not supported!");
               }

               panFlags.c2Rate = moduleData.uleInt(rowIdx + 32);
               if(noteOffset) {
                  if(signedSamples) {
                     panFlags.setSampleData(moduleData.samS16(token, noteKey), noteIns, noteVol, false);
                  } else {
                     panFlags.setSampleData(moduleData.samU16(token, noteKey), noteIns, noteVol, false);
                  }
               } else if(signedSamples) {
                  panFlags.setSampleData(moduleData.samS8(token, noteKey), noteIns, noteVol, false);
               } else {
                  panFlags.setSampleData(moduleData.samU8(token, noteKey), noteIns, noteVol, false);
               }
            }
         }

         this.patterns = new Pattern[this.numPatterns];

         int var23;
         for(chanIdx = 0; chanIdx < this.numPatterns; ++chanIdx) {
            Pattern var21 = this.patterns[chanIdx] = new Pattern(this.numChannels, 64);
            var23 = (moduleData.uleShort(moduleDataIdx) << 4) + 2;
            rowIdx = 0;

            while(true) {
               while(rowIdx < 64) {
                  token = moduleData.uByte(var23++);
                  if(token == 0) {
                     ++rowIdx;
                  } else {
                     noteKey = 0;
                     noteIns = 0;
                     if((token & 32) == 32) {
                        noteKey = moduleData.uByte(var23++);
                        noteIns = moduleData.uByte(var23++);
                        if(noteKey < 254) {
                           noteKey = (noteKey >> 4) * 12 + (noteKey & 15) + 1;
                        }

                        if(noteKey == 255) {
                           noteKey = 0;
                        }
                     }

                     noteVol = 0;
                     if((token & 64) == 64) {
                        noteVol = (moduleData.uByte(var23++) & 127) + 16;
                        if(noteVol > 80) {
                           noteVol = 0;
                        }
                     }

                     int var24 = 0;
                     int var25 = 0;
                     if((token & 128) == 128) {
                        var24 = moduleData.uByte(var23++);
                        var25 = moduleData.uByte(var23++);
                        if(var24 < 1 || var24 >= 64) {
                           var25 = 0;
                           var24 = 0;
                        }

                        if(var24 > 0) {
                           var24 += 128;
                        }
                     }

                     int var26 = channelMap[token & 31];
                     if(var26 >= 0) {
                        int var27 = (rowIdx * this.numChannels + var26) * 5;
                        var21.data[var27] = (byte)noteKey;
                        var21.data[var27 + 1] = (byte)noteIns;
                        var21.data[var27 + 2] = (byte)noteVol;
                        var21.data[var27 + 3] = (byte)var24;
                        var21.data[var27 + 4] = (byte)var25;
                     }
                  }
               }

               moduleDataIdx += 2;
               break;
            }
         }

         this.defaultPanning = new int[this.numChannels];

         for(chanIdx = 0; chanIdx < 32; ++chanIdx) {
            if(channelMap[chanIdx] >= 0) {
               int var22 = 7;
               if(stereoMode) {
                  var22 = 12;
                  if(moduleData.uByte(64 + chanIdx) < 8) {
                     var22 = 3;
                  }
               }

               if(defaultPan) {
                  var23 = moduleData.uByte(moduleDataIdx + chanIdx);
                  if((var23 & 32) == 32) {
                     var22 = var23 & 15;
                  }
               }

               this.defaultPanning[channelMap[chanIdx]] = var22 * 17;
            }
         }

      }
   }

   private void loadXM(Data moduleData) throws IOException {
      if(moduleData.uleShort(58) != 260) {
         throw new IllegalArgumentException("XM format version must be 0x0104!");
      } else {
         this.songName = moduleData.strCp850(17, 20);
         boolean deltaEnv = moduleData.strLatin1(38, 20).startsWith("DigiBooster Pro");
         int dataOffset = 60 + moduleData.uleInt(60);
         this.sequenceLength = moduleData.uleShort(64);
         this.restartPos = moduleData.uleShort(66);
         this.numChannels = moduleData.uleShort(68);
         this.numPatterns = moduleData.uleShort(70);
         this.numInstruments = moduleData.uleShort(72);
         this.linearPeriods = (moduleData.uleShort(74) & 1) > 0;
         this.defaultGVol = 64;
         this.defaultSpeed = moduleData.uleShort(76);
         this.defaultTempo = moduleData.uleShort(78);
         this.c2Rate = 8363;
         this.gain = 64;
         this.defaultPanning = new int[this.numChannels];

         int insIdx;
         for(insIdx = 0; insIdx < this.numChannels; ++insIdx) {
            this.defaultPanning[insIdx] = 128;
         }

         this.sequence = new int[this.sequenceLength];

         int instrument;
         for(insIdx = 0; insIdx < this.sequenceLength; ++insIdx) {
            instrument = moduleData.uByte(80 + insIdx);
            this.sequence[insIdx] = instrument < this.numPatterns?instrument:0;
         }

         this.patterns = new Pattern[this.numPatterns];

         int numSamples;
         int samIdx;
         int sample;
         int sampleDataBytes;
         int sampleLoopStart;
         int sampleLoopLength;
         for(insIdx = 0; insIdx < this.numPatterns; ++insIdx) {
            if(moduleData.uByte(dataOffset + 4) != 0) {
               throw new IllegalArgumentException("Unknown pattern packing type!");
            }

            instrument = moduleData.uleShort(dataOffset + 5);
            numSamples = instrument * this.numChannels;
            Pattern sampleHeaderOffset = this.patterns[insIdx] = new Pattern(this.numChannels, instrument);
            samIdx = moduleData.uleShort(dataOffset + 7);
            dataOffset += moduleData.uleInt(dataOffset);
            sample = dataOffset + samIdx;
            if(samIdx > 0) {
               sampleDataBytes = 0;

               for(sampleLoopStart = 0; sampleLoopStart < numSamples; ++sampleLoopStart) {
                  sampleLoopLength = moduleData.uByte(dataOffset);
                  if((sampleLoopLength & 128) == 0) {
                     sampleLoopLength = 31;
                  } else {
                     ++dataOffset;
                  }

                  byte looped = (sampleLoopLength & 1) > 0?moduleData.sByte(dataOffset++):0;
                  sampleHeaderOffset.data[sampleDataBytes++] = looped;
                  byte pingPong = (sampleLoopLength & 2) > 0?moduleData.sByte(dataOffset++):0;
                  sampleHeaderOffset.data[sampleDataBytes++] = pingPong;
                  byte sixteenBit = (sampleLoopLength & 4) > 0?moduleData.sByte(dataOffset++):0;
                  sampleHeaderOffset.data[sampleDataBytes++] = sixteenBit;
                  byte fxc = (sampleLoopLength & 8) > 0?moduleData.sByte(dataOffset++):0;
                  byte fxp = (sampleLoopLength & 16) > 0?moduleData.sByte(dataOffset++):0;
                  if(fxc >= 64) {
                     fxp = 0;
                     fxc = 0;
                  }

                  sampleHeaderOffset.data[sampleDataBytes++] = fxc;
                  sampleHeaderOffset.data[sampleDataBytes++] = fxp;
               }
            }

            dataOffset = sample;
         }

         this.instruments = new Instrument[this.numInstruments + 1];
         this.instruments[0] = new Instrument();

         for(insIdx = 1; insIdx <= this.numInstruments; ++insIdx) {
            Instrument var18 = this.instruments[insIdx] = new Instrument();
            var18.name = moduleData.strCp850(dataOffset + 4, 22);
            numSamples = var18.numSamples = moduleData.uleShort(dataOffset + 27);
            int var19;
            if(numSamples > 0) {
               var18.samples = new Sample[numSamples];

               for(var19 = 0; var19 < 96; ++var19) {
                  var18.keyToSample[var19 + 1] = moduleData.uByte(dataOffset + 33 + var19);
               }

               Envelope var20 = var18.volumeEnvelope = new Envelope();
               var20.pointsTick = new int[12];
               var20.pointsAmpl = new int[12];
               samIdx = 0;

               for(sample = 0; sample < 12; ++sample) {
                  sampleDataBytes = dataOffset + 129 + sample * 4;
                  samIdx = (deltaEnv?samIdx:0) + moduleData.uleShort(sampleDataBytes);
                  var20.pointsTick[sample] = samIdx;
                  var20.pointsAmpl[sample] = moduleData.uleShort(sampleDataBytes + 2);
               }

               Envelope var21 = var18.panningEnvelope = new Envelope();
               var21.pointsTick = new int[12];
               var21.pointsAmpl = new int[12];
               samIdx = 0;

               for(sampleDataBytes = 0; sampleDataBytes < 12; ++sampleDataBytes) {
                  sampleLoopStart = dataOffset + 177 + sampleDataBytes * 4;
                  samIdx = (deltaEnv?samIdx:0) + moduleData.uleShort(sampleLoopStart);
                  var21.pointsTick[sampleDataBytes] = samIdx;
                  var21.pointsAmpl[sampleDataBytes] = moduleData.uleShort(sampleLoopStart + 2);
               }

               var20.numPoints = moduleData.uByte(dataOffset + 225);
               if(var20.numPoints > 12) {
                  var20.numPoints = 0;
               }

               var21.numPoints = moduleData.uByte(dataOffset + 226);
               if(var21.numPoints > 12) {
                  var21.numPoints = 0;
               }

               var20.sustainTick = var20.pointsTick[moduleData.uByte(dataOffset + 227)];
               var20.loopStartTick = var20.pointsTick[moduleData.uByte(dataOffset + 228)];
               var20.loopEndTick = var20.pointsTick[moduleData.uByte(dataOffset + 229)];
               var21.sustainTick = var21.pointsTick[moduleData.uByte(dataOffset + 230)];
               var21.loopStartTick = var21.pointsTick[moduleData.uByte(dataOffset + 231)];
               var21.loopEndTick = var21.pointsTick[moduleData.uByte(dataOffset + 232)];
               var20.enabled = var20.numPoints > 0 && (moduleData.uByte(dataOffset + 233) & 1) > 0;
               var20.sustain = (moduleData.uByte(dataOffset + 233) & 2) > 0;
               var20.looped = (moduleData.uByte(dataOffset + 233) & 4) > 0;
               var21.enabled = var21.numPoints > 0 && (moduleData.uByte(dataOffset + 234) & 1) > 0;
               var21.sustain = (moduleData.uByte(dataOffset + 234) & 2) > 0;
               var21.looped = (moduleData.uByte(dataOffset + 234) & 4) > 0;
               var18.vibratoType = moduleData.uByte(dataOffset + 235);
               var18.vibratoSweep = moduleData.uByte(dataOffset + 236);
               var18.vibratoDepth = moduleData.uByte(dataOffset + 237);
               var18.vibratoRate = moduleData.uByte(dataOffset + 238);
               var18.volumeFadeOut = moduleData.uleShort(dataOffset + 239);
            }

            dataOffset += moduleData.uleInt(dataOffset);
            var19 = dataOffset;
            dataOffset += numSamples * 40;

            for(samIdx = 0; samIdx < numSamples; ++samIdx) {
               Sample var22 = var18.samples[samIdx] = new Sample();
               sampleDataBytes = moduleData.uleInt(var19);
               sampleLoopStart = moduleData.uleInt(var19 + 4);
               sampleLoopLength = moduleData.uleInt(var19 + 8);
               var22.volume = moduleData.sByte(var19 + 12);
               var22.fineTune = moduleData.sByte(var19 + 13);
               var22.c2Rate = 8363;
               boolean var23 = (moduleData.uByte(var19 + 14) & 3) > 0;
               boolean var24 = (moduleData.uByte(var19 + 14) & 2) > 0;
               boolean var25 = (moduleData.uByte(var19 + 14) & 16) > 0;
               var22.panning = moduleData.uByte(var19 + 15);
               var22.relNote = moduleData.sByte(var19 + 16);
               var22.name = moduleData.strCp850(var19 + 18, 22);
               var19 += 40;
               if(!var23 || sampleLoopStart + sampleLoopLength > sampleDataBytes) {
                  sampleLoopStart = sampleDataBytes;
                  sampleLoopLength = 0;
               }

               if(var25) {
                  var22.setSampleData(moduleData.samS16D(dataOffset, sampleDataBytes >> 1), sampleLoopStart >> 1, sampleLoopLength >> 1, var24);
               } else {
                  var22.setSampleData(moduleData.samS8D(dataOffset, sampleDataBytes), sampleLoopStart, sampleLoopLength, var24);
               }

               dataOffset += sampleDataBytes;
            }
         }

      }
   }

   public void toStringBuffer(StringBuffer out) {
      out.append("Song Name: " + this.songName + '\n' + "Num Channels: " + this.numChannels + '\n' + "Num Instruments: " + this.numInstruments + '\n' + "Num Patterns: " + this.numPatterns + '\n' + "Sequence Length: " + this.sequenceLength + '\n' + "Restart Pos: " + this.restartPos + '\n' + "Default Speed: " + this.defaultSpeed + '\n' + "Default Tempo: " + this.defaultTempo + '\n' + "Linear Periods: " + this.linearPeriods + '\n');
      out.append("Sequence: ");

      int insIdx;
      for(insIdx = 0; insIdx < this.sequence.length; ++insIdx) {
         out.append(this.sequence[insIdx] + ", ");
      }

      out.append('\n');

      for(insIdx = 0; insIdx < this.patterns.length; ++insIdx) {
         out.append("Pattern " + insIdx + ":\n");
         this.patterns[insIdx].toStringBuffer(out);
      }

      for(insIdx = 1; insIdx < this.instruments.length; ++insIdx) {
         out.append("Instrument " + insIdx + ":\n");
         this.instruments[insIdx].toStringBuffer(out);
      }

   }
}
