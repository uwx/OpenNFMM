/*     */ package ds.nfm.xm;
/*     */ 
/*     */ import ds.nfm.ModuleSlayer;
/*     */ import ibxm.IBXM;
/*     */ import ibxm.Module;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.IOException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class IBXModSlayer
/*     */   extends ModuleSlayer
/*     */ {
/*     */   private Module module;
/*     */   private IBXM ibxm;
/*     */   private int samplePos;
/*     */   private int duration;
/*  20 */   private int gain = 300;
/*     */   
/*  22 */   public boolean offMark = false;
/*  23 */   public int offIndex = -1;
/*     */   public int[] patternOffsets;
/*     */   
/*     */   public IBXModSlayer(IBXMod pmod, int smpl, int gn, int bpmflex) {
/*  27 */     this.module = pmod.refMod;
/*  28 */     if (this.module.defaultTempo == 125)
/*  29 */       this.module.defaultTempo = bpmflex;
/*  30 */     this.ibxm = new IBXM(this.module, smpl / 2);
/*  31 */     this.ibxm.connect(this);
/*  32 */     this.ibxm.setInterpolation(1);
/*  33 */     this.gain = gn;
/*  34 */     this.duration = this.ibxm.calculateSongDuration();
/*     */   }
/*     */   
/*     */   public void offMark(int index)
/*     */   {
/*  39 */     this.offIndex = index;
/*  40 */     this.offMark = true;
/*     */   }
/*     */   
/*     */   public byte[] turnbytesNorm(boolean calvol) throws IOException
/*     */   {
/*  45 */     ByteArrayOutputStream out = new ByteArrayOutputStream();
/*  46 */     int[] mixBuf = new int[this.ibxm.getMixBufferLength()];
/*  47 */     byte[] outBuf = new byte[mixBuf.length * 2];
/*  48 */     this.oln = 0;
/*  49 */     int olniu = 1;int niu = 0;int cav = 0;
/*     */     
/*  51 */     int maxsize = Math.min(18000000, this.duration * 2);
/*  52 */     while (this.oln < maxsize) {
/*  53 */       int count = getAudio(mixBuf);
/*     */       
/*  55 */       if (this.offMark) {
/*  56 */         if (this.patternOffsets[this.offIndex] == 0) {
/*  57 */           this.patternOffsets[this.offIndex] = this.oln;
/*     */         }
/*     */         
/*  60 */         this.offMark = false;
/*     */       }
/*  62 */       int outIdx = niu = cav = 0;
/*  63 */       int mixIdx = 0; for (int mixEnd = count * 2; mixIdx < mixEnd; mixIdx++) {
/*  64 */         if (mixIdx % 2 == 0) {
/*  65 */           int ampl = (int)(mixBuf[mixIdx] * (this.gain / 300.0F));
/*  66 */           if (ampl > 32767) {
/*  67 */             ampl = 32767;
/*     */           }
/*  69 */           if (ampl < 32768) {
/*  70 */             ampl = 32768;
/*     */           }
/*  72 */           outBuf[(outIdx++)] = ((byte)(ampl & 0xFF));
/*  73 */           outBuf[(outIdx++)] = ((byte)(ampl >> 8));
/*  74 */           this.oln += 2;
/*  75 */           if (calvol) {
/*  76 */             cav += Math.abs(ampl);
/*  77 */             niu++;
/*     */           }
/*     */         }
/*     */       }
/*  81 */       if ((calvol) && 
/*  82 */         (niu != 0)) {
/*  83 */         cav /= niu;
/*  84 */         this.olav += cav;
/*  85 */         olniu++;
/*     */       }
/*     */       
/*  88 */       out.write(outBuf, 0, outIdx);
/*  89 */       if (this.loopMark) {
/*  90 */         this.rollBackTrig = this.oln;
/*  91 */         this.loopMark = false;
/*     */       }
/*     */     }
/*     */     
/*  95 */     if (calvol) {
/*  96 */       this.olav /= olniu;
/*     */     }
/*  98 */     if (this.oln % 2 != 0) { this.oln += 1;
/*     */     }
/* 100 */     return out.toByteArray();
/*     */   }
/*     */   
/*     */   private synchronized void seek(int pos) {
/* 104 */     this.samplePos = this.ibxm.seek(pos);
/*     */   }
/*     */   
/*     */   private synchronized int getAudio(int[] mixBuf) {
/* 108 */     int count = this.ibxm.getAudio(mixBuf);
/* 109 */     this.samplePos += count;
/* 110 */     return count;
/*     */   }
/*     */ }


/* Location:              E:\Games\Need For Madness\data\madapp.jar!\ds\nfm\xm\IBXModSlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */