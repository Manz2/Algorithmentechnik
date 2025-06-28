package org.example.dynamic;

public class Partition {

    static void partition(int n) {
        int k, no;
        int[] x = new int[500];
        int[] s = new int[500];
        boolean isSucc;

        k = 1;
        no = 0;
        x[k] = 0;
        s[0] = 0;

        while (k > 0) {
            // Geeigneten Summanden finden
            do {
                isSucc = isSuccessor(x[k], n);
                if (isSucc) {
                    x[k]++;
                    s[k] = s[k - 1] + x[k];
                }
            } while (isSucc && !isCandidate(s[k], n));

            if (isSucc) {
                if (s[k] == n) {
                    writeSolution(x, k);
                    no++;
                } else {
                    k++;
                    x[k] = x[k - 1] - 1;
                }
            } else {
                k--;
            }
        }

        System.out.println("Anzahl der Loesungen: " + no);
    }

    static boolean isCandidate(int s, int n) {
        return s <= n;
    }

    static boolean isSuccessor(int x, int n) {
        return x < n;
    }

    static void writeSolution(int[] x, int k) {
        for (int i = 1; i <= k; i++) {
            System.out.print(x[i]);
            if (i < k) {
                System.out.print(" + ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 4;  // Beispielwert, kannst du ändern
        partition(n);
    }
}
