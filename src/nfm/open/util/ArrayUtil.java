package nfm.open.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayUtil {
    private ArrayUtil() {
    }

    /**
     * Reverses an array of bytes.
     *
     * @param data The array to reverse.
     */
    public static void reverse(final byte[] data) {
        for (int left = 0, right = data.length - 1; left < right; left++, right--) {
            // swap the values at the left and right indices
            final byte temp = data[left];
            data[left] = data[right];
            data[right] = temp;
        }
    }

    /**
     * Reverses an array of elements.
     *
     * @param data The array to reverse.
     */
    public static <E> void reverse(final E[] data) {
        for (int left = 0, right = data.length - 1; left < right; left++, right--) {
            // swap the values at the left and right indices
            final E temp = data[left];
            data[left] = data[right];
            data[right] = temp;
        }
    }

    @SuppressWarnings("unchecked")
    public static <E> E[] removeElement(final E[] array, final int index) {
        final List<E> list = new ArrayList<>(Arrays.asList(array));
        list.remove(index);
        return list.toArray((E[]) new Object[list.size()]);
    }

    public static int[] removeElement(final int[] input, final int index) {
        final List<Integer> result = new ArrayList<>();

        for (int i = 0; i < input.length; i++) {
            if (i != index) {
                result.add(input[i]);
            }
        }

        return toIntArray(result);
    }

    public static int[] toIntArray(final List<Integer> list) {
        final int[] ret = new int[list.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }
}
