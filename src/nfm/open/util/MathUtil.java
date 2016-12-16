package nfm.open.util;

import static nfm.open.Medium.cm;

import java.math.BigDecimal;
import java.util.concurrent.ThreadLocalRandom;

import nfm.open.Medium;

/**
 * The Class RadicalMath. <br>
 * <br>
 * This is a utility class, so it can't be inherited.
 *
 * @author Rafael
 */
public final class MathUtil {

    public static float sin_m_zy;
    public static float cos_m_zy;
    public static float sin_m_xz;
    public static float cos_m_xz;
    public static float sin_m_xy;
    public static float cos_m_xy;

    /**
     * Table of cosine values
     *
     * @see #SIN_TABLE
     */
    private static final float[] COS_TABLE = new float[360];

    /**
     * Table of sine values
     *
     * @see #COS_TABLE
     */
    private static final float[] SIN_TABLE = new float[360];

    /**
     * Phi, the golden ratio, as a double-precision floating point integer.
     *
     * @see #f_GOLDEN_RATIO
     * @see #GOLDEN_RATIO
     */
    public static final double d_GOLDEN_RATIO = (1D + Math.sqrt(5D)) / 2D;

    /**
     * Phi, the golden ratio, as a single-precision floating point integer.
     *
     * @see #d_GOLDEN_RATIO
     * @see #GOLDEN_RATIO
     */
    public static final float f_GOLDEN_RATIO = (float) ((1F + Math.sqrt(5F)) / 2F);

    /**
     * Phi, the golden ratio, as a double-precision floating point integer.
     *
     * @see #d_GOLDEN_RATIO
     * @see #f_GOLDEN_RATIO
     */
    public static final float GOLDEN_RATIO = f_GOLDEN_RATIO;

    static {
        //3.14159265358979323846 / 180 = 0.01745329251994329576922
        for (int i = 0; i < 360; i++) {
            COS_TABLE[i] = (float) Math.cos(i * 0.01745329251994329576922);
        }
        for (int i = 0; i < 360; i++) {
            SIN_TABLE[i] = (float) Math.sin(i * 0.01745329251994329576922);
        }
    }

    private final static float EPSILON = 0.0000001F;
    private final static double EPSILON_DOUBLE = 0.0000001D;

    /**
     * Don't let anyone instantiate this class.
     */
    private MathUtil() {
    }

    public static int fibonacci(final int n) {
        return (int) Math.floor(Math.pow((1 + Math.sqrt(5)) / 2, n) / Math.sqrt(5) + 1 / 2);
    }

    /**
     * Returns the cosine of i
     *
     * @param i the number, in degrees
     * @return the cosine of i
     * @see #sin(int)
     */
    public static float cos(int i) {
        for (/**/; i >= 360; i -= 360) {

        }
        for (/**/; i < 0; i += 360) {

        }
        return COS_TABLE[i];
    }

    /**
     * Returns the sine of i
     *
     * @param i the number, in degrees
     * @return the sine of i
     * @see #cos(int)
     */
    public static float sin(int i) {
        for (/**/; i >= 360; i -= 360) {

        }
        for (/**/; i < 0; i += 360) {

        }
        return SIN_TABLE[i];
    }

    /**
     * Increments to angle (degrees), wrapping around if necessary
     *
     * @param i the angle
     * @param i1 the value to increment
     * @return angle, snapped if necessary
     */
    public static int angleAdd(int i, final int i1) {
        i += i1;
        while (i >= 360) {
            i -= 360;
        }
        while (i < 0) {
            i += 360;
        }
        return i;
    }

    /**
     * With this function you can maintain an input value between a specified range.
     *
     * @param val The value to clamp.
     * @param min The minimum value to clamp between.
     * @param max The maximum value to clamp between.
     * @return a value clamped between the specified minimum and maximum.
     * @see #clamp(int, int, int)
     */
    public static float clamp(final float val, final float min, final float max) {
        return Math.max(min, Math.min(max, val));
    }

    /**
     * With this function you can maintain an input value between a specified range.
     *
     * @param val The value to clamp.
     * @param min The minimum value to clamp between.
     * @param max The maximum value to clamp between.
     * @return a value clamped between the specified minimum and maximum.
     * @see #clamp(float, float, float)
     */
    public static int clamp(final int val, final int min, final int max) {
        return Math.max(min, Math.min(max, val));
    }

    /**
     * <p>
     * With this function you can find the value that equates to the position between two other values for a given percentage. So if you do, for example:
     * </p>
     * {@code lerp(0, 10, 0.5)}
     * <p>
     * you would get the return value of 5, which is 50% of the input values. You can extrapolate using this function too, by supplying a positive or negative value for the interpolation amount so that doing something like:
     * </p>
     * {@code lerp(0, 10, 2)}
     * <p>
     * will return a value of 20.<br>
     * <br>
     * </p>
     *
     * @param a The first value.
     * @param b The second value.
     * @param f The amount to interpolate.
     * @return the linear interpolation of two input values by the given amount.
     * @see #lerp(int, int, float)
     */
    public static float lerp(final float a, final float b, final float f) {
        return a * (1.0f - f) + b * f;
    }

    /**
     * <p>
     * With this function you can find the value that equates to the position between two other values for a given percentage. So if you do, for example:
     * </p>
     * {@code lerp(0, 10, 0.5)}
     * <p>
     * you would get the return value of 5, which is 50% of the input values. You can extrapolate using this function too, by supplying a positive or negative value for the interpolation amount so that doing something like:
     * </p>
     * {@code lerp(0, 10, 2)}
     * <p>
     * will return a value of 20.<br>
     * <br>
     * </p>
     *
     * @param a The first value.
     * @param b The second value.
     * @param f The amount to interpolate.
     * @return the linear interpolation of two input values by the given amount.
     * @see #lerp(float, float, float)
     */
    public static int lerp(final int a, final int b, final float f) {
        //return (int) (a + f * (b - a));
        return (int) (a * (1.0f - f) + b * f);
    }

    /**
     * This function returns the fractional part of n, that is, the part behind the decimal dot. It will return only the decimals behind the dot of a value, so frac(3.125) will return 0.125, frac(6.921) will return 0.921, etc...
     *
     * @param n The number to change.
     * @return the decimal part of the given number.
     */
    public static float frac(final float n) {
        return BigDecimal.valueOf(n).divideAndRemainder(BigDecimal.ONE)[1].floatValue();
    }

    /**
     * Gets a focus point value for an amount.
     *
     * @param fov the fov
     * @return the focus point
     */
    public static int getFocusPoint(final int fov) {
        return (int) (Medium.cx[cm] * Math.tan(Math.abs(180 - fov) * 0.5 * 0.0174532925199432957));
    }

    /**
     * Check the equality of two floats.
     *
     * @see #dEquals(double, double)
     */
    public static boolean fEquals(final float a, final float b) {
        return Math.abs(a - b) < MathUtil.EPSILON;
    }

    /**
     * Check the equality of two doubles.
     *
     * @see #fEquals(float, float)
     */
    public static boolean dEquals(final double a, final double b) {
        return Math.abs(a - b) < MathUtil.EPSILON_DOUBLE;
    }

    /**
     * Pick a random item from an array.
     *
     * @param is The array.
     * @return The item.
     * @author Rafael
     */
    @SafeVarargs
    public static <E> E choose(final E... is) {
        return is[ThreadLocalRandom.current().nextInt(is.length)];
    }

    /**
     * A much faster square root method for integers. Uses Tim's Fast-square-root method.
     *
     * @param x the number to get the square root of
     * @return the square root of that number
     * @see <a href="http://www.java-gaming.org/topics/hotspot-intrinsics/27010/view.html">Java-Gaming thread on HotSpot optimizations</a>
     */
    public static int sqrt(final int x) {
        if (x < 289)
            return SquareRoot.fastSqrt(x);
        return SquareRoot.sqrt(x);
    }

    /*
     * Uses Newton's method, not sure if faster than ATOMS (which might use newton?)
     * from http://stackoverflow.com/a/21626924

    private static final int debruijn= 0x07C4ACDD;
    //private static final long debruijn= ( ~0x0218A392CD3D5DBFL)>>>6;
    
    static
    {
      for(int x= 0; x<32; ++x)
      {
        final long v= ~( -2L<<(x));
        DeBruijnArray[(v*debruijn)>>>27]= x; //>>>58
      }
      for(int x= 0; x<32; ++x)
        SQRT[x]= (int) (Math.sqrt((1L<<DeBruijnArray[x])*Math.sqrt(2)));
    }
    
    public static int sqrt(final int num)
    {
      int y;
      if(num==0)
        return num;
      {
        int v= num;
        v|= v>>>1; // first round up to one less than a power of 2
        v|= v>>>2;
        v|= v>>>4;
        v|= v>>>8;
        v|= v>>>16;
        //v|= v>>>32;
        y= SQRT[(v*debruijn)>>>27]; //>>>58
      }
      //y= (y+num/y)>>>1;
      y= (y+num/y)>>>1;
      y= (y+num/y)>>>1;
      y= (y+num/y)>>>1;
      return y*y>num?y-1:y;
    }
    
     */

    /*
    ATOMS
    Fast integer square roots in Java

    Here are several fast integer square root methods, written in Java, including:
    sqrt(x) agrees completely with (int)(java.lang.Math.sqrt(x)) for x < 2147483648 (i.e. 2^31), while executing about three times faster than it1.

    fast_sqrt(x) agrees completely with (int)(java.lang.Math.sqrt(x)) for x < 289 (and provides a reasonable approximation thereafter), while executing about five times faster than it1.

    SquareRoot.java - fast integer square root class;
    SquareRootTest.java - basic speed and accuracy test class.
    Thanks to Paul Hsieh's square root page for the accurate algorithm.
    This code has been placed in the public domain.

    Can you improve on the speed or accuracy of these methods (without chewing an "unreasonable" quantity of cache with a huge look-up table)?

    If so, drop us a line, and hopefully we'll put your name up in lights.

    [1: your mileage may vary]



    tim@tt1.org | http://atoms.org.uk/
    */

    /*
     * Integer Square Root function
     * Contributors include Arne Steinarson for the basic approximation idea, Dann
     * Corbit and Mathew Hendry for the first cut at the algorithm, Lawrence Kirby
     * for the rearrangement, improvments and range optimization, Paul Hsieh
     * for the round-then-adjust idea, Tim Tyler, for the Java port
     * and Jeff Lawson for a bug-fix and some code to improve accuracy.
     *
     *
     * v0.02 - 2003/09/07
     */

    /**
     * Faster replacements for (int)(java.lang.Math.sqrt(integer))
     */
    public static class SquareRoot {
        final static int[] table = { // TODO could this be an array of short or char instead?
                0, 16, 22, 27, 32, 35, 39, 42, 45, 48, 50, 53, 55, 57, 59, 61, 64, 65, 67, 69, 71, 73, 75, 76, 78, 80,
                81, 83, 84, 86, 87, 89, 90, 91, 93, 94, 96, 97, 98, 99, 101, 102, 103, 104, 106, 107, 108, 109, 110,
                112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 128, 128, 129, 130, 131, 132,
                133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144, 144, 145, 146, 147, 148, 149, 150, 150, 151,
                152, 153, 154, 155, 155, 156, 157, 158, 159, 160, 160, 161, 162, 163, 163, 164, 165, 166, 167, 167, 168,
                169, 170, 170, 171, 172, 173, 173, 174, 175, 176, 176, 177, 178, 178, 179, 180, 181, 181, 182, 183, 183,
                184, 185, 185, 186, 187, 187, 188, 189, 189, 190, 191, 192, 192, 193, 193, 194, 195, 195, 196, 197, 197,
                198, 199, 199, 200, 201, 201, 202, 203, 203, 204, 204, 205, 206, 206, 207, 208, 208, 209, 209, 210, 211,
                211, 212, 212, 213, 214, 214, 215, 215, 216, 217, 217, 218, 218, 219, 219, 220, 221, 221, 222, 222, 223,
                224, 224, 225, 225, 226, 226, 227, 227, 228, 229, 229, 230, 230, 231, 231, 232, 232, 233, 234, 234, 235,
                235, 236, 236, 237, 237, 238, 238, 239, 240, 240, 241, 241, 242, 242, 243, 243, 244, 244, 245, 245, 246,
                246, 247, 247, 248, 248, 249, 249, 250, 250, 251, 251, 252, 252, 253, 253, 254, 254, 255
        };

        /**
         * A faster replacement for (int)(java.lang.Math.sqrt(x)). Completely accurate for x < 2147483648 (i.e. 2^31)...
         */
        static int sqrt(final int x) {
            int xn;

            if (x >= 0x10000) {
                if (x >= 0x1000000) {
                    if (x >= 0x10000000) {
                        if (x >= 0x40000000) {
                            xn = table[x >> 24] << 8;
                        } else {
                            xn = table[x >> 22] << 7;
                        }
                    } else {
                        if (x >= 0x4000000) {
                            xn = table[x >> 20] << 6;
                        } else {
                            xn = table[x >> 18] << 5;
                        }
                    }

                    xn = xn + 1 + x / xn >> 1;
                    xn = xn + 1 + x / xn >> 1;
                    return xn * xn > x ? --xn : xn;
                } else {
                    if (x >= 0x100000) {
                        if (x >= 0x400000) {
                            xn = table[x >> 16] << 4;
                        } else {
                            xn = table[x >> 14] << 3;
                        }
                    } else {
                        if (x >= 0x40000) {
                            xn = table[x >> 12] << 2;
                        } else {
                            xn = table[x >> 10] << 1;
                        }
                    }

                    xn = xn + 1 + x / xn >> 1;

                    return xn * xn > x ? --xn : xn;
                }
            } else {
                if (x >= 0x100) {
                    if (x >= 0x1000) {
                        if (x >= 0x4000) {
                            xn = table[x >> 8] + 1;
                        } else {
                            xn = (table[x >> 6] >> 1) + 1;
                        }
                    } else {
                        if (x >= 0x400) {
                            xn = (table[x >> 4] >> 2) + 1;
                        } else {
                            xn = (table[x >> 2] >> 3) + 1;
                        }
                    }

                    return xn * xn > x ? --xn : xn;
                } else {
                    if (x >= 0)
                        return table[x] >> 4;
                }
            }

            illegalArgument();
            return -1;
        }

        /**
         * A faster replacement for (int)(java.lang.Math.sqrt(x)). Completely accurate for x < 2147483648 (i.e. 2^31)... Adjusted to more closely approximate "(int)(java.lang.Math.sqrt(x) + 0.5)" by Jeff Lawson.
         */
        static int accurateSqrt(final int x) {
            int xn;

            if (x >= 0x10000) {
                if (x >= 0x1000000) {
                    if (x >= 0x10000000) {
                        if (x >= 0x40000000) {
                            xn = table[x >> 24] << 8;
                        } else {
                            xn = table[x >> 22] << 7;
                        }
                    } else {
                        if (x >= 0x4000000) {
                            xn = table[x >> 20] << 6;
                        } else {
                            xn = table[x >> 18] << 5;
                        }
                    }

                    xn = xn + 1 + x / xn >> 1;
                    xn = xn + 1 + x / xn >> 1;
                    return adjustment(x, xn);
                } else {
                    if (x >= 0x100000) {
                        if (x >= 0x400000) {
                            xn = table[x >> 16] << 4;
                        } else {
                            xn = table[x >> 14] << 3;
                        }
                    } else {
                        if (x >= 0x40000) {
                            xn = table[x >> 12] << 2;
                        } else {
                            xn = table[x >> 10] << 1;
                        }
                    }

                    xn = xn + 1 + x / xn >> 1;

                    return adjustment(x, xn);
                }
            } else {
                if (x >= 0x100) {
                    if (x >= 0x1000) {
                        if (x >= 0x4000) {
                            xn = table[x >> 8] + 1;
                        } else {
                            xn = (table[x >> 6] >> 1) + 1;
                        }
                    } else {
                        if (x >= 0x400) {
                            xn = (table[x >> 4] >> 2) + 1;
                        } else {
                            xn = (table[x >> 2] >> 3) + 1;
                        }
                    }

                    return adjustment(x, xn);
                } else {
                    if (x >= 0)
                        return adjustment(x, table[x] >> 4);
                }
            }

            illegalArgument();
            return -1;
        }

        private static int adjustment(final int x, int xn) {
            // Added by Jeff Lawson:
            // need to test:
            //   if  |xn * xn - x|  >  |x - (xn-1) * (xn-1)|  then xn-1 is more accurate
            //   if  |xn * xn - x|  >  |(xn+1) * (xn+1) - x|  then xn+1 is more accurate
            // or, for all cases except x == 0:
            //    if  |xn * xn - x|  >  x - xn * xn + 2 * xn - 1 then xn-1 is more accurate
            //    if  |xn * xn - x|  >  xn * xn + 2 * xn + 1 - x then xn+1 is more accurate
            final int xn2 = xn * xn;

            // |xn * xn - x|
            int comparitor0 = xn2 - x;
            if (comparitor0 < 0) {
                comparitor0 = -comparitor0;
            }

            final int twice_xn = xn << 1;

            // |x - (xn-1) * (xn-1)|
            int comparitor1 = x - xn2 + twice_xn - 1;
            if (comparitor1 < 0) { // need to correct for x == 0 case?
                comparitor1 = -comparitor1; // only gets here when x == 0
            }

            // |(xn+1) * (xn+1) - x|
            final int comparitor2 = xn2 + twice_xn + 1 - x;

            if (comparitor0 > comparitor1)
                return comparitor1 > comparitor2 ? ++xn : --xn;

            return comparitor0 > comparitor2 ? ++xn : xn;
        }

        /**
         * A *much* faster replacement for (int)(java.lang.Math.sqrt(x)). Completely accurate for x < 289...
         */
        static int fastSqrt(final int x) {
            if (x >= 0x10000) {
                if (x >= 0x1000000) {
                    if (x >= 0x10000000) {
                        if (x >= 0x40000000)
                            return table[x >> 24] << 8;
                        else
                            return table[x >> 22] << 7;
                    } else if (x >= 0x4000000)
                        return table[x >> 20] << 6;
                    else
                        return table[x >> 18] << 5;
                } else if (x >= 0x100000) {
                    if (x >= 0x400000)
                        return table[x >> 16] << 4;
                    else
                        return table[x >> 14] << 3;
                } else if (x >= 0x40000)
                    return table[x >> 12] << 2;
                else
                    return table[x >> 10] << 1;
            } else if (x >= 0x100) {
                if (x >= 0x1000) {
                    if (x >= 0x4000)
                        return table[x >> 8];
                    else
                        return table[x >> 6] >> 1;
                } else if (x >= 0x400)
                    return table[x >> 4] >> 2;
                else
                    return table[x >> 2] >> 3;
            } else if (x >= 0)
                return table[x] >> 4;
            illegalArgument();
            return -1;
        }

        private static void illegalArgument() {
            throw new IllegalArgumentException("Attemt to take the square root of negative number");
        }

        /**
         * From http://research.microsoft.com/~hollasch/cgindex/math/introot.html where it is presented by Ben Discoe (rodent@netcom.COM) Not terribly speedy...
         */

        /*
         static int unrolled_sqrt(int x) {
            int v;
            int t = 1<<30;
            int r = 0;
            int s;

            s = t + r; r>>= 1;
            if (s <= x) { x -= s; r |= t;} t >>= 2;
            s = t + r; r>>= 1;
            if (s <= x) { x -= s; r |= t;} t >>= 2;
            s = t + r; r>>= 1;
            if (s <= x) { x -= s; r |= t;} t >>= 2;
            s = t + r; r>>= 1;
            if (s <= x) { x -= s; r |= t;} t >>= 2;
            s = t + r; r>>= 1;
            if (s <= x) { x -= s; r |= t;} t >>= 2;
            s = t + r; r>>= 1;
            if (s <= x) { x -= s; r |= t;} t >>= 2;
            s = t + r; r>>= 1;
            if (s <= x) { x -= s; r |= t;} t >>= 2;
            s = t + r; r>>= 1;
            if (s <= x) { x -= s; r |= t;} t >>= 2;
            s = t + r; r>>= 1;
            if (s <= x) { x -= s; r |= t;} t >>= 2;
            s = t + r; r>>= 1;
            if (s <= x) { x -= s; r |= t;} t >>= 2;
            s = t + r; r>>= 1;
            if (s <= x) { x -= s; r |= t;} t >>= 2;
            s = t + r; r>>= 1;
            if (s <= x) { x -= s; r |= t;} t >>= 2;
            s = t + r; r>>= 1;
            if (s <= x) { x -= s; r |= t;} t >>= 2;
            s = t + r; r>>= 1;
            if (s <= x) { x -= s; r |= t;} t >>= 2;
            s = t + r; r>>= 1;
            if (s <= x) { x -= s; r |= t;} t >>= 2;
            s = t + r; r>>= 1;
            if (s <= x) { x -= s; r |= t;}

            return r;
         }
        */

        /**
         * Mark Borgerding's algorithm... Not terribly speedy...
         */

        /*
         static int mborg_sqrt(int val) {
            int guess=0;
            int bit = 1 << 15;
            do {
               guess ^= bit;
               // check to see if we can set this bit without going over sqrt(val)...
               if (guess * guess > val )
                  guess ^= bit;  // it was too much, unset the bit...
            } while ((bit >>= 1) != 0);

            return guess;
         }
        */

        /**
         * Taken from http://www.jjj.de/isqrt.cc Code not tested well... Attributed to: http://www.tu-chemnitz.de/~arndt/joerg.html / email: arndt@physik.tu-chemnitz.de Slow.
         */

        /*
         final static int BITS = 32;
         final static int NN = 0;  // range: 0...BITSPERLONG/2

         final static int test_sqrt(int x) {
            int i;
            int a = 0;                   // accumulator...
            int e = 0;                   // trial product...
            int r;

            r=0;                         // remainder...

            for (i=0; i < (BITS/2) + NN; i++)
            {
               r <<= 2;
               r +=  (x >> (BITS - 2));
               x <<= 2;

               a <<= 1;
               e = (a << 1)+1;

               if(r >= e)
               {
                  r -= e;
                  a++;
               }
            }

            return a;
         }
        */

        /*
        // Totally hopeless performance...
         static int test_sqrt(int n) {
            float r = 2.0F;
            float s = 0.0F;
            for(; r < (float)n / r; r *= 2.0F);
            for(s = (r + (float)n / r) / 2.0F; r - s > 1.0F; s = (r + (float)n / r) / 2.0F) {
               r = s;
            }

            return (int)s;
         }
        */
    }

    /*
     * Test Integer Square Root function
     */

    public static class SquareRootTest {
        //        public static void main(final String args[]) {
        //            final int x = -2;
        //            debug("" + (x == -2L));
        //
        //            // perform timings...
        //            //testSpeed();
        //
        //            // accuracy test...
        //            testAccuracy();
        //
        //            // hang...
        //            do {
        //            } while (true);
        //        }

        @SuppressWarnings("unused")
        static void testSpeed() {
            int i;
            long newtime;
            long oldtime;
            final int N = 10000000;
            final int mask = (1 << 16) - 1;

            // SquareRoot.fast_sqrt()...
            oldtime = System.currentTimeMillis();

            for (i = 0; i < N; i++) {
                final int temp = SquareRoot.fastSqrt(i & mask);
            }

            newtime = System.currentTimeMillis();
            debug("SquareRoot.fast_sqrt:" + (newtime - oldtime));

            // SquareRoot.sqrt()...
            oldtime = System.currentTimeMillis();

            for (i = 0; i < N; i++) {
                final int temp = SquareRoot.sqrt(i & mask);
            }

            newtime = System.currentTimeMillis();
            debug("SquareRoot.sqrt:" + (newtime - oldtime));

            /*
               // SquareRoot.mborg_sqrt()...
               oldtime = System.currentTimeMillis();

               for (i = 0; i < N; i++) {
              temp = SquareRoot.mborg_sqrt(i & mask);
               }

               newtime = System.currentTimeMillis();
               debug("SquareRoot.mborg_sqrt:" + (newtime - oldtime));


               // SquareRoot.test_sqrt()...
               oldtime = System.currentTimeMillis();

               for (i = 0; i < N; i++) {
              temp = SquareRoot.test_sqrt(i & mask);
               }

               newtime = System.currentTimeMillis();
               debug("SquareRoot.test_sqrt:" + (newtime - oldtime));
            */

            // java.lang.Math.sqrt()...
            oldtime = System.currentTimeMillis();

            for (i = 0; i < N; i++) {
                final int temp = (int) java.lang.Math.sqrt(i & mask);
            }

            newtime = System.currentTimeMillis();
            debug("java.lang.Math.sqrt:" + (newtime - oldtime));
        }

        @SuppressWarnings("unused")
        static void testAccuracy() {
            int i;
            int a;
            int b;
            int c;
            int d;
            int e;
            final int start = 0;
            int last_wrong_value = 0;

            for (i = start;; i++) {
                a = (int) java.lang.Math.sqrt(i);
                b = (int) (java.lang.Math.sqrt(i) + 0.5);
                c = SquareRoot.sqrt(i);
                d = SquareRoot.fastSqrt(i);
                e = SquareRoot.accurateSqrt(i);
                // e = SquareRoot.mborg_sqrt(i);
                // f = SquareRoot.test_sqrt(i);

                if (b != e) {
                    //if (a > (last_wrong_value * 1.05)) { // don't print too many wrong values - just a sample...
                    last_wrong_value = a;
                    debug("N:" + i + " - Math.sqrt:" + a + " - Math.sqrt+:" + b + " - accurateSqrt:" + e + " - sqrt:" + c);
                }
                //}
            }
        }

        final static void debug(final String o) {
            System.out.println(o);
        }
    }
}
