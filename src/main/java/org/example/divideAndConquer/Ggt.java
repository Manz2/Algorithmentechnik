package org.example.divideAndConquer;

import java.util.Arrays;

public class Ggt {
    public static void main(String[] args) {
        int[] a = new int[]{48, 64, 32, 96};
        System.out.println(all(a));
    }

    private static int all(int[] a){
        if(a.length == 2){
            return ggt(a[0], a[1]);
        }
        if(a.length == 1) {
            return a[0];
        }
        int middle = a.length /2;
        int[] first = Arrays.copyOfRange(a,0,middle);
        int[] second = Arrays.copyOfRange(a,middle,a.length);

        int c = all(first);
        int d = all(second);

        return ggt(c,d);
    }

    private static int ggt(int a, int b){
        int bigger = Math.max(a, b);
        int smaller = Math.min(a,b);

        int rest = bigger % smaller;
        if(rest == 0){
            return smaller;
        }
        return ggt(rest,smaller);
    }
}
