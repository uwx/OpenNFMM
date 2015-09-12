package stagemaker;

/*    */ import java.applet.Applet;
/*    */ import java.awt.Event;
/*    */ import java.awt.FontMetrics;
/*    */ import java.awt.Graphics;
/*    */ import java.awt.Graphics2D;
/*    */ import java.awt.Image;
/*    */ import java.awt.RenderingHints;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class update
/*    */   extends Applet
/*    */   implements Runnable
/*    */ {
/**
	 * 
	 */
	private static final long serialVersionUID = 1713950283760450017L;
/* 18 */   int xm = 0; int ym = 0;
/* 19 */   boolean moused = false;
/* 20 */   int scur = 0;
/*    */   Graphics2D rd;
/*    */   FontMetrics ftm;
/*    */   
/* 24 */   public void run() {
	
/*    */   }
/*    */   
/*    */   Image offImage;
/*    */   Thread gamer;
/*    */   public void init() {
/* 73 */     offImage = createImage(800, 300);
/* 74 */     if (offImage != null) rd = ((Graphics2D)offImage.getGraphics());
/* 75 */     rd.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
/*    */   }
/*    */   
/*    */   public boolean mouseMove(Event paramEvent, int paramInt1, int paramInt2)
/*    */   {
/* 80 */     xm = paramInt1;ym = paramInt2;
/* 81 */     return false;
/*    */   }
/*    */   
/*    */   public boolean mouseUp(Event paramEvent, int paramInt1, int paramInt2)
/*    */   {
/* 86 */     xm = paramInt1;ym = paramInt2;
/* 87 */     moused = true;
/* 88 */     return false;
/*    */   }
/*    */   
/* 91 */   public void start() { if (gamer == null) gamer = new Thread(this); gamer.start(); }
/* 92 */   public void stop() { if (gamer != null) gamer.stop(); gamer = null; }
/* 93 */   public void paint(Graphics paramGraphics) { paramGraphics.drawImage(offImage, 0, 0, this); }
/* 94 */   public update(Graphics paramGraphics) { paint(paramGraphics); }
/*    */ }