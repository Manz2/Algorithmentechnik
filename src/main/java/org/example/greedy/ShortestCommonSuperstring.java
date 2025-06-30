package org.example.greedy;

import java.util.*;

public class ShortestCommonSuperstring {

    public static void main(String[] args) {
        List<String> input = new ArrayList<>(List.of("catgc", "ctaagt", "gcta", "ttca", "atgcatc"));
        String result = greedySuperstring(input);
        System.out.println("Shortest common superstring: " + result);
    }

    public static String greedySuperstring(List<String> strings) {
        while (strings.size() > 1) {
            int maxOverlap = -1;
            int bestI = 0, bestJ = 0;
            String merged = "";

            for (int i = 0; i < strings.size(); i++) {
                for (int j = 0; j < strings.size(); j++) {
                    if (i == j) continue;
                    String s1 = strings.get(i);
                    String s2 = strings.get(j);
                    int overlap = getOverlap(s1, s2);
                    if (overlap > maxOverlap) {
                        maxOverlap = overlap;
                        bestI = i;
                        bestJ = j;
                        merged = s1 + s2.substring(overlap);
                    }
                }
            }

            // Strings ersetzen
            if (bestI > bestJ) {
                strings.remove(bestI);
                strings.remove(bestJ);
            } else {
                strings.remove(bestJ);
                strings.remove(bestI);
            }
            strings.add(merged);
        }

        return strings.get(0);
    }

    // Gibt die Länge des maximalen Overlaps zurück: Suffix von a = Prefix von b
    private static int getOverlap(String a, String b) {
        int max = Math.min(a.length(), b.length());
        for (int i = max; i > 0; i--) {
            if (a.endsWith(b.substring(0, i))) {
                return i;
            }
        }
        return 0;
    }
}
