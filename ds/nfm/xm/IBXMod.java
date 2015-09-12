/*    */ package ds.nfm.xm;
/*    */ 
/*    */ import java.io.ByteArrayInputStream;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ 
/*    */ 
/*    */ public class IBXMod
/*    */   extends ds.nfm.Module
/*    */ {
/*    */   ibxm.Module refMod;
/*    */   
/*    */   public IBXMod(byte[] modf)
/*    */   {
/*    */     try
/*    */     {
/* 17 */       loadMod(new ByteArrayInputStream(modf));
/* 18 */       this.loaded = true;
/*    */     } catch (Exception e) {
/* 20 */       this.loaded = false;
/*    */     }
/*    */   }
/*    */   
/*    */   public void loadMod(InputStream inputstream) throws IOException
/*    */   {
/* 26 */     this.refMod = new ibxm.Module(inputstream);
/*    */   }
/*    */ }


/* Location:              E:\Games\Need For Madness\data\madapp.jar!\ds\nfm\xm\IBXMod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */