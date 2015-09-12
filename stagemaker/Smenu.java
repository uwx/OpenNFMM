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
        this.opts = new String[i];
        this.sopts = new String[i];
    }
    
    public void add(Graphics2D graphics2d, String string) {
        graphics2d.setFont(this.font);
        this.ftm = graphics2d.getFontMetrics();
        if ((!this.rooms || this.no == 0) && this.ftm.stringWidth(string) + 30 > this.w)
            this.w = this.ftm.stringWidth(string) + 30;
        if (this.rooms) {
            this.iroom = new int[7];
            for (int i = 0; i < 7; i++)
                this.iroom[i] = 0;
        }
        this.opts[this.no] = string;
        if (this.maxl != 0) {
            int i;
            for (i = string.length(); this.ftm.stringWidth(string.substring(0, i)) + 30 > this.maxl; i--) {
                /* empty */
            }
            if (i != string.length()) {
                string = string.substring(0, i - 3);
                string = new StringBuilder().append(string).append("...").toString();
            }
        }
        this.sopts[this.no] = string;
        if (this.no < this.opts.length - 1)
            this.no++;
    }
    
    public void removeAll() {
        this.no = 0;
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
        if (i > 0 && i < this.no)
            string = this.opts[i];
        return string;
    }
    
    public int getItemCount() {
        return this.no;
    }
    
    public void remove(String string) {
        for (int i = 0; i < this.no; i++) {
            if (this.opts[i].equals(string)) {
                for (int i_0_ = i; i_0_ < this.no; i_0_++) {
                    if (i_0_ != this.no - 1) {
                        this.opts[i_0_] = this.opts[i_0_ + 1];
                        this.sopts[i_0_] = this.sopts[i_0_ + 1];
                    }
                }
                this.no--;
                break;
            }
        }
    }
    
    public void setSize(int i, int i_1_) {
        this.w = i;
        this.h = i_1_;
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
    
    public void move(int i, int i_2_) {
        this.x = i;
        this.y = i_2_;
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
    
    public boolean draw(Graphics2D graphics2d, int i, int i_3_, boolean bool, int i_4_, boolean bool_5_) {
        boolean bool_6_ = false;
        if (this.show) {
            boolean bool_7_ = false;
            if (bool) {
                if (!this.om) {
                    this.om = true;
                    bool_7_ = true;
                }
            } else if (this.om)
                this.om = false;
            boolean bool_8_ = false;
            if ((this.bcol.getRed() + this.bcol.getGreen() + this.bcol.getBlue()) / 3 > (this.fcol.getRed() + this.fcol.getGreen() + this.fcol.getBlue()) / 3)
                bool_8_ = true;
            boolean bool_9_ = false;
            if (i > this.x && i < this.x + this.w && i_3_ > this.y + 1 && i_3_ < this.y + 22 && !this.open && !this.dis)
                bool_9_ = true;
            if (!this.open && bool_9_ && bool_7_ && !this.dis) {
                this.open = true;
                bool_7_ = false;
            }
            graphics2d.setFont(this.font);
            this.ftm = graphics2d.getFontMetrics();
            if (this.open) {
                int i_10_ = 4 + (this.ftm.getHeight() + 2) * this.no;
                if (!bool_5_) {
                    int i_11_ = 0;
                    graphics2d.setColor(this.bcol);
                    graphics2d.fillRect(this.x, this.y + 23, this.w, i_10_);
                    graphics2d.setColor(new Color((this.fcol.getRed() + this.bcol.getRed()) / 2, (this.fcol.getGreen() + this.bcol.getGreen()) / 2, (this.fcol.getBlue() + this.bcol.getBlue()) / 2));
                    graphics2d.drawRect(this.x, this.y + 23, this.w, i_10_);
                    if (this.y + 23 + i_10_ > i_4_) {
                        graphics2d.drawLine(this.x + this.w - 18, this.y + 17, this.x + this.w - 18, i_4_);
                        if (bool_8_)
                            graphics2d.setColor(new Color((this.bcol.getRed() + 510) / 3, (this.bcol.getGreen() + 510) / 3, (this.bcol.getBlue() + 510) / 3));
                        else
                            graphics2d.setColor(new Color((this.fcol.getRed() + 510) / 3, (this.fcol.getGreen() + 510) / 3, (this.fcol.getBlue() + 510) / 3));
                        graphics2d.fillRect(this.x + this.w - 15, this.y + 25 + this.scra, 13, 30);
                        graphics2d.setColor(this.fcol);
                        graphics2d.drawRect(this.x + this.w - 15, this.y + 25 + this.scra, 12, 30);
                        graphics2d.setColor(new Color(0, 0, 0));
                        graphics2d.drawLine(this.x + this.w - 12, this.y + 9 + 29 + this.scra, this.x + this.w - 12, this.y + 10 + 29 + this.scra);
                        graphics2d.drawLine(this.x + this.w - 11, this.y + 10 + 29 + this.scra, this.x + this.w - 11, this.y + 11 + 29 + this.scra);
                        graphics2d.drawLine(this.x + this.w - 10, this.y + 11 + 29 + this.scra, this.x + this.w - 10, this.y + 12 + 29 + this.scra);
                        graphics2d.drawLine(this.x + this.w - 9, this.y + 12 + 29 + this.scra, this.x + this.w - 9, this.y + 13 + 29 + this.scra);
                        graphics2d.drawLine(this.x + this.w - 8, this.y + 11 + 29 + this.scra, this.x + this.w - 8, this.y + 12 + 29 + this.scra);
                        graphics2d.drawLine(this.x + this.w - 7, this.y + 10 + 29 + this.scra, this.x + this.w - 7, this.y + 11 + 29 + this.scra);
                        graphics2d.drawLine(this.x + this.w - 6, this.y + 9 + 29 + this.scra, this.x + this.w - 6, this.y + 10 + 29 + this.scra);
                        i_11_ = -18;
                        if (bool) {
                            if (i > this.x + this.w - 18 && i < this.x + this.w && i_3_ > this.y + 25 && i_3_ < i_4_) {
                                bool_7_ = false;
                                this.onsc = true;
                            }
                        } else if (this.onsc)
                            this.onsc = false;
                        if (this.onsc) {
                            this.scra = i_3_ - (this.y + 25) - 15;
                            if (this.scra < 0)
                                this.scra = 0;
                            int i_12_ = i_4_ - (this.y + 25) - 33;
                            if (this.scra > i_12_)
                                this.scra = i_12_;
                            int i_13_ = this.no * (this.ftm.getHeight() + 2) - i_12_ - this.ftm.getHeight() / 2;
                            this.scro = -(int) ((float) this.scra * ((float) i_13_ / (float) i_12_));
                        }
                    }
                    for (int i_14_ = 0; i_14_ < this.no; i_14_++) {
                        if (Math.abs(this.scro) < (i_14_ + 1) * (this.ftm.getHeight() + 2)) {
                            graphics2d.setColor(this.fcol);
                            if (i > this.x && i < this.x + this.w && i_3_ > this.y + 25 + this.scro + i_14_ * (this.ftm.getHeight() + 2) && i_3_ < this.y + 25 + this.scro + (i_14_ + 1) * (this.ftm.getHeight() + 2)) {
                                if (bool_8_)
                                    graphics2d.setColor(new Color((this.fcol.getRed() + this.bcol.getRed()) / 2, (this.fcol.getGreen() + this.bcol.getGreen()) / 2, (this.fcol.getBlue() + this.bcol.getBlue()) / 2));
                                else
                                    graphics2d.setColor(this.fcol);
                                graphics2d.fillRect(this.x + 1, this.y + 25 + this.scro + i_14_ * (this.ftm.getHeight() + 2), this.w - 1 + i_11_, this.ftm.getHeight() + 2);
                                graphics2d.setColor(this.bcol);
                                if (bool_7_) {
                                    if (!this.rooms || !this.opts[i_14_].equals("full")) {
                                        this.sel = i_14_;
                                        if (this.rooms && i_14_ != 0)
                                            this.sopts[i_14_] = " ";
                                    } else
                                        this.kmoused = 20;
                                    this.open = false;
                                }
                            }
                            if (this.rooms && this.sopts[i_14_].indexOf("10 / 10") != -1)
                                graphics2d.setColor(new Color(255, 0, 0));
                            graphics2d.drawString(this.sopts[i_14_], this.x + 4, this.y + 38 + this.scro + i_14_ * (this.ftm.getHeight() + 2));
                        }
                    }
                    if (i_11_ != 0) {
                        graphics2d.setColor(new Color((this.fcol.getRed() + this.bcol.getRed()) / 2, (this.fcol.getGreen() + this.bcol.getGreen()) / 2, (this.fcol.getBlue() + this.bcol.getBlue()) / 2));
                        graphics2d.drawLine(this.x, i_4_ - 1, this.x + this.w, i_4_ - 1);
                    }
                } else {
                    int i_15_ = 0;
                    graphics2d.setColor(this.bcol);
                    graphics2d.fillRect(this.x, this.y - i_10_, this.w, i_10_);
                    graphics2d.setColor(new Color((this.fcol.getRed() + this.bcol.getRed()) / 2, (this.fcol.getGreen() + this.bcol.getGreen()) / 2, (this.fcol.getBlue() + this.bcol.getBlue()) / 2));
                    graphics2d.drawRect(this.x, this.y - i_10_, this.w, i_10_);
                    if (this.y - i_10_ < 0) {
                        graphics2d.drawLine(this.x + this.w - 18, 0, this.x + this.w - 18, this.y);
                        if (bool_8_)
                            graphics2d.setColor(new Color((this.bcol.getRed() + 510) / 3, (this.bcol.getGreen() + 510) / 3, (this.bcol.getBlue() + 510) / 3));
                        else
                            graphics2d.setColor(new Color((this.fcol.getRed() + 510) / 3, (this.fcol.getGreen() + 510) / 3, (this.fcol.getBlue() + 510) / 3));
                        graphics2d.fillRect(this.x + this.w - 15, this.y - this.scra - 33, 13, 30);
                        graphics2d.setColor(this.fcol);
                        graphics2d.drawRect(this.x + this.w - 15, this.y - this.scra - 33, 12, 30);
                        graphics2d.setColor(new Color(0, 0, 0));
                        graphics2d.drawLine(this.x + this.w - 12, this.y + 13 - 29 - this.scra, this.x + this.w - 12, this.y + 12 - 29 - this.scra);
                        graphics2d.drawLine(this.x + this.w - 11, this.y + 12 - 29 - this.scra, this.x + this.w - 11, this.y + 11 - 29 - this.scra);
                        graphics2d.drawLine(this.x + this.w - 10, this.y + 11 - 29 - this.scra, this.x + this.w - 10, this.y + 10 - 29 - this.scra);
                        graphics2d.drawLine(this.x + this.w - 9, this.y + 10 - 29 - this.scra, this.x + this.w - 9, this.y + 9 - 29 - this.scra);
                        graphics2d.drawLine(this.x + this.w - 8, this.y + 11 - 29 - this.scra, this.x + this.w - 8, this.y + 10 - 29 - this.scra);
                        graphics2d.drawLine(this.x + this.w - 7, this.y + 12 - 29 - this.scra, this.x + this.w - 7, this.y + 11 - 29 - this.scra);
                        graphics2d.drawLine(this.x + this.w - 6, this.y + 13 - 29 - this.scra, this.x + this.w - 6, this.y + 12 - 29 - this.scra);
                        i_15_ = -18;
                        if (bool) {
                            if (i > this.x + this.w - 18 && i < this.x + this.w && i_3_ > 0 && i_3_ < this.y - 3) {
                                bool_7_ = false;
                                this.onsc = true;
                            }
                        } else if (this.onsc)
                            this.onsc = false;
                        if (this.onsc) {
                            this.scra = this.y - 3 - 15 - i_3_;
                            if (this.scra < 0)
                                this.scra = 0;
                            int i_16_ = this.y - 35;
                            if (this.scra > i_16_)
                                this.scra = i_16_;
                            int i_17_ = this.no * (this.ftm.getHeight() + 2) - i_16_ - this.ftm.getHeight() / 2;
                            this.scro = (int) ((float) this.scra * ((float) i_17_ / (float) i_16_));
                        }
                    }
                    for (int i_18_ = 0; i_18_ < this.no; i_18_++) {
                        if (Math.abs(this.scro) < (i_18_ + 1) * (this.ftm.getHeight() + 2)) {
                            graphics2d.setColor(this.fcol);
                            if (i > this.x && i < this.x + this.w && i_3_ < this.y - 18 + this.scro - (i_18_ - 1) * (this.ftm.getHeight() + 2) && i_3_ > this.y - 18 + this.scro - i_18_ * (this.ftm.getHeight() + 2)) {
                                if (bool_8_)
                                    graphics2d.setColor(new Color((this.fcol.getRed() + this.bcol.getRed()) / 2, (this.fcol.getGreen() + this.bcol.getGreen()) / 2, (this.fcol.getBlue() + this.bcol.getBlue()) / 2));
                                else
                                    graphics2d.setColor(this.fcol);
                                graphics2d.fillRect(this.x + 1, this.y - 18 + this.scro - i_18_ * (this.ftm.getHeight() + 2), this.w - 1 + i_15_, this.ftm.getHeight() + 2);
                                graphics2d.setColor(this.bcol);
                                if (bool_7_) {
                                    this.sel = i_18_;
                                    this.open = false;
                                }
                            }
                            graphics2d.drawString(this.sopts[i_18_], this.x + 4, this.y - 5 + this.scro - i_18_ * (this.ftm.getHeight() + 2));
                        }
                    }
                    if (i_15_ != 0) {
                        graphics2d.setColor(new Color((this.fcol.getRed() + this.bcol.getRed()) / 2, (this.fcol.getGreen() + this.bcol.getGreen()) / 2, (this.fcol.getBlue() + this.bcol.getBlue()) / 2));
                        graphics2d.drawLine(this.x, 0, this.x + this.w, 0);
                    }
                }
                bool_6_ = true;
                if (bool_7_)
                    this.open = false;
            } else {
                if (this.scro != 0)
                    this.scro = 0;
                if (this.scra != 0)
                    this.scra = 0;
            }
            if (bool_9_) {
                if (bool_8_)
                    graphics2d.setColor(new Color((this.fcol.getRed() + this.bcol.getRed()) / 2, (this.fcol.getGreen() + this.bcol.getGreen()) / 2, (this.fcol.getBlue() + this.bcol.getBlue()) / 2));
                else
                    graphics2d.setColor(this.fcol);
            } else
                graphics2d.setColor(this.bcol);
            graphics2d.fillRect(this.x, this.y + 1, this.w, 21);
            graphics2d.setColor(new Color((this.fcol.getRed() + this.bcol.getRed()) / 2, (this.fcol.getGreen() + this.bcol.getGreen()) / 2, (this.fcol.getBlue() + this.bcol.getBlue()) / 2));
            graphics2d.drawRect(this.x, this.y + 1, this.w, 21);
            if (bool_8_)
                graphics2d.setColor(new Color((this.bcol.getRed() + 255) / 2, (this.bcol.getGreen() + 255) / 2, (this.bcol.getBlue() + 255) / 2));
            else
                graphics2d.setColor(new Color((this.fcol.getRed() + 255) / 2, (this.fcol.getGreen() + 255) / 2, (this.fcol.getBlue() + 255) / 2));
            graphics2d.drawRect(this.x + 1, this.y + 2, this.w - 2, 19);
            graphics2d.drawLine(this.x + this.w - 17, this.y + 3, this.x + this.w - 17, this.y + 20);
            graphics2d.setColor(this.fcol);
            if (this.dis)
                graphics2d.setColor(new Color((this.fcol.getRed() + this.bcol.getRed() * 2) / 3, (this.fcol.getGreen() + this.bcol.getGreen() * 2) / 3, (this.fcol.getBlue() + this.bcol.getBlue() * 2) / 3));
            graphics2d.drawRect(this.x + this.w - 16, this.y + 3, 14, 17);
            if (bool_8_)
                graphics2d.setColor(new Color((this.bcol.getRed() + 510) / 3, (this.bcol.getGreen() + 510) / 3, (this.bcol.getBlue() + 510) / 3));
            else
                graphics2d.setColor(new Color((this.fcol.getRed() + 510) / 3, (this.fcol.getGreen() + 510) / 3, (this.fcol.getBlue() + 510) / 3));
            graphics2d.fillRect(this.x + this.w - 15, this.y + 4, 13, 16);
            graphics2d.setColor(new Color(0, 0, 0));
            if (this.dis)
                graphics2d.setColor(new Color((this.fcol.getRed() + this.bcol.getRed() * 2) / 3, (this.fcol.getGreen() + this.bcol.getGreen() * 2) / 3, (this.fcol.getBlue() + this.bcol.getBlue() * 2) / 3));
            graphics2d.drawLine(this.x + this.w - 12, this.y + 9, this.x + this.w - 12, this.y + 10);
            graphics2d.drawLine(this.x + this.w - 11, this.y + 10, this.x + this.w - 11, this.y + 11);
            graphics2d.drawLine(this.x + this.w - 10, this.y + 11, this.x + this.w - 10, this.y + 12);
            graphics2d.drawLine(this.x + this.w - 9, this.y + 12, this.x + this.w - 9, this.y + 13);
            graphics2d.drawLine(this.x + this.w - 8, this.y + 11, this.x + this.w - 8, this.y + 12);
            graphics2d.drawLine(this.x + this.w - 7, this.y + 10, this.x + this.w - 7, this.y + 11);
            graphics2d.drawLine(this.x + this.w - 6, this.y + 9, this.x + this.w - 6, this.y + 10);
            if (bool_9_)
                graphics2d.setColor(this.bcol);
            else
                graphics2d.setColor(this.fcol);
            if (this.dis)
                graphics2d.setColor(new Color((this.fcol.getRed() + this.bcol.getRed() * 2) / 3, (this.fcol.getGreen() + this.bcol.getGreen() * 2) / 3, (this.fcol.getBlue() + this.bcol.getBlue() * 2) / 3));
            graphics2d.drawString(this.sopts[this.sel], this.x + 4, this.y + (this.ftm.getHeight() + 2));
        } else {
            if (this.scro != 0)
                this.scro = 0;
            if (this.scra != 0)
                this.scra = 0;
        }
        return bool_6_;
    }
}
