/*     */ package ds.nfm;
/*     */ 
/*     */ import ds.nfm.mod.Mod;
/*     */ import ds.nfm.mod.ModSlayer;
/*     */ import ds.nfm.xm.IBXMod;
/*     */ import ds.nfm.xm.IBXModSlayer;
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.DataInputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.IOException;
/*     */ import java.net.URL;
/*     */ import java.util.zip.ZipEntry;
/*     */ import java.util.zip.ZipInputStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ModuleLoader
/*     */ {
/*     */   public static Module loadMod(String paramString)
/*     */     throws FileNotFoundException, IOException
/*     */   {
/*  27 */     ZipInputStream localZipInputStream = new ZipInputStream(new FileInputStream(new File(paramString)));
/*  28 */     return loadMod(localZipInputStream);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Module loadMod(URL paramURL)
/*     */     throws IOException
/*     */   {
/*  38 */     ZipInputStream localZipInputStream = new ZipInputStream(new DataInputStream(paramURL.openStream()));
/*  39 */     return loadMod(localZipInputStream);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Module loadMod(byte[] paramArrayOfByte)
/*     */     throws IOException
/*     */   {
/*  49 */     ZipInputStream localZipInputStream = new ZipInputStream(new ByteArrayInputStream(paramArrayOfByte));
/*  50 */     return loadMod(localZipInputStream);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Module loadMod(ZipInputStream paramZipInputStream)
/*     */     throws IOException
/*     */   {
/*  60 */     Object localObject = null;
/*  61 */     ZipEntry localZipEntry = paramZipInputStream.getNextEntry();
/*  62 */     String str = localZipEntry.getName();
/*  63 */     int i = (int)localZipEntry.getSize();
/*     */     int k;
/*  65 */     byte[] arrayOfByte; if (i == -1) {
/*  66 */       ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
/*     */       
/*  68 */       while ((k = paramZipInputStream.read()) != -1) {
/*  69 */         localByteArrayOutputStream.write(k);
/*     */       }
/*  71 */       arrayOfByte = localByteArrayOutputStream.toByteArray();
/*     */     } else {
/*  73 */       arrayOfByte = new byte[i];
/*  74 */       int j = 0;
/*  76 */       for (; 
/*  76 */           i > 0; i -= k) {
/*  77 */         k = paramZipInputStream.read(arrayOfByte, j, i);
/*  78 */         j += k;
/*     */       }
/*     */     }
/*  81 */     paramZipInputStream.close();
/*     */     
/*  83 */     if ((str.toLowerCase().endsWith(".xm")) || (str.toLowerCase().endsWith(".s3m"))) localObject = new IBXMod(arrayOfByte); else localObject = new Mod(arrayOfByte);
/*  84 */     return (Module)localObject;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static ModuleSlayer prepareSlayer(Module paramModule, int paramInt1, int paramInt2, int paramInt3)
/*     */   {
/*  99 */     if ((paramModule instanceof Mod))
/* 100 */       return new ModSlayer((Mod)paramModule, paramInt1, paramInt2, paramInt3);
/* 101 */     if ((paramModule instanceof IBXMod)) {
/* 102 */       return new IBXModSlayer((IBXMod)paramModule, paramInt1, paramInt2, paramInt3);
/*     */     }
/* 104 */     throw new ModuleException("Unsuported module format: " + paramModule.getName());
/*     */   }
/*     */ }


/* Location:              E:\Games\Need For Madness\data\madapp.jar!\ds\nfm\ModuleLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */