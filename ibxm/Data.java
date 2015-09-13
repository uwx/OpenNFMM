/*     */ package ibxm;
/*     */ 
/*     */ import java.io.IOException;
/*     */ 
/*     */ public class Data {
/*     */   private int bufLen;
/*     */   private byte[] buffer;
/*     */   private java.io.InputStream stream;
/*     */   
/*     */   public Data(java.io.InputStream inputStream) throws IOException {
/*  11 */     bufLen = 65536;
/*  12 */     buffer = new byte[bufLen];
/*  13 */     stream = inputStream;
/*  14 */     readFully(stream, buffer, 0, bufLen);
/*     */   }
/*     */   
/*     */   public Data(byte[] data) {
/*  18 */     bufLen = data.length;
/*  19 */     buffer = data;
/*     */   }
/*     */   
/*     */   public byte sByte(int offset) throws IOException {
/*  23 */     load(offset, 1);
/*  24 */     return buffer[offset];
/*     */   }
/*     */   
/*     */   public int uByte(int offset) throws IOException {
/*  28 */     load(offset, 1);
/*  29 */     return buffer[offset] & 0xFF;
/*     */   }
/*     */   
/*     */   public int ubeShort(int offset) throws IOException {
/*  33 */     load(offset, 2);
/*  34 */     return (buffer[offset] & 0xFF) << 8 | buffer[(offset + 1)] & 0xFF;
/*     */   }
/*     */   
/*     */   public int uleShort(int offset) throws IOException {
/*  38 */     load(offset, 2);
/*  39 */     return buffer[offset] & 0xFF | (buffer[(offset + 1)] & 0xFF) << 8;
/*     */   }
/*     */   
/*     */   public int uleInt(int offset) throws IOException {
/*  43 */     load(offset, 4);
/*  44 */     int value = buffer[offset] & 0xFF;
/*  45 */     value |= (buffer[(offset + 1)] & 0xFF) << 8;
/*  46 */     value |= (buffer[(offset + 2)] & 0xFF) << 16;
/*  47 */     value |= (buffer[(offset + 3)] & 0x7F) << 24;
/*  48 */     return value;
/*     */   }
/*     */   
/*     */   public String strLatin1(int offset, int length) throws IOException {
/*  52 */     load(offset, length);
/*  53 */     char[] str = new char[length];
/*  54 */     for (int idx = 0; idx < length; idx++) {
/*  55 */       int chr = buffer[(offset + idx)] & 0xFF;
/*  56 */       str[idx] = (chr < 32 ? 32 : (char)chr);
/*     */     }
/*  58 */     return new String(str);
/*     */   }
/*     */   
/*     */   public String strCp850(int offset, int length) throws IOException {
/*  62 */     load(offset, length);
/*     */     try {
/*  64 */       char[] str = new String(buffer, offset, length, "Cp850").toCharArray();
/*  65 */       for (int idx = 0; idx < str.length; idx++) {
/*  66 */         str[idx] = (str[idx] < ' ' ? 32 : str[idx]);
/*     */       }
/*  68 */       return new String(str);
/*     */     } catch (java.io.UnsupportedEncodingException e) {}
/*  70 */     return strLatin1(offset, length);
/*     */   }
/*     */   
/*     */   public short[] samS8(int offset, int length) throws IOException
/*     */   {
/*  75 */     load(offset, length);
/*  76 */     short[] sampleData = new short[length];
/*  77 */     for (int idx = 0; idx < length; idx++) {
/*  78 */       sampleData[idx] = ((short)(buffer[(offset + idx)] << 8));
/*     */     }
/*  80 */     return sampleData;
/*     */   }
/*     */   
/*     */   public short[] samS8D(int offset, int length) throws IOException {
/*  84 */     load(offset, length);
/*  85 */     short[] sampleData = new short[length];
/*  86 */     int sam = 0;
/*  87 */     for (int idx = 0; idx < length; idx++) {
/*  88 */       sam += buffer[(offset + idx)];
/*  89 */       sampleData[idx] = ((short)(sam << 8));
/*     */     }
/*  91 */     return sampleData;
/*     */   }
/*     */   
/*     */   public short[] samU8(int offset, int length) throws IOException {
/*  95 */     load(offset, length);
/*  96 */     short[] sampleData = new short[length];
/*  97 */     for (int idx = 0; idx < length; idx++) {
/*  98 */       sampleData[idx] = ((short)((buffer[(offset + idx)] & 0xFF) - 128 << 8));
/*     */     }
/* 100 */     return sampleData;
/*     */   }
/*     */   
/*     */   public short[] samS16(int offset, int samples) throws IOException {
/* 104 */     load(offset, samples * 2);
/* 105 */     short[] sampleData = new short[samples];
/* 106 */     for (int idx = 0; idx < samples; idx++) {
/* 107 */       sampleData[idx] = ((short)(buffer[(offset + idx * 2)] & 0xFF | buffer[(offset + idx * 2 + 1)] << 8));
/*     */     }
/* 109 */     return sampleData;
/*     */   }
/*     */   
/*     */   public short[] samS16D(int offset, int samples) throws IOException {
/* 113 */     load(offset, samples * 2);
/* 114 */     short[] sampleData = new short[samples];
/* 115 */     int sam = 0;
/* 116 */     for (int idx = 0; idx < samples; idx++) {
/* 117 */       sam += (buffer[(offset + idx * 2)] & 0xFF | buffer[(offset + idx * 2 + 1)] << 8);
/* 118 */       sampleData[idx] = ((short)sam);
/*     */     }
/* 120 */     return sampleData;
/*     */   }
/*     */   
/*     */   public short[] samU16(int offset, int samples) throws IOException {
/* 124 */     load(offset, samples * 2);
/* 125 */     short[] sampleData = new short[samples];
/* 126 */     for (int idx = 0; idx < samples; idx++) {
/* 127 */       int sam = buffer[(offset + idx * 2)] & 0xFF | (buffer[(offset + idx * 2 + 1)] & 0xFF) << 8;
/* 128 */       sampleData[idx] = ((short)(sam - 32768));
/*     */     }
/* 130 */     return sampleData;
/*     */   }
/*     */   
/*     */   private void load(int offset, int length) throws IOException {
/* 134 */     while (offset + length > bufLen) {
/* 135 */       int newBufLen = bufLen << 1;
/* 136 */       byte[] newBuf = new byte[newBufLen];
/* 137 */       System.arraycopy(buffer, 0, newBuf, 0, bufLen);
/* 138 */       if (stream != null) {
/* 139 */         readFully(stream, newBuf, bufLen, newBufLen - bufLen);
/*     */       }
/* 141 */       bufLen = newBufLen;
/* 142 */       buffer = newBuf;
/*     */     }
/*     */   }
/*     */   
/*     */   private static void readFully(java.io.InputStream inputStream, byte[] buffer, int offset, int length) throws IOException {
/* 147 */     int read = 1;int end = offset + length;
/* 148 */     while (read > 0) {
/* 149 */       read = inputStream.read(buffer, offset, end - offset);
/* 150 */       offset += read;
/*     */     }
/*     */   }
/*     */ }


/* Location:              E:\Games\Need For Madness\data\madapp.jar!\ibxm\Data.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */