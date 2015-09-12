package stagemaker;

/*    */ import java.applet.Applet;
/*    */ import java.awt.Color;
/*    */ import java.awt.Cursor;
/*    */ import java.awt.Event;
/*    */ import java.awt.Font;
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
/* 73 */     this.offImage = createImage(800, 300);
/* 74 */     if (this.offImage != null) this.rd = ((Graphics2D)this.offImage.getGraphics());
/* 75 */     this.rd.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
/*    */   }
/*    */   
/*    */   public boolean mouseMove(Event paramEvent, int paramInt1, int paramInt2)
/*    */   {
/* 80 */     this.xm = paramInt1;this.ym = paramInt2;
/* 81 */     return false;
/*    */   }
/*    */   
/*    */   public boolean mouseUp(Event paramEvent, int paramInt1, int paramInt2)
/*    */   {
/* 86 */     this.xm = paramInt1;this.ym = paramInt2;
/* 87 */     this.moused = true;
/* 88 */     return false;
/*    */   }
/*    */   
/* 91 */   public void start() { if (this.gamer == null) this.gamer = new Thread(this); this.gamer.start(); }
/* 92 */   public void stop() { if (this.gamer != null) this.gamer.stop(); this.gamer = null; }
/* 93 */   public void paint(Graphics paramGraphics) { paramGraphics.drawImage(this.offImage, 0, 0, this); }
/* 94 */   public void update(Graphics paramGraphics) { paint(paramGraphics); }
/*    */ }