/* Smenu - Decompiled by JODE Visit http://jode.sourceforge.net/ */
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;

class Smenu {
    boolean alphad;
    private Color bcol = new Color(255, 255, 255);
    boolean carsel;
    private boolean dis;
    private Color fcol = new Color(0, 0, 0);
    private boolean flksel;
    private final Font font = new Font("Arial", 1, 13);
    private FontMetrics ftm;
    int[] iroom;
    int kmoused;
    int maxl;
    int no;
    private boolean om;
    private boolean onsc;
    boolean open;
    String[] opts;
    private boolean revup;
    boolean rooms;
    private int scra;
    private int scro;
    int sel;
    boolean show;
    String[] sopts;
    int w;
    private int x;
    private int y;

    Smenu(final int i) {
        opts = new String[i];
        sopts = new String[i];
    }

    void add(final Graphics2D graphics2d, String string) {
        graphics2d.setFont(font);
        ftm = graphics2d.getFontMetrics();
        if ((!rooms || no == 0) && ftm.stringWidth(string) + 30 > w) {
            w = ftm.stringWidth(string) + 30;
        }
        if (rooms) {
            iroom = new int[7];
            for (int i = 0; i < 7; i++) {
                iroom[i] = 0;
            }
        }
        opts[no] = string;
        if (maxl != 0) {
            int i;
            for (i = string.length(); ftm.stringWidth(string.substring(0, i)) + 30 > maxl; i--) {
            }
            if (i != string.length()) {
                string = string.substring(0, i - 3);
                string = string + "...";
            }
        }
        sopts[no] = string;
        if (no < opts.length - 1) {
            no++;
        }
    }

    void addstg(final String string) {
        if (ftm.stringWidth(string) + 30 > w) {
            w = ftm.stringWidth(string) + 30;
        }
        no++;
        if (no > 701) {
            no = 701;
        }
        for (int i = no - 1; i > 1; i--) {
            opts[i] = opts[i - 1];
            sopts[i] = sopts[i - 1];
        }
        opts[1] = string;
        sopts[1] = string;
    }

    public void addw(final String string, final String string0) {
        w = 300;
        opts[no] = string0;
        sopts[no] = string;
        if (no < opts.length - 1) {
            no++;
        }
    }

    @Deprecated
    public void disable() {
        dis = true;
    }

    boolean draw(final Graphics2D graphics2d, final int i, final int i4, final boolean bool, final int i5, boolean bool6) {
        boolean bool7 = false;
        if (revup) {
            bool6 = !bool6;
            revup = false;
        }
        if (show) {
            if (alphad) {
                graphics2d.setComposite(AlphaComposite.getInstance(3, 0.7F));
            }
            boolean bool8 = false;
            if (bool) {
                if (!om) {
                    om = true;
                    bool8 = true;
                }
            } else if (om) {
                om = false;
            }
            boolean bool9 = (bcol.getRed() + bcol.getGreen() + bcol.getBlue()) / 3 > (fcol.getRed() + fcol.getGreen() + fcol.getBlue()) / 3;
            boolean bool10 = i > x && i < x + w && i4 > y + 1 && i4 < y + 22 && !open && !dis;
            if (!open && bool10 && bool8 && !dis) {
                open = true;
                bool8 = false;
            }
            graphics2d.setFont(font);
            ftm = graphics2d.getFontMetrics();
            if (open) {
                final int i11 = 4 + (ftm.getHeight() + 2) * no;
                if (!bool6) {
                    int i12 = 0;
                    graphics2d.setColor(bcol);
                    graphics2d.fillRect(x, y + 23, w, i11);
                    graphics2d.setColor(new Color((fcol.getRed() + bcol.getRed()) / 2, (fcol.getGreen() + bcol.getGreen()) / 2, (fcol.getBlue() + bcol.getBlue()) / 2));
                    graphics2d.drawRect(x, y + 23, w, i11);
                    if (y + 23 + i11 > i5) {
                        graphics2d.drawLine(x + w - 18, y + 17, x + w - 18, i5);
                        if (bool9) {
                            graphics2d.setColor(new Color((bcol.getRed() + 510) / 3, (bcol.getGreen() + 510) / 3, (bcol.getBlue() + 510) / 3));
                        } else {
                            graphics2d.setColor(new Color((fcol.getRed() + 510) / 3, (fcol.getGreen() + 510) / 3, (fcol.getBlue() + 510) / 3));
                        }
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
                        i12 = -18;
                        if (bool) {
                            if (i > x + w - 18 && i < x + w && i4 > y + 25 && i4 < i5) {
                                bool8 = false;
                                onsc = true;
                            }
                        } else if (onsc) {
                            onsc = false;
                        }
                        if (onsc) {
                            scra = i4 - (y + 25) - 15;
                            if (scra < 0) {
                                scra = 0;
                            }
                            final int i13 = i5 - (y + 25) - 33;
                            if (scra > i13) {
                                scra = i13;
                            }
                            final int i14 = no * (ftm.getHeight() + 2) - i13 - ftm.getHeight() / 2;
                            scro = -(int) (scra * ((float) i14 / i13));
                        }
                    }
                    for (int i15 = 0; i15 < no; i15++) {
                        if (Math.abs(scro) < (i15 + 1) * (ftm.getHeight() + 2)) {
                            graphics2d.setColor(fcol);
                            if (i > x && i < x + w && i4 > y + 25 + scro + i15 * (ftm.getHeight() + 2) && i4 < y + 25 + scro + (i15 + 1) * (ftm.getHeight() + 2)) {
                                if (bool9) {
                                    graphics2d.setColor(new Color((fcol.getRed() + bcol.getRed()) / 2, (fcol.getGreen() + bcol.getGreen()) / 2, (fcol.getBlue() + bcol.getBlue()) / 2));
                                } else {
                                    graphics2d.setColor(fcol);
                                }
                                graphics2d.fillRect(x + 1, y + 25 + scro + i15 * (ftm.getHeight() + 2), w - 1 + i12, ftm.getHeight() + 2);
                                graphics2d.setColor(bcol);
                                if (bool8) {
                                    if (!rooms || !"full".equals(opts[i15])) {
                                        sel = i15;
                                        if (rooms && i15 != 0) {
                                            sopts[i15] = " ";
                                        }
                                    } else {
                                        kmoused = 20;
                                    }
                                    open = false;
                                }
                            }
                            if (rooms && sopts[i15].contains("10 / 10")) {
                                graphics2d.setColor(new Color(255, 0, 0));
                            }
                            graphics2d.drawString(sopts[i15], x + 4, y + 38 + scro + i15 * (ftm.getHeight() + 2));
                        }
                    }
                    if (i12 != 0) {
                        graphics2d.setColor(new Color((fcol.getRed() + bcol.getRed()) / 2, (fcol.getGreen() + bcol.getGreen()) / 2, (fcol.getBlue() + bcol.getBlue()) / 2));
                        graphics2d.drawLine(x, i5 - 1, x + w, i5 - 1);
                    }
                } else {
                    int i16 = 0;
                    graphics2d.setColor(bcol);
                    graphics2d.fillRect(x, y - i11, w, i11);
                    graphics2d.setColor(new Color((fcol.getRed() + bcol.getRed()) / 2, (fcol.getGreen() + bcol.getGreen()) / 2, (fcol.getBlue() + bcol.getBlue()) / 2));
                    graphics2d.drawRect(x, y - i11, w, i11);
                    if (y - i11 < 0) {
                        graphics2d.drawLine(x + w - 18, 0, x + w - 18, y);
                        if (bool9) {
                            graphics2d.setColor(new Color((bcol.getRed() + 510) / 3, (bcol.getGreen() + 510) / 3, (bcol.getBlue() + 510) / 3));
                        } else {
                            graphics2d.setColor(new Color((fcol.getRed() + 510) / 3, (fcol.getGreen() + 510) / 3, (fcol.getBlue() + 510) / 3));
                        }
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
                        i16 = -18;
                        if (bool) {
                            if (i > x + w - 18 && i < x + w && i4 > 0 && i4 < y - 3) {
                                bool8 = false;
                                onsc = true;
                            }
                        } else if (onsc) {
                            onsc = false;
                        }
                        if (onsc) {
                            scra = y - 3 - 15 - i4;
                            if (scra < 0) {
                                scra = 0;
                            }
                            final int i17 = y - 35;
                            if (scra > i17) {
                                scra = i17;
                            }
                            final int i18 = no * (ftm.getHeight() + 2) - i17 - ftm.getHeight() / 2;
                            scro = (int) (scra * ((float) i18 / i17));
                        }
                    }
                    for (int i19 = 0; i19 < no; i19++) {
                        if (Math.abs(scro) < (i19 + 1) * (ftm.getHeight() + 2)) {
                            graphics2d.setColor(fcol);
                            if (i > x && i < x + w && i4 < y - 18 + scro - (i19 - 1) * (ftm.getHeight() + 2) && i4 > y - 18 + scro - i19 * (ftm.getHeight() + 2)) {
                                if (bool9) {
                                    graphics2d.setColor(new Color((fcol.getRed() + bcol.getRed()) / 2, (fcol.getGreen() + bcol.getGreen()) / 2, (fcol.getBlue() + bcol.getBlue()) / 2));
                                } else {
                                    graphics2d.setColor(fcol);
                                }
                                graphics2d.fillRect(x + 1, y - 18 + scro - i19 * (ftm.getHeight() + 2), w - 1 + i16, ftm.getHeight() + 2);
                                graphics2d.setColor(bcol);
                                if (bool8) {
                                    sel = i19;
                                    open = false;
                                }
                            }
                            graphics2d.drawString(sopts[i19], x + 4, y - 5 + scro - i19 * (ftm.getHeight() + 2));
                        }
                    }
                    if (i16 != 0) {
                        graphics2d.setColor(new Color((fcol.getRed() + bcol.getRed()) / 2, (fcol.getGreen() + bcol.getGreen()) / 2, (fcol.getBlue() + bcol.getBlue()) / 2));
                        graphics2d.drawLine(x, 0, x + w, 0);
                    }
                }
                bool7 = true;
                if (bool8) {
                    open = false;
                }
            } else {
                if (scro != 0) {
                    scro = 0;
                }
                if (scra != 0) {
                    scra = 0;
                }
            }
            if (bool10) {
                if (bool9) {
                    graphics2d.setColor(new Color((fcol.getRed() + bcol.getRed()) / 2, (fcol.getGreen() + bcol.getGreen()) / 2, (fcol.getBlue() + bcol.getBlue()) / 2));
                } else {
                    graphics2d.setColor(fcol);
                }
            } else {
                graphics2d.setColor(bcol);
            }
            graphics2d.fillRect(x, y + 1, w, 21);
            graphics2d.setColor(new Color((fcol.getRed() + bcol.getRed()) / 2, (fcol.getGreen() + bcol.getGreen()) / 2, (fcol.getBlue() + bcol.getBlue()) / 2));
            graphics2d.drawRect(x, y + 1, w, 21);
            if (bool9) {
                graphics2d.setColor(new Color((bcol.getRed() + 255) / 2, (bcol.getGreen() + 255) / 2, (bcol.getBlue() + 255) / 2));
            } else {
                graphics2d.setColor(new Color((fcol.getRed() + 255) / 2, (fcol.getGreen() + 255) / 2, (fcol.getBlue() + 255) / 2));
            }
            graphics2d.drawRect(x + 1, y + 2, w - 2, 19);
            graphics2d.drawLine(x + w - 17, y + 3, x + w - 17, y + 20);
            graphics2d.setColor(fcol);
            if (dis) {
                graphics2d.setColor(new Color((fcol.getRed() + bcol.getRed() * 2) / 3, (fcol.getGreen() + bcol.getGreen() * 2) / 3, (fcol.getBlue() + bcol.getBlue() * 2) / 3));
            }
            graphics2d.drawRect(x + w - 16, y + 3, 14, 17);
            if (bool9) {
                graphics2d.setColor(new Color((bcol.getRed() + 510) / 3, (bcol.getGreen() + 510) / 3, (bcol.getBlue() + 510) / 3));
            } else {
                graphics2d.setColor(new Color((fcol.getRed() + 510) / 3, (fcol.getGreen() + 510) / 3, (fcol.getBlue() + 510) / 3));
            }
            graphics2d.fillRect(x + w - 15, y + 4, 13, 16);
            graphics2d.setColor(new Color(0, 0, 0));
            if (dis) {
                graphics2d.setColor(new Color((fcol.getRed() + bcol.getRed() * 2) / 3, (fcol.getGreen() + bcol.getGreen() * 2) / 3, (fcol.getBlue() + bcol.getBlue() * 2) / 3));
            }
            graphics2d.drawLine(x + w - 12, y + 9, x + w - 12, y + 10);
            graphics2d.drawLine(x + w - 11, y + 10, x + w - 11, y + 11);
            graphics2d.drawLine(x + w - 10, y + 11, x + w - 10, y + 12);
            graphics2d.drawLine(x + w - 9, y + 12, x + w - 9, y + 13);
            graphics2d.drawLine(x + w - 8, y + 11, x + w - 8, y + 12);
            graphics2d.drawLine(x + w - 7, y + 10, x + w - 7, y + 11);
            graphics2d.drawLine(x + w - 6, y + 9, x + w - 6, y + 10);
            if (bool10) {
                graphics2d.setColor(bcol);
            } else {
                graphics2d.setColor(fcol);
            }
            if (dis) {
                graphics2d.setColor(new Color((fcol.getRed() + bcol.getRed() * 2) / 3, (fcol.getGreen() + bcol.getGreen() * 2) / 3, (fcol.getBlue() + bcol.getBlue() * 2) / 3));
            }
            if (carsel && !bool10) {
                if (flksel) {
                    graphics2d.setColor(new Color(240, 240, 240));
                    flksel = false;
                } else {
                    flksel = true;
                }
            }
            graphics2d.drawString(sopts[sel], x + 4, y + ftm.getHeight() + 2);
            if (alphad) {
                graphics2d.setComposite(AlphaComposite.getInstance(3, 1.0F));
            }
        } else {
            if (scro != 0) {
                scro = 0;
            }
            if (scra != 0) {
                scra = 0;
            }
        }
        return bool7;
    }

    @Deprecated
    public void enable() {
        dis = false;
    }

    public Color getBackground() {
        return bcol;
    }

    public Color getForeground() {
        return fcol;
    }

    String getItem(final int i) {
        String string = "";
        if (i >= 0 && i < no) {
            string = opts[i];
        }
        return string;
    }

    public int getItemCount() {
        return no;
    }

    public int getSelectedIndex() {
        return sel;
    }

    public String getSelectedItem() {
        return opts[sel];
    }

    public int getWidth() {
        return w;
    }

    boolean hasFocus() {
        return false;
    }

    /** Use setVisible instead. */
    @Deprecated
    public void hide() {
        show = false;
        open = false;
    }

    public boolean isEnabled() {
        return !dis;
    }

    public boolean isShowing() {
        return show;
    }

    void move(final int i, final int i3) {
        x = i;
        y = i3;
    }

    void remove(final String string) {
        for (int i = 0; i < no; i++) {
            if (opts[i].equals(string)) {
                for (int i1 = i; i1 < no; i1++) {
                    if (i1 != no - 1) {
                        opts[i1] = opts[i1 + 1];
                        sopts[i1] = sopts[i1 + 1];
                    }
                }
                no--;
                break;
            }
        }
    }

    void removeAll() {
        no = 0;
        w = 0;
        sel = 0;
    }

    void select(final int i) {
        if (i >= 0 && i < no) {
            sel = i;
        }
    }

    void select(final String string) {
        for (int i = 0; i < no; i++) {
            if (opts[i].equals(string)) {
                sel = i;
                break;
            }
        }
    }

    public void setBackground(final Color color) {
        bcol = color;
    }

    public void setFont(final Font font) {
        // font = font;
    }

    public void setForeground(final Color color) {
        fcol = color;
    }

    void setSize(final int i, final int i2) {
        w = i;
    }

    public void setVisible(final boolean v) {
        if (v) {
            show = true;
        } else {
            show = false;
            open = false;
        }
    }

    /** Use setVisible instead. */
    @Deprecated
    public void show() {
        show = true;
    }

    public void setEnabled(final boolean b) {
        dis = b;
    }
}
