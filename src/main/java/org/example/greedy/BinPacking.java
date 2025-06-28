package org.example.greedy;

import java.util.*;

public class BinPacking {

    private static int binPacking(List<Double> elements, double binSize) {
        Collections.sort(elements);
        double currentBin;
        int binCounter = 0;
        while (!elements.isEmpty()) {
            currentBin = binSize;
            binCounter++;
            System.out.print("Bin with Elements: ");
            for (int i = elements.size() - 1; i >= 0; i--) {
                if (currentBin - elements.get(i) >= 0) {
                    currentBin -= elements.get(i);
                    System.out.print(elements.get(i) + " ");
                    elements.remove(i);
                }
            }
            System.out.println("Final size: " + currentBin);
        }
        return binCounter;
    }

    public static void main(String[] args) {
        Double[] n = {0.4, 0.8, 0.2, 0.7, 0.3};
        List<Double> r = new ArrayList<>(Arrays.asList(n));
        int bins = binPacking(r, 1.1);
        System.out.println("Bins: " + bins);
    }
}