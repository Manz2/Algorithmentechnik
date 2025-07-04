package org.example.dynamic;

import java.util.HashMap;
import java.util.Map;

public class CollatzFolge {
    private static Map<Long, Integer> lengthMap = new HashMap<>();
    public static void main(String[] args) {
        int maxStart = 1;
        int maxLength = 1;

        for (int i = 2; i < 1_000_000; i++) {
            int length = collatz(i);
            if (length > maxLength) {
                maxLength = length;
                maxStart = i;
            }
        }

        System.out.println("Startwert mit längster Folge: " + maxStart);
        System.out.println("Länge der Folge: " + maxLength);
    }
    private static int collatz(long n) {
        if (n == 1) return 1;
        if (lengthMap.containsKey(n)) return lengthMap.get(n);

        long next = (n % 2 == 0) ? n / 2 : 3 * n + 1;
        int length = 1 + collatz(next);

        lengthMap.put(n, length);
        return length;
    }

}
