package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CBeann
 * @create 2020-02-21 0:05
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        Solution solution = new Solution();
        List<List<Integer>> subsets = solution.subsets(nums);

    }



    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, res, new ArrayList<Integer>());
        return res;

    }

    private void backtrack(int i, int[] nums, List<List<Integer>> res, ArrayList<Integer> tmp) {
        res.add(new ArrayList<>(tmp));
        System.out.println(tmp);
        for (int j = i; j < nums.length; j++) {
            tmp.add(nums[j]);
            backtrack(j + 1, nums, res, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }








}
