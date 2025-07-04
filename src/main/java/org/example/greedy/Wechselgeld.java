package org.example.greedy;

import java.util.Arrays;

public class Wechselgeld {
    public static void main(String[] args) {
        int[] coins = new int[]{1, 5, 10, 20, 50};
        int n = 73;
        change(coins, n);
    }

    public static void change(int[] coins, int n) {
        int current = 0;
        Arrays.sort(coins); // O(k log k) k = Anzahl der Münztypen
        System.out.println("Coins: ");
        for (int i = coins.length - 1; i >= 0; i--) { // O(n)
            while (current + coins[i] <= n) {
                current += coins[i];
                System.out.print(coins[i] + ", ");
            }
        }
    }
}
