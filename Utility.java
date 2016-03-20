
class Utility {

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
            i437 = Integer.valueOf(string442).intValue();
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
}
