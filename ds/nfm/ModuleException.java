/*    */ package ds.nfm;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ModuleException
/*    */   extends RuntimeException
/*    */ {
/**
	 * 
	 */
	private static final long serialVersionUID = 2007674564336027625L;
/*    */   public ModuleException() {}
/*    */   
/*    */ 
/*    */ 
/*    */   public ModuleException(String message)
/*    */   {
/* 14 */     super(message);
/*    */   }
/*    */   
/*    */   public ModuleException(String message, Throwable cause) {
/* 18 */     super(message, cause);
/*    */   }
/*    */   
/*    */   public ModuleException(Throwable cause) {
/* 22 */     super(cause);
/*    */   }
/*    */ }


/* Location:              E:\Games\Need For Madness\data\madapp.jar!\ds\nfm\ModuleException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */