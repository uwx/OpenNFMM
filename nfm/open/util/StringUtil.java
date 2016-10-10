package nfm.open.util;

import java.util.regex.Pattern;

public class StringUtil {
    private StringUtil() {
    }

    /**
     * This function will return the amount of times the given substring appears within a specific string. In this way you can check for how many times a single letter or a phrase is repeated in a section of stored text.
     *
     * @param str The string to check.
     * @param find The substring to check the string for.
     * @return the number of instances of a substring found within a given string.
     */
    public static int count(final String str, final String find) {
        int index = 0, count = 0;
        while (true) {
            index = str.indexOf(find, index); // not +=
            if (index == -1) {
                return count;
            }
            index += find.length();
            count++;
        }
    }

    /**
     * You can use this function to remove a specific part of a string. So, you supply the input string and the start and end position within that string to remove characters (index starts at 1) and the function will return a new string without that section in it.
     *
     * @param str The string to copy and delete from.
     * @param index The position of the first character to remove.
     * @param count The number of characters to remove.
     * @return a copy of a given string with a selected section deleted.
     */
    public static String delete(final String str, final int index, final int count) {
        return str.substring(0, index) + str.substring(index + count);
    }

    /**
     * With this function you can create a new string made up of a string and a char, where one has been inserted into the other at a given position. It can be useful, for example, to add a user name into a predefined text and so make the player of your game feel more involved in the action.
     *
     * @param str The string to be copied.
     * @param substr The char to be inserted.
     * @param index The position in characters of the string to insert the substring.
     * @return a copy of a given string with a substring inserted into a chosen position.
     */
    public static String insert(final String str, final char substr, final int index) {
        return str.substring(0, index) + substr + str.substring(index, str.length());
    }

    /**
     * With this function you can create a new string made up of two strings, where one has been inserted into the other at a given position. It can be useful, for example, to add a user name into a predefined text and so make the player of your game feel more involved in the action.
     *
     * @param str The string to be copied.
     * @param substr The substring to be inserted.
     * @param index The position in characters of the string to insert the substring.
     * @return a copy of a given string with a substring inserted into a chosen position.
     */
    public static String insert(final String str, final String substr, final int index) {
        return str.substring(0, index) + substr + str.substring(index, str.length());
    }

    /**
     * This function simply returns the same string repeated a given number of times over itself.
     *
     * @param str The string to repeat.
     * @param count The number of times to repeat the string.
     * @return a copy of a given string repeated a given number of times.
     */
    public static String repeat(final String str, final int count) {
        final StringBuilder a = new StringBuilder();
        for (int i = 0; i < count; i++) {
            a.append(str);
        }
        return a.toString();
    }

    private static final Pattern letters = Pattern.compile("[^A-Za-z]");
    private static final Pattern digits = Pattern.compile("[^1234567890]");
    private static final Pattern lettersdigits = Pattern.compile("[^A-Za-z1234567890]");

    /**
     * With this function you can remove all characters that are not classed as letters. This is handy for preventing people from entering unwanted characters into a text entry (like entering "#" to force a new line).<br>
     * <br>
     * <b>Note</b>: This function only detects the 26 letter english alphabet from A - Z.<br>
     * <br>
     *
     * @param str The string to convert to letters.
     * @return a copy of a given string with everything but its letters removed.
     */
    public static String letters(final String str) {
        return letters.matcher(str).replaceAll("");
    }

    /**
     * You can use this function to parse a given string and get any numbers from it. For example, say you have this text - "I am 81 years old". With this function you would get a return string of "81".
     *
     * @param str The string to get the digits from.
     * @return a copy of a given string with everything but its digits removed.
     */
    public static String digits(final String str) {
        return digits.matcher(str).replaceAll("");
    }

    /**
     * This function will return a copy of a given string with everything but its letters and digits removed, which means it can be used to remove any unwanted characters (like "#" or "?") from, for example, a login name or a password.<br>
     * <br>
     * <b>Note</b>: This function only detects the 26 letter english alphabet from A - Z.<br>
     * <br>
     *
     * @param str The string to convert to letters and digits.
     * @return a copy of a given string with everything but its letters and digits removed.
     */
    public static String lettersdigits(final String str) {
        return lettersdigits.matcher(str).replaceAll("");
    }
}
