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
	opts = new String[i];
	sopts = new String[i];
    }
    
    public void add(Graphics2D graphics2d, String string) {
	graphics2d.setFont(font);
	ftm = graphics2d.getFontMetrics();
	if ((!rooms || no == 0)
	    && ftm.stringWidth(string) + 30 > w)
	    w = ftm.stringWidth(string) + 30;
	if (rooms) {
	    iroom = new int[7];
	    for (int i = 0; i < 7; i++)
		iroom[i] = 0;
	}
	opts[no] = string;
	if (maxl != 0) {
	    int i;
	    for (i = string.length();
		 (ftm.stringWidth(string.substring(0, i)) + 30
		  > maxl);
		 i--) {
		/* empty */
	    }
	    if (i != string.length()) {
		string = string.substring(0, i - 3);
		string = new StringBuilder().append(string).append("...")
			     .toString();
	    }
	}
	sopts[no] = string;
	if (no < opts.length - 1)
	    no++;
    }
    
    public void addw(String string, String string_0_) {
	w = 300;
	opts[no] = string_0_;
	sopts[no] = string;
	if (no < opts.length - 1)
	    no++;
    }
    
    public void addstg(String string) {
	if (ftm.stringWidth(string) + 30 > w)
	    w = ftm.stringWidth(string) + 30;
	no++;
	if (no > 701)
	    no = 701;
	for (int i = no - 1; i > 1; i--) {
	    opts[i] = opts[i - 1];
	    sopts[i] = sopts[i - 1];
	}
	opts[1] = string;
	sopts[1] = string;
    }
    
    public void removeAll() {
	no = 0;
	w = 0;
	sel = 0;
    }
    
    public void select(int i) {
	if (i >= 0 && i < no)
	    sel = i;
    }
    
    public void select(String string) {
	for (int i = 0; i < no; i++) {
	    if (opts[i].equals(string)) {
		sel = i;
		break;
	    }
	}
    }
    
    public int getSelectedIndex() {
	return sel;
    }
    
    public String getSelectedItem() {
	return opts[sel];
    }
    
    public String getItem(int i) {
	String string = "";
	if (i >= 0 && i < no)
	    string = opts[i];
	return string;
    }
    
    public int getItemCount() {
	return no;
    }
    
    public void remove(String string) {
	for (int i = 0; i < no; i++) {
	    if (opts[i].equals(string)) {
		for (int i_1_ = i; i_1_ < no; i_1_++) {
		    if (i_1_ != no - 1) {
			opts[i_1_]
			    = opts[i_1_ + 1];
			sopts[i_1_]
			    = sopts[i_1_ + 1];
		    }
		}
		no--;
		break;
	    }
	}
    }
    
    public void setSize(int i, int i_2_) {
	w = i;
	h = i_2_;
    }
    
    public int getWidth() {
	return w;
    }
    
    public void setFont(Font font) {
	//font = font;
    }
    
    public void setBackground(Color color) {
	bcol = color;
    }
    
    public void setForeground(Color color) {
	fcol = color;
    }
    
    public Color getBackground() {
	return bcol;
    }
    
    public Color getForeground() {
	return fcol;
    }
    
    public void hide() {
	show = false;
	open = false;
    }
    
    public void show() {
	show = true;
    }
    
    public boolean isShowing() {
	return show;
    }
    
    public void move(int i, int i_3_) {
	x = i;
	y = i_3_;
    }
    
    public boolean hasFocus() {
	return false;
    }
    
    public void disable() {
	dis = true;
    }
    
    public void enable() {
	dis = false;
    }
    
    public boolean isEnabled() {
	return !dis;
    }
    
    public boolean draw(Graphics2D graphics2d, int i, int i_4_, boolean bool,
			int i_5_, boolean bool_6_) {
	boolean bool_7_ = false;
	if (revup) {
	    if (bool_6_)
		bool_6_ = false;
	    else
		bool_6_ = true;
	    revup = false;
	}
	if (show) {
	    if (alphad)
		graphics2d.setComposite(AlphaComposite.getInstance(3, 0.7F));
	    boolean bool_8_ = false;
	    if (bool) {
		if (!om) {
		    om = true;
		    bool_8_ = true;
		}
	    } else if (om)
		om = false;
	    boolean bool_9_ = false;
	    if ((bcol.getRed() + bcol.getGreen()
		 + bcol.getBlue()) / 3
		> (fcol.getRed()
		   + fcol.getGreen()
		   + fcol.getBlue()) / 3)
		bool_9_ = true;
	    boolean bool_10_ = false;
	    if (i > x && i < x + w
		&& i_4_ > y + 1 && i_4_ < y + 22
		&& !open && !dis)
		bool_10_ = true;
	    if (!open && bool_10_ && bool_8_
		&& !dis) {
		open = true;
		bool_8_ = false;
	    }
	    graphics2d.setFont(font);
	    ftm = graphics2d.getFontMetrics();
	    if (open) {
		int i_11_ = 4 + ((ftm.getHeight() + 2)
				 * no);
		if (!bool_6_) {
		    int i_12_ = 0;
		    graphics2d.setColor(bcol);
		    graphics2d.fillRect(x,
					y + 23,
					w, i_11_);
		    graphics2d.setColor
			(new Color((fcol.getRed()
				    + bcol.getRed()) / 2,
				   (fcol.getGreen()
				    + bcol.getGreen()) / 2,
				   (fcol.getBlue()
				    + bcol.getBlue()) / 2));
		    graphics2d.drawRect(x,
					y + 23,
					w, i_11_);
		    if (y + 23 + i_11_ > i_5_) {
			graphics2d.drawLine((x
					     + w - 18),
					    y + 17,
					    (x
					     + w - 18),
					    i_5_);
			if (bool_9_)
			    graphics2d.setColor
				(new Color((bcol.getRed()
					    + 510) / 3,
					   (bcol.getGreen()
					    + 510) / 3,
					   (bcol.getBlue()
					    + 510) / 3));
			else
			    graphics2d.setColor
				(new Color((fcol.getRed()
					    + 510) / 3,
					   (fcol.getGreen()
					    + 510) / 3,
					   (fcol.getBlue()
					    + 510) / 3));
			graphics2d.fillRect((x
					     + w - 15),
					    (y + 25
					     + scra),
					    13, 30);
			graphics2d.setColor(fcol);
			graphics2d.drawRect((x
					     + w - 15),
					    (y + 25
					     + scra),
					    12, 30);
			graphics2d.setColor(new Color(0, 0, 0));
			graphics2d.drawLine
			    (x + w - 12,
			     y + 9 + 29 + scra,
			     x + w - 12,
			     y + 10 + 29 + scra);
			graphics2d.drawLine
			    (x + w - 11,
			     y + 10 + 29 + scra,
			     x + w - 11,
			     y + 11 + 29 + scra);
			graphics2d.drawLine
			    (x + w - 10,
			     y + 11 + 29 + scra,
			     x + w - 10,
			     y + 12 + 29 + scra);
			graphics2d.drawLine
			    (x + w - 9,
			     y + 12 + 29 + scra,
			     x + w - 9,
			     y + 13 + 29 + scra);
			graphics2d.drawLine
			    (x + w - 8,
			     y + 11 + 29 + scra,
			     x + w - 8,
			     y + 12 + 29 + scra);
			graphics2d.drawLine
			    (x + w - 7,
			     y + 10 + 29 + scra,
			     x + w - 7,
			     y + 11 + 29 + scra);
			graphics2d.drawLine
			    (x + w - 6,
			     y + 9 + 29 + scra,
			     x + w - 6,
			     y + 10 + 29 + scra);
			i_12_ = -18;
			if (bool) {
			    if (i > x + w - 18
				&& i < x + w
				&& i_4_ > y + 25
				&& i_4_ < i_5_) {
				bool_8_ = false;
				onsc = true;
			    }
			} else if (onsc)
			    onsc = false;
			if (onsc) {
			    scra
				= i_4_ - (y + 25) - 15;
			    if (scra < 0)
				scra = 0;
			    int i_13_ = i_5_ - (y + 25) - 33;
			    if (scra > i_13_)
				scra = i_13_;
			    int i_14_
				= ((no
				    * (ftm.getHeight() + 2))
				   - i_13_
				   - ftm.getHeight() / 2);
			    scro
				= -(int) ((float) scra
					  * ((float) i_14_ / (float) i_13_));
			}
		    }
		    for (int i_15_ = 0; i_15_ < no; i_15_++) {
			if (Math.abs(scro)
			    < (i_15_ + 1) * (ftm.getHeight()
					     + 2)) {
			    graphics2d.setColor(fcol);
			    if (i > x
				&& i < x + w
				&& i_4_ > (y + 25
					   + scro
					   + (i_15_
					      * (ftm.getHeight()
						 + 2)))
				&& i_4_ < (y + 25
					   + scro
					   + ((i_15_ + 1)
					      * (ftm.getHeight()
						 + 2)))) {
				if (bool_9_)
				    graphics2d.setColor
					(new Color
					 ((fcol.getRed()
					   + bcol.getRed()) / 2,
					  ((fcol.getGreen()
					    + bcol.getGreen())
					   / 2),
					  ((fcol.getBlue()
					    + bcol.getBlue())
					   / 2)));
				else
				    graphics2d.setColor(fcol);
				graphics2d.fillRect
				    (x + 1,
				     (y + 25
				      + scro
				      + i_15_ * (ftm.getHeight()
						 + 2)),
				     w - 1 + i_12_,
				     ftm.getHeight() + 2);
				graphics2d.setColor(bcol);
				if (bool_8_) {
				    if (!rooms
					|| !opts[i_15_]
						.equals("full")) {
					sel = i_15_;
					if (rooms && i_15_ != 0)
					    sopts[i_15_] = " ";
				    } else
					kmoused = 20;
				    open = false;
				}
			    }
			    if (rooms
				&& sopts[i_15_]
				       .indexOf("10 / 10") != -1)
				graphics2d.setColor(new Color(255, 0, 0));
			    graphics2d.drawString(sopts[i_15_],
						  x + 4,
						  (y + 38
						   + scro
						   + i_15_ * (this
								  .ftm
								  .getHeight()
							      + 2)));
			}
		    }
		    if (i_12_ != 0) {
			graphics2d.setColor
			    (new Color((fcol.getRed()
					+ bcol.getRed()) / 2,
				       (fcol.getGreen()
					+ bcol.getGreen()) / 2,
				       (fcol.getBlue()
					+ bcol.getBlue()) / 2));
			graphics2d.drawLine(x, i_5_ - 1,
					    (x
					     + w),
					    i_5_ - 1);
		    }
		} else {
		    int i_16_ = 0;
		    graphics2d.setColor(bcol);
		    graphics2d.fillRect(x,
					y - i_11_,
					w, i_11_);
		    graphics2d.setColor
			(new Color((fcol.getRed()
				    + bcol.getRed()) / 2,
				   (fcol.getGreen()
				    + bcol.getGreen()) / 2,
				   (fcol.getBlue()
				    + bcol.getBlue()) / 2));
		    graphics2d.drawRect(x,
					y - i_11_,
					w, i_11_);
		    if (y - i_11_ < 0) {
			graphics2d.drawLine((x
					     + w - 18),
					    0,
					    (x
					     + w - 18),
					    y);
			if (bool_9_)
			    graphics2d.setColor
				(new Color((bcol.getRed()
					    + 510) / 3,
					   (bcol.getGreen()
					    + 510) / 3,
					   (bcol.getBlue()
					    + 510) / 3));
			else
			    graphics2d.setColor
				(new Color((fcol.getRed()
					    + 510) / 3,
					   (fcol.getGreen()
					    + 510) / 3,
					   (fcol.getBlue()
					    + 510) / 3));
			graphics2d.fillRect((x
					     + w - 15),
					    (y
					     - scra - 33),
					    13, 30);
			graphics2d.setColor(fcol);
			graphics2d.drawRect((x
					     + w - 15),
					    (y
					     - scra - 33),
					    12, 30);
			graphics2d.setColor(new Color(0, 0, 0));
			graphics2d.drawLine
			    (x + w - 12,
			     y + 13 - 29 - scra,
			     x + w - 12,
			     y + 12 - 29 - scra);
			graphics2d.drawLine
			    (x + w - 11,
			     y + 12 - 29 - scra,
			     x + w - 11,
			     y + 11 - 29 - scra);
			graphics2d.drawLine
			    (x + w - 10,
			     y + 11 - 29 - scra,
			     x + w - 10,
			     y + 10 - 29 - scra);
			graphics2d.drawLine
			    (x + w - 9,
			     y + 10 - 29 - scra,
			     x + w - 9,
			     y + 9 - 29 - scra);
			graphics2d.drawLine
			    (x + w - 8,
			     y + 11 - 29 - scra,
			     x + w - 8,
			     y + 10 - 29 - scra);
			graphics2d.drawLine
			    (x + w - 7,
			     y + 12 - 29 - scra,
			     x + w - 7,
			     y + 11 - 29 - scra);
			graphics2d.drawLine
			    (x + w - 6,
			     y + 13 - 29 - scra,
			     x + w - 6,
			     y + 12 - 29 - scra);
			i_16_ = -18;
			if (bool) {
			    if (i > x + w - 18
				&& i < x + w
				&& i_4_ > 0 && i_4_ < y - 3) {
				bool_8_ = false;
				onsc = true;
			    }
			} else if (onsc)
			    onsc = false;
			if (onsc) {
			    scra
				= y - 3 - 15 - i_4_;
			    if (scra < 0)
				scra = 0;
			    int i_17_ = y - 35;
			    if (scra > i_17_)
				scra = i_17_;
			    int i_18_
				= ((no
				    * (ftm.getHeight() + 2))
				   - i_17_
				   - ftm.getHeight() / 2);
			    scro
				= (int) ((float) scra
					 * ((float) i_18_ / (float) i_17_));
			}
		    }
		    for (int i_19_ = 0; i_19_ < no; i_19_++) {
			if (Math.abs(scro)
			    < (i_19_ + 1) * (ftm.getHeight()
					     + 2)) {
			    graphics2d.setColor(fcol);
			    if (i > x
				&& i < x + w
				&& i_4_ < (y - 18
					   + scro
					   - ((i_19_ - 1)
					      * (ftm.getHeight()
						 + 2)))
				&& i_4_ > (y - 18
					   + scro
					   - (i_19_
					      * (ftm.getHeight()
						 + 2)))) {
				if (bool_9_)
				    graphics2d.setColor
					(new Color
					 ((fcol.getRed()
					   + bcol.getRed()) / 2,
					  ((fcol.getGreen()
					    + bcol.getGreen())
					   / 2),
					  ((fcol.getBlue()
					    + bcol.getBlue())
					   / 2)));
				else
				    graphics2d.setColor(fcol);
				graphics2d.fillRect
				    (x + 1,
				     (y - 18
				      + scro
				      - i_19_ * (ftm.getHeight()
						 + 2)),
				     w - 1 + i_16_,
				     ftm.getHeight() + 2);
				graphics2d.setColor(bcol);
				if (bool_8_) {
				    sel = i_19_;
				    open = false;
				}
			    }
			    graphics2d.drawString(sopts[i_19_],
						  x + 4,
						  (y - 5
						   + scro
						   - i_19_ * (this
								  .ftm
								  .getHeight()
							      + 2)));
			}
		    }
		    if (i_16_ != 0) {
			graphics2d.setColor
			    (new Color((fcol.getRed()
					+ bcol.getRed()) / 2,
				       (fcol.getGreen()
					+ bcol.getGreen()) / 2,
				       (fcol.getBlue()
					+ bcol.getBlue()) / 2));
			graphics2d.drawLine(x, 0,
					    (x
					     + w),
					    0);
		    }
		}
		bool_7_ = true;
		if (bool_8_)
		    open = false;
	    } else {
		if (scro != 0)
		    scro = 0;
		if (scra != 0)
		    scra = 0;
	    }
	    if (bool_10_) {
		if (bool_9_)
		    graphics2d.setColor
			(new Color((fcol.getRed()
				    + bcol.getRed()) / 2,
				   (fcol.getGreen()
				    + bcol.getGreen()) / 2,
				   (fcol.getBlue()
				    + bcol.getBlue()) / 2));
		else
		    graphics2d.setColor(fcol);
	    } else
		graphics2d.setColor(bcol);
	    graphics2d.fillRect(x, y + 1,
				w, 21);
	    graphics2d.setColor(new Color((fcol.getRed()
					   + bcol.getRed()) / 2,
					  ((fcol.getGreen()
					    + bcol.getGreen())
					   / 2),
					  ((fcol.getBlue()
					    + bcol.getBlue())
					   / 2)));
	    graphics2d.drawRect(x, y + 1,
				w, 21);
	    if (bool_9_)
		graphics2d.setColor
		    (new Color((bcol.getRed() + 255) / 2,
			       (bcol.getGreen() + 255) / 2,
			       (bcol.getBlue() + 255) / 2));
	    else
		graphics2d.setColor
		    (new Color((fcol.getRed() + 255) / 2,
			       (fcol.getGreen() + 255) / 2,
			       (fcol.getBlue() + 255) / 2));
	    graphics2d.drawRect(x + 1, y + 2,
				w - 2, 19);
	    graphics2d.drawLine(x + w - 17,
				y + 3,
				x + w - 17,
				y + 20);
	    graphics2d.setColor(fcol);
	    if (dis)
		graphics2d.setColor
		    (new Color((fcol.getRed()
				+ bcol.getRed() * 2) / 3,
			       (fcol.getGreen()
				+ bcol.getGreen() * 2) / 3,
			       (fcol.getBlue()
				+ bcol.getBlue() * 2) / 3));
	    graphics2d.drawRect(x + w - 16,
				y + 3, 14, 17);
	    if (bool_9_)
		graphics2d.setColor
		    (new Color((bcol.getRed() + 510) / 3,
			       (bcol.getGreen() + 510) / 3,
			       (bcol.getBlue() + 510) / 3));
	    else
		graphics2d.setColor
		    (new Color((fcol.getRed() + 510) / 3,
			       (fcol.getGreen() + 510) / 3,
			       (fcol.getBlue() + 510) / 3));
	    graphics2d.fillRect(x + w - 15,
				y + 4, 13, 16);
	    graphics2d.setColor(new Color(0, 0, 0));
	    if (dis)
		graphics2d.setColor
		    (new Color((fcol.getRed()
				+ bcol.getRed() * 2) / 3,
			       (fcol.getGreen()
				+ bcol.getGreen() * 2) / 3,
			       (fcol.getBlue()
				+ bcol.getBlue() * 2) / 3));
	    graphics2d.drawLine(x + w - 12,
				y + 9,
				x + w - 12,
				y + 10);
	    graphics2d.drawLine(x + w - 11,
				y + 10,
				x + w - 11,
				y + 11);
	    graphics2d.drawLine(x + w - 10,
				y + 11,
				x + w - 10,
				y + 12);
	    graphics2d.drawLine(x + w - 9,
				y + 12,
				x + w - 9,
				y + 13);
	    graphics2d.drawLine(x + w - 8,
				y + 11,
				x + w - 8,
				y + 12);
	    graphics2d.drawLine(x + w - 7,
				y + 10,
				x + w - 7,
				y + 11);
	    graphics2d.drawLine(x + w - 6,
				y + 9,
				x + w - 6,
				y + 10);
	    if (bool_10_)
		graphics2d.setColor(bcol);
	    else
		graphics2d.setColor(fcol);
	    if (dis)
		graphics2d.setColor
		    (new Color((fcol.getRed()
				+ bcol.getRed() * 2) / 3,
			       (fcol.getGreen()
				+ bcol.getGreen() * 2) / 3,
			       (fcol.getBlue()
				+ bcol.getBlue() * 2) / 3));
	    if (carsel && !bool_10_) {
		if (flksel) {
		    graphics2d.setColor(new Color(240, 240, 240));
		    flksel = false;
		} else
		    flksel = true;
	    }
	    graphics2d.drawString(sopts[sel],
				  x + 4,
				  (y
				   + (ftm.getHeight() + 2)));
	    if (alphad)
		graphics2d.setComposite(AlphaComposite.getInstance(3, 1.0F));
	} else {
	    if (scro != 0)
		scro = 0;
	    if (scra != 0)
		scra = 0;
	}
	return bool_7_;
    }
}
