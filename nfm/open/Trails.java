package nfm.open;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import gnu.trove.list.TFloatList;
import gnu.trove.list.TIntList;
import gnu.trove.list.array.TFloatArrayList;
import gnu.trove.list.array.TIntArrayList;
import nfm.open.Trails.Vec3i;

public class Trails {

    public static class Vec3i {
        /**
         * The x coordinate.
         */
        public int x;

        /**
         * The y coordinate.
         */
        public int y;

        /**
         * The z coordinate.
         */
        public int z;
        
        public Vec3i() {
        }

        public Vec3i(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public Vec3i(Vec3i v) {
            this.x = v.x;
            this.y = v.y;
            this.z = v.z;
        }

        public void set(Vec3i v) {
            this.x = v.x;
            this.y = v.y;
            this.z = v.z;
        }

        public void set(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public final void mul(float s) {
            this.x *= s;
            this.y *= s;
            this.z *= s;
        }

        /**
         * Sets the value of this vector to the difference of vectors t1 and t2 (this = t1 - t2).
         * 
         * @param t1 the first vector
         * @param t2 the second vector
         */
        public void sub(Vec3i t1, Vec3i t2) {
            this.x = t1.x - t2.x;
            this.y = t1.y - t2.y;
            this.z = t1.z - t2.z;
        }

        /**
         * Sets the value of this vector to the difference of itself and vector t1 (this = this - t1) .
         * 
         * @param t1 the other vector
         */
        public void sub(Vec3i t1) {
            this.x -= t1.x;
            this.y -= t1.y;
            this.z -= t1.z;
        }

        /**
         * Sets the value of this vector to the sum of vectors t1 and t2 (this = t1 + t2).
         * 
         * @param t1 the first vector
         * @param t2 the second vector
         */
        public void add(Vec3i t1, Vec3i t2) {
            this.x = t1.x + t2.x;
            this.y = t1.y + t2.y;
            this.z = t1.z + t2.z;
        }

        /**
         * Sets the value of this vector to the sum of itself and vector t1 (this = this + t1) .
         * 
         * @param t1 the other vector
         */
        public void add(Vec3i t1) {
            this.x += t1.x;
            this.y += t1.y;
            this.z += t1.z;
        }

        /**
         * Returns the length of this vector.
         * 
         * @return the length of this vector
         */
        public float length() {
            return (float) Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
        }

        /**
         * Normalize this vector.
         */
        public void normalize() {
            float norm = 1.0f / length();
            this.x = (int) (this.x * norm);
            this.y = (int) (this.y * norm);
            this.z = (int) (this.z * norm);
        }

        /**
         * Sets this vector to be the vector cross product of vectors v1 and v2.
         * 
         * @param v1 the first vector
         * @param v2 the second vector
         */
        public void cross(Vec3i v1, Vec3i v2) {
            int tmpX;
            int tmpY;

            tmpX = v1.y * v2.z - v1.z * v2.y;
            tmpY = v2.x * v1.z - v2.z * v1.x;
            this.z = v1.x * v2.y - v1.y * v2.x;
            this.x = tmpX;
            this.y = tmpY;
        }

        /**
         * Computes the dot product of this vector and vector v1.
         * 
         * @param v1 the other vector
         * @return the dot product of this vector and v1
         */
        public int dot(Vec3i v1) {
            return this.x * v1.x + this.y * v1.y + this.z * v1.z;
        }

        /**
         * Returns the hashcode for this <code>Vec3f</code>.
         * 
         * @return a hash code for this <code>Vec3f</code>.
         */
        @Override
        public int hashCode() {
            int bits = 7;
            bits = 31 * bits + x;
            bits = 31 * bits + y;
            bits = 31 * bits + z;
            return bits;
        }

        /**
         * Determines whether or not two 3D points or vectors are equal. Two instances of <code>Vec3f</code> are equal if the values of their <code>x</code>, <code>y</code> and <code>z</code> member fields, representing their position in the coordinate space, are the same.
         * 
         * @param obj an object to be compared with this <code>Vec3f</code>
         * @return <code>true</code> if the object to be compared is an instance of <code>Vec3f</code> and has the same values; <code>false</code> otherwise.
         */
        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof Vec3i) {
                Vec3i v = (Vec3i) obj;
                return (x == v.x) && (y == v.y) && (z == v.z);
            }
            return false;
        }

        /**
         * Returns a <code>String</code> that represents the value of this <code>Vec3f</code>.
         * 
         * @return a string representation of this <code>Vec3f</code>.
         */
        @Override
        public String toString() {
            return "Vec3f[" + x + ", " + y + ", " + z + "]";
        }
    }

    public static interface Trail {
        /**
         * initialize/reset whatever you must
         * 
         * @param co the trailboy conto
         */
        void initialize(ContO co);

        /**
         * @param rd Graphics2D object
         * @param tx last X
         * @param ty last Y
         * @param tz last Z
         * @param nx next X
         * @param ny next Y
         * @param nz next Z
         */
        void draw(Graphics2D rd, int xz, int xy, int zy, Vec3i previous, Vec3i current);

        /**
         * Return a wrapper class around a vector
         * @param vec3i the vector to wrap around
         * @return a wrapper class with whatever crap you wanna store
         */
        default Vec3i wrap(Vec3i vec) {
            return vec;
        };
    }

    public static class ExampleTrail implements Trail {

        @Override
        public void draw(final Graphics2D rd, final int xz, final int xy, final int zy, Vec3i previous, Vec3i current) {

            final int aX[] = {
                    previous.x - Medium.x, current.x - Medium.x
            };
            final int aY[] = {
                    previous.y - Medium.y, current.y - Medium.y
            };
            final int aZ[] = {
                    previous.z - Medium.z, current.z - Medium.z
            };

            Medium.rot(aX, aZ, Medium.cx, Medium.cz, Medium.xz, 2);
            Medium.rot(aY, aZ, Medium.cy, Medium.cz, Medium.zy, 2);
            final int x2d[] = new int[2];
            final int y2d[] = new int[2];

            for (int i = 0; i < 2; i++) {
                x2d[i] = Utility.xs(aX[i], aZ[i]);
                y2d[i] = Utility.mediumYs(aY[i], aZ[i]);
            }

            rd.setColor(Color.white);
            rd.drawLine(x2d[0], y2d[0], x2d[1], y2d[1]);
        }

        @Override
        public void initialize(ContO co) {

        }

    }

    public static class ExamplePolygonTrail implements Trail {
        int vehicleYDiff = 50;

        @Override
        public void draw(final Graphics2D rd, final int xz, final int xy, final int zy, Vec3i previous, Vec3i current) {

            final int aX[] = {
                    previous.x - Medium.x, previous.x - Medium.x, current.x - Medium.x, current.x - Medium.x
            };
            final int aY[] = {
                    (previous.y - vehicleYDiff) - Medium.y, (previous.y + vehicleYDiff) - Medium.y,
                    (current.y + vehicleYDiff) - Medium.y, (current.y - vehicleYDiff) - Medium.y
            };
            final int aZ[] = {
                    previous.z - Medium.z, previous.z - Medium.z, current.z - Medium.z, current.z - Medium.z
            };

            Medium.rot(aX, aZ, Medium.cx, Medium.cz, Medium.xz, 4);
            Medium.rot(aY, aZ, Medium.cy, Medium.cz, Medium.zy, 4);
            final int x2d[] = new int[4];
            final int y2d[] = new int[4];

            for (int i = 0; i < 4; i++) {
                x2d[i] = Utility.xs(aX[i], aZ[i]);
                y2d[i] = Utility.mediumYs(aY[i], aZ[i]);
            }

            rd.setColor(Color.white);
            rd.fillPolygon(x2d, y2d, 4);
        }

        @Override
        public void initialize(ContO co) {
            vehicleYDiff = Math.min(Math.abs(co.roofat - co.grat), 50) / 2; // so we can pull from center
        }

    }

    public static class ExampleFXTrail implements Trail {
        int vehicleYDiff = 50;

        @Override
        public void draw(final Graphics2D rd, final int xz, final int xy, final int zy, Vec3i previous, Vec3i current) {

            // if x is wrong angle, do z
            final int aX[] = {
                    (previous.x - 50), (previous.x + 50), (previous.x + 50), (previous.x - 50)
            };
            final int aY[] = {
                    (previous.y - 50), (previous.y - 50), (previous.y + 50), (previous.y + 50)
            };
            final int aZ[] = {
                    previous.z, previous.z, previous.z, previous.z
            };

            //            Medium.rot(aX, aZ, previous.x, previous.z, xz, 4);
            //            Medium.rot(aY, aZ, previous.x, previous.z, zy, 4);

            // i'm sure if i added medium.x/cx/z/cz to the x/z values here it would spare me some trouble BUT i don't want to break this now
            Medium.rot(aX, aZ, previous.x, previous.z, xz, 4);

            for (int i = 0; i < 4; i++) {
                aX[i] -= Medium.x;
                aY[i] -= Medium.y;
                aZ[i] -= Medium.z;
            }

            Medium.rot(aX, aZ, Medium.cx, Medium.cz, Medium.xz, 4);
            Medium.rot(aY, aZ, Medium.cy, Medium.cz, Medium.zy, 4);
            final int x2d[] = new int[4];
            final int y2d[] = new int[4];

            for (int i = 0; i < 4; i++) {
                x2d[i] = Utility.xs(aX[i], aZ[i]);
                y2d[i] = Utility.mediumYs(aY[i], aZ[i]);
            }

            rd.setColor(new Color(ThreadLocalRandom.current().nextInt(256), ThreadLocalRandom.current().nextInt(256), ThreadLocalRandom.current().nextInt(256), 150));
            rd.fillPolygon(x2d, y2d, 4);
        }

        @Override
        public void initialize(ContO co) {
            vehicleYDiff = Math.min(Math.abs(co.roofat - co.grat), 50) / 2; // so we can pull from center
        }

    }

    public static class ExampleRandomPolyTrail implements Trail {
        private static final int nPoints = 6;
        
        int vehicleYDiff = 50;
        private static class VecNode extends Vec3i {
            private final int[] xPoints;
            private final int[] yPoints;
            private final Color color;
            
            VecNode(Vec3i vec) {
                super(vec);

                ArrayList<int[]> polys = generatePolygon( vec.x, vec.y, 50, 0.35f, 0.2f, nPoints ); // a cool effect can be achieved by replacing nPoints here with a bigger number, which chops up the polys 
                int size = polys.size();
                int[] aX = new int[size];
                int[] aY = new int[size];
                for (int i = 0; i < size; i++) {
                    int[] xyp = polys.get(i);
                    aX[i] = xyp[0];
                    aY[i] = xyp[1];
                }
                xPoints = aX;
                yPoints = aY;
                color = new Color(ThreadLocalRandom.current().nextInt(256), ThreadLocalRandom.current().nextInt(256), ThreadLocalRandom.current().nextInt(256), 150);
            }
        }

        @Override
        public void draw(final Graphics2D rd, final int xz, final int xy, final int zy, Vec3i previous, Vec3i current) {
            VecNode prevNode = (VecNode) previous;

            // if x is wrong angle, do z
            
            final int aZ[] = new int[nPoints];
            Arrays.fill(aZ, previous.z);
            final int aX[] = prevNode.xPoints.clone();
            final int aY[] = prevNode.yPoints.clone();
            
            //            Medium.rot(aX, aZ, previous.x, previous.z, xz, 4);
            //            Medium.rot(aY, aZ, previous.x, previous.z, zy, 4);

            // i'm sure if i added medium.x/cx/z/cz to the x/z values here it would spare me some trouble BUT i don't want to break this now
            Medium.rot(aX, aZ, previous.x, previous.z, xz, nPoints);

            for (int i = 0; i < nPoints; i++) {
                aX[i] -= Medium.x;
                aY[i] -= Medium.y;
                aZ[i] -= Medium.z;
            }

            Medium.rot(aX, aZ, Medium.cx, Medium.cz, Medium.xz, nPoints);
            Medium.rot(aY, aZ, Medium.cy, Medium.cz, Medium.zy, nPoints);
            final int x2d[] = new int[nPoints];
            final int y2d[] = new int[nPoints];

            for (int i = 0; i < nPoints; i++) {
                x2d[i] = Utility.xs(aX[i], aZ[i]);
                y2d[i] = Utility.mediumYs(aY[i], aZ[i]);
            }

            rd.setColor(prevNode.color);
            rd.fillPolygon(x2d, y2d, nPoints);
        }

        @Override
        public void initialize(ContO co) {
            vehicleYDiff = Math.min(Math.abs(co.roofat - co.grat), 50) / 2; // so we can pull from center
        }

        @Override
        public Vec3i wrap(Vec3i vec) {
            return new VecNode(vec);
        };
    }

    public static ArrayList<int[]> generatePolygon(int ctrX, int ctrY, int aveRadius, float irregularity, float spikeyness, int numVerts) {
        /*
         * Start with the centre of the polygon at ctrX, ctrY, 
         * then creates the polygon by sampling points on a circle around the centre. 
         * Randon noise is added by varying the angular spacing between sequential points,
         * and by varying the radial distance of each point from the centre.
         * 
         * Params:
         * ctrX, ctrY - coordinates of the "centre" of the polygon
         * aveRadius - in px, the average radius of this polygon, this roughly controls how large the polygon is, really only useful for order of magnitude.
         * irregularity - [0,1] indicating how much variance there is in the angular spacing of vertices. [0,1] will map to [0, 2pi/numberOfVerts]
         * spikeyness - [0,1] indicating how much variance there is in each vertex from the circle of radius aveRadius. [0,1] will map to [0, aveRadius]
         * numVerts - self-explanatory
         * 
         * Returns a list of vertices, in CCW order.
         * 
         * http://stackoverflow.com/a/25276331
         */

        irregularity = (float) (clip(irregularity, 0, 1) * 2 * Math.PI / numVerts);
        spikeyness = clip(spikeyness, 0, 1) * aveRadius;

        // generate n angle steps
        TFloatList angleSteps = new TFloatArrayList();
        float lower = (float) ((2 * Math.PI / numVerts) - irregularity);
        float upper = (float) ((2 * Math.PI / numVerts) + irregularity);
        float sum = 0;
        for (int i = 0; i < numVerts; i++) {
            float tmp = (float) ThreadLocalRandom.current().nextDouble(Math.min(lower, upper), Math.max(lower, upper));
            angleSteps.add(tmp);
            sum += tmp;
        }

        // normalize the steps so that point 0 and point n+1 are the same
        float k = (float) (sum / (2 * Math.PI));
        for (int i = 0; i < numVerts; i++) {
            angleSteps.set(i, angleSteps.get(i) / k);
        }

        // now generate the points
        ArrayList<int[]> points = new ArrayList<>();
        float angle = (float) ThreadLocalRandom.current().nextDouble(0, 2 * Math.PI);
        for (int i = 0; i < numVerts; i++) {
            float r_i = clip(gauss(aveRadius, spikeyness), 0, 2 * aveRadius);
            float x = (float) (ctrX + r_i * Math.cos(angle));
            float y = (float) (ctrY + r_i * Math.sin(angle));
            points.add(new int[] {
                    (int) (x), (int) (y)
            });

            angle = angle + angleSteps.get(i);
        }

        return points;
    }

//    private static float clip(float x, int min, float max) {
//        if (min > max)
//            return x;
//        else if (x < min)
//            return min;
//        else if (x > max)
//            return max;
//        else
//            return x;
//    }

    public static float clip(float x, int min, int max) {
        if (min > max)
            return x;
        else if (x < min)
            return min;
        else if (x > max)
            return max;
        else
            return x;
    }

    public static float gauss(float mu, float sigma) {
        return (float) (ThreadLocalRandom.current().nextGaussian() * sigma + mu);
    }
}
