package org.example.divideAndConquer;

import java.util.Arrays;

import static java.lang.Math.abs;

public class SummeDerBeträge {
    public static void main(String[] args) {
        int[] a = new int[]{-3, 5, -1, 4};
        System.out.println(sum(a));
    }

    private static int sum(int[] a){
        if(a.length == 1){
            return abs(a[0]);
        }
        int middle = a.length /2;
        int[] first = Arrays.copyOfRange(a,0,middle);
        int[] second = Arrays.copyOfRange(a,middle,a.length);

        return sum(first) + sum(second);
    }
}

// Komplexität = Mastertheorem alpha = log2 (2) = 1 ==> Fall1 O(n)