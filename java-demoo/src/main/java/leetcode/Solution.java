package leetcode;

class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.longestPalindrome("cbbd"));
  }

  // 22.07
  public String longestPalindrome(String s) {

    String res = "";

    for (int i = 0; i < s.length(); i++) {
      String val = doLongestPalindrome(i, i, s);
      if (val != null && res.length() < val.length()) {
        res = val;
      }
    }

    for (int i = 0; i < s.length() - 1; i++) {
      String val = doLongestPalindrome(i, i + 1, s);
      if (val != null && res.length() < val.length()) {
        res = val;
      }
    }

    return res;
  }

  private String doLongestPalindrome(int left, int right, String s) {

    if (s.charAt(left) != s.charAt(right)) {
      return null;
    }

    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
      left--;
      right++;
    }

    left++;
    right--;
    return s.substring(left, right + 1);
  }
}
