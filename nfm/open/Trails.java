package nfm.open;

import java.awt.Color;
import java.awt.Graphics2D;

import nfm.open.util.MathUtil;

public class Trails {
    public static interface Trail {
        /**
         * @param rd Graphics2D object
         * @param tx last X
         * @param ty last Y
         * @param tz last Z
         * @param nx next X
         * @param ny next Y
         * @param nz next Z
         */
        void draw(Graphics2D rd, int xz, int xy, int zy, int tx, int ty, int tz, int nx, int ny, int nz);
    }

    public static class ExampleTrail implements Trail {

        @Override
        public void draw(final Graphics2D rd, final int xz, final int xy, final int zy, final int tx, final int ty, final int tz, final int nx, final int ny, final int nz) {
            final int sin = (int) (MathUtil.sin(xz) * 50f);
            final int cos = (int) (MathUtil.cos(xz) * 50f);

            final int aX[] = {
                    tx - sin, tx + sin
            };
            final int aY[] = {
                    ty, ty
            };
            final int aZ[] = {
                    tz - cos, tz + cos
            };

            Medium.rot(aX, aZ, Medium.cx, Medium.cz, Medium.xz, 2);
            Medium.rot(aY, aZ, Medium.cy, Medium.cz, Medium.zy, 2);
            final int x2d[] = new int[2];
            final int y2d[] = new int[2];

            x2d[0] = Utility.xs(aX[0], aZ[0]);
            y2d[0] = Utility.mediumYs(aY[0], aZ[0]);
            x2d[1] = Utility.xs(aX[1], aZ[1]);
            y2d[1] = Utility.mediumYs(aY[1], aZ[1]);

            rd.setColor(Color.white);
            rd.drawLine(x2d[0], y2d[0], x2d[1], y2d[1]);
        }

    }
}
