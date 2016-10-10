package nfm.open.util;

import java.awt.geom.Point2D;
import java.io.Serializable;
import java.util.Comparator;

/******************************************************************************
 * Compilation:  javac Point2D.java
 * Execution:    java Point2D x0 y0 N
 * Dependencies: StdDraw.java StdRandom.java
 * <p>
 * Immutable point data type for points in the plane.
 ******************************************************************************/

/**
 * The <tt>Point</tt> class is an immutable data type to encapsulate a two-dimensional point with real-value coordinates.
 * <p>
 * Note: in order to deal with the difference behavior of double and Double with respect to -0.0 and +0.0F, the Point2D constructor converts any coordinates that are -0.0 to +0.0.
 * <p>
 * For additional documentation, see <a href="http://algs4.cs.princeton.edu/12oop">Section 1.2</a> of <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 * @author Rafael
 * @author YoYoGames (documentation)
 * @author Robert Sedgewick
 * @author Kevin Wayne
 */
public final class HPoint extends Point2D implements Comparable<HPoint>, Serializable {

    /**
     * ID for serialization.
     */
    private static final long serialVersionUID = -5366675937398638198L;

    /**
     * Compares two points by x-coordinate.
     */
    public static final Comparator<HPoint> X_ORDER = new XOrder();

    /**
     * Compares two points by y-coordinate.
     */
    public static final Comparator<HPoint> Y_ORDER = new YOrder();

    /**
     * Compares two points by polar radius.
     */
    public static final Comparator<HPoint> R_ORDER = new ROrder();

    /**
     * The X coordinate of this point.
     */
    public final int x;

    /**
     * The Y coordinate of this point.
     */
    public final int y;

    /**
     * Initializes a new point (x, y).
     *
     * @param x the x-coordinate
     * @param y the y-coordinate
     * @throws IllegalArgumentException if either <tt>x</tt> or <tt>y</tt> is <tt>Double.NaN</tt>, <tt>Double.POSITIVE_INFINITY</tt> or <tt>Double.NEGATIVE_INFINITY</tt>
     */
    public HPoint(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the x-coordinate.
     *
     * @return the x-coordinate
     * @deprecated access raw field instead ({@link #x})
     */
    @Deprecated
    public int x() {
        return x;
    }

    /**
     * Returns the y-coordinate.
     *
     * @return the y-coordinate
     * @deprecated access raw field instead ({@link #y})
     */
    @Deprecated
    public int y() {
        return y;
    }

    /**
     * Returns the polar radius of this point.
     *
     * @return the polar radius of this point in polar coordiantes: sqrt(x*x + y*y)
     */
    public float r() {
        return (float) Math.sqrt(x * x + y * y);
    }

    /**
     * Returns the angle of this point in polar coordinates.
     *
     * @return the angle (in radians) of this point in polar coordiantes (between -pi/2 and pi/2)
     */
    public float theta() {
        return (float) Math.atan2(y, x);
    }

    /**
     * Returns the angle between this point and that point.
     *
     * @return the angle in radians (between -pi and pi) between this point and that point (0 if equal)
     */
    public float angleTo(final HPoint that) {
        final int dx = that.x - x;
        final int dy = that.y - y;
        return (float) Math.atan2(dy, dx);
    }

    /**
     * The same thing as {@link #angleTo(HPoint)} but in degrees and capped
     *
     * @return the angle in degrees between this point and that point (0 if equal)
     */
    public int pointDirection(final HPoint that) {
        final int angle = (int) Math.toDegrees(Math.atan2(that.y - y, that.x - x));

        return angle < 0 ? angle + 360 : angle;
    }

    /**
     * Returns true if a->b->c is a counterclockwise turn.
     *
     * @param a first point
     * @param b second point
     * @param c third point
     * @return { -1, 0, +1 } if a->b->c is a { clockwise, collinear; counterclocwise } turn.
     */
    public static int ccw(final HPoint a, final HPoint b, final HPoint c) {
        final int area2 = (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
        if (area2 < 0) {
            return -1;
        } else if (area2 > 0) {
            return +1;
        } else {
            return 0;
        }
    }

    /**
     * Returns twice the signed area of the triangle a-b-c.
     *
     * @param a first point
     * @param b second point
     * @param c third point
     * @return twice the signed area of the triangle a-b-c
     */
    public static int area2(final HPoint a, final HPoint b, final HPoint c) {
        return (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
    }

    /**
     * Returns the Euclidean distance between this point and that point.
     *
     * @param that the other point
     * @return the Euclidean distance between this point and that point
     */
    public float distanceTo(final HPoint that) {
        final int dx = x - that.x;
        final int dy = y - that.y;
        return (float) Math.sqrt(dx * dx + dy * dy);
    }

    /**
     * Returns the square of the Euclidean distance between this point and that point.
     *
     * @param that the other point
     * @return the square of the Euclidean distance between this point and that point
     */
    public int distanceSquaredTo(final HPoint that) {
        final int dx = x - that.x;
        final int dy = y - that.y;
        return dx * dx + dy * dy;
    }

    /**
     * Compares two points by y-coordinate, breaking ties by x-coordinate. Formally, the invoking point (x0, y0) is less than the argument point (x1, y1) if and only if either y0 < y1 or if y0 = y1 and x0 < x1.
     *
     * @param that the other point
     * @return the value <tt>0</tt> if this string is equal to the argument string (precisely when <tt>equals()</tt> returns <tt>true</tt>); a negative integer if this point is less than the argument point; and a positive integer if this point is greater than the argument point
     */
    @Override
    public int compareTo(final HPoint that) {
        if (y < that.y) {
            return -1;
        }
        if (y > that.y) {
            return +1;
        }
        if (x < that.x) {
            return -1;
        }
        if (x > that.x) {
            return +1;
        }
        return 0;
    }

    /**
     * Compares two points by polar angle (between 0 and 2pi) with respect to this point.
     *
     * @return the comparator
     */
    public Comparator<HPoint> polarOrder() {
        return new PolarOrder();
    }

    /**
     * Compares two points by atan2() angle (between -pi and pi) with respect to this point.
     *
     * @return the comparator
     */
    public Comparator<HPoint> atan2Order() {
        return new Atan2Order();
    }

    /**
     * Compares two points by distance to this point.
     *
     * @return the comparator
     */
    public Comparator<HPoint> distanceToOrder() {
        return new DistanceToOrder();
    }

    // compare points according to their x-coordinate
    private static class XOrder implements Comparator<HPoint> {
        @Override
        public int compare(final HPoint p, final HPoint q) {
            if (p.x < q.x) {
                return -1;
            }
            if (p.x > q.x) {
                return +1;
            }
            return 0;
        }
    }

    // compare points according to their y-coordinate
    private static class YOrder implements Comparator<HPoint> {
        @Override
        public int compare(final HPoint p, final HPoint q) {
            if (p.y < q.y) {
                return -1;
            }
            if (p.y > q.y) {
                return +1;
            }
            return 0;
        }
    }

    // compare points according to their polar radius
    private static class ROrder implements Comparator<HPoint> {
        @Override
        public int compare(final HPoint p, final HPoint q) {
            final int delta = p.x * p.x + p.y * p.y - (q.x * q.x + q.y * q.y);
            if (delta < 0) {
                return -1;
            }
            if (delta > 0) {
                return +1;
            }
            return 0;
        }
    }

    // compare other points relative to atan2 angle (bewteen -pi/2 and pi/2) they make with this Point
    private class Atan2Order implements Comparator<HPoint> {
        @Override
        public int compare(final HPoint q1, final HPoint q2) {
            final float angle1 = angleTo(q1);
            final float angle2 = angleTo(q2);
            if (angle1 < angle2) {
                return -1;
            } else if (angle1 > angle2) {
                return +1;
            } else {
                return 0;
            }
        }
    }

    // compare other points relative to polar angle (between 0 and 2pi) they make with this Point
    private class PolarOrder implements Comparator<HPoint> {
        @Override
        public int compare(final HPoint q1, final HPoint q2) {
            final int dx1 = q1.x - x;
            final int dy1 = q1.y - y;
            final int dx2 = q2.x - x;
            final int dy2 = q2.y - y;

            if (dy1 >= 0 && dy2 < 0) {
                return -1; // q1 above; q2 below
            } else if (dy2 >= 0 && dy1 < 0) {
                return +1; // q1 below; q2 above
            } else if (dy1 == 0 && dy2 == 0) { // 3-collinear and horizontal
                if (dx1 >= 0 && dx2 < 0) {
                    return -1;
                } else if (dx2 >= 0 && dx1 < 0) {
                    return +1;
                } else {
                    return 0;
                }
            } else {
                return -ccw(HPoint.this, q1, q2); // both above or below
            }

            // Note: ccw() recomputes dx1, dy1, dx2, and dy2
        }
    }

    // compare points according to their distance to this point
    private class DistanceToOrder implements Comparator<HPoint> {
        @Override
        public int compare(final HPoint p, final HPoint q) {
            final int dist1 = distanceSquaredTo(p);
            final int dist2 = distanceSquaredTo(q);
            if (dist1 < dist2) {
                return -1;
            } else if (dist1 > dist2) {
                return +1;
            } else {
                return 0;
            }
        }
    }

    /**
     * Compares this point to the specified point.
     *
     * @param other the other point
     * @return <tt>true</tt> if this point equals <tt>other</tt>; <tt>false</tt> otherwise
     */
    @Override
    public boolean equals(final Object other) {
        if (other == this) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (other.getClass() != this.getClass()) {
            return false;
        }
        final HPoint that = (HPoint) other;
        return x == that.x && y == that.y;
    }

    /**
     * Return a string representation of this point.
     *
     * @return a string representation of this point in the format (x, y)
     */
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    /**
     * Returns an integer hash code for this point.
     *
     * @return an integer hash code for this point
     */
    @Override
    public int hashCode() {
        long bits = java.lang.Double.doubleToLongBits(x);
        bits ^= java.lang.Double.doubleToLongBits(y) * 31;
        return (int) bits ^ (int) (bits >> 32);
    }

    //
    //    /**
    //     *  <h3 class="studio">Syntax (in GML):</h3>
    //
    //        <p class="code">dot_product(x1, y1, x2, y2)</p>
    //
    //        <p><br>
    //        </p>
    //
    //        <div class="param">
    //        <table>
    //        <tbody><tr>
    //        <th>Argument (in GML)</th>
    //        <th>Description</th>
    //        </tr>
    //
    //        <tr>
    //        <td>x1</td>
    //        <td>The x coordinate of the first vector.</td>
    //        </tr>
    //
    //        <tr class="alt">
    //        <td>y1</td>
    //        <td>The y coordinate of the first vector.</td>
    //        </tr>
    //
    //        <tr>
    //        <td>x2</td>
    //        <td>The x coordinate of the second vector.</td>
    //        </tr>
    //
    //        <tr class="alt">
    //        <td>y2</td>
    //        <td>The y coordinate of the second vector.</td>
    //        </tr>
    //        </tbody></table>
    //        </div>
    //
    //        <p><br>
    //        </p>
    //
    //        <p><b>Returns:</b> Real</p>
    //
    //        <p><br>
    //        </p>
    //
    //        <h3 class="studio">Description</h3>
    //
    /**
     * <p>
     * The dot product is a value expressing the angular relationship between two vectors and is found by taking two vectors, multiplying them together and then adding the results. The name "dot product" is derived from the centered dot "·" that is often used to designate this operation (the alternative name "scalar product" emphasizes the scalar rather than vector nature of the result).<br>
     * <br>
     * The actual mathematical formula can be written like this:<br>
     * <br>
     * <img class="center" src="https://docs.yoyogames.com/source/dadiospice/002_reference/maths/vector functions/dot_product_image.png">
     * </p>
     * <p>
     * <br>
     * So, in 2D the dot product of vectors a[x1,y1] and b[x2,2] is x1x2 + y1y2, meaning that the dot_product in <i>GameMaker: Studio</i> is calculated as:<br>
     * </p>
     * <p class="code">
     * a · b = (x1*x2)+(y1*y2);<br>
     * </p>
     * <p>
     * The curious thing about the dot product is the relationship it has to the angle formed by the input vectors which can be expressed as:
     * </p>
     * <p class="code">
     * a · b = (length of a) * (length of b) * cos(angle)
     * </p>
     * <p>
     * That is to say, the dot product of two vectors will be equal to the cosine of the angle between those vectors, multiplied by the lengths of each of them. Here is an image to illustrate:<br>
     * <br>
     * <img class="center" src="https://docs.yoyogames.com/source/dadiospice/002_reference/maths/vector functions/dot_product_image_2.png">
     * </p>
     * <p>
     * There are a few things that we can now state from any two vectors in relation to the result of their dot product:
     * </p>
     * <ul>
     * <li>If a and b are perpendicular (at 90 degrees to each other), the result of the dot product will be zero, because cos(ang) will be zero</li>
     * <li>If the angle between a and b are less than 90 degrees, the dot product will be positive (greater than zero), as cos(ang) will be positive</li>
     * <li>If the angle between a and b are greater than 90 degrees, the dot product will be negative (less than zero), as cos(ang) will be negative</li>
     * </ul>
     * <p>
     * So what does this mean for those of us that make games? Well, this mathematical relationship can be used in quite a few circumstances, but the best way to see it is to build an actual scenario and see for yourself what is going on. One of the simplest ways to do this is to generate a simple "line of sight" check for an enemy in, say, a platform game so that the enemy will "see" the player if they are within 90° of either side of their vector <i>normal</i>.<br>
     * <br>
     * <img class="center" src="https://docs.yoyogames.com/source/dadiospice/002_reference/maths/vector functions/dot_product_image_1.png">
     * </p>
     * <p>
     * Basically, we have to get the vector normal from the enemy (ie: comprised of a direction and sight distance) and then we need to get the vector of the player to the enemy. We will then get the dot_product of these vectors, and if the result is positive the player has been seen, and if it is negative he hasn't. The actual code to get this working is supplied in the example below.
     * </p>
     * <p>
     * <br>
     * </p>
     * <h3 class="studio">Example (in GML):</h3>
     * <p class="code">
     * var x1, y1, x2, y2;<br>
     * x1 = lengthdir_x(1, image_angle);<br>
     * y1 = lengthdir_y(1, image_angle);<br>
     * x2 = o_Player.x - x;<br>
     * y2 = o_Player.y - y;<br>
     * if dot_product(x1, y1, x2, y2) &gt; 0 seen=true else seen=false;<br>
     * </p>
     * <p>
     * The above code creates a vector using the instances image angle, and then gets the vector of the player object "o_Player" to itself. Finally it calculates the dot product of these two vectors and if it is greater than 0 it sets the variable "seen" to true, and if it is equal to or less than 0 it sets it to "false".
     * </p>
     *
     * @return the dot product of this Vector a and b
     */
    public int dot(final HPoint that) {
        return x * that.x + y * that.y;
    }

    /**
     * @return the Euclidean norm of this Vector
     */
    public float magnitude() {
        return (float) Math.sqrt(dot(this));
    }

    /**
     * @return this + that
     */
    public HPoint add(final HPoint that) {
        return new HPoint(x + that.x, y + that.y);
    }

    /**
     * @return this - that
     */
    public HPoint subtract(final HPoint that) {
        return new HPoint(x - that.x, y - that.y);
    }

    /**
     * create and return a new object whose value is (this * factor)
     *
     * @param factor the factor to multiply by
     * @return the scaled vector
     */
    public HPoint scale(final float factor) {
        return new HPoint((int) (x * factor), (int) (y * factor));
    }

    //////////////////////////////// Methods from Point2D, deprecated because fuk u ////////////////////////////////

    /**
     * Returns the x-coordinate.
     *
     * @return the x-coordinate
     * @deprecated access raw field instead ({@link #x})
     */
    @Override
    @Deprecated
    public double getX() {
        return x;
    }

    /**
     * Returns the y-coordinate.
     *
     * @return the y-coordinate
     * @deprecated access raw field instead ({@link #y})
     */
    @Override
    @Deprecated
    public double getY() {
        return y;
    }

    /**
     * @deprecated does nothing. create a new instance instead {@link HPoint}
     */
    @Override
    @Deprecated
    public void setLocation(final double x, final double y) {
        // IMMUTABLE!!!!
    }

    /**
     * @deprecated does nothing. create a new instance instead {@link HPoint}
     */
    @Override
    @Deprecated
    public void setLocation(final Point2D y) {
        // IMMUTABLE!!!!
    }

    //////////////////////////////// MODIFIED INHERITED ////////////////////////////////

    /**
     * Returns the square of the distance from this <code>Point2D</code> to a specified point.
     *
     * @param px the X coordinate of the specified point to be measured against this <code>Point2D</code>
     * @param py the Y coordinate of the specified point to be measured against this <code>Point2D</code>
     * @return the square of the distance between this <code>Point2D</code> and the specified point.
     * @since 1.2
     */
    @Override
    public double distanceSq(double px, double py) {
        px -= x;
        py -= y;
        return px * px + py * py;
    }

    /**
     * Returns the square of the distance from this <code>Point2D</code> to a specified point.
     *
     * @param px the X coordinate of the specified point to be measured against this <code>Point2D</code>
     * @param py the Y coordinate of the specified point to be measured against this <code>Point2D</code>
     * @return the square of the distance between this <code>Point2D</code> and the specified point.
     * @since 1.2
     */
    public double distanceSq(int px, int py) {
        px -= x;
        py -= y;
        return px * px + py * py;
    }

    /**
     * Returns the square of the distance from this <code>Point2D</code> to a specified <code>Point2D</code>.
     *
     * @param pt the specified point to be measured against this <code>Point2D</code>
     * @return the square of the distance between this <code>Point2D</code> to a specified <code>Point2D</code>.
     * @since 1.2
     */
    public double distanceSq(final HPoint pt) {
        final double px = pt.x - x;
        final double py = pt.y - y;
        return px * px + py * py;
    }

    /**
     * Returns the square of the distance from this <code>Point2D</code> to a specified <code>Point2D</code>.
     *
     * @param pt the specified point to be measured against this <code>Point2D</code>
     * @return the square of the distance between this <code>Point2D</code> to a specified <code>Point2D</code>.
     * @since 1.2
     */
    @Override
    public double distanceSq(final Point2D pt) {
        final double px = pt.getX() - x;
        final double py = pt.getY() - y;
        return px * px + py * py;
    }

    /**
     * Returns the distance from this <code>Point2D</code> to a specified point.
     *
     * @param px the X coordinate of the specified point to be measured against this <code>Point2D</code>
     * @param py the Y coordinate of the specified point to be measured against this <code>Point2D</code>
     * @return the distance between this <code>Point2D</code> and a specified point.
     * @since 1.2
     */
    @Override
    public double distance(double px, double py) {
        px -= x;
        py -= y;
        return Math.sqrt(px * px + py * py);
    }

    /**
     * Returns the distance from this <code>Point2D</code> to a specified point.
     *
     * @param px the X coordinate of the specified point to be measured against this <code>Point2D</code>
     * @param py the Y coordinate of the specified point to be measured against this <code>Point2D</code>
     * @return the distance between this <code>Point2D</code> and a specified point.
     * @since 1.2
     */
    public double distance(int px, int py) {
        px -= x;
        py -= y;
        return Math.sqrt(px * px + py * py);
    }

    /**
     * Returns the distance from this <code>Point2D</code> to a specified <code>Point2D</code>.
     *
     * @param pt the specified point to be measured against this <code>Point2D</code>
     * @return the distance between this <code>Point2D</code> and the specified <code>Point2D</code>.
     * @since 1.2
     */
    public double distance(final HPoint pt) {
        final double px = pt.x - x;
        final double py = pt.y - y;
        return Math.sqrt(px * px + py * py);
    }

    /**
     * Returns the distance from this <code>Point2D</code> to a specified <code>Point2D</code>.
     *
     * @param pt the specified point to be measured against this <code>Point2D</code>
     * @return the distance between this <code>Point2D</code> and the specified <code>Point2D</code>.
     * @since 1.2
     */
    @Override
    public double distance(final Point2D pt) {
        final double px = pt.getX() - x;
        final double py = pt.getY() - y;
        return Math.sqrt(px * px + py * py);
    }

}

//Copyright © 2002–2015, Robert Sedgewick and Kevin Wayne.
//Last updated: Mon Sep 7 10:52:46 EDT 2015.
