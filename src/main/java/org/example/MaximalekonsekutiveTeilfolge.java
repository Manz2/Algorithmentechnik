package org.example;
//Maximale-konsekutive Teilfolge iterativ
public class MaximalekonsekutiveTeilfolge {
    public static void main(String[] args) {
        int[] a = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int max = 0;
        for(int i = 0; i<=a.length-1; i++){
            int imax = 0;
            for(int j = 0; j<=i; j++){
                int sum = 0;
                for(int k = j; k<=i;k++){
                    sum += a[k];
                }
                imax = Math.max(imax, sum);
            }
            max = Math.max(imax, max);
        }
        System.out.println(max);
    }
}
