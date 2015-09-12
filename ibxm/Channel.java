/*     */ package ibxm;
/*     */ 
/*     */ public class Channel {
/*     */   public static final int NEAREST = 0;
/*     */   public static final int LINEAR = 1;
/*     */   public static final int SINC = 2;
/*   7 */   private static final int[] periodTable = { 29021, 28812, 28605, 28399, 28195, 27992, 27790, 27590, 27392, 27195, 26999, 26805, 26612, 26421, 26231, 26042, 25855, 25669, 25484, 25301, 25119, 24938, 24758, 24580, 24403, 24228, 24054, 23881, 23709, 23538, 23369, 23201, 23034, 22868, 22704, 22540, 22378, 22217, 22057, 21899, 21741, 21585, 21429, 21275, 21122, 20970, 20819, 20670, 20521, 20373, 20227, 20081, 19937, 19793, 19651, 19509, 19369, 19230, 19091, 18954, 18818, 18682, 18548, 18414, 18282, 18150, 18020, 17890, 17762, 17634, 17507, 17381, 17256, 17132, 17008, 16886, 16765, 16644, 16524, 16405, 16287, 16170, 16054, 15938, 15824, 15710, 15597, 15485, 15373, 15263, 15153, 15044, 14936, 14828, 14721, 14616, 14510, 14406, 14302, 14199, 14097, 13996, 13895, 13795, 13696, 13597, 13500, 13403, 13306, 13210, 13115, 13021, 12927, 12834, 12742, 12650, 12559, 12469, 12379, 12290, 12202, 12114, 12027, 11940, 11854, 11769, 11684, 11600 };
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  27 */   private static final int[] freqTable = { 267616, 269555, 271509, 273476, 275458, 277454, 279464, 281489, 283529, 285584, 287653, 289738, 291837, 293952, 296082, 298228, 300389, 302566, 304758, 306966, 309191, 311431, 313688, 315961, 318251, 320557, 322880, 325220, 327576, 329950, 332341, 334749, 337175, 339618, 342079, 344558, 347055, 349570, 352103, 354655, 357225, 359813, 362420, 365047, 367692, 370356, 373040, 375743, 378466, 381209, 383971, 386754, 389556, 392379, 395222, 398086, 400971, 403877, 406803, 409751, 412720, 415711, 418723, 421758, 424814, 427892, 430993, 434116, 437262, 440430, 443622, 446837, 450075, 453336, 456621, 459930, 463263, 466620, 470001, 473407, 476838, 480293, 483773, 487279, 490810, 494367, 497949, 501557, 505192, 508853, 512540, 516254, 519995, 523763, 527558, 531381, 535232, 539111, 543017, 546952, 550915, 554908, 558929, 562979 };
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  44 */   private static final short[] sineTable = { 0, 24, 49, 74, 97, 120, 141, 161, 180, 197, 212, 224, 235, 244, 250, 253, 255, 253, 250, 244, 235, 224, 212, 197, 180, 161, 141, 120, 97, 74, 49, 24 };
/*     */   private Module module;
/*     */   private GlobalVol globalVol;
/*     */   private Instrument instrument;
/*     */   private Sample sample;
/*     */   private boolean keyOn;
/*     */   private int noteKey;
/*     */   private int noteIns;
/*     */   private int noteVol;
/*     */   private int noteEffect;
/*     */   private int noteParam;
/*     */   private int sampleOffset;
/*     */   private int sampleIdx;
/*     */   private int sampleFra;
/*     */   private int freq;
/*     */   private int ampl;
/*     */   private int volume;
/*     */   private int panning;
/*     */   private int fadeOutVol;
/*     */   private int volEnvTick;
/*     */   private int panEnvTick;
/*     */   private int period;
/*     */   private int portaPeriod;
/*     */   private int retrigCount;
/*     */   private int fxCount;
/*     */   private int autoVibratoCount;
/*     */   private int portaUpParam;
/*     */   private int portaDownParam;
/*     */   private int tonePortaParam;
/*     */   private int offsetParam;
/*     */   private int finePortaUpParam;
/*     */   private int finePortaDownParam;
/*     */   private int extraFinePortaParam;
/*     */   
/*     */   public Channel(Module module, int id, GlobalVol globalVol)
/*     */   {
/*  70 */     module = module;
/*  72 */     globalVol = globalVol;
/*  73 */     panning = module.defaultPanning[id];
/*  74 */     instrument = new Instrument();
/*  75 */     sample = instrument.samples[0];
/*  76 */     randomSeed = ((id + 1) * 11259375);
/*     */   }
/*     */   
/*     */   private int arpeggioParam;
/*     */   private int vslideParam;
/*     */   private int globalVslideParam;
/*     */   private int panningSlideParam;
/*     */   
/*     */   public void resample(int[] outBuf, int offset, int length, int sampleRate, int interpolation)
/*     */   {
/*  80 */     if (ampl <= 0) { return;
/*     */     }
/*  82 */     int lAmpl = ampl * 255 >> 8;
/*  83 */     int rAmpl = ampl * 255 >> 8;
/*  84 */     int step = (freq << 12) / (sampleRate >> 3);
/*  85 */     switch (interpolation)
/*     */     {
/*     */     case 0: 
/*  87 */       sample.resampleNearest(sampleIdx, sampleFra, step, lAmpl, rAmpl, outBuf, offset, length);
/*  88 */       break;
/*     */     case 1: default: 
/*  90 */       sample.resampleLinear(sampleIdx, sampleFra, step, lAmpl, rAmpl, outBuf, offset, length);
/*  91 */       break;
/*     */     case 2: 
/*  93 */       sample.resampleSinc(sampleIdx, sampleFra, step, lAmpl, rAmpl, outBuf, offset, length);
/*     */     }
/*     */   }
/*     */   
/*     */   private int fineVslideUpParam;
/*     */   private int fineVslideDownParam;
/*     */   private int retrigVolume;
/*     */   private int retrigTicks;
/*     */   private int tremorOnTicks;
/*     */   private int tremorOffTicks;
/*     */   private int vibratoType;
/*     */   
/*     */   public void updateSampleIdx(int length, int sampleRate)
/*     */   {
/*  99 */     int step = (freq << 12) / (sampleRate >> 3);
/* 100 */     sampleFra += step * length;
/* 101 */     sampleIdx = sample.normaliseSampleIdx(sampleIdx + (sampleFra >> 15));
/* 102 */     sampleFra &= 0x7FFF;
/*     */   }
/*     */   
/*     */   private int vibratoPhase;
/*     */   private int vibratoSpeed;
/*     */   
/*     */   public void row(Note note)
/*     */   {
/* 106 */     noteKey = note.key;
/* 107 */     noteIns = note.instrument;
/* 108 */     noteVol = note.volume;
/* 109 */     noteEffect = note.effect;
/* 110 */     noteParam = note.param;
/* 111 */     retrigCount += 1;
/* 112 */     vibratoAdd = (tremoloAdd = arpeggioAdd = fxCount = 0);
/* 113 */     if (((noteEffect != 125) && (noteEffect != 253)) || (noteParam <= 0))
/*     */     {
/* 115 */       trigger();
/*     */     }
/* 117 */     switch (noteEffect) {
/*     */     case 1: case 134: 
/* 119 */       if (noteParam > 0) portaUpParam = noteParam;
/* 120 */       portamentoUp(portaUpParam);
/* 121 */       break;
/*     */     case 2: case 133: 
/* 123 */       if (noteParam > 0) portaDownParam = noteParam;
/* 124 */       portamentoDown(portaDownParam);
/* 125 */       break;
/*     */     case 3: case 135: 
/* 127 */       if (noteParam > 0) tonePortaParam = noteParam;
/*     */       break;
/*     */     case 4: case 136: 
/* 130 */       if (noteParam >> 4 > 0) vibratoSpeed = (noteParam >> 4);
/* 131 */       if ((noteParam & 0xF) > 0) vibratoDepth = (noteParam & 0xF);
/* 132 */       vibrato(false);
/* 133 */       break;
/*     */     case 5: case 140: 
/* 135 */       if (noteParam > 0) vslideParam = noteParam;
/* 136 */       volumeSlide();
/* 137 */       break;
/*     */     case 6: case 139: 
/* 139 */       if (noteParam > 0) vslideParam = noteParam;
/* 140 */       vibrato(false);
/* 141 */       volumeSlide();
/* 142 */       break;
/*     */     case 7: case 146: 
/* 144 */       if (noteParam >> 4 > 0) tremoloSpeed = (noteParam >> 4);
/* 145 */       if ((noteParam & 0xF) > 0) tremoloDepth = (noteParam & 0xF);
/* 146 */       tremolo();
/* 147 */       break;
/*     */     case 8: 
/* 149 */       panning = (noteParam < 128 ? noteParam << 1 : 255);
/* 150 */       break;
/*     */     case 10: case 132: 
/* 152 */       if (noteParam > 0) vslideParam = noteParam;
/* 153 */       volumeSlide();
/* 154 */       break;
/*     */     case 12: 
/* 156 */       volume = (noteParam >= 64 ? 64 : noteParam & 0x3F);
/* 157 */       break;
/*     */     case 16: case 150: 
/* 159 */       globalVol.volume = (noteParam >= 64 ? 64 : noteParam & 0x3F);
/* 160 */       break;
/*     */     case 17: 
/* 162 */       if (noteParam > 0) globalVslideParam = noteParam;
/*     */       break;
/*     */     case 20: 
/* 165 */       keyOn = false;
/* 166 */       break;
/*     */     case 21: 
/* 168 */       volEnvTick = (panEnvTick = noteParam & 0xFF);
/* 169 */       break;
/*     */     case 25: 
/* 171 */       if (noteParam > 0) panningSlideParam = noteParam;
/*     */       break;
/*     */     case 27: case 145: 
/* 174 */       if (noteParam >> 4 > 0) retrigVolume = (noteParam >> 4);
/* 175 */       if ((noteParam & 0xF) > 0) retrigTicks = (noteParam & 0xF);
/* 176 */       retrigVolSlide();
/* 177 */       break;
/*     */     case 29: case 137: 
/* 179 */       if (noteParam >> 4 > 0) tremorOnTicks = (noteParam >> 4);
/* 180 */       if ((noteParam & 0xF) > 0) tremorOffTicks = (noteParam & 0xF);
/* 181 */       tremor();
/* 182 */       break;
/*     */     case 33: 
/* 184 */       if (noteParam > 0) extraFinePortaParam = noteParam;
/* 185 */       switch (extraFinePortaParam & 0xF0) {
/*     */       case 16: 
/* 187 */         portamentoUp(0xE0 | extraFinePortaParam & 0xF);
/* 188 */         break;
/*     */       case 32: 
/* 190 */         portamentoDown(0xE0 | extraFinePortaParam & 0xF);
/*     */       }
/*     */       
/* 193 */       break;
/*     */     case 113: 
/* 195 */       if (noteParam > 0) finePortaUpParam = noteParam;
/* 196 */       portamentoUp(0xF0 | finePortaUpParam & 0xF);
/* 197 */       break;
/*     */     case 114: 
/* 199 */       if (noteParam > 0) finePortaDownParam = noteParam;
/* 200 */       portamentoDown(0xF0 | finePortaDownParam & 0xF);
/* 201 */       break;
/*     */     case 116: case 243: 
/* 203 */       if (noteParam < 8) vibratoType = noteParam;
/*     */       break;
/*     */     case 119: case 244: 
/* 206 */       if (noteParam < 8) tremoloType = noteParam;
/*     */       break;
/*     */     case 122: 
/* 209 */       if (noteParam > 0) fineVslideUpParam = noteParam;
/* 210 */       volume += fineVslideUpParam;
/* 211 */       if (volume > 64) volume = 64;
/*     */       break;
/*     */     case 123: 
/* 214 */       if (noteParam > 0) fineVslideDownParam = noteParam;
/* 215 */       volume -= fineVslideDownParam;
/* 216 */       if (volume < 0) volume = 0;
/*     */       break;
/*     */     case 124: case 252: 
/* 219 */       if (noteParam <= 0) volume = 0;
/*     */       break;
/*     */     case 138: 
/* 222 */       if (noteParam > 0) arpeggioParam = noteParam;
/*     */       break;
/*     */     case 149: 
/* 225 */       if (noteParam >> 4 > 0) vibratoSpeed = (noteParam >> 4);
/* 226 */       if ((noteParam & 0xF) > 0) vibratoDepth = (noteParam & 0xF);
/* 227 */       vibrato(true);
/* 228 */       break;
/*     */     case 248: 
/* 230 */       panning = (noteParam * 17);
/*     */     }
/*     */     
/* 233 */     autoVibrato();
/* 234 */     calculateFrequency();
/* 235 */     calculateAmplitude();
/* 236 */     updateEnvelopes(); }
/*     */   
/*     */   private int vibratoDepth;
/*     */   private int tremoloType;
/* 240 */   public void tick() { vibratoAdd = 0;
/* 241 */     fxCount += 1;
/* 242 */     retrigCount += 1;
/* 243 */     if ((noteEffect != 125) || (fxCount > noteParam)) {
/* 244 */       switch (noteVol & 0xF0) {
/*     */       case 96: 
/* 246 */         volume -= (noteVol & 0xF);
/* 247 */         if (volume < 0) volume = 0;
/*     */         break;
/*     */       case 112: 
/* 250 */         volume += (noteVol & 0xF);
/* 251 */         if (volume > 64) volume = 64;
/*     */         break;
/*     */       case 176: 
/* 254 */         vibratoPhase += vibratoSpeed;
/* 255 */         vibrato(false);
/* 256 */         break;
/*     */       case 208: 
/* 258 */         panning -= (noteVol & 0xF);
/* 259 */         if (panning < 0) panning = 0;
/*     */         break;
/*     */       case 224: 
/* 262 */         panning += (noteVol & 0xF);
/* 263 */         if (panning > 255) panning = 255;
/*     */         break;
/*     */       case 240: 
/* 266 */         tonePortamento();
/*     */       }
/*     */       
/*     */     }
/* 270 */     switch (noteEffect) {
/*     */     case 1: case 134: 
/* 272 */       portamentoUp(portaUpParam);
/* 273 */       break;
/*     */     case 2: case 133: 
/* 275 */       portamentoDown(portaDownParam);
/* 276 */       break;
/*     */     case 3: case 135: 
/* 278 */       tonePortamento();
/* 279 */       break;
/*     */     case 4: case 136: 
/* 281 */       vibratoPhase += vibratoSpeed;
/* 282 */       vibrato(false);
/* 283 */       break;
/*     */     case 5: case 140: 
/* 285 */       tonePortamento();
/* 286 */       volumeSlide();
/* 287 */       break;
/*     */     case 6: case 139: 
/* 289 */       vibratoPhase += vibratoSpeed;
/* 290 */       vibrato(false);
/* 291 */       volumeSlide();
/* 292 */       break;
/*     */     case 7: case 146: 
/* 294 */       tremoloPhase += tremoloSpeed;
/* 295 */       tremolo();
/* 296 */       break;
/*     */     case 10: case 132: 
/* 298 */       volumeSlide();
/* 299 */       break;
/*     */     case 17: 
/* 301 */       globalVol.volume += (globalVslideParam >> 4) - (globalVslideParam & 0xF);
/* 302 */       if (globalVol.volume < 0) globalVol.volume = 0;
/* 303 */       if (globalVol.volume > 64) globalVol.volume = 64;
/*     */       break;
/*     */     case 25: 
/* 306 */       panning += (panningSlideParam >> 4) - (panningSlideParam & 0xF);
/* 307 */       if (panning < 0) panning = 0;
/* 308 */       if (panning > 255) panning = 255;
/*     */       break;
/*     */     case 27: case 145: 
/* 311 */       retrigVolSlide();
/* 312 */       break;
/*     */     case 29: case 137: 
/* 314 */       tremor();
/* 315 */       break;
/*     */     case 121: 
/* 317 */       if (fxCount >= noteParam) {
/* 318 */         fxCount = 0;
/* 319 */         sampleIdx = (sampleFra = 0);
/*     */       }
/*     */       break;
/*     */     case 124: case 252: 
/* 323 */       if (noteParam == fxCount) volume = 0;
/*     */       break;
/*     */     case 125: case 253: 
/* 326 */       if (noteParam == fxCount) trigger();
/*     */       break;
/*     */     case 138: 
/* 329 */       if (fxCount > 2) fxCount = 0;
/* 330 */       if (fxCount == 0) arpeggioAdd = 0;
/* 331 */       if (fxCount == 1) arpeggioAdd = (arpeggioParam >> 4);
/* 332 */       if (fxCount == 2) arpeggioAdd = (arpeggioParam & 0xF);
/*     */       break;
/*     */     case 149: 
/* 335 */       vibratoPhase += vibratoSpeed;
/* 336 */       vibrato(true);
/*     */     }
/*     */     
/* 339 */     autoVibrato();
/* 340 */     calculateFrequency();
/* 341 */     calculateAmplitude();
/* 342 */     updateEnvelopes(); }
/*     */   
/*     */   private int tremoloPhase;
/*     */   private int tremoloSpeed;
/* 346 */   private void updateEnvelopes() { if (instrument.volumeEnvelope.enabled) {
/* 347 */       if (!keyOn) {
/* 348 */         fadeOutVol -= instrument.volumeFadeOut;
/* 349 */         if (fadeOutVol < 0) fadeOutVol = 0;
/*     */       }
/* 351 */       volEnvTick = instrument.volumeEnvelope.nextTick(volEnvTick, keyOn);
/*     */     }
/* 353 */     if (instrument.panningEnvelope.enabled)
/* 354 */       panEnvTick = instrument.panningEnvelope.nextTick(panEnvTick, keyOn); }
/*     */   
/*     */   private int tremoloDepth;
/*     */   private int tremoloAdd;
/* 358 */   private void autoVibrato() { int depth = instrument.vibratoDepth & 0x7F;
/* 359 */     if (depth > 0) {
/* 360 */       int sweep = instrument.vibratoSweep & 0x7F;
/* 361 */       int rate = instrument.vibratoRate & 0x7F;
/* 362 */       int type = instrument.vibratoType;
/* 363 */       if (autoVibratoCount < sweep) depth = depth * autoVibratoCount / sweep;
/* 364 */       vibratoAdd += (waveform(autoVibratoCount * rate >> 2, type + 4) * depth >> 8);
/* 365 */       autoVibratoCount += 1; } }
/*     */   
/*     */   private int vibratoAdd;
/*     */   private int arpeggioAdd;
/* 370 */   private int randomSeed; public int plRow; private void volumeSlide() { int up = vslideParam >> 4;
/* 371 */     int down = vslideParam & 0xF;
/* 372 */     if ((down == 15) && (up > 0)) {
/* 373 */       if (fxCount == 0) volume += up;
/* 374 */     } else if ((up == 15) && (down > 0)) {
/* 375 */       if (fxCount == 0) volume -= down;
/* 376 */     } else if ((fxCount > 0) || (module.fastVolSlides))
/* 377 */       volume += up - down;
/* 378 */     if (volume > 64) volume = 64;
/* 379 */     if (volume < 0) volume = 0;
/*     */   }
/*     */   
/*     */   private void portamentoUp(int param) {
/* 383 */     switch (param & 0xF0) {
/*     */     case 224: 
/* 385 */       if (fxCount == 0) period -= (param & 0xF);
/*     */       break;
/*     */     case 240: 
/* 388 */       if (fxCount == 0) period -= ((param & 0xF) << 2);
/*     */       break;
/*     */     default: 
/* 391 */       if (fxCount > 0) period -= (param << 2);
/*     */       break;
/*     */     }
/* 394 */     if (period < 0) period = 0;
/*     */   }
/*     */   
/*     */   private void portamentoDown(int param) {
/* 398 */     if (period > 0) {
/* 399 */       switch (param & 0xF0) {
/*     */       case 224: 
/* 401 */         if (fxCount == 0) period += (param & 0xF);
/*     */         break;
/*     */       case 240: 
/* 404 */         if (fxCount == 0) period += ((param & 0xF) << 2);
/*     */         break;
/*     */       default: 
/* 407 */         if (fxCount > 0) period += (param << 2);
/*     */         break;
/*     */       }
/* 410 */       if (period > 65535) period = 65535;
/*     */     }
/*     */   }
/*     */   
/*     */   private void tonePortamento() {
/* 415 */     if (period > 0) {
/* 416 */       if (period < portaPeriod) {
/* 417 */         period += (tonePortaParam << 2);
/* 418 */         if (period > portaPeriod) period = portaPeriod;
/*     */       } else {
/* 420 */         period -= (tonePortaParam << 2);
/* 421 */         if (period < portaPeriod) period = portaPeriod;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void vibrato(boolean fine) {
/* 427 */     vibratoAdd = (waveform(vibratoPhase, vibratoType & 0x3) * vibratoDepth >> (fine ? 7 : 5));
/*     */   }
/*     */   
/*     */   private void tremolo() {
/* 431 */     tremoloAdd = (waveform(tremoloPhase, tremoloType & 0x3) * tremoloDepth >> 6);
/*     */   }
/*     */   
/*     */   private int waveform(int phase, int type) {
/* 435 */     int amplitude = 0;
/* 436 */     switch (type) {
/*     */     case 4: default: 
/* 438 */       amplitude = sineTable[(phase & 0x1F)];
/* 439 */       if ((phase & 0x20) > 0) amplitude = -amplitude;
/*     */       break;
/*     */     case 6: 
/* 442 */       amplitude = ((phase + 32 & 0x3F) << 3) - 255;
/* 443 */       break;
/*     */     case 1: case 7: 
/* 445 */       amplitude = 255 - ((phase + 32 & 0x3F) << 3);
/* 446 */       break;
/*     */     case 2: case 5: 
/* 448 */       amplitude = (phase & 0x20) > 0 ? 255 : 65281;
/* 449 */       break;
/*     */     case 3: case 8: 
/* 451 */       amplitude = (randomSeed >> 20) - 255;
/* 452 */       randomSeed = (randomSeed * 65 + 17 & 0x1FFFFFFF);
/*     */     }
/*     */     
/* 455 */     return amplitude;
/*     */   }
/*     */   
/*     */   private void tremor() {
/* 459 */     if (retrigCount >= tremorOnTicks) tremoloAdd = -64;
/* 460 */     if (retrigCount >= tremorOnTicks + tremorOffTicks)
/* 461 */       tremoloAdd = (retrigCount = 0);
/*     */   }
/*     */   
/*     */   private void retrigVolSlide() {
/* 465 */     if (retrigCount >= retrigTicks) {
/* 466 */       retrigCount = (sampleIdx = sampleFra = 0);
/* 467 */       switch (retrigVolume) {
/* 468 */       case 1:  volume -= 1; break;
/* 469 */       case 2:  volume -= 2; break;
/* 470 */       case 3:  volume -= 4; break;
/* 471 */       case 4:  volume -= 8; break;
/* 472 */       case 5:  volume -= 16; break;
/* 473 */       case 6:  volume -= volume / 3; break;
/* 474 */       case 7:  volume >>= 1; break;
/*     */       case 8: 
/*     */         break; case 9:  volume += 1; break;
/* 477 */       case 10:  volume += 2; break;
/* 478 */       case 11:  volume += 4; break;
/* 479 */       case 12:  volume += 8; break;
/* 480 */       case 13:  volume += 16; break;
/* 481 */       case 14:  volume += (volume >> 1); break;
/* 482 */       case 15:  volume <<= 1;
/*     */       }
/* 484 */       if (volume < 0) volume = 0;
/* 485 */       if (volume > 64) volume = 64;
/*     */     }
/*     */   }
/*     */   
/*     */   private void calculateFrequency() {
/* 490 */     if (module.linearPeriods) {
/* 491 */       int per = period + vibratoAdd - (arpeggioAdd << 6);
/* 492 */       if ((per < 28) || (per > 7680)) per = 7680;
/* 493 */       int tone = 7680 - per;
/* 494 */       int i = (tone >> 3) % 96;
/* 495 */       int c = freqTable[i];
/* 496 */       int m = freqTable[(i + 1)] - c;
/* 497 */       int x = tone & 0x7;
/* 498 */       int y = (m * x >> 3) + c;
/* 499 */       freq = (y >> 9 - tone / 768);
/*     */     } else {
/* 501 */       int per = period + vibratoAdd;
/* 502 */       per = per * (periodTable[((arpeggioAdd & 0xF) << 3)] << 1) / periodTable[0];
/* 503 */       per = (per >> 1) + (per & 0x1);
/* 504 */       if (per < 28) per = periodTable[0];
/* 505 */       freq = (module.c2Rate * 1712 / per);
/*     */     }
/*     */   }
/*     */   
/*     */   private void calculateAmplitude() {
/* 510 */     int envVol = keyOn ? 64 : 0;
/* 511 */     if (instrument.volumeEnvelope.enabled)
/* 512 */       envVol = instrument.volumeEnvelope.calculateAmpl(volEnvTick);
/* 513 */     int vol = volume + tremoloAdd;
/* 514 */     if (vol > 64) vol = 64;
/* 515 */     if (vol < 0) vol = 0;
/* 516 */     vol = vol * module.gain * 32768 >> 13;
/* 517 */     vol = vol * fadeOutVol >> 15;
/* 518 */     ampl = (vol * globalVol.volume * envVol >> 12);
/* 519 */     int envPan = 32;
/* 520 */     if (instrument.panningEnvelope.enabled)
/* 521 */       envPan = instrument.panningEnvelope.calculateAmpl(panEnvTick);
/* 522 */     int panRange = panning < 128 ? panning : 255 - panning;   }
/*     */   
/*     */   private void trigger() {
/* 527 */     if ((noteIns > 0) && (noteIns <= module.numInstruments)) {
/* 528 */       instrument = module.instruments[noteIns];
/* 529 */       Sample sam = instrument.samples[instrument.keyToSample[0]];
/* 530 */       volume = (sam.volume >= 64 ? 64 : sam.volume & 0x3F);
/* 531 */       if (sam.panning >= 0) panning = (sam.panning & 0xFF);
/* 532 */       if ((period > 0) && (sam.looped())) sample = sam;
/* 533 */       sampleOffset = (volEnvTick = panEnvTick = 0);
/* 534 */       fadeOutVol = 32768;
/* 535 */       keyOn = true;
/*     */     }
/* 537 */     if ((noteEffect == 9) || (noteEffect == 143)) {
/* 538 */       if (noteParam > 0) offsetParam = noteParam;
/* 539 */       sampleOffset = (offsetParam << 8);
/*     */     }
/* 541 */     if ((noteVol >= 16) && (noteVol < 96))
/* 542 */       volume = (noteVol < 80 ? noteVol - 16 : 64);
/* 543 */     switch (noteVol & 0xF0) {
/*     */     case 128: 
/* 545 */       volume -= (noteVol & 0xF);
/* 546 */       if (volume < 0) volume = 0;
/*     */       break;
/*     */     case 144: 
/* 549 */       volume += (noteVol & 0xF);
/* 550 */       if (volume > 64) volume = 64;
/*     */       break;
/*     */     case 160: 
/* 553 */       if ((noteVol & 0xF) > 0) vibratoSpeed = (noteVol & 0xF);
/*     */       break;
/*     */     case 176: 
/* 556 */       if ((noteVol & 0xF) > 0) vibratoDepth = (noteVol & 0xF);
/* 557 */       vibrato(false);
/* 558 */       break;
/*     */     case 192: 
/* 560 */       panning = ((noteVol & 0xF) * 17);
/* 561 */       break;
/*     */     case 240: 
/* 563 */       if ((noteVol & 0xF) > 0) tonePortaParam = (noteVol & 0xF);
/*     */       break;
/*     */     }
/* 566 */     if (noteKey > 0) {
/* 567 */       if (noteKey > 96) {
/* 568 */         keyOn = false;
/*     */       } else {
/* 570 */         boolean isPorta = ((noteVol & 0xF0) == 240) || (noteEffect == 3) || (noteEffect == 5) || (noteEffect == 135) || (noteEffect == 140);
/*     */         
/*     */ 
/* 573 */         if (!isPorta) sample = instrument.samples[instrument.keyToSample[noteKey]];
/* 574 */         int fineTune = sample.fineTune;
/* 575 */         if ((noteEffect == 117) || (noteEffect == 242)) {
/* 576 */           fineTune = (noteParam & 0xF) << 4;
/* 577 */           if (fineTune > 127) fineTune -= 256;
/*     */         }
/* 579 */         int key = noteKey + sample.relNote;
/* 580 */         if (key < 1) key = 1;
/* 581 */         if (key > 120) key = 120;
/* 582 */         int per = keyToPeriod(key, fineTune, module.linearPeriods);
/* 583 */         per = module.c2Rate * per * 2 / sample.c2Rate;
/* 584 */         portaPeriod = ((per >> 1) + (per & 0x1));
/* 585 */         if (!isPorta) {
/* 586 */           period = portaPeriod;
/* 587 */           sampleIdx = sampleOffset;
/* 588 */           sampleFra = 0;
/* 589 */           if (vibratoType < 4) vibratoPhase = 0;
/* 590 */           if (tremoloType < 4) tremoloPhase = 0;
/* 591 */           retrigCount = (autoVibratoCount = 0);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public static int keyToPeriod(int key, int fineTune, boolean linear) {
/* 598 */     if (linear) {
/* 599 */       return 7744 - (key << 6) - (fineTune >> 1);
/*     */     }
/* 601 */     int tone = (key << 6) + (fineTune >> 1);
/* 602 */     int i = (tone >> 3) % 96;
/* 603 */     int c = periodTable[i] * 2;
/* 604 */     int m = periodTable[(i + 1)] * 2 - c;
/* 605 */     int x = tone & 0x7;
/* 606 */     int y = (m * x >> 3) + c >> tone / 768;
/* 607 */     return (y >> 1) + (y & 0x1);
/*     */   }
/*     */   
/*     */   public static int periodToKey(int period)
/*     */   {
/* 612 */     int key = 0;int oct = 0;
/* 613 */     while (period < periodTable[96]) {
/* 614 */       period <<= 1;
/* 615 */       oct++;
/*     */     }
/* 617 */     while (key < 12) {
/* 618 */       int d1 = periodTable[(key << 3)] - period;
/* 619 */       int d2 = period - periodTable[(key + 1 << 3)];
/* 620 */       if (d2 >= 0) {
/* 621 */         if (d2 >= d1) break; key++; break;
/*     */       }
/*     */       
/* 624 */       key++;
/*     */     }
/* 626 */     return oct * 12 + key;
/*     */   }
/*     */ }


/* Location:              E:\Games\Need For Madness\data\madapp.jar!\ibxm\Channel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */