import java.util.Arrays;

final class Utility {

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
        return Float.valueOf(string264).intValue();
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
     * @param i
     *            The 3D X point
     * @param i338
     *            The 3D Y point
     * @param m the Medium
     * @return The 2D X coordinate.
     */
    static int xs(final int i, int i338, final Medium m) {
        if (i338 < m.cz) {
            i338 = m.cz;
        }
        return (i338 - m.focusPoint) * (m.cx - i) / i338 + i;
    }

    /**
     * Turns a 3D ZY coordinate into a 2D Y perspective coordinate.
     *
     * @param i
     *            The 3D Z point
     * @param i339
     *            The 3D Y point
     * @param m the Medium
     * @return The 2D Y coordinate.
     */
    static int ys(final int i, int i339, final Medium m) {
        if (i339 < m.cz) {
            i339 = m.cz;
        }
        return (i339 - m.focusPoint) * (m.cy - i) / i339 + i;
    }

    // alt

    static int altXs(final int i, int i260, final Medium m) {
        if (i260 < 50) {
            i260 = 50;
        }
        return (i260 - m.focusPoint) * (m.cx - i) / i260 + i;
    }

    static int altYs(final int i, int i261, final Medium m) {
        if (i261 < 50) {
            i261 = 50;
        }
        return (i261 - m.focusPoint) * (m.cy - i) / i261 + i;
    }

    // medium

    /*static public int mediumXs(final int i, int i272) {
    	if (i272 < m.cz)
    		i272 = m.cz;
    	return (i272 - m.focusPoint) * (m.cx - i) / i272 + i;
    }*/

    static int mediumYs(final int i, int i273, final Medium m) {
        if (i273 < 10) {
            i273 = 10;
        }
        return (i273 - m.focusPoint) * (m.cy - i) / i273 + i;
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
