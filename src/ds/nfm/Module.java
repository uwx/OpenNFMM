package ds.nfm;

import java.io.IOException;
import java.io.InputStream;

public abstract class Module {
   protected String name;
   protected boolean loaded = false;

   public String getName() {
      return this.name;
   }

   public boolean isLoaded() {
      return this.loaded;
   }

   public abstract void loadMod(InputStream var1) throws IOException;
}
