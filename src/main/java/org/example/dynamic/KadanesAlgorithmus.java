package org.example.dynamic;
//Maximale-konsekutive Teilfolge Kadane’s Algorithmus
public class KadanesAlgorithmus {
    public static void main(String[] args) {
        int[] a = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int maxSoFar = a[0];
        int maxEndingHere = a[0];
        int end = 0, start = 0, currentStart =  0;

        for (int i = 1; i < a.length; i++) {
            if(a[i] > maxEndingHere + a[i]){
                maxEndingHere = a[i];
                currentStart = i;
            } else {
                maxEndingHere += a[i];
            }
            if(maxEndingHere > maxSoFar){
                maxSoFar = maxEndingHere;
                start = currentStart;
                end = i;
            }
        }
        System.out.println(maxSoFar + ", " + start + "-" + end);
    }
}
