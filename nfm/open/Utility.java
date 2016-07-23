package nfm.open;

class Utility {

    /**
     * Gets a value from a string in format:
     * string(value1,value2,value3...)
     *
     * @param string      The variable name (e.g: foo(bar) = foo)
     * @param string_262_ The string (single line) to get the value from
     * @param i           The position of the value (starting from 0)
     * @return An integer containing the value
     */
    public static int getvalue(final String string, final String string_262_, final int i) {
        int i_263_ = 0;
        String string_264_ = "";
        for (int i_265_ = string.length() + 1; i_265_ < string_262_.length(); i_265_++) {
            final String string_266_ = "" + string_262_.charAt(i_265_);
            if (string_266_.equals(",") || string_266_.equals(")")) {
                i_263_++;
                i_265_++;
            }
            if (i_263_ == i)
                string_264_ = string_264_ + string_262_.charAt(i_265_);
        }
        return Float.valueOf(string_264_).intValue();
    }

    /**
     * Allan please add comments
     *
     * @param string
     * @param i
     * @return
     */
    public static int getServerValue(final String string, final int i) {
        int i_437_ = -1;
        try {
            int i_438_ = 0;
            int i_439_ = 0;
            int i_440_ = 0;
            String string_441_;
            String string_442_ = "";
            for ( /**/ ; i_438_ < string.length() && i_440_ != 2; i_438_++) {
                string_441_ = "" + string.charAt(i_438_);
                if (string_441_.equals("|")) {
                    i_439_++;
                    if (i_440_ == 1 || i_439_ > i)
                        i_440_ = 2;
                } else if (i_439_ == i) {
                    string_442_ = string_442_ + string_441_;
                    i_440_ = 1;
                }
            }
            if (string_442_.equals(""))
                string_442_ = "-1";
            i_437_ = Integer.valueOf(string_442_);
        } catch (final Exception exception) {
            /* empty */
        }
        return i_437_;
    }

    /**
     * Turns a 3D XY coordinate into a 2D X perspective coordinate.
     *
     * @param i      The 3D X point
     * @param i_338_ The 3D Y point
     * @return The 2D X coordinate.
     */
    public static int xs(final int i, int i_338_, Medium m) {
        if (i_338_ < m.cz)
            i_338_ = m.cz;
        return (i_338_ - m.focus_point) * (m.cx - i) / i_338_ + i;
    }

    /**
     * Turns a 3D ZY coordinate into a 2D Y perspective coordinate.
     *
     * @param i      The 3D Z point
     * @param i_339_ The 3D Y point
     * @return The 2D Y coordinate.
     */
    public static int ys(final int i, int i_339_, Medium m) {
        if (i_339_ < m.cz)
            i_339_ = m.cz;
        return (i_339_ - m.focus_point) * (m.cy - i) / i_339_ + i;
    }

    // alt

    public static int altXs(final int i, int i_260_, Medium m) {
        if (i_260_ < 50)
            i_260_ = 50;
        return (i_260_ - m.focus_point) * (m.cx - i) / i_260_ + i;
    }

    public static int altYs(final int i, int i_261_, Medium m) {
        if (i_261_ < 50)
            i_261_ = 50;
        return (i_261_ - m.focus_point) * (m.cy - i) / i_261_ + i;
    }

    // medium

    /*static public int mediumXs(final int i, int i_272_) {
        if (i_272_ < m.cz)
    		i_272_ = m.cz;
    	return (i_272_ - m.focus_point) * (m.cx - i) / i_272_ + i;
    }*/

    static public int mediumYs(final int i, int i_273_, Medium m) {
        if (i_273_ < 10)
            i_273_ = 10;
        return (i_273_ - m.focus_point) * (m.cy - i) / i_273_ + i;
    }
}
