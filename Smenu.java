/* Smenu - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;

public class Smenu
{
    int sel = 0;
    String[] opts;
    String[] sopts;
    int no = 0;
    int x = 0;
    int y = 0;
    Font font = new Font("Arial", 1, 13);
    Color bcol = new Color(255, 255, 255);
    Color fcol = new Color(0, 0, 0);
    int w = 0;
    int h = 0;
    FontMetrics ftm;
    boolean show = false;
    boolean open = false;
    boolean dis = false;
    int maxl = 0;
    boolean rooms = false;
    int[] iroom;
    int kmoused = 0;
    boolean alphad = false;
    boolean revup = false;
    boolean carsel = false;
    boolean flksel = false;
    boolean om = false;
    boolean onsc = false;
    int scro = 0;
    int scra = 0;
    
    public Smenu(int i) {
	this.opts = new String[i];
	this.sopts = new String[i];
    }
    
    public void add(Graphics2D graphics2d, String string) {
	graphics2d.setFont(this.font);
	this.ftm = graphics2d.getFontMetrics();
	if ((!this.rooms || this.no == 0)
	    && this.ftm.stringWidth(string) + 30 > this.w)
	    this.w = this.ftm.stringWidth(string) + 30;
	if (this.rooms) {
	    this.iroom = new int[7];
	    for (int i = 0; i < 7; i++)
		this.iroom[i] = 0;
	}
	this.opts[this.no] = string;
	if (this.maxl != 0) {
	    int i;
	    for (i = string.length();
		 (this.ftm.stringWidth(string.substring(0, i)) + 30
		  > this.maxl);
		 i--) {
		/* empty */
	    }
	    if (i != string.length()) {
		string = string.substring(0, i - 3);
		string = new StringBuilder().append(string).append("...")
			     .toString();
	    }
	}
	this.sopts[this.no] = string;
	if (this.no < this.opts.length - 1)
	    this.no++;
    }
    
    public void addw(String string, String string_0_) {
	this.w = 300;
	this.opts[this.no] = string_0_;
	this.sopts[this.no] = string;
	if (this.no < this.opts.length - 1)
	    this.no++;
    }
    
    public void addstg(String string) {
	if (this.ftm.stringWidth(string) + 30 > this.w)
	    this.w = this.ftm.stringWidth(string) + 30;
	this.no++;
	if (this.no > 701)
	    this.no = 701;
	for (int i = this.no - 1; i > 1; i--) {
	    this.opts[i] = this.opts[i - 1];
	    this.sopts[i] = this.sopts[i - 1];
	}
	this.opts[1] = string;
	this.sopts[1] = string;
    }
    
    public void removeAll() {
	this.no = 0;
	this.w = 0;
	this.sel = 0;
    }
    
    public void select(int i) {
	if (i >= 0 && i < this.no)
	    this.sel = i;
    }
    
    public void select(String string) {
	for (int i = 0; i < this.no; i++) {
	    if (this.opts[i].equals(string)) {
		this.sel = i;
		break;
	    }
	}
    }
    
    public int getSelectedIndex() {
	return this.sel;
    }
    
    public String getSelectedItem() {
	return this.opts[this.sel];
    }
    
    public String getItem(int i) {
	String string = "";
	if (i >= 0 && i < this.no)
	    string = this.opts[i];
	return string;
    }
    
    public int getItemCount() {
	return this.no;
    }
    
    public void remove(String string) {
	for (int i = 0; i < this.no; i++) {
	    if (this.opts[i].equals(string)) {
		for (int i_1_ = i; i_1_ < this.no; i_1_++) {
		    if (i_1_ != this.no - 1) {
			this.opts[i_1_]
			    = this.opts[i_1_ + 1];
			this.sopts[i_1_]
			    = this.sopts[i_1_ + 1];
		    }
		}
		this.no--;
		break;
	    }
	}
    }
    
    public void setSize(int i, int i_2_) {
	this.w = i;
	this.h = i_2_;
    }
    
    public int getWidth() {
	return this.w;
    }
    
    public void setFont(Font font) {
	this.font = font;
    }
    
    public void setBackground(Color color) {
	this.bcol = color;
    }
    
    public void setForeground(Color color) {
	this.fcol = color;
    }
    
    public Color getBackground() {
	return this.bcol;
    }
    
    public Color getForeground() {
	return this.fcol;
    }
    
    public void hide() {
	this.show = false;
	this.open = false;
    }
    
    public void show() {
	this.show = true;
    }
    
    public boolean isShowing() {
	return this.show;
    }
    
    public void move(int i, int i_3_) {
	this.x = i;
	this.y = i_3_;
    }
    
    public boolean hasFocus() {
	return false;
    }
    
    public void disable() {
	this.dis = true;
    }
    
    public void enable() {
	this.dis = false;
    }
    
    public boolean isEnabled() {
	return !this.dis;
    }
    
    public boolean draw(Graphics2D graphics2d, int i, int i_4_, boolean bool,
			int i_5_, boolean bool_6_) {
	boolean bool_7_ = false;
	if (this.revup) {
	    if (bool_6_)
		bool_6_ = false;
	    else
		bool_6_ = true;
	    this.revup = false;
	}
	if (this.show) {
	    if (this.alphad)
		graphics2d.setComposite(AlphaComposite.getInstance(3, 0.7F));
	    boolean bool_8_ = false;
	    if (bool) {
		if (!this.om) {
		    this.om = true;
		    bool_8_ = true;
		}
	    } else if (this.om)
		this.om = false;
	    boolean bool_9_ = false;
	    if ((this.bcol.getRed() + this.bcol.getGreen()
		 + this.bcol.getBlue()) / 3
		> (this.fcol.getRed()
		   + this.fcol.getGreen()
		   + this.fcol.getBlue()) / 3)
		bool_9_ = true;
	    boolean bool_10_ = false;
	    if (i > this.x && i < this.x + this.w
		&& i_4_ > this.y + 1 && i_4_ < this.y + 22
		&& !this.open && !this.dis)
		bool_10_ = true;
	    if (!this.open && bool_10_ && bool_8_
		&& !this.dis) {
		this.open = true;
		bool_8_ = false;
	    }
	    graphics2d.setFont(this.font);
	    this.ftm = graphics2d.getFontMetrics();
	    if (this.open) {
		int i_11_ = 4 + ((this.ftm.getHeight() + 2)
				 * this.no);
		if (!bool_6_) {
		    int i_12_ = 0;
		    graphics2d.setColor(this.bcol);
		    graphics2d.fillRect(this.x,
					this.y + 23,
					this.w, i_11_);
		    graphics2d.setColor
			(new Color((this.fcol.getRed()
				    + this.bcol.getRed()) / 2,
				   (this.fcol.getGreen()
				    + this.bcol.getGreen()) / 2,
				   (this.fcol.getBlue()
				    + this.bcol.getBlue()) / 2));
		    graphics2d.drawRect(this.x,
					this.y + 23,
					this.w, i_11_);
		    if (this.y + 23 + i_11_ > i_5_) {
			graphics2d.drawLine((this.x
					     + this.w - 18),
					    this.y + 17,
					    (this.x
					     + this.w - 18),
					    i_5_);
			if (bool_9_)
			    graphics2d.setColor
				(new Color((this.bcol.getRed()
					    + 510) / 3,
					   (this.bcol.getGreen()
					    + 510) / 3,
					   (this.bcol.getBlue()
					    + 510) / 3));
			else
			    graphics2d.setColor
				(new Color((this.fcol.getRed()
					    + 510) / 3,
					   (this.fcol.getGreen()
					    + 510) / 3,
					   (this.fcol.getBlue()
					    + 510) / 3));
			graphics2d.fillRect((this.x
					     + this.w - 15),
					    (this.y + 25
					     + this.scra),
					    13, 30);
			graphics2d.setColor(this.fcol);
			graphics2d.drawRect((this.x
					     + this.w - 15),
					    (this.y + 25
					     + this.scra),
					    12, 30);
			graphics2d.setColor(new Color(0, 0, 0));
			graphics2d.drawLine
			    (this.x + this.w - 12,
			     this.y + 9 + 29 + this.scra,
			     this.x + this.w - 12,
			     this.y + 10 + 29 + this.scra);
			graphics2d.drawLine
			    (this.x + this.w - 11,
			     this.y + 10 + 29 + this.scra,
			     this.x + this.w - 11,
			     this.y + 11 + 29 + this.scra);
			graphics2d.drawLine
			    (this.x + this.w - 10,
			     this.y + 11 + 29 + this.scra,
			     this.x + this.w - 10,
			     this.y + 12 + 29 + this.scra);
			graphics2d.drawLine
			    (this.x + this.w - 9,
			     this.y + 12 + 29 + this.scra,
			     this.x + this.w - 9,
			     this.y + 13 + 29 + this.scra);
			graphics2d.drawLine
			    (this.x + this.w - 8,
			     this.y + 11 + 29 + this.scra,
			     this.x + this.w - 8,
			     this.y + 12 + 29 + this.scra);
			graphics2d.drawLine
			    (this.x + this.w - 7,
			     this.y + 10 + 29 + this.scra,
			     this.x + this.w - 7,
			     this.y + 11 + 29 + this.scra);
			graphics2d.drawLine
			    (this.x + this.w - 6,
			     this.y + 9 + 29 + this.scra,
			     this.x + this.w - 6,
			     this.y + 10 + 29 + this.scra);
			i_12_ = -18;
			if (bool) {
			    if (i > this.x + this.w - 18
				&& i < this.x + this.w
				&& i_4_ > this.y + 25
				&& i_4_ < i_5_) {
				bool_8_ = false;
				this.onsc = true;
			    }
			} else if (this.onsc)
			    this.onsc = false;
			if (this.onsc) {
			    this.scra
				= i_4_ - (this.y + 25) - 15;
			    if (this.scra < 0)
				this.scra = 0;
			    int i_13_ = i_5_ - (this.y + 25) - 33;
			    if (this.scra > i_13_)
				this.scra = i_13_;
			    int i_14_
				= ((this.no
				    * (this.ftm.getHeight() + 2))
				   - i_13_
				   - this.ftm.getHeight() / 2);
			    this.scro
				= -(int) ((float) this.scra
					  * ((float) i_14_ / (float) i_13_));
			}
		    }
		    for (int i_15_ = 0; i_15_ < this.no; i_15_++) {
			if (Math.abs(this.scro)
			    < (i_15_ + 1) * (this.ftm.getHeight()
					     + 2)) {
			    graphics2d.setColor(this.fcol);
			    if (i > this.x
				&& i < this.x + this.w
				&& i_4_ > (this.y + 25
					   + this.scro
					   + (i_15_
					      * (this.ftm.getHeight()
						 + 2)))
				&& i_4_ < (this.y + 25
					   + this.scro
					   + ((i_15_ + 1)
					      * (this.ftm.getHeight()
						 + 2)))) {
				if (bool_9_)
				    graphics2d.setColor
					(new Color
					 ((this.fcol.getRed()
					   + this.bcol.getRed()) / 2,
					  ((this.fcol.getGreen()
					    + this.bcol.getGreen())
					   / 2),
					  ((this.fcol.getBlue()
					    + this.bcol.getBlue())
					   / 2)));
				else
				    graphics2d.setColor(this.fcol);
				graphics2d.fillRect
				    (this.x + 1,
				     (this.y + 25
				      + this.scro
				      + i_15_ * (this.ftm.getHeight()
						 + 2)),
				     this.w - 1 + i_12_,
				     this.ftm.getHeight() + 2);
				graphics2d.setColor(this.bcol);
				if (bool_8_) {
				    if (!this.rooms
					|| !this.opts[i_15_]
						.equals("full")) {
					this.sel = i_15_;
					if (this.rooms && i_15_ != 0)
					    this.sopts[i_15_] = " ";
				    } else
					this.kmoused = 20;
				    this.open = false;
				}
			    }
			    if (this.rooms
				&& this.sopts[i_15_]
				       .indexOf("10 / 10") != -1)
				graphics2d.setColor(new Color(255, 0, 0));
			    graphics2d.drawString(this.sopts[i_15_],
						  this.x + 4,
						  (this.y + 38
						   + this.scro
						   + i_15_ * (this
								  .ftm
								  .getHeight()
							      + 2)));
			}
		    }
		    if (i_12_ != 0) {
			graphics2d.setColor
			    (new Color((this.fcol.getRed()
					+ this.bcol.getRed()) / 2,
				       (this.fcol.getGreen()
					+ this.bcol.getGreen()) / 2,
				       (this.fcol.getBlue()
					+ this.bcol.getBlue()) / 2));
			graphics2d.drawLine(this.x, i_5_ - 1,
					    (this.x
					     + this.w),
					    i_5_ - 1);
		    }
		} else {
		    int i_16_ = 0;
		    graphics2d.setColor(this.bcol);
		    graphics2d.fillRect(this.x,
					this.y - i_11_,
					this.w, i_11_);
		    graphics2d.setColor
			(new Color((this.fcol.getRed()
				    + this.bcol.getRed()) / 2,
				   (this.fcol.getGreen()
				    + this.bcol.getGreen()) / 2,
				   (this.fcol.getBlue()
				    + this.bcol.getBlue()) / 2));
		    graphics2d.drawRect(this.x,
					this.y - i_11_,
					this.w, i_11_);
		    if (this.y - i_11_ < 0) {
			graphics2d.drawLine((this.x
					     + this.w - 18),
					    0,
					    (this.x
					     + this.w - 18),
					    this.y);
			if (bool_9_)
			    graphics2d.setColor
				(new Color((this.bcol.getRed()
					    + 510) / 3,
					   (this.bcol.getGreen()
					    + 510) / 3,
					   (this.bcol.getBlue()
					    + 510) / 3));
			else
			    graphics2d.setColor
				(new Color((this.fcol.getRed()
					    + 510) / 3,
					   (this.fcol.getGreen()
					    + 510) / 3,
					   (this.fcol.getBlue()
					    + 510) / 3));
			graphics2d.fillRect((this.x
					     + this.w - 15),
					    (this.y
					     - this.scra - 33),
					    13, 30);
			graphics2d.setColor(this.fcol);
			graphics2d.drawRect((this.x
					     + this.w - 15),
					    (this.y
					     - this.scra - 33),
					    12, 30);
			graphics2d.setColor(new Color(0, 0, 0));
			graphics2d.drawLine
			    (this.x + this.w - 12,
			     this.y + 13 - 29 - this.scra,
			     this.x + this.w - 12,
			     this.y + 12 - 29 - this.scra);
			graphics2d.drawLine
			    (this.x + this.w - 11,
			     this.y + 12 - 29 - this.scra,
			     this.x + this.w - 11,
			     this.y + 11 - 29 - this.scra);
			graphics2d.drawLine
			    (this.x + this.w - 10,
			     this.y + 11 - 29 - this.scra,
			     this.x + this.w - 10,
			     this.y + 10 - 29 - this.scra);
			graphics2d.drawLine
			    (this.x + this.w - 9,
			     this.y + 10 - 29 - this.scra,
			     this.x + this.w - 9,
			     this.y + 9 - 29 - this.scra);
			graphics2d.drawLine
			    (this.x + this.w - 8,
			     this.y + 11 - 29 - this.scra,
			     this.x + this.w - 8,
			     this.y + 10 - 29 - this.scra);
			graphics2d.drawLine
			    (this.x + this.w - 7,
			     this.y + 12 - 29 - this.scra,
			     this.x + this.w - 7,
			     this.y + 11 - 29 - this.scra);
			graphics2d.drawLine
			    (this.x + this.w - 6,
			     this.y + 13 - 29 - this.scra,
			     this.x + this.w - 6,
			     this.y + 12 - 29 - this.scra);
			i_16_ = -18;
			if (bool) {
			    if (i > this.x + this.w - 18
				&& i < this.x + this.w
				&& i_4_ > 0 && i_4_ < this.y - 3) {
				bool_8_ = false;
				this.onsc = true;
			    }
			} else if (this.onsc)
			    this.onsc = false;
			if (this.onsc) {
			    this.scra
				= this.y - 3 - 15 - i_4_;
			    if (this.scra < 0)
				this.scra = 0;
			    int i_17_ = this.y - 35;
			    if (this.scra > i_17_)
				this.scra = i_17_;
			    int i_18_
				= ((this.no
				    * (this.ftm.getHeight() + 2))
				   - i_17_
				   - this.ftm.getHeight() / 2);
			    this.scro
				= (int) ((float) this.scra
					 * ((float) i_18_ / (float) i_17_));
			}
		    }
		    for (int i_19_ = 0; i_19_ < this.no; i_19_++) {
			if (Math.abs(this.scro)
			    < (i_19_ + 1) * (this.ftm.getHeight()
					     + 2)) {
			    graphics2d.setColor(this.fcol);
			    if (i > this.x
				&& i < this.x + this.w
				&& i_4_ < (this.y - 18
					   + this.scro
					   - ((i_19_ - 1)
					      * (this.ftm.getHeight()
						 + 2)))
				&& i_4_ > (this.y - 18
					   + this.scro
					   - (i_19_
					      * (this.ftm.getHeight()
						 + 2)))) {
				if (bool_9_)
				    graphics2d.setColor
					(new Color
					 ((this.fcol.getRed()
					   + this.bcol.getRed()) / 2,
					  ((this.fcol.getGreen()
					    + this.bcol.getGreen())
					   / 2),
					  ((this.fcol.getBlue()
					    + this.bcol.getBlue())
					   / 2)));
				else
				    graphics2d.setColor(this.fcol);
				graphics2d.fillRect
				    (this.x + 1,
				     (this.y - 18
				      + this.scro
				      - i_19_ * (this.ftm.getHeight()
						 + 2)),
				     this.w - 1 + i_16_,
				     this.ftm.getHeight() + 2);
				graphics2d.setColor(this.bcol);
				if (bool_8_) {
				    this.sel = i_19_;
				    this.open = false;
				}
			    }
			    graphics2d.drawString(this.sopts[i_19_],
						  this.x + 4,
						  (this.y - 5
						   + this.scro
						   - i_19_ * (this
								  .ftm
								  .getHeight()
							      + 2)));
			}
		    }
		    if (i_16_ != 0) {
			graphics2d.setColor
			    (new Color((this.fcol.getRed()
					+ this.bcol.getRed()) / 2,
				       (this.fcol.getGreen()
					+ this.bcol.getGreen()) / 2,
				       (this.fcol.getBlue()
					+ this.bcol.getBlue()) / 2));
			graphics2d.drawLine(this.x, 0,
					    (this.x
					     + this.w),
					    0);
		    }
		}
		bool_7_ = true;
		if (bool_8_)
		    this.open = false;
	    } else {
		if (this.scro != 0)
		    this.scro = 0;
		if (this.scra != 0)
		    this.scra = 0;
	    }
	    if (bool_10_) {
		if (bool_9_)
		    graphics2d.setColor
			(new Color((this.fcol.getRed()
				    + this.bcol.getRed()) / 2,
				   (this.fcol.getGreen()
				    + this.bcol.getGreen()) / 2,
				   (this.fcol.getBlue()
				    + this.bcol.getBlue()) / 2));
		else
		    graphics2d.setColor(this.fcol);
	    } else
		graphics2d.setColor(this.bcol);
	    graphics2d.fillRect(this.x, this.y + 1,
				this.w, 21);
	    graphics2d.setColor(new Color((this.fcol.getRed()
					   + this.bcol.getRed()) / 2,
					  ((this.fcol.getGreen()
					    + this.bcol.getGreen())
					   / 2),
					  ((this.fcol.getBlue()
					    + this.bcol.getBlue())
					   / 2)));
	    graphics2d.drawRect(this.x, this.y + 1,
				this.w, 21);
	    if (bool_9_)
		graphics2d.setColor
		    (new Color((this.bcol.getRed() + 255) / 2,
			       (this.bcol.getGreen() + 255) / 2,
			       (this.bcol.getBlue() + 255) / 2));
	    else
		graphics2d.setColor
		    (new Color((this.fcol.getRed() + 255) / 2,
			       (this.fcol.getGreen() + 255) / 2,
			       (this.fcol.getBlue() + 255) / 2));
	    graphics2d.drawRect(this.x + 1, this.y + 2,
				this.w - 2, 19);
	    graphics2d.drawLine(this.x + this.w - 17,
				this.y + 3,
				this.x + this.w - 17,
				this.y + 20);
	    graphics2d.setColor(this.fcol);
	    if (this.dis)
		graphics2d.setColor
		    (new Color((this.fcol.getRed()
				+ this.bcol.getRed() * 2) / 3,
			       (this.fcol.getGreen()
				+ this.bcol.getGreen() * 2) / 3,
			       (this.fcol.getBlue()
				+ this.bcol.getBlue() * 2) / 3));
	    graphics2d.drawRect(this.x + this.w - 16,
				this.y + 3, 14, 17);
	    if (bool_9_)
		graphics2d.setColor
		    (new Color((this.bcol.getRed() + 510) / 3,
			       (this.bcol.getGreen() + 510) / 3,
			       (this.bcol.getBlue() + 510) / 3));
	    else
		graphics2d.setColor
		    (new Color((this.fcol.getRed() + 510) / 3,
			       (this.fcol.getGreen() + 510) / 3,
			       (this.fcol.getBlue() + 510) / 3));
	    graphics2d.fillRect(this.x + this.w - 15,
				this.y + 4, 13, 16);
	    graphics2d.setColor(new Color(0, 0, 0));
	    if (this.dis)
		graphics2d.setColor
		    (new Color((this.fcol.getRed()
				+ this.bcol.getRed() * 2) / 3,
			       (this.fcol.getGreen()
				+ this.bcol.getGreen() * 2) / 3,
			       (this.fcol.getBlue()
				+ this.bcol.getBlue() * 2) / 3));
	    graphics2d.drawLine(this.x + this.w - 12,
				this.y + 9,
				this.x + this.w - 12,
				this.y + 10);
	    graphics2d.drawLine(this.x + this.w - 11,
				this.y + 10,
				this.x + this.w - 11,
				this.y + 11);
	    graphics2d.drawLine(this.x + this.w - 10,
				this.y + 11,
				this.x + this.w - 10,
				this.y + 12);
	    graphics2d.drawLine(this.x + this.w - 9,
				this.y + 12,
				this.x + this.w - 9,
				this.y + 13);
	    graphics2d.drawLine(this.x + this.w - 8,
				this.y + 11,
				this.x + this.w - 8,
				this.y + 12);
	    graphics2d.drawLine(this.x + this.w - 7,
				this.y + 10,
				this.x + this.w - 7,
				this.y + 11);
	    graphics2d.drawLine(this.x + this.w - 6,
				this.y + 9,
				this.x + this.w - 6,
				this.y + 10);
	    if (bool_10_)
		graphics2d.setColor(this.bcol);
	    else
		graphics2d.setColor(this.fcol);
	    if (this.dis)
		graphics2d.setColor
		    (new Color((this.fcol.getRed()
				+ this.bcol.getRed() * 2) / 3,
			       (this.fcol.getGreen()
				+ this.bcol.getGreen() * 2) / 3,
			       (this.fcol.getBlue()
				+ this.bcol.getBlue() * 2) / 3));
	    if (this.carsel && !bool_10_) {
		if (this.flksel) {
		    graphics2d.setColor(new Color(240, 240, 240));
		    this.flksel = false;
		} else
		    this.flksel = true;
	    }
	    graphics2d.drawString(this.sopts[this.sel],
				  this.x + 4,
				  (this.y
				   + (this.ftm.getHeight() + 2)));
	    if (this.alphad)
		graphics2d.setComposite(AlphaComposite.getInstance(3, 1.0F));
	} else {
	    if (this.scro != 0)
		this.scro = 0;
	    if (this.scra != 0)
		this.scra = 0;
	}
	return bool_7_;
    }
}
