/*    */ package ibxm;
/*    */ 
/*    */ public class Pattern
/*    */ {
/*    */   public int numRows;
/*    */   public byte[] data;
/*    */   
/*    */   public Pattern(int numChannels, int numRows) {
/*  9 */     this.numRows = numRows;
/* 10 */     this.data = new byte[numChannels * numRows * 5];
/*    */   }
/*    */   
/*    */   public void getNote(int index, Note note) {
/* 14 */     int offset = index * 5;
/* 15 */     note.key = (this.data[offset] & 0xFF);
/* 16 */     note.instrument = (this.data[(offset + 1)] & 0xFF);
/* 17 */     note.volume = (this.data[(offset + 2)] & 0xFF);
/* 18 */     note.effect = (this.data[(offset + 3)] & 0xFF);
/* 19 */     note.param = (this.data[(offset + 4)] & 0xFF);
/*    */   }
/*    */   
/*    */   public void toStringBuffer(StringBuffer out) {
/* 23 */     char[] hex = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
/*    */     
/*    */ 
/* 26 */     int channels = this.data.length / (this.numRows * 5);
/* 27 */     int data_offset = 0;
/* 28 */     for (int row = 0; row < this.numRows; row++) {
/* 29 */       for (int channel = 0; channel < channels; channel++) {
/* 30 */         for (int n = 0; n < 5; n++) {
/* 31 */           int b = this.data[(data_offset++)];
/* 32 */           if (b == 0) {
/* 33 */             out.append("--");
/*    */           } else {
/* 35 */             out.append(hex[(b >> 4 & 0xF)]);
/* 36 */             out.append(hex[(b & 0xF)]);
/*    */           }
/*    */         }
/* 39 */         out.append(' ');
/*    */       }
/* 41 */       out.append('\n');
/*    */     }
/*    */   }
/*    */ }


/* Location:              E:\Games\Need For Madness\data\madapp.jar!\ibxm\Pattern.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */