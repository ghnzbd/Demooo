package leetcode;

public class Solution {

  public static void main(String[] args) {

    Solution solution = new Solution();

    System.out.println(solution.sumNums2(3));
  }

  int res = 0;

  public int sumNums(int n) {
    boolean x = n > 1 && sumNums(n - 1) > 0;
    res += n;
    return res;
  }

  public int sumNums2(int n) {
    boolean x = n > 1 && sumNums(n - 1) > -1;
    res += n;
    return res;
  }
}
