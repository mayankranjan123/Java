package DP;


import java.util.ArrayList;
import java.util.List;

class SubsetsOfString {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        generateSubsets(0, new ArrayList<>(), nums, subsets);
        return subsets;
    }

    List<List<Integer>> generateSubsets(int index, List<Integer> current, int[] nums, List<List<Integer>> subsets) {
        subsets.add(new ArrayList<>(current));

        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            generateSubsets(i + 1, current, nums, subsets);
            current.remove(current.size() - 1);
        }
        return subsets;
    }
}
