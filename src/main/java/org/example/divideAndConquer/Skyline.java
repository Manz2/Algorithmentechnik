package org.example.divideAndConquer;

import java.util.ArrayList;
import java.util.List;

public class Skyline {

    public static void main(String[] args) {
        List<int[]> a = new ArrayList<int[]>();
        //buildings = [(1, 11, 5), (2, 6, 7), (3, 13, 9), (12, 7, 16), (14, 3, 25), (19, 18, 22)]
        a.add( new int []{1,11,5});
        a.add(new int []{2,6,7});
        a.add(new int []{3,13,9});
        a.add(new int []{12,7,16});
        a.add(new int []{14,3,25});
        a.add(new int []{19,18,22});

        List<int[]> r = makeSkyline(a);
        printSkyline(r);


    }

    private static List<int[]> mergeSkyline(List<int[]> left, List<int[]> right) {
        List<int[]> result = new ArrayList<>();
        int h1 = 0, h2 = 0, i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            int x;
            if (left.get(i)[0] < right.get(j)[0]) {
                x = left.get(i)[0];
                h1 = left.get(i)[1];
                i++;
            } else if (right.get(j)[0] < left.get(i)[0]) {
                x = right.get(j)[0];
                h2 = right.get(j)[1];
                j++;
            } else {
                x = left.get(i)[0];
                h1 = left.get(i)[1];
                h2 = right.get(j)[1];
                i++;
                j++;
            }
            int maxH = Math.max(h1, h2);
            if (result.isEmpty() || result.get(result.size() - 1)[1] != maxH) {
                result.add(new int[]{x, maxH});
            }
        }

        while (i < left.size()) result.add(left.get(i++));
        while (j < right.size()) result.add(right.get(j++));

        return result;
    }



    private static List<int[]> makeSkyline(List<int[]> buildings) {

        if (buildings.size() == 1) {
            int[] b = buildings.get(0);
            List<int[]> skyline = new ArrayList<>();
            skyline.add(new int[]{b[0], b[1]});
            skyline.add(new int[]{b[2], 0});
            return skyline;
        }
        int middle = buildings.size() / 2;
        List<int[]> first = makeSkyline(buildings.subList(0, middle));
        List<int[]> second = makeSkyline(buildings.subList(middle, buildings.size()));

        return mergeSkyline(first, second);
    }

    public static void printSkyline(List<int[]> skyline) {
        for (int[] point : skyline) {
            if (point.length == 2) {
                System.out.printf("(%d, %d)\n", point[0], point[1]);
            } else if (point.length == 3) {
                System.out.printf("(%d, %d, %d)\n", point[0], point[1], point[2]);
            } else {
                System.out.println("Unerwartetes Tupel mit Länge " + point.length);
            }
        }
    }

}
