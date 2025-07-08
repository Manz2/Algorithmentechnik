package org.example.greedy;

import java.util.ArrayList;
import java.util.List;

public class Partition {

    static int count = 0;

    public static void main(String[] args) {
        int n = 5;
        List<Integer> current = new ArrayList<>();
        partition(n, 1, current);
        System.out.println("Anzahl der Partitionen: " + count);
    }

    private static void partition(int n, int start, List<Integer> current) {
        if (isCandidate(current, n)) {
            System.out.println(current);
            count++;
            return;
        }

        for (int i = start; i <= n; i++) {
            if (isSuccessor(i, current, n)) {
                current.add(i);
                partition(n, i, current); // i statt i+1, weil Wiederholung erlaubt ist
                current.removeLast();
            }
        }
    }

    // (1) isCandidate – prüft, ob aktuelle Liste eine gültige Lösung ist
    private static boolean isCandidate(List<Integer> list, int n) {
        return sum(list) == n;
    }

    // (2) isSuccessor – prüft, ob i als nächster Summand erlaubt ist
    private static boolean isSuccessor(int x, List<Integer> list, int n) {
        return sum(list) + x <= n;
    }

    private static int sum(List<Integer> list) {
        int s = 0;
        for (int val : list) {
            s += val;
        }
        return s;
    }
}
