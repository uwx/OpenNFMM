package nfm.open.util;

/**
 * Utility class for math dealing with polygons
 *
 * @author Rafael
 * @author YoYoGames (documentation)
 * @author Robert Sedgewick
 * @author Kevin Wayne
 */
public final class VectorUtil {
    private VectorUtil() {
    }

    /**
     * Calculates the distance between two points. <br>
     * You might want to inline calls to this method if you don't like JVM optimizations. <br>
     * Do note that calls to Math.pow(x,2) are <a href="http://hg.openjdk.java.net/jdk8u/jdk8u/hotspot/file/5755b2aee8e8/src/share/vm/opto/library_call.cpp#l1799">inlined to x*x</a>
     *
     * @param x1 the x1
     * @param y1 the y1
     * @param x2 the x2
     * @param y2 the y2
     * @return the the distance between two points
     */
    public static int distance(final int x1, final int y1, final int x2, final int y2) {
        return (int) Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }

    /**
     * Calculates the 3D distance between two points. <br>
     * You might want to inline calls to this method if you don't like JVM optimizations. <br>
     * Do note that calls to Math.pow(x,2) are <a href="http://hg.openjdk.java.net/jdk8u/jdk8u/hotspot/file/5755b2aee8e8/src/share/vm/opto/library_call.cpp#l1799">inlined to x*x</a>
     *
     * @param x1 the x1
     * @param y1 the y1
     * @param z1 the z1
     * @param x2 the x2
     * @param y2 the y2
     * @param z2 the z2
     * @return the the distance between two points
     */
    public static double getDistance(final int x1, final int y1, final int z1, final int x2, final int y2, final int z2) {
        final int dx = x1 - x2;
        final int dy = y1 - y2;
        final int dz = z1 - z2;

        // We should avoid Math.pow or Math.hypot due to perfomance reasons
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    /**
     * Calculates the 3D distance between two points. <br>
     * You might want to inline calls to this method if you don't like JVM optimizations. <br>
     * Do note that calls to Math.pow(x,2) are <a href="http://hg.openjdk.java.net/jdk8u/jdk8u/hotspot/file/5755b2aee8e8/src/share/vm/opto/library_call.cpp#l1799">inlined to x*x</a>
     *
     * @param x1 the x1
     * @param y1 the y1
     * @param z1 the z1
     * @param x2 the x2
     * @param y2 the y2
     * @param z2 the z2
     * @return the the distance between two points
     */
    public static double getDistance(final float x1, final float y1, final float z1, final float x2, final float y2, final float z2) {
        final float dx = x1 - x2;
        final float dy = y1 - y2;
        final float dz = z1 - z2;

        // We should avoid Math.pow or Math.hypot due to perfomance reasons
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    public static int pointDirection(final int x, final int y, final int tX, final int tY) {
        final int angle = (int) Math.toDegrees(Math.atan2(tY - y, tX - x));

        return angle < 0 ? angle + 360 : angle;
    }

    /**
     * Length (angular) of a shortest way between two angles. It will be in range [0, 180].<br>
     * <br>
     * <p>
     * This function will return the smallest angle difference between two angles as a value between -180 and 180 degrees (where a positive angle is anti-clockwise and a negative angle clockwise).
     * </p>
     * <h3 class="studio">Example (in GML):</h3>
     * <p class="code" style="font-family:'Consolas','Lucida Console', monospace">
     * var pd = point_direction(x, y, mouse_x, mouse_y);<br>
     * var dd = angle_difference(image_angle, pd);<br>
     * image_angle -= min(abs(dd), 10) * sign(dd);<br>
     * </p>
     * <p>
     * The above code will get the angle of direction from the instance to the mouse cursor, then get the difference between that angle and the current <tt>image_angle</tt>, using this value to slowly rotate towards the mouse.
     * </p>
     *
     * @param alpha The first angle to use.
     * @param beta The second angle to use.
     * @return the shortest way (angle difference) between two angles.
     */
    public static int angleDifference(final int alpha, final int beta) {
        final int phi = Math.abs(beta - alpha) % 360; // This is either the distance or 360 - distance
        return phi > 180 ? 360 - phi : phi;
    }

    /**
     * A merged version of {@link #lengthDirectionX(int, int)} and {@link #lengthDirectionY(int, int)} that returns an array instead of individual values
     *
     * @param len The length away of the point to return.
     * @param dir The direction of the point to return.
     * @return the x and y components of a position "len" pixels from the starting point and in direction "dir".
     */
    public static int[] lengthDirection(final int len, final int dir) {
        return new int[] {
                (int) (MathUtil.sin(dir) * len), (int) (MathUtil.cos(dir) * len)
        };
    }

    /**
     * This function seems confusing at first, but it's not really. It is used to get the x component of a position "len" pixels from the starting point and in direction "dir". Imagine a circle around your instance, then imagine a point anywhere on that circle. To move to that point we need to move the object so many pixels in that direction... so this function (when used with {@link #lengthDirectionY(int, int)}) gets the position of that point on the circle to be used in code by the instance.
     *
     * @param len The length away of the point to return.
     * @param dir The direction of the point to return.
     * @return the horizontal x-component of the vector determined by the indicated length and direction.
     */
    public static int lengthDirectionX(final int len, final int dir) {
        return (int) (MathUtil.sin(dir) * len);
    }

    /**
     * This function seems confusing at first, but it's not really. It is used to get the y component of a position "len" pixels from the starting point and in direction "dir". Imagine a circle around your instance, then imagine a point anywhere on that circle. To move to that point we need to move the object so many pixels in that direction... so this function (when used with {@link #lengthDirectionX(int, int)}) gets the position of that point on the circle to be used in code by the instance.
     *
     * @param len The length away of the point to return.
     * @param dir The direction of the point to return.
     * @return the vertical y-component of the vector determined by the indicated length and direction.
     */
    public static int lengthDirectionY(final int len, final int dir) {
        return (int) (MathUtil.cos(dir) * len);
    }

    // METHODS FROM HPOINT

    /**
     * Returns the polar radius of a point.
     *
     * @return the polar radius of a point in polar coordiantes: sqrt(x*x + y*y)
     */
    public static float r(final int x, final int y) {
        return (float) Math.sqrt(x * x + y * y);
    }

    /**
     * Returns the angle of this point in polar coordinates.
     *
     * @return the angle (in radians) of this point in polar coordiantes (between -pi/2 and pi/2)
     */
    public static float theta(final int x, final int y) {
        return (float) Math.atan2(y, x);
    }

    /**
     * Returns the angle between this point and that point.
     *
     * @return the angle in radians (between -pi and pi) between this point and that point (0 if equal)
     */
    public static float angleTo(final int x, final int y, final int thatx, final int thaty) {
        final int dx = thatx - x;
        final int dy = thaty - y;
        return (float) Math.atan2(dy, dx);
    }

    /**
     * Returns true if a->b->c is a counterclockwise turn.
     *
     * @return { -1, 0, +1 } if a->b->c is a { clockwise, collinear; counterclocwise } turn.
     */
    public static int ccw(final int ax, final int ay, final int bx, final int by, final int cx, final int cy) {
        final int area2 = (bx - ax) * (cy - ay) - (by - ay) * (cx - ax);
        if (area2 < 0)
            return -1;
        else if (area2 > 0)
            return +1;
        else
            return 0;
    }

    /**
     * Returns twice the signed area of the triangle a-b-c.
     *
     * @return twice the signed area of the triangle a-b-c
     */
    public static int area2(final int ax, final int ay, final int bx, final int by, final int cx, final int cy) {
        return (bx - ax) * (cy - ay) - (by - ay) * (cx - ax);
    }

    /**
     * Returns the Euclidean distance between this point and that point.
     *
     * @return the Euclidean distance between this point and that point
     */
    public static float distanceTo(final int x, final int y, final int thatx, final int thaty) {
        final int dx = x - thatx;
        final int dy = y - thaty;
        return (float) Math.sqrt(dx * dx + dy * dy);
    }

    /**
     * Returns the square of the Euclidean distance between this point and that point.
     *
     * @return the square of the Euclidean distance between this point and that point
     */
    public static int distanceSquaredTo(final int x, final int y, final int thatx, final int thaty) {
        final int dx = x - thatx;
        final int dy = y - thaty;
        return dx * dx + dy * dy;
    }

    /**
     * Compares two points by y-coordinate, breaking ties by x-coordinate. Formally, the invoking point (x0, y0) is less than the argument point (x1, y1) if and only if either y0 < y1 or if y0 = y1 and x0 < x1.
     *
     * @return the value <tt>0</tt> if this string is equal to the argument string (precisely when <tt>equals()</tt> returns <tt>true</tt>); a negative integer if this point is less than the argument point; and a positive integer if this point is greater than the argument point
     */
    public static int compare(final int x, final int y, final int thatx, final int thaty) {
        if (y < thaty)
            return -1;
        if (y > thaty)
            return +1;
        if (x < thatx)
            return -1;
        if (x > thatx)
            return +1;
        return 0;
    }

    /**
     * Compares a point to the specified point.
     *
     * @return <tt>true</tt> if this point equals <tt>other</tt>; <tt>false</tt> otherwise
     */
    public static boolean equals(final int x, final int y, final int thatx, final int thaty) {
        return x == thatx && y == thaty;
    }

    /**
     * Return a string representation of a point.
     *
     * @return a string representation of a point in the format (x, y)
     */
    public static String toString(final int x, final int y) {
        return "(" + x + ", " + y + ")";
    }

    /**
     * Returns an integer hash code for a point.
     *
     * @return an integer hash code for a point
     */
    public static int hashCode(final int x, final int y) {
        final int hashX = ((Integer) x).hashCode();
        final int hashY = ((Integer) y).hashCode();
        return 31 * hashX + hashY;
    }

    //
    //    /**
    //     *  <h3 class="studio">Syntax (in GML):</h3>
    //
    //        <p class="code" style="font-family:'Consolas','Lucida Console', monospace">dot_product(x1, y1, x2, y2)</p>
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
     * <p class="code" style="font-family:'Consolas','Lucida Console', monospace">
     * a · b = (x1*x2)+(y1*y2);<br>
     * </p>
     * <p>
     * The curious thing about the dot product is the relationship it has to the angle formed by the input vectors which can be expressed as:
     * </p>
     * <p class="code" style="font-family:'Consolas','Lucida Console', monospace">
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
     * <p class="code" style="font-family:'Consolas','Lucida Console', monospace">
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
     * @return the dot product of a vector a and b
     */
    public static int dot(final int x, final int y, final int thatx, final int thaty) {
        return x * thatx + y * thaty;
    }

    /**
     * @return the Euclidean norm of a vector
     */
    public float magnitude(final int x, final int y, final int thatx, final int thaty) {
        return (float) Math.sqrt(dot(x, y, thatx, thaty));
    }

    /**
     * @return this + that
     */
    public HPoint add(final int x, final int y, final int thatx, final int thaty) {
        return new HPoint(x + thatx, y + thaty);
    }

    /**
     * @return this - that
     */
    public HPoint subtract(final int x, final int y, final int thatx, final int thaty) {
        return new HPoint(x - thatx, y - thaty);
    }

    /**
     * create and return a new array vector whose value is (this * factor)
     *
     * @param factor the factor to multiply by
     * @return the scaled vector array
     */
    public static int[] scale(final int x, final int y, final float factor) {
        return new int[] {
                (int) (x * factor), (int) (y * factor)
        };
    }
}
