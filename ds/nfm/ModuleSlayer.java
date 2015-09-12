/*    */ package ds.nfm;
/*    */ 
/*    */ import java.io.IOException;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class ModuleSlayer
/*    */ {
/* 12 */   public int oln = 0;
/* 13 */   public int olav = 0;
/* 14 */   public int rollBack = -1;
/* 15 */   public int rollBackPos = 0;
/* 16 */   public int rollBackTrig = 0;
/* 17 */   public boolean loopMark = false;
/*    */   
/*    */   public abstract byte[] turnbytesNorm(boolean paramBoolean)
/*    */     throws IOException;
/*    */ }


/* Location:              E:\Games\Need For Madness\data\madapp.jar!\ds\nfm\ModuleSlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */