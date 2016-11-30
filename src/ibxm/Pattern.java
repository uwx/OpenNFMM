package ibxm;

import ibxm.Note;

public class Pattern {
   public int numRows;
   public byte[] data;

   public Pattern(int numChannels, int numRows) {
      this.numRows = numRows;
      this.data = new byte[numChannels * numRows * 5];
   }

   public void getNote(int index, Note note) {
      int offset = index * 5;
      note.key = this.data[offset] & 255;
      note.instrument = this.data[offset + 1] & 255;
      note.volume = this.data[offset + 2] & 255;
      note.effect = this.data[offset + 3] & 255;
      note.param = this.data[offset + 4] & 255;
   }

   public void toStringBuffer(StringBuffer out) {
      char[] hex = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
      int channels = this.data.length / (this.numRows * 5);
      int data_offset = 0;

      for(int row = 0; row < this.numRows; ++row) {
         for(int channel = 0; channel < channels; ++channel) {
            for(int n = 0; n < 5; ++n) {
               byte b = this.data[data_offset++];
               if(b == 0) {
                  out.append("--");
               } else {
                  out.append(hex[b >> 4 & 15]);
                  out.append(hex[b & 15]);
               }
            }

            out.append(' ');
         }

         out.append('\n');
      }

   }
}
