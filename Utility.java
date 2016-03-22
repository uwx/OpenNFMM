import java.util.Arrays;

class Utility {

    /**
     * This is an utility class, so it can't be inherited.
     */
    private Utility() {
    }
    
    /**
     * Gets a value from a string in format:
     * string(value1,value2,value3...)
     *
     *
     * @param string The variable name (e.g: foo(bar) = foo)
     * @param string262 The string (single line) to get the value from
     * @param i The position of the value (starting from 0)
     * @return An integer containing the value
     */
    static int getvalue(final String string, final String string262, final int i) {
        int i263 = 0;
        String string264 = "";
        for (int i265 = string.length() + 1; i265 < string262.length(); i265++) {
            final String string266 = "" + string262.charAt(i265);
            if (string266.equals(",") || string266.equals(")")) {
                i263++;
                i265++;
            }
            if (i263 == i) {
                string264 = "" + string264 + string262.charAt(i265);
            }
        }
        return Integer.parseInt(string264);
    }

    /**
     * Gets a value from a string like: a|b|c|0|1|2|
     * @param string the string to get the value from
     * @param i the value position
     * @return the value at the position
     */
    public static int getServerValue(final String string, final int i) {
        int i437 = -1;
        try {
            int i438 = 0;
            int i439 = 0;
            int i440 = 0;
            String string441 = "";
            String string442 = "";
            for (; i438 < string.length() && i440 != 2; i438++) {
                string441 = "" + string.charAt(i438);
                if (string441.equals("|")) {
                    i439++;
                    if (i440 == 1 || i439 > i) {
                        i440 = 2;
                    }
                } else if (i439 == i) {
                    string442 = "" + string442 + string441;
                    i440 = 1;
                }
            }
            if (string442.equals("")) {
                string442 = "-1";
            }
            i437 = Integer.parseInt(string442);
        } catch (final Exception exception) {

        }
        return i437;
    }

    /**
     * Turns a 3D XY coordinate into a 2D X perspective coordinate.
     *
     * @param x3d
     *            The 3D X point
     * @param y3d
     *            The 3D Y point
     * @param m the Medium
     * @return The 2D X coordinate.
     */
    static int xs(final int x3d, int y3d, final Medium m) {
        if (y3d < m.cz) {
            y3d = m.cz;
        }
        return (y3d - m.focusPoint) * (m.cx - x3d) / y3d + x3d;
    }

    /**
     * Turns a 3D ZY coordinate into a 2D Y perspective coordinate.
     *
     * @param z3d
     *            The 3D Z point
     * @param y3d
     *            The 3D Y point
     * @param m the Medium
     * @return The 2D Y coordinate.
     */
    static int ys(final int z3d, int y3d, final Medium m) {
        if (y3d < m.cz) {
            y3d = m.cz;
        }
        return (y3d - m.focusPoint) * (m.cy - z3d) / y3d + z3d;
    }

    // alt

    /**
     * A variant of {@link Utility#xs(int, int, Medium)}.
     *
     * @see Utility#xs(int, int, Medium)
     * @param x3d
     *            The 3D X point
     * @param y3d
     *            The 3D Y point
     * @param m the Medium
     * @return The 2D X coordinate.
     */
    static int altXs(final int x3d, int y3d, final Medium m) {
        if (y3d < 50) {
            y3d = 50;
        }
        return (y3d - m.focusPoint) * (m.cx - x3d) / y3d + x3d;
    }

    /**
     * A variant of {@link Utility#ys(int, int, Medium)}.
     *
     * @see Utility#ys(int, int, Medium)
     * @param z3d
     *            The 3D Z point
     * @param y3d
     *            The 3D Y point
     * @param m the Medium
     * @return The 2D Y coordinate.
     */
    static int altYs(final int z3d, int y3d, final Medium m) {
        if (y3d < 50) {
            y3d = 50;
        }
        return (y3d - m.focusPoint) * (m.cy - z3d) / y3d + z3d;
    }

    // medium

    /*static public int mediumXs(final int i, int i272) {
    	if (i272 < m.cz)
    		i272 = m.cz;
    	return (i272 - m.focusPoint) * (m.cx - i) / i272 + i;
    }*/

    /**
     * A variant of {@link Utility#ys(int, int, Medium)}.
     *
     * @see Utility#ys(int, int, Medium)
     * @param z3d
     *            The 3D Z point
     * @param y3d
     *            The 3D Y point
     * @param m the Medium
     * @return The 2D Y coordinate.
     */
    static int mediumYs(final int z3d, int y3d, final Medium m) {
        if (y3d < 10) {
            y3d = 10;
        }
        return (y3d - m.focusPoint) * (m.cy - z3d) / y3d + z3d;
    }

    /**
     * Converts an IP Adress to a byte array.
     *
     * @author Rafael
     * @param ip a String containing an IP address in the format: ABC.DEF.GHI.JKL
     * @return a byte array with the values of the IP, useful for {@link java.net.InetAddress#getByAddress(byte[]) InetAddress.getByAddress}
     */
    public static byte[] ipToBytes(final String ip) {
        final byte[] ipBytes = new byte[4];
        int i = 0;
        for (final String quarter : ip.split("\\.")) {
            ipBytes[i] = (byte) (Integer.parseInt(quarter) & 0xFF);
            i++;
        }
        return ipBytes;
    }
    
    /**
     * Probably not the cleanest thing I've written, just use a loop or smartFill instead
     *
     * @author Rafael
     * @param arr An array containing an array
     * @param val The value to set the underlying variables of the underlying arrays' items to
     */
    @Deprecated
    static <T> void deepFill(final T[] arr, final Object val) {
        if (arr != null && arr.length > 0) {
            if (arr[0] instanceof int[]) {
                for (final T key : arr) {
                    Arrays.fill((int[]) key, (int) val);
                }
            } else if (arr[0] instanceof short[]) {
                for (final T key : arr) {
                    Arrays.fill((short[]) key, (short) val);
                }
            } else if (arr[0] instanceof byte[]) {
                for (final T key : arr) {
                    Arrays.fill((byte[]) key, (byte) val);
                }
            } else if (arr[0] instanceof long[]) {
                for (final T key : arr) {
                    Arrays.fill((long[]) key, (long) val);
                }
            } else if (arr[0] instanceof float[]) {
                for (final T key : arr) {
                    Arrays.fill((float[]) key, (float) val);
                }
            } else if (arr[0] instanceof double[]) {
                for (final T key : arr) {
                    Arrays.fill((double[]) key, (double) val);
                }
            } else if (arr[0] instanceof Object[]) {
                for (final T key : arr) {
                    deepFill((Object[]) key, val);
                }
            }
        }
    }

    /**
     * From the Java Programmer's FAQ Part B Sect 6: <br>
     * <br>
     * Initialize a smaller piece of the array and use the System.arraycopy
     * call to fill in the rest of the array in an expanding binary fashion.
     * <br><br>
     * "allows a much shorter loop by handing some of the work off to the
     * System class, which (if the JVM you're using is smart enough) can be
     * turned into a memset operation"
     */
    public static void smartFill(final byte[] array, final byte value) {
        final int len = array.length;

        if (len > 0) {
            array[0] = value;
        }

        for (int i = 1; i < len; i += i) {
            System.arraycopy(array, 0, array, i, len - i < i ? len - i : i);
        }
    }

    /**
     * From the Java Programmer's FAQ Part B Sect 6: <br>
     * <br>
     * Initialize a smaller piece of the array and use the System.arraycopy
     * call to fill in the rest of the array in an expanding binary fashion.
     * <br><br>
     * "allows a much shorter loop by handing some of the work off to the
     * System class, which (if the JVM you're using is smart enough) can be
     * turned into a memset operation"
     */
    public static void smartFill(final short[] array, final short value) {
        final int len = array.length;

        if (len > 0) {
            array[0] = value;
        }

        for (int i = 1; i < len; i += i) {
            System.arraycopy(array, 0, array, i, len - i < i ? len - i : i);
        }
    }

    /**
     * From the Java Programmer's FAQ Part B Sect 6: <br>
     * <br>
     * Initialize a smaller piece of the array and use the System.arraycopy
     * call to fill in the rest of the array in an expanding binary fashion.
     * <br><br>
     * "allows a much shorter loop by handing some of the work off to the
     * System class, which (if the JVM you're using is smart enough) can be
     * turned into a memset operation"
     */
    public static void smartFill(final char[] array, final char value) {
        final int len = array.length;

        if (len > 0) {
            array[0] = value;
        }

        for (int i = 1; i < len; i += i) {
            System.arraycopy(array, 0, array, i, len - i < i ? len - i : i);
        }
    }

    /**
     * From the Java Programmer's FAQ Part B Sect 6: <br>
     * <br>
     * Initialize a smaller piece of the array and use the System.arraycopy
     * call to fill in the rest of the array in an expanding binary fashion.
     * <br><br>
     * "allows a much shorter loop by handing some of the work off to the
     * System class, which (if the JVM you're using is smart enough) can be
     * turned into a memset operation"
     */
    public static void smartFill(final int[] array, final int value) {
        final int len = array.length;

        if (len > 0) {
            array[0] = value;
        }

        for (int i = 1; i < len; i += i) {
            System.arraycopy(array, 0, array, i, len - i < i ? len - i : i);
        }
    }

    /**
     * From the Java Programmer's FAQ Part B Sect 6: <br>
     * <br>
     * Initialize a smaller piece of the array and use the System.arraycopy
     * call to fill in the rest of the array in an expanding binary fashion.
     * <br><br>
     * "allows a much shorter loop by handing some of the work off to the
     * System class, which (if the JVM you're using is smart enough) can be
     * turned into a memset operation"
     */
    public static void smartFill(final long[] array, final long value) {
        final int len = array.length;

        if (len > 0) {
            array[0] = value;
        }

        for (int i = 1; i < len; i += i) {
            System.arraycopy(array, 0, array, i, len - i < i ? len - i : i);
        }
    }

    /**
     * From the Java Programmer's FAQ Part B Sect 6: <br>
     * <br>
     * Initialize a smaller piece of the array and use the System.arraycopy
     * call to fill in the rest of the array in an expanding binary fashion.
     * <br><br>
     * "allows a much shorter loop by handing some of the work off to the
     * System class, which (if the JVM you're using is smart enough) can be
     * turned into a memset operation"
     */
    public static void smartFill(final float[] array, final float value) {
        final int len = array.length;

        if (len > 0) {
            array[0] = value;
        }

        for (int i = 1; i < len; i += i) {
            System.arraycopy(array, 0, array, i, len - i < i ? len - i : i);
        }
    }

    /**
     * From the Java Programmer's FAQ Part B Sect 6: <br>
     * <br>
     * Initialize a smaller piece of the array and use the System.arraycopy
     * call to fill in the rest of the array in an expanding binary fashion.
     * <br><br>
     * "allows a much shorter loop by handing some of the work off to the
     * System class, which (if the JVM you're using is smart enough) can be
     * turned into a memset operation"
     */
    public static void smartFill(final double[] array, final double value) {
        final int len = array.length;

        if (len > 0) {
            array[0] = value;
        }

        for (int i = 1; i < len; i += i) {
            System.arraycopy(array, 0, array, i, len - i < i ? len - i : i);
        }
    }

    /**
     * From the Java Programmer's FAQ Part B Sect 6: <br>
     * <br>
     * Initialize a smaller piece of the array and use the System.arraycopy
     * call to fill in the rest of the array in an expanding binary fashion.
     * <br><br>
     * "allows a much shorter loop by handing some of the work off to the
     * System class, which (if the JVM you're using is smart enough) can be
     * turned into a memset operation"
     */
    public static void smartFill(final Object[] array, final Object value) {
        final int len = array.length;

        if (len > 0) {
            array[0] = value;
        }

        for (int i = 1; i < len; i += i) {
            System.arraycopy(array, 0, array, i, len - i < i ? len - i : i);
        }
    }

    /**
     * From the Java Programmer's FAQ Part B Sect 6: <br>
     * <br>
     * Initialize a smaller piece of the array and use the System.arraycopy
     * call to fill in the rest of the array in an expanding binary fashion.
     * <br><br>
     * "allows a much shorter loop by handing some of the work off to the
     * System class, which (if the JVM you're using is smart enough) can be
     * turned into a memset operation"
     */
    public static void smartFill(final boolean[] array, final boolean value) {
        final int len = array.length;

        if (len > 0) {
            array[0] = value;
        }

        for (int i = 1; i < len; i += i) {
            System.arraycopy(array, 0, array, i, len - i < i ? len - i : i);
        }
    }
}
