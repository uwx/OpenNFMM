package stagemaker;

/* Smenu - Decompiled by JODE extended
 * DragShot Software
 * JODE (c) 1998-2001 Jochen Hoenicke
 */
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
        if ((!rooms || no == 0) && ftm.stringWidth(string) + 30 > w)
            w = ftm.stringWidth(string) + 30;
        if (rooms) {
            iroom = new int[7];
            for (int i = 0; i < 7; i++)
                iroom[i] = 0;
        }
        opts[no] = string;
        if (maxl != 0) {
            int i;
            for (i = string.length(); ftm.stringWidth(string.substring(0, i)) + 30 > maxl; i--) {
                /* empty */
            }
            if (i != string.length()) {
                string = string.substring(0, i - 3);
                string = new StringBuilder().append(string).append("...").toString();
            }
        }
        sopts[no] = string;
        if (no < opts.length - 1)
            no++;
    }
    
    public void removeAll() {
        no = 0;
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
        if (i > 0 && i < no)
            string = opts[i];
        return string;
    }
    
    public int getItemCount() {
        return no;
    }
    
    public void remove(String string) {
        for (int i = 0; i < no; i++) {
            if (opts[i].equals(string)) {
                for (int i_0_ = i; i_0_ < no; i_0_++) {
                    if (i_0_ != no - 1) {
                        opts[i_0_] = opts[i_0_ + 1];
                        sopts[i_0_] = sopts[i_0_ + 1];
                    }
                }
                no--;
                break;
            }
        }
    }
    
    public void setSize(int i, int i_1_) {
        w = i;
        h = i_1_;
    }
    
    public int getWidth() {
        return w;
    }
    
    public void setFont(Font font) {
        font = font;
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
    
    public void move(int i, int i_2_) {
        x = i;
        y = i_2_;
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
    
    public boolean draw(Graphics2D graphics2d, int i, int i_3_, boolean bool, int i_4_, boolean bool_5_) {
        boolean bool_6_ = false;
        if (show) {
            boolean bool_7_ = false;
            if (bool) {
                if (!om) {
                    om = true;
                    bool_7_ = true;
                }
            } else if (om)
                om = false;
            boolean bool_8_ = false;
            if ((bcol.getRed() + bcol.getGreen() + bcol.getBlue()) / 3 > (fcol.getRed() + fcol.getGreen() + fcol.getBlue()) / 3)
                bool_8_ = true;
            boolean bool_9_ = false;
            if (i > x && i < x + w && i_3_ > y + 1 && i_3_ < y + 22 && !open && !dis)
                bool_9_ = true;
            if (!open && bool_9_ && bool_7_ && !dis) {
                open = true;
                bool_7_ = false;
            }
            graphics2d.setFont(font);
            ftm = graphics2d.getFontMetrics();
            if (open) {
                int i_10_ = 4 + (ftm.getHeight() + 2) * no;
                if (!bool_5_) {
                    int i_11_ = 0;
                    graphics2d.setColor(bcol);
                    graphics2d.fillRect(x, y + 23, w, i_10_);
                    graphics2d.setColor(new Color((fcol.getRed() + bcol.getRed()) / 2, (fcol.getGreen() + bcol.getGreen()) / 2, (fcol.getBlue() + bcol.getBlue()) / 2));
                    graphics2d.drawRect(x, y + 23, w, i_10_);
                    if (y + 23 + i_10_ > i_4_) {
                        graphics2d.drawLine(x + w - 18, y + 17, x + w - 18, i_4_);
                        if (bool_8_)
                            graphics2d.setColor(new Color((bcol.getRed() + 510) / 3, (bcol.getGreen() + 510) / 3, (bcol.getBlue() + 510) / 3));
                        else
                            graphics2d.setColor(new Color((fcol.getRed() + 510) / 3, (fcol.getGreen() + 510) / 3, (fcol.getBlue() + 510) / 3));
                        graphics2d.fillRect(x + w - 15, y + 25 + scra, 13, 30);
                        graphics2d.setColor(fcol);
                        graphics2d.drawRect(x + w - 15, y + 25 + scra, 12, 30);
                        graphics2d.setColor(new Color(0, 0, 0));
                        graphics2d.drawLine(x + w - 12, y + 9 + 29 + scra, x + w - 12, y + 10 + 29 + scra);
                        graphics2d.drawLine(x + w - 11, y + 10 + 29 + scra, x + w - 11, y + 11 + 29 + scra);
                        graphics2d.drawLine(x + w - 10, y + 11 + 29 + scra, x + w - 10, y + 12 + 29 + scra);
                        graphics2d.drawLine(x + w - 9, y + 12 + 29 + scra, x + w - 9, y + 13 + 29 + scra);
                        graphics2d.drawLine(x + w - 8, y + 11 + 29 + scra, x + w - 8, y + 12 + 29 + scra);
                        graphics2d.drawLine(x + w - 7, y + 10 + 29 + scra, x + w - 7, y + 11 + 29 + scra);
                        graphics2d.drawLine(x + w - 6, y + 9 + 29 + scra, x + w - 6, y + 10 + 29 + scra);
                        i_11_ = -18;
                        if (bool) {
                            if (i > x + w - 18 && i < x + w && i_3_ > y + 25 && i_3_ < i_4_) {
                                bool_7_ = false;
                                onsc = true;
                            }
                        } else if (onsc)
                            onsc = false;
                        if (onsc) {
                            scra = i_3_ - (y + 25) - 15;
                            if (scra < 0)
                                scra = 0;
                            int i_12_ = i_4_ - (y + 25) - 33;
                            if (scra > i_12_)
                                scra = i_12_;
                            int i_13_ = no * (ftm.getHeight() + 2) - i_12_ - ftm.getHeight() / 2;
                            scro = -(int) ((float) scra * ((float) i_13_ / (float) i_12_));
                        }
                    }
                    for (int i_14_ = 0; i_14_ < no; i_14_++) {
                        if (Math.abs(scro) < (i_14_ + 1) * (ftm.getHeight() + 2)) {
                            graphics2d.setColor(fcol);
                            if (i > x && i < x + w && i_3_ > y + 25 + scro + i_14_ * (ftm.getHeight() + 2) && i_3_ < y + 25 + scro + (i_14_ + 1) * (ftm.getHeight() + 2)) {
                                if (bool_8_)
                                    graphics2d.setColor(new Color((fcol.getRed() + bcol.getRed()) / 2, (fcol.getGreen() + bcol.getGreen()) / 2, (fcol.getBlue() + bcol.getBlue()) / 2));
                                else
                                    graphics2d.setColor(fcol);
                                graphics2d.fillRect(x + 1, y + 25 + scro + i_14_ * (ftm.getHeight() + 2), w - 1 + i_11_, ftm.getHeight() + 2);
                                graphics2d.setColor(bcol);
                                if (bool_7_) {
                                    if (!rooms || !opts[i_14_].equals("full")) {
                                        sel = i_14_;
                                        if (rooms && i_14_ != 0)
                                            sopts[i_14_] = " ";
                                    } else
                                        kmoused = 20;
                                    open = false;
                                }
                            }
                            if (rooms && sopts[i_14_].indexOf("10 / 10") != -1)
                                graphics2d.setColor(new Color(255, 0, 0));
                            graphics2d.drawString(sopts[i_14_], x + 4, y + 38 + scro + i_14_ * (ftm.getHeight() + 2));
                        }
                    }
                    if (i_11_ != 0) {
                        graphics2d.setColor(new Color((fcol.getRed() + bcol.getRed()) / 2, (fcol.getGreen() + bcol.getGreen()) / 2, (fcol.getBlue() + bcol.getBlue()) / 2));
                        graphics2d.drawLine(x, i_4_ - 1, x + w, i_4_ - 1);
                    }
                } else {
                    int i_15_ = 0;
                    graphics2d.setColor(bcol);
                    graphics2d.fillRect(x, y - i_10_, w, i_10_);
                    graphics2d.setColor(new Color((fcol.getRed() + bcol.getRed()) / 2, (fcol.getGreen() + bcol.getGreen()) / 2, (fcol.getBlue() + bcol.getBlue()) / 2));
                    graphics2d.drawRect(x, y - i_10_, w, i_10_);
                    if (y - i_10_ < 0) {
                        graphics2d.drawLine(x + w - 18, 0, x + w - 18, y);
                        if (bool_8_)
                            graphics2d.setColor(new Color((bcol.getRed() + 510) / 3, (bcol.getGreen() + 510) / 3, (bcol.getBlue() + 510) / 3));
                        else
                            graphics2d.setColor(new Color((fcol.getRed() + 510) / 3, (fcol.getGreen() + 510) / 3, (fcol.getBlue() + 510) / 3));
                        graphics2d.fillRect(x + w - 15, y - scra - 33, 13, 30);
                        graphics2d.setColor(fcol);
                        graphics2d.drawRect(x + w - 15, y - scra - 33, 12, 30);
                        graphics2d.setColor(new Color(0, 0, 0));
                        graphics2d.drawLine(x + w - 12, y + 13 - 29 - scra, x + w - 12, y + 12 - 29 - scra);
                        graphics2d.drawLine(x + w - 11, y + 12 - 29 - scra, x + w - 11, y + 11 - 29 - scra);
                        graphics2d.drawLine(x + w - 10, y + 11 - 29 - scra, x + w - 10, y + 10 - 29 - scra);
                        graphics2d.drawLine(x + w - 9, y + 10 - 29 - scra, x + w - 9, y + 9 - 29 - scra);
                        graphics2d.drawLine(x + w - 8, y + 11 - 29 - scra, x + w - 8, y + 10 - 29 - scra);
                        graphics2d.drawLine(x + w - 7, y + 12 - 29 - scra, x + w - 7, y + 11 - 29 - scra);
                        graphics2d.drawLine(x + w - 6, y + 13 - 29 - scra, x + w - 6, y + 12 - 29 - scra);
                        i_15_ = -18;
                        if (bool) {
                            if (i > x + w - 18 && i < x + w && i_3_ > 0 && i_3_ < y - 3) {
                                bool_7_ = false;
                                onsc = true;
                            }
                        } else if (onsc)
                            onsc = false;
                        if (onsc) {
                            scra = y - 3 - 15 - i_3_;
                            if (scra < 0)
                                scra = 0;
                            int i_16_ = y - 35;
                            if (scra > i_16_)
                                scra = i_16_;
                            int i_17_ = no * (ftm.getHeight() + 2) - i_16_ - ftm.getHeight() / 2;
                            scro = (int) ((float) scra * ((float) i_17_ / (float) i_16_));
                        }
                    }
                    for (int i_18_ = 0; i_18_ < no; i_18_++) {
                        if (Math.abs(scro) < (i_18_ + 1) * (ftm.getHeight() + 2)) {
                            graphics2d.setColor(fcol);
                            if (i > x && i < x + w && i_3_ < y - 18 + scro - (i_18_ - 1) * (ftm.getHeight() + 2) && i_3_ > y - 18 + scro - i_18_ * (ftm.getHeight() + 2)) {
                                if (bool_8_)
                                    graphics2d.setColor(new Color((fcol.getRed() + bcol.getRed()) / 2, (fcol.getGreen() + bcol.getGreen()) / 2, (fcol.getBlue() + bcol.getBlue()) / 2));
                                else
                                    graphics2d.setColor(fcol);
                                graphics2d.fillRect(x + 1, y - 18 + scro - i_18_ * (ftm.getHeight() + 2), w - 1 + i_15_, ftm.getHeight() + 2);
                                graphics2d.setColor(bcol);
                                if (bool_7_) {
                                    sel = i_18_;
                                    open = false;
                                }
                            }
                            graphics2d.drawString(sopts[i_18_], x + 4, y - 5 + scro - i_18_ * (ftm.getHeight() + 2));
                        }
                    }
                    if (i_15_ != 0) {
                        graphics2d.setColor(new Color((fcol.getRed() + bcol.getRed()) / 2, (fcol.getGreen() + bcol.getGreen()) / 2, (fcol.getBlue() + bcol.getBlue()) / 2));
                        graphics2d.drawLine(x, 0, x + w, 0);
                    }
                }
                bool_6_ = true;
                if (bool_7_)
                    open = false;
            } else {
                if (scro != 0)
                    scro = 0;
                if (scra != 0)
                    scra = 0;
            }
            if (bool_9_) {
                if (bool_8_)
                    graphics2d.setColor(new Color((fcol.getRed() + bcol.getRed()) / 2, (fcol.getGreen() + bcol.getGreen()) / 2, (fcol.getBlue() + bcol.getBlue()) / 2));
                else
                    graphics2d.setColor(fcol);
            } else
                graphics2d.setColor(bcol);
            graphics2d.fillRect(x, y + 1, w, 21);
            graphics2d.setColor(new Color((fcol.getRed() + bcol.getRed()) / 2, (fcol.getGreen() + bcol.getGreen()) / 2, (fcol.getBlue() + bcol.getBlue()) / 2));
            graphics2d.drawRect(x, y + 1, w, 21);
            if (bool_8_)
                graphics2d.setColor(new Color((bcol.getRed() + 255) / 2, (bcol.getGreen() + 255) / 2, (bcol.getBlue() + 255) / 2));
            else
                graphics2d.setColor(new Color((fcol.getRed() + 255) / 2, (fcol.getGreen() + 255) / 2, (fcol.getBlue() + 255) / 2));
            graphics2d.drawRect(x + 1, y + 2, w - 2, 19);
            graphics2d.drawLine(x + w - 17, y + 3, x + w - 17, y + 20);
            graphics2d.setColor(fcol);
            if (dis)
                graphics2d.setColor(new Color((fcol.getRed() + bcol.getRed() * 2) / 3, (fcol.getGreen() + bcol.getGreen() * 2) / 3, (fcol.getBlue() + bcol.getBlue() * 2) / 3));
            graphics2d.drawRect(x + w - 16, y + 3, 14, 17);
            if (bool_8_)
                graphics2d.setColor(new Color((bcol.getRed() + 510) / 3, (bcol.getGreen() + 510) / 3, (bcol.getBlue() + 510) / 3));
            else
                graphics2d.setColor(new Color((fcol.getRed() + 510) / 3, (fcol.getGreen() + 510) / 3, (fcol.getBlue() + 510) / 3));
            graphics2d.fillRect(x + w - 15, y + 4, 13, 16);
            graphics2d.setColor(new Color(0, 0, 0));
            if (dis)
                graphics2d.setColor(new Color((fcol.getRed() + bcol.getRed() * 2) / 3, (fcol.getGreen() + bcol.getGreen() * 2) / 3, (fcol.getBlue() + bcol.getBlue() * 2) / 3));
            graphics2d.drawLine(x + w - 12, y + 9, x + w - 12, y + 10);
            graphics2d.drawLine(x + w - 11, y + 10, x + w - 11, y + 11);
            graphics2d.drawLine(x + w - 10, y + 11, x + w - 10, y + 12);
            graphics2d.drawLine(x + w - 9, y + 12, x + w - 9, y + 13);
            graphics2d.drawLine(x + w - 8, y + 11, x + w - 8, y + 12);
            graphics2d.drawLine(x + w - 7, y + 10, x + w - 7, y + 11);
            graphics2d.drawLine(x + w - 6, y + 9, x + w - 6, y + 10);
            if (bool_9_)
                graphics2d.setColor(bcol);
            else
                graphics2d.setColor(fcol);
            if (dis)
                graphics2d.setColor(new Color((fcol.getRed() + bcol.getRed() * 2) / 3, (fcol.getGreen() + bcol.getGreen() * 2) / 3, (fcol.getBlue() + bcol.getBlue() * 2) / 3));
            graphics2d.drawString(sopts[sel], x + 4, y + (ftm.getHeight() + 2));
        } else {
            if (scro != 0)
                scro = 0;
            if (scra != 0)
                scra = 0;
        }
        return bool_6_;
    }
}
