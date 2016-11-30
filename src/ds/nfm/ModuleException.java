package ds.nfm;

public class ModuleException extends RuntimeException {
   /**
     * 
     */
    private static final long serialVersionUID = 2007674564336027625L;

    public ModuleException() {
   }

   public ModuleException(String message) {
      super(message);
   }

   public ModuleException(String message, Throwable cause) {
      super(message, cause);
   }

   public ModuleException(Throwable cause) {
      super(cause);
   }
}
