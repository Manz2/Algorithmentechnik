package org.example.dynamic;

import java.util.ArrayList;
import java.util.List;

public class SubsetSum {
    public static void main(String[] args) {
        int[] t = {1,2,3,4,5,6,7,8,9,10};


        System.out.println("Teilmenge gefunden: " + sum(t,22));
    }
    private static List<Integer> sum(int[] t, int n){
        boolean[][] dp = new boolean[t.length+1][n+1];

        for (int i = 0; i <= t.length; i++) {
            dp[i][0] = true; // Summe 0 ist immer möglich (leere Menge)
        }

        for (int i = 1; i <= t.length; i++) {
            for (int j = 0; j <= n; j++) {
                if (dp[i - 1][j]) {
                    dp[i][j] = true;
                } else if (j - t[i - 1] >= 0 && dp[i - 1][j - t[i - 1]]) {
                    dp[i][j] = true;
                }
            }
        }


        if (!dp[t.length][n]) {
            return null;
        }

        List<Integer> subset = new ArrayList<>();
        int i = t.length;
        int j = n;
        while (i > 0 && j > 0) {
            if (dp[i - 1][j]) {
                // Element t[i-1] wurde NICHT gewählt
                i--;
            } else {
                // Element t[i-1] wurde gewählt
                subset.add(t[i - 1]);
                j -= t[i - 1];
                i--;
            }
        }

        return subset;
    }
}
