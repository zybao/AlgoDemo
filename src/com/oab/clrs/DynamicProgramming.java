package com.oab.clrs;

public class DynamicProgramming {
    private int memorizedCurRodAux(int[] p, int n, int[] r) {
        if (r[n] >= 0) return r[n];
        int q;
        if (n == 0) {
            q = 0;
        } else {
            q = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                q = Math.max(q, p[i] + memorizedCurRodAux(p, n - i, r));
            }
        }

        r[n] = q;
        return q;
    }

    public int memorizedCutRod(int[] p, int n) {
        int r[] = new int[n];
        for (int i = 0; i < n; i++) {
            r[i] = Integer.MIN_VALUE;
        }

        return memorizedCurRodAux(p, n, r);
    }

    private int bootomUpCutRod(int[] p, int n) {
        int[] r = new int[n];
        r[0] = 0;

        for (int i = 1; i < n; i++) {
            int q = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                q = Math.max(q, p[j] + r[i - j]);
            }
            r[i] = q;
        }

        return r[n];
    }
}
