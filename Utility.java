
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
    public static int getvalue(final String string, final String string262, final int i) {
        int i263 = 0;
        String string264 = "";
        for (int i265 = string.length() + 1; i265 < string262.length(); i265++) {
            final String string266 = new StringBuilder().append("").append(string262.charAt(i265)).toString();
            if (string266.equals(",") || string266.equals(")")) {
                i263++;
                i265++;
            }
            if (i263 == i)
                string264 = new StringBuilder().append(string264).append(string262.charAt(i265)).toString();
        }
        return Float.valueOf(string264).intValue();
    }

    /**
     * Allan please add comments
     * @param string
     * @param i
     * @return
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
                string441 = new StringBuilder().append("").append(string.charAt(i438)).toString();
                if (string441.equals("|")) {
                    i439++;
                    if (i440 == 1 || i439 > i)
                        i440 = 2;
                } else if (i439 == i) {
                    string442 = new StringBuilder().append(string442).append(string441).toString();
                    i440 = 1;
                }
            }
            if (string442.equals(""))
                string442 = "-1";
            i437 = Integer.valueOf(string442).intValue();
        } catch (final Exception exception) {
            
        }
        return i437;
    }

    /**
     * Turns a 3D XY coordinate into a 2D X perspective coordinate.
     *
     * @param i
     *            The 3D X point
     * @param i161
     *            The 3D Y point
     * @return The 2D X coordinate.
     */
    public static int xs(final int i, int i338, final Medium m) {
        if (i338 < m.cz)
            i338 = m.cz;
        return (i338 - m.focusPoint) * (m.cx - i) / i338 + i;
    }

    /**
     * Turns a 3D ZY coordinate into a 2D Y perspective coordinate.
     *
     * @param i
     *            The 3D Z point
     * @param i161
     *            The 3D Y point
     * @return The 2D Y coordinate.
     */
    public static int ys(final int i, int i339, final Medium m) {
        if (i339 < m.cz)
            i339 = m.cz;
        return (i339 - m.focusPoint) * (m.cy - i) / i339 + i;
    }

    // alt

    public static int altXs(final int i, int i260, final Medium m) {
        if (i260 < 50)
            i260 = 50;
        return (i260 - m.focusPoint) * (m.cx - i) / i260 + i;
    }

    public static int altYs(final int i, int i261, final Medium m) {
        if (i261 < 50)
            i261 = 50;
        return (i261 - m.focusPoint) * (m.cy - i) / i261 + i;
    }

    // medium

    /*static public int mediumXs(final int i, int i272) {
    	if (i272 < m.cz)
    		i272 = m.cz;
    	return (i272 - m.focusPoint) * (m.cx - i) / i272 + i;
    }*/

    static public int mediumYs(final int i, int i273, final Medium m) {
        if (i273 < 10)
            i273 = 10;
        return (i273 - m.focusPoint) * (m.cy - i) / i273 + i;
    }
}
