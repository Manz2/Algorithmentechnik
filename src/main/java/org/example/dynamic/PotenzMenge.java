package org.example.dynamic;

import java.util.*;

public class PotenzMenge {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>()); // leeres Set

        for (int num : nums) {
            int size = res.size();
            for (int i = 0; i < size; i++) {
                List<Integer> newSubset = new ArrayList<>(res.get(i));
                newSubset.add(num);
                res.add(newSubset);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = subsets(nums);

        System.out.println("Potenzmenge:");
        for (List<Integer> subset : result) {
            System.out.println(subset);
        }
    }
}

