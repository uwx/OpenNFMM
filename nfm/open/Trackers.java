package nfm.open;

/* nfm.open.Trackers - Decompiled by JODE extended
 * DragShot Software
 * JODE (c) 1998-2001 Jochen Hoenicke
 */
class Trackers {
    final int[][] c = new int[95000][3];
    final int[] dam = new int[95000];
    final boolean[] decor = new boolean[95000];
    int ncx = 0;
    int ncz = 0;
    final boolean[] notwall = new boolean[95000];
    int nt = 0;
    final int[] radx = new int[95000];
    final int[] rady = new int[95000];
    final int[] radz = new int[95000];
    int[][][] sect = null;
    final int[] skd = new int[95000];
    int sx = 0;
    int sz = 0;
    final int[] x = new int[95000];
    final int[] xy = new int[95000];
    final int[] y = new int[95000];
    final int[] z = new int[95000];
    final int[] zy = new int[95000];

    void devidetrackers(final int i, final int i0, final int i1, final int i2) {
        sect = null;
        sx = i;
        sz = i1;
        ncx = i0 / 3000;
        if (ncx <= 0) {
            ncx = 1;
        }
        ncz = i2 / 3000;
        if (ncz <= 0) {
            ncz = 1;
        }
        sect = new int[ncx][ncz][];
        for (int i3 = 0; i3 < ncx; i3++) {
            for (int i4 = 0; i4 < ncz; i4++) {
                final int i5 = sx + i3 * 3000 + 1500;
                final int i6 = sz + i4 * 3000 + 1500;
                final int[] is = new int[6700];
                int i7 = 0;
                for (int i8 = 0; i8 < nt; i8++) {
                    final int i9 = py(i5, x[i8], i6, z[i8]);
                    if (i9 < 20250000 && i9 > 0 && dam[i8] != 167) {
                        is[i7] = i8;
                        i7++;
                    }
                }
                if (i3 == 0 || i4 == 0 || i3 == ncx - 1 || i4 == ncz - 1) {
                    for (int i10 = 0; i10 < nt; i10++)
                        if (dam[i10] == 167) {
                            is[i7] = i10;
                            i7++;
                        }
                }
                if (i7 == 0) {
                    is[i7] = 0;
                    i7++;
                }
                sect[i3][i4] = new int[i7];
                System.arraycopy(is, 0, sect[i3][i4], 0, i7);
            }
        }
        for (int i12 = 0; i12 < nt; i12++)
            if (dam[i12] == 167) {
                dam[i12] = 1;
            }
        ncx--;
        ncz--;
    }

    private int py(final int i, final int i13, final int i14, final int i15) {
        return (i - i13) * (i - i13) + (i14 - i15) * (i14 - i15);
    }
}
