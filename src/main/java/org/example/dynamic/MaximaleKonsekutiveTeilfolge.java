package org.example.dynamic;

public class MaximaleKonsekutiveTeilfolge {
    public static void main(String[] args) {
        int[] a = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[][] res = new int[a.length][a.length];
        res[0][0] = a[0];
        int max = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;
        for(int i = 1; i<= a.length-1; i++){
            for(int j = 0; j<= i; j++){
                res[i][j] = res[i-1][j] + a[i];
                if(res[i][j] > max){
                    max = res[i][j];
                    start = j;
                    end = i;
                }
            }
        }
        System.out.println("Maximale Summe= " + max + " von Index: " + start + " bis: " + end);
    }
}

// Laufzeit O(n^2)
