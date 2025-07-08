package org.example.dynamic;

public class DynamicSum {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(sum(n));
    }
    private static double sum(int n){
        double[] N = new double[n+1];
        N[0] = 1;
        for (int i = 1; i < N.length; i++) {
            double current=0;
            for (int j = 1; j <= i; j++) {
                current += N[j-1] + N[i-j];
            }
            N[i] = i+(1.0/i)*current;
        }
        return N[n];
    }
}
