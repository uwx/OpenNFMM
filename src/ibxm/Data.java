package ibxm;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class Data {
   private int bufLen;
   private byte[] buffer;
   private InputStream stream;

   public Data(InputStream inputStream) throws IOException {
      this.bufLen = 65536;
      this.buffer = new byte[this.bufLen];
      this.stream = inputStream;
      readFully(this.stream, this.buffer, 0, this.bufLen);
   }

   public Data(byte[] data) {
      this.bufLen = data.length;
      this.buffer = data;
   }

   public byte sByte(int offset) throws IOException {
      this.load(offset, 1);
      return this.buffer[offset];
   }

   public int uByte(int offset) throws IOException {
      this.load(offset, 1);
      return this.buffer[offset] & 255;
   }

   public int ubeShort(int offset) throws IOException {
      this.load(offset, 2);
      return (this.buffer[offset] & 255) << 8 | this.buffer[offset + 1] & 255;
   }

   public int uleShort(int offset) throws IOException {
      this.load(offset, 2);
      return this.buffer[offset] & 255 | (this.buffer[offset + 1] & 255) << 8;
   }

   public int uleInt(int offset) throws IOException {
      this.load(offset, 4);
      int value = this.buffer[offset] & 255;
      value |= (this.buffer[offset + 1] & 255) << 8;
      value |= (this.buffer[offset + 2] & 255) << 16;
      value |= (this.buffer[offset + 3] & 127) << 24;
      return value;
   }

   public String strLatin1(int offset, int length) throws IOException {
      this.load(offset, length);
      char[] str = new char[length];

      for(int idx = 0; idx < length; ++idx) {
         int chr = this.buffer[offset + idx] & 255;
         str[idx] = chr < 32?32:(char)chr;
      }

      return new String(str);
   }

   public String strCp850(int offset, int length) throws IOException {
      this.load(offset, length);

      try {
         char[] e = (new String(this.buffer, offset, length, "Cp850")).toCharArray();

         for(int idx = 0; idx < e.length; ++idx) {
            e[idx] = e[idx] < 32?32:e[idx];
         }

         return new String(e);
      } catch (UnsupportedEncodingException var5) {
         return this.strLatin1(offset, length);
      }
   }

   public short[] samS8(int offset, int length) throws IOException {
      this.load(offset, length);
      short[] sampleData = new short[length];

      for(int idx = 0; idx < length; ++idx) {
         sampleData[idx] = (short)(this.buffer[offset + idx] << 8);
      }

      return sampleData;
   }

   public short[] samS8D(int offset, int length) throws IOException {
      this.load(offset, length);
      short[] sampleData = new short[length];
      int sam = 0;

      for(int idx = 0; idx < length; ++idx) {
         sam += this.buffer[offset + idx];
         sampleData[idx] = (short)(sam << 8);
      }

      return sampleData;
   }

   public short[] samU8(int offset, int length) throws IOException {
      this.load(offset, length);
      short[] sampleData = new short[length];

      for(int idx = 0; idx < length; ++idx) {
         sampleData[idx] = (short)((this.buffer[offset + idx] & 255) - 128 << 8);
      }

      return sampleData;
   }

   public short[] samS16(int offset, int samples) throws IOException {
      this.load(offset, samples * 2);
      short[] sampleData = new short[samples];

      for(int idx = 0; idx < samples; ++idx) {
         sampleData[idx] = (short)(this.buffer[offset + idx * 2] & 255 | this.buffer[offset + idx * 2 + 1] << 8);
      }

      return sampleData;
   }

   public short[] samS16D(int offset, int samples) throws IOException {
      this.load(offset, samples * 2);
      short[] sampleData = new short[samples];
      int sam = 0;

      for(int idx = 0; idx < samples; ++idx) {
         sam += this.buffer[offset + idx * 2] & 255 | this.buffer[offset + idx * 2 + 1] << 8;
         sampleData[idx] = (short)sam;
      }

      return sampleData;
   }

   public short[] samU16(int offset, int samples) throws IOException {
      this.load(offset, samples * 2);
      short[] sampleData = new short[samples];

      for(int idx = 0; idx < samples; ++idx) {
         int sam = this.buffer[offset + idx * 2] & 255 | (this.buffer[offset + idx * 2 + 1] & 255) << 8;
         sampleData[idx] = (short)(sam - '耀');
      }

      return sampleData;
   }

   private void load(int offset, int length) throws IOException {
      while(offset + length > this.bufLen) {
         int newBufLen = this.bufLen << 1;
         byte[] newBuf = new byte[newBufLen];
         System.arraycopy(this.buffer, 0, newBuf, 0, this.bufLen);
         if(this.stream != null) {
            readFully(this.stream, newBuf, this.bufLen, newBufLen - this.bufLen);
         }

         this.bufLen = newBufLen;
         this.buffer = newBuf;
      }

   }

   private static void readFully(InputStream inputStream, byte[] buffer, int offset, int length) throws IOException {
      int read = 1;

      for(int end = offset + length; read > 0; offset += read) {
         read = inputStream.read(buffer, offset, end - offset);
      }

   }
}
