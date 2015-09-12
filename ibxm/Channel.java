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
/*     */   private int pann;
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
/*  70 */     this.module = module;
/*  71 */     this.id = id;
/*  72 */     this.globalVol = globalVol;
/*  73 */     this.panning = module.defaultPanning[id];
/*  74 */     this.instrument = new Instrument();
/*  75 */     this.sample = this.instrument.samples[0];
/*  76 */     this.randomSeed = ((id + 1) * 11259375);
/*     */   }
/*     */   
/*     */   private int arpeggioParam;
/*     */   private int vslideParam;
/*     */   private int globalVslideParam;
/*     */   private int panningSlideParam;
/*     */   
/*     */   public void resample(int[] outBuf, int offset, int length, int sampleRate, int interpolation)
/*     */   {
/*  80 */     if (this.ampl <= 0) { return;
/*     */     }
/*  82 */     int lAmpl = this.ampl * 255 >> 8;
/*  83 */     int rAmpl = this.ampl * 255 >> 8;
/*  84 */     int step = (this.freq << 12) / (sampleRate >> 3);
/*  85 */     switch (interpolation)
/*     */     {
/*     */     case 0: 
/*  87 */       this.sample.resampleNearest(this.sampleIdx, this.sampleFra, step, lAmpl, rAmpl, outBuf, offset, length);
/*  88 */       break;
/*     */     case 1: default: 
/*  90 */       this.sample.resampleLinear(this.sampleIdx, this.sampleFra, step, lAmpl, rAmpl, outBuf, offset, length);
/*  91 */       break;
/*     */     case 2: 
/*  93 */       this.sample.resampleSinc(this.sampleIdx, this.sampleFra, step, lAmpl, rAmpl, outBuf, offset, length);
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
/*  99 */     int step = (this.freq << 12) / (sampleRate >> 3);
/* 100 */     this.sampleFra += step * length;
/* 101 */     this.sampleIdx = this.sample.normaliseSampleIdx(this.sampleIdx + (this.sampleFra >> 15));
/* 102 */     this.sampleFra &= 0x7FFF;
/*     */   }
/*     */   
/*     */   private int vibratoPhase;
/*     */   private int vibratoSpeed;
/*     */   
/*     */   public void row(Note note)
/*     */   {
/* 106 */     this.noteKey = note.key;
/* 107 */     this.noteIns = note.instrument;
/* 108 */     this.noteVol = note.volume;
/* 109 */     this.noteEffect = note.effect;
/* 110 */     this.noteParam = note.param;
/* 111 */     this.retrigCount += 1;
/* 112 */     this.vibratoAdd = (this.tremoloAdd = this.arpeggioAdd = this.fxCount = 0);
/* 113 */     if (((this.noteEffect != 125) && (this.noteEffect != 253)) || (this.noteParam <= 0))
/*     */     {
/* 115 */       trigger();
/*     */     }
/* 117 */     switch (this.noteEffect) {
/*     */     case 1: case 134: 
/* 119 */       if (this.noteParam > 0) this.portaUpParam = this.noteParam;
/* 120 */       portamentoUp(this.portaUpParam);
/* 121 */       break;
/*     */     case 2: case 133: 
/* 123 */       if (this.noteParam > 0) this.portaDownParam = this.noteParam;
/* 124 */       portamentoDown(this.portaDownParam);
/* 125 */       break;
/*     */     case 3: case 135: 
/* 127 */       if (this.noteParam > 0) this.tonePortaParam = this.noteParam;
/*     */       break;
/*     */     case 4: case 136: 
/* 130 */       if (this.noteParam >> 4 > 0) this.vibratoSpeed = (this.noteParam >> 4);
/* 131 */       if ((this.noteParam & 0xF) > 0) this.vibratoDepth = (this.noteParam & 0xF);
/* 132 */       vibrato(false);
/* 133 */       break;
/*     */     case 5: case 140: 
/* 135 */       if (this.noteParam > 0) this.vslideParam = this.noteParam;
/* 136 */       volumeSlide();
/* 137 */       break;
/*     */     case 6: case 139: 
/* 139 */       if (this.noteParam > 0) this.vslideParam = this.noteParam;
/* 140 */       vibrato(false);
/* 141 */       volumeSlide();
/* 142 */       break;
/*     */     case 7: case 146: 
/* 144 */       if (this.noteParam >> 4 > 0) this.tremoloSpeed = (this.noteParam >> 4);
/* 145 */       if ((this.noteParam & 0xF) > 0) this.tremoloDepth = (this.noteParam & 0xF);
/* 146 */       tremolo();
/* 147 */       break;
/*     */     case 8: 
/* 149 */       this.panning = (this.noteParam < 128 ? this.noteParam << 1 : 255);
/* 150 */       break;
/*     */     case 10: case 132: 
/* 152 */       if (this.noteParam > 0) this.vslideParam = this.noteParam;
/* 153 */       volumeSlide();
/* 154 */       break;
/*     */     case 12: 
/* 156 */       this.volume = (this.noteParam >= 64 ? 64 : this.noteParam & 0x3F);
/* 157 */       break;
/*     */     case 16: case 150: 
/* 159 */       this.globalVol.volume = (this.noteParam >= 64 ? 64 : this.noteParam & 0x3F);
/* 160 */       break;
/*     */     case 17: 
/* 162 */       if (this.noteParam > 0) this.globalVslideParam = this.noteParam;
/*     */       break;
/*     */     case 20: 
/* 165 */       this.keyOn = false;
/* 166 */       break;
/*     */     case 21: 
/* 168 */       this.volEnvTick = (this.panEnvTick = this.noteParam & 0xFF);
/* 169 */       break;
/*     */     case 25: 
/* 171 */       if (this.noteParam > 0) this.panningSlideParam = this.noteParam;
/*     */       break;
/*     */     case 27: case 145: 
/* 174 */       if (this.noteParam >> 4 > 0) this.retrigVolume = (this.noteParam >> 4);
/* 175 */       if ((this.noteParam & 0xF) > 0) this.retrigTicks = (this.noteParam & 0xF);
/* 176 */       retrigVolSlide();
/* 177 */       break;
/*     */     case 29: case 137: 
/* 179 */       if (this.noteParam >> 4 > 0) this.tremorOnTicks = (this.noteParam >> 4);
/* 180 */       if ((this.noteParam & 0xF) > 0) this.tremorOffTicks = (this.noteParam & 0xF);
/* 181 */       tremor();
/* 182 */       break;
/*     */     case 33: 
/* 184 */       if (this.noteParam > 0) this.extraFinePortaParam = this.noteParam;
/* 185 */       switch (this.extraFinePortaParam & 0xF0) {
/*     */       case 16: 
/* 187 */         portamentoUp(0xE0 | this.extraFinePortaParam & 0xF);
/* 188 */         break;
/*     */       case 32: 
/* 190 */         portamentoDown(0xE0 | this.extraFinePortaParam & 0xF);
/*     */       }
/*     */       
/* 193 */       break;
/*     */     case 113: 
/* 195 */       if (this.noteParam > 0) this.finePortaUpParam = this.noteParam;
/* 196 */       portamentoUp(0xF0 | this.finePortaUpParam & 0xF);
/* 197 */       break;
/*     */     case 114: 
/* 199 */       if (this.noteParam > 0) this.finePortaDownParam = this.noteParam;
/* 200 */       portamentoDown(0xF0 | this.finePortaDownParam & 0xF);
/* 201 */       break;
/*     */     case 116: case 243: 
/* 203 */       if (this.noteParam < 8) this.vibratoType = this.noteParam;
/*     */       break;
/*     */     case 119: case 244: 
/* 206 */       if (this.noteParam < 8) this.tremoloType = this.noteParam;
/*     */       break;
/*     */     case 122: 
/* 209 */       if (this.noteParam > 0) this.fineVslideUpParam = this.noteParam;
/* 210 */       this.volume += this.fineVslideUpParam;
/* 211 */       if (this.volume > 64) this.volume = 64;
/*     */       break;
/*     */     case 123: 
/* 214 */       if (this.noteParam > 0) this.fineVslideDownParam = this.noteParam;
/* 215 */       this.volume -= this.fineVslideDownParam;
/* 216 */       if (this.volume < 0) this.volume = 0;
/*     */       break;
/*     */     case 124: case 252: 
/* 219 */       if (this.noteParam <= 0) this.volume = 0;
/*     */       break;
/*     */     case 138: 
/* 222 */       if (this.noteParam > 0) this.arpeggioParam = this.noteParam;
/*     */       break;
/*     */     case 149: 
/* 225 */       if (this.noteParam >> 4 > 0) this.vibratoSpeed = (this.noteParam >> 4);
/* 226 */       if ((this.noteParam & 0xF) > 0) this.vibratoDepth = (this.noteParam & 0xF);
/* 227 */       vibrato(true);
/* 228 */       break;
/*     */     case 248: 
/* 230 */       this.panning = (this.noteParam * 17);
/*     */     }
/*     */     
/* 233 */     autoVibrato();
/* 234 */     calculateFrequency();
/* 235 */     calculateAmplitude();
/* 236 */     updateEnvelopes(); }
/*     */   
/*     */   private int vibratoDepth;
/*     */   private int tremoloType;
/* 240 */   public void tick() { this.vibratoAdd = 0;
/* 241 */     this.fxCount += 1;
/* 242 */     this.retrigCount += 1;
/* 243 */     if ((this.noteEffect != 125) || (this.fxCount > this.noteParam)) {
/* 244 */       switch (this.noteVol & 0xF0) {
/*     */       case 96: 
/* 246 */         this.volume -= (this.noteVol & 0xF);
/* 247 */         if (this.volume < 0) this.volume = 0;
/*     */         break;
/*     */       case 112: 
/* 250 */         this.volume += (this.noteVol & 0xF);
/* 251 */         if (this.volume > 64) this.volume = 64;
/*     */         break;
/*     */       case 176: 
/* 254 */         this.vibratoPhase += this.vibratoSpeed;
/* 255 */         vibrato(false);
/* 256 */         break;
/*     */       case 208: 
/* 258 */         this.panning -= (this.noteVol & 0xF);
/* 259 */         if (this.panning < 0) this.panning = 0;
/*     */         break;
/*     */       case 224: 
/* 262 */         this.panning += (this.noteVol & 0xF);
/* 263 */         if (this.panning > 255) this.panning = 255;
/*     */         break;
/*     */       case 240: 
/* 266 */         tonePortamento();
/*     */       }
/*     */       
/*     */     }
/* 270 */     switch (this.noteEffect) {
/*     */     case 1: case 134: 
/* 272 */       portamentoUp(this.portaUpParam);
/* 273 */       break;
/*     */     case 2: case 133: 
/* 275 */       portamentoDown(this.portaDownParam);
/* 276 */       break;
/*     */     case 3: case 135: 
/* 278 */       tonePortamento();
/* 279 */       break;
/*     */     case 4: case 136: 
/* 281 */       this.vibratoPhase += this.vibratoSpeed;
/* 282 */       vibrato(false);
/* 283 */       break;
/*     */     case 5: case 140: 
/* 285 */       tonePortamento();
/* 286 */       volumeSlide();
/* 287 */       break;
/*     */     case 6: case 139: 
/* 289 */       this.vibratoPhase += this.vibratoSpeed;
/* 290 */       vibrato(false);
/* 291 */       volumeSlide();
/* 292 */       break;
/*     */     case 7: case 146: 
/* 294 */       this.tremoloPhase += this.tremoloSpeed;
/* 295 */       tremolo();
/* 296 */       break;
/*     */     case 10: case 132: 
/* 298 */       volumeSlide();
/* 299 */       break;
/*     */     case 17: 
/* 301 */       this.globalVol.volume += (this.globalVslideParam >> 4) - (this.globalVslideParam & 0xF);
/* 302 */       if (this.globalVol.volume < 0) this.globalVol.volume = 0;
/* 303 */       if (this.globalVol.volume > 64) this.globalVol.volume = 64;
/*     */       break;
/*     */     case 25: 
/* 306 */       this.panning += (this.panningSlideParam >> 4) - (this.panningSlideParam & 0xF);
/* 307 */       if (this.panning < 0) this.panning = 0;
/* 308 */       if (this.panning > 255) this.panning = 255;
/*     */       break;
/*     */     case 27: case 145: 
/* 311 */       retrigVolSlide();
/* 312 */       break;
/*     */     case 29: case 137: 
/* 314 */       tremor();
/* 315 */       break;
/*     */     case 121: 
/* 317 */       if (this.fxCount >= this.noteParam) {
/* 318 */         this.fxCount = 0;
/* 319 */         this.sampleIdx = (this.sampleFra = 0);
/*     */       }
/*     */       break;
/*     */     case 124: case 252: 
/* 323 */       if (this.noteParam == this.fxCount) this.volume = 0;
/*     */       break;
/*     */     case 125: case 253: 
/* 326 */       if (this.noteParam == this.fxCount) trigger();
/*     */       break;
/*     */     case 138: 
/* 329 */       if (this.fxCount > 2) this.fxCount = 0;
/* 330 */       if (this.fxCount == 0) this.arpeggioAdd = 0;
/* 331 */       if (this.fxCount == 1) this.arpeggioAdd = (this.arpeggioParam >> 4);
/* 332 */       if (this.fxCount == 2) this.arpeggioAdd = (this.arpeggioParam & 0xF);
/*     */       break;
/*     */     case 149: 
/* 335 */       this.vibratoPhase += this.vibratoSpeed;
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
/* 346 */   private void updateEnvelopes() { if (this.instrument.volumeEnvelope.enabled) {
/* 347 */       if (!this.keyOn) {
/* 348 */         this.fadeOutVol -= this.instrument.volumeFadeOut;
/* 349 */         if (this.fadeOutVol < 0) this.fadeOutVol = 0;
/*     */       }
/* 351 */       this.volEnvTick = this.instrument.volumeEnvelope.nextTick(this.volEnvTick, this.keyOn);
/*     */     }
/* 353 */     if (this.instrument.panningEnvelope.enabled)
/* 354 */       this.panEnvTick = this.instrument.panningEnvelope.nextTick(this.panEnvTick, this.keyOn); }
/*     */   
/*     */   private int tremoloDepth;
/*     */   private int tremoloAdd;
/* 358 */   private void autoVibrato() { int depth = this.instrument.vibratoDepth & 0x7F;
/* 359 */     if (depth > 0) {
/* 360 */       int sweep = this.instrument.vibratoSweep & 0x7F;
/* 361 */       int rate = this.instrument.vibratoRate & 0x7F;
/* 362 */       int type = this.instrument.vibratoType;
/* 363 */       if (this.autoVibratoCount < sweep) depth = depth * this.autoVibratoCount / sweep;
/* 364 */       this.vibratoAdd += (waveform(this.autoVibratoCount * rate >> 2, type + 4) * depth >> 8);
/* 365 */       this.autoVibratoCount += 1; } }
/*     */   
/*     */   private int vibratoAdd;
/*     */   private int arpeggioAdd;
/*     */   private int id;
/* 370 */   private int randomSeed; public int plRow; private void volumeSlide() { int up = this.vslideParam >> 4;
/* 371 */     int down = this.vslideParam & 0xF;
/* 372 */     if ((down == 15) && (up > 0)) {
/* 373 */       if (this.fxCount == 0) this.volume += up;
/* 374 */     } else if ((up == 15) && (down > 0)) {
/* 375 */       if (this.fxCount == 0) this.volume -= down;
/* 376 */     } else if ((this.fxCount > 0) || (this.module.fastVolSlides))
/* 377 */       this.volume += up - down;
/* 378 */     if (this.volume > 64) this.volume = 64;
/* 379 */     if (this.volume < 0) this.volume = 0;
/*     */   }
/*     */   
/*     */   private void portamentoUp(int param) {
/* 383 */     switch (param & 0xF0) {
/*     */     case 224: 
/* 385 */       if (this.fxCount == 0) this.period -= (param & 0xF);
/*     */       break;
/*     */     case 240: 
/* 388 */       if (this.fxCount == 0) this.period -= ((param & 0xF) << 2);
/*     */       break;
/*     */     default: 
/* 391 */       if (this.fxCount > 0) this.period -= (param << 2);
/*     */       break;
/*     */     }
/* 394 */     if (this.period < 0) this.period = 0;
/*     */   }
/*     */   
/*     */   private void portamentoDown(int param) {
/* 398 */     if (this.period > 0) {
/* 399 */       switch (param & 0xF0) {
/*     */       case 224: 
/* 401 */         if (this.fxCount == 0) this.period += (param & 0xF);
/*     */         break;
/*     */       case 240: 
/* 404 */         if (this.fxCount == 0) this.period += ((param & 0xF) << 2);
/*     */         break;
/*     */       default: 
/* 407 */         if (this.fxCount > 0) this.period += (param << 2);
/*     */         break;
/*     */       }
/* 410 */       if (this.period > 65535) this.period = 65535;
/*     */     }
/*     */   }
/*     */   
/*     */   private void tonePortamento() {
/* 415 */     if (this.period > 0) {
/* 416 */       if (this.period < this.portaPeriod) {
/* 417 */         this.period += (this.tonePortaParam << 2);
/* 418 */         if (this.period > this.portaPeriod) this.period = this.portaPeriod;
/*     */       } else {
/* 420 */         this.period -= (this.tonePortaParam << 2);
/* 421 */         if (this.period < this.portaPeriod) this.period = this.portaPeriod;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void vibrato(boolean fine) {
/* 427 */     this.vibratoAdd = (waveform(this.vibratoPhase, this.vibratoType & 0x3) * this.vibratoDepth >> (fine ? 7 : 5));
/*     */   }
/*     */   
/*     */   private void tremolo() {
/* 431 */     this.tremoloAdd = (waveform(this.tremoloPhase, this.tremoloType & 0x3) * this.tremoloDepth >> 6);
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
/* 451 */       amplitude = (this.randomSeed >> 20) - 255;
/* 452 */       this.randomSeed = (this.randomSeed * 65 + 17 & 0x1FFFFFFF);
/*     */     }
/*     */     
/* 455 */     return amplitude;
/*     */   }
/*     */   
/*     */   private void tremor() {
/* 459 */     if (this.retrigCount >= this.tremorOnTicks) this.tremoloAdd = -64;
/* 460 */     if (this.retrigCount >= this.tremorOnTicks + this.tremorOffTicks)
/* 461 */       this.tremoloAdd = (this.retrigCount = 0);
/*     */   }
/*     */   
/*     */   private void retrigVolSlide() {
/* 465 */     if (this.retrigCount >= this.retrigTicks) {
/* 466 */       this.retrigCount = (this.sampleIdx = this.sampleFra = 0);
/* 467 */       switch (this.retrigVolume) {
/* 468 */       case 1:  this.volume -= 1; break;
/* 469 */       case 2:  this.volume -= 2; break;
/* 470 */       case 3:  this.volume -= 4; break;
/* 471 */       case 4:  this.volume -= 8; break;
/* 472 */       case 5:  this.volume -= 16; break;
/* 473 */       case 6:  this.volume -= this.volume / 3; break;
/* 474 */       case 7:  this.volume >>= 1; break;
/*     */       case 8: 
/*     */         break; case 9:  this.volume += 1; break;
/* 477 */       case 10:  this.volume += 2; break;
/* 478 */       case 11:  this.volume += 4; break;
/* 479 */       case 12:  this.volume += 8; break;
/* 480 */       case 13:  this.volume += 16; break;
/* 481 */       case 14:  this.volume += (this.volume >> 1); break;
/* 482 */       case 15:  this.volume <<= 1;
/*     */       }
/* 484 */       if (this.volume < 0) this.volume = 0;
/* 485 */       if (this.volume > 64) this.volume = 64;
/*     */     }
/*     */   }
/*     */   
/*     */   private void calculateFrequency() {
/* 490 */     if (this.module.linearPeriods) {
/* 491 */       int per = this.period + this.vibratoAdd - (this.arpeggioAdd << 6);
/* 492 */       if ((per < 28) || (per > 7680)) per = 7680;
/* 493 */       int tone = 7680 - per;
/* 494 */       int i = (tone >> 3) % 96;
/* 495 */       int c = freqTable[i];
/* 496 */       int m = freqTable[(i + 1)] - c;
/* 497 */       int x = tone & 0x7;
/* 498 */       int y = (m * x >> 3) + c;
/* 499 */       this.freq = (y >> 9 - tone / 768);
/*     */     } else {
/* 501 */       int per = this.period + this.vibratoAdd;
/* 502 */       per = per * (periodTable[((this.arpeggioAdd & 0xF) << 3)] << 1) / periodTable[0];
/* 503 */       per = (per >> 1) + (per & 0x1);
/* 504 */       if (per < 28) per = periodTable[0];
/* 505 */       this.freq = (this.module.c2Rate * 1712 / per);
/*     */     }
/*     */   }
/*     */   
/*     */   private void calculateAmplitude() {
/* 510 */     int envVol = this.keyOn ? 64 : 0;
/* 511 */     if (this.instrument.volumeEnvelope.enabled)
/* 512 */       envVol = this.instrument.volumeEnvelope.calculateAmpl(this.volEnvTick);
/* 513 */     int vol = this.volume + this.tremoloAdd;
/* 514 */     if (vol > 64) vol = 64;
/* 515 */     if (vol < 0) vol = 0;
/* 516 */     vol = vol * this.module.gain * 32768 >> 13;
/* 517 */     vol = vol * this.fadeOutVol >> 15;
/* 518 */     this.ampl = (vol * this.globalVol.volume * envVol >> 12);
/* 519 */     int envPan = 32;
/* 520 */     if (this.instrument.panningEnvelope.enabled)
/* 521 */       envPan = this.instrument.panningEnvelope.calculateAmpl(this.panEnvTick);
/* 522 */     int panRange = this.panning < 128 ? this.panning : 255 - this.panning;
/* 523 */     this.pann = (this.panning + (panRange * (envPan - 32) >> 5));
/*     */   }
/*     */   
/*     */   private void trigger() {
/* 527 */     if ((this.noteIns > 0) && (this.noteIns <= this.module.numInstruments)) {
/* 528 */       this.instrument = this.module.instruments[this.noteIns];
/* 529 */       Sample sam = this.instrument.samples[this.instrument.keyToSample[0]];
/* 530 */       this.volume = (sam.volume >= 64 ? 64 : sam.volume & 0x3F);
/* 531 */       if (sam.panning >= 0) this.panning = (sam.panning & 0xFF);
/* 532 */       if ((this.period > 0) && (sam.looped())) this.sample = sam;
/* 533 */       this.sampleOffset = (this.volEnvTick = this.panEnvTick = 0);
/* 534 */       this.fadeOutVol = 32768;
/* 535 */       this.keyOn = true;
/*     */     }
/* 537 */     if ((this.noteEffect == 9) || (this.noteEffect == 143)) {
/* 538 */       if (this.noteParam > 0) this.offsetParam = this.noteParam;
/* 539 */       this.sampleOffset = (this.offsetParam << 8);
/*     */     }
/* 541 */     if ((this.noteVol >= 16) && (this.noteVol < 96))
/* 542 */       this.volume = (this.noteVol < 80 ? this.noteVol - 16 : 64);
/* 543 */     switch (this.noteVol & 0xF0) {
/*     */     case 128: 
/* 545 */       this.volume -= (this.noteVol & 0xF);
/* 546 */       if (this.volume < 0) this.volume = 0;
/*     */       break;
/*     */     case 144: 
/* 549 */       this.volume += (this.noteVol & 0xF);
/* 550 */       if (this.volume > 64) this.volume = 64;
/*     */       break;
/*     */     case 160: 
/* 553 */       if ((this.noteVol & 0xF) > 0) this.vibratoSpeed = (this.noteVol & 0xF);
/*     */       break;
/*     */     case 176: 
/* 556 */       if ((this.noteVol & 0xF) > 0) this.vibratoDepth = (this.noteVol & 0xF);
/* 557 */       vibrato(false);
/* 558 */       break;
/*     */     case 192: 
/* 560 */       this.panning = ((this.noteVol & 0xF) * 17);
/* 561 */       break;
/*     */     case 240: 
/* 563 */       if ((this.noteVol & 0xF) > 0) this.tonePortaParam = (this.noteVol & 0xF);
/*     */       break;
/*     */     }
/* 566 */     if (this.noteKey > 0) {
/* 567 */       if (this.noteKey > 96) {
/* 568 */         this.keyOn = false;
/*     */       } else {
/* 570 */         boolean isPorta = ((this.noteVol & 0xF0) == 240) || (this.noteEffect == 3) || (this.noteEffect == 5) || (this.noteEffect == 135) || (this.noteEffect == 140);
/*     */         
/*     */ 
/* 573 */         if (!isPorta) this.sample = this.instrument.samples[this.instrument.keyToSample[this.noteKey]];
/* 574 */         int fineTune = this.sample.fineTune;
/* 575 */         if ((this.noteEffect == 117) || (this.noteEffect == 242)) {
/* 576 */           fineTune = (this.noteParam & 0xF) << 4;
/* 577 */           if (fineTune > 127) fineTune -= 256;
/*     */         }
/* 579 */         int key = this.noteKey + this.sample.relNote;
/* 580 */         if (key < 1) key = 1;
/* 581 */         if (key > 120) key = 120;
/* 582 */         int per = keyToPeriod(key, fineTune, this.module.linearPeriods);
/* 583 */         per = this.module.c2Rate * per * 2 / this.sample.c2Rate;
/* 584 */         this.portaPeriod = ((per >> 1) + (per & 0x1));
/* 585 */         if (!isPorta) {
/* 586 */           this.period = this.portaPeriod;
/* 587 */           this.sampleIdx = this.sampleOffset;
/* 588 */           this.sampleFra = 0;
/* 589 */           if (this.vibratoType < 4) this.vibratoPhase = 0;
/* 590 */           if (this.tremoloType < 4) this.tremoloPhase = 0;
/* 591 */           this.retrigCount = (this.autoVibratoCount = 0);
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