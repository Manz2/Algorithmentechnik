package org.example.greedy;

import java.util.*;

public class SetCover {

    private static void setCover(List<List<Integer>> subSets, List<Integer> universe) {
        while (!universe.isEmpty()) {
            subSets.sort(Comparator.comparingInt(List::size));
            List<Integer> selectedSet = subSets.getLast();
            universe.removeAll(selectedSet);
            System.out.println("Using Set: " + selectedSet);
            for (List<Integer> list : subSets) {
                list.removeAll(selectedSet);
            }
            subSets.removeLast();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> subsets = new ArrayList<>();

        subsets.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
        subsets.add(new ArrayList<>(Arrays.asList(2, 4)));
        subsets.add(new ArrayList<>(Arrays.asList(3, 4)));
        subsets.add(new ArrayList<>(Arrays.asList(4, 5)));

        ArrayList<Integer> universe = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        setCover(subsets, universe);
    }
}