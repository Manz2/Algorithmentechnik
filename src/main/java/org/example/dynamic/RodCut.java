package org.example.dynamic;


public class RodCut {
    public static void main(String[] args) {
        int[] price = {2, 5, 8, 9, 10, 17, 17, 20}; // Preise für Längen 1 bis 8
        rodCut(price, price.length);
    }

    private static void rodCut(int[] price, int n) {
        int[] dp = new int[n+1]; //initialisiert mit 0
        int[] cuts = new int[n+1]; //initialisiert mit 0

        for (int i = 1; i <= n; i++) {
            int max = Integer.MIN_VALUE;
            for(int j = 1; j<=i; j++){
                if(max < dp[i-j] + price[j-1]){
                    max = dp[i-j] + price[j-1];
                    cuts[i] = j;
                }
            }
            dp[i] = max;
        }

        System.out.println("Maximaler Erlös: " + dp[n]);


        System.out.print("Schnitte: ");
        while (n > 0) {
            System.out.print(cuts[n] + " ");
            n -= cuts[n];
        }

    }
}

