package leetcode;

import java.util.HashMap;
import java.util.Map;

class Solution {
  public static void main(String[] args) {

    Solution solution = new Solution();
    System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
  }

  public int lengthOfLongestSubstring(String s) {

    int length = s.length();
    int start = -1;

    int result = 0;

    Map<Character, Integer> cache = new HashMap<>();

    for (int i = 0; i < length; i++) {

      char c = s.charAt(i);
      if (cache.containsKey(c)) {

        Integer integer = cache.get(c);

        if (integer >= start) {
          start = integer;
        }
      }
      cache.put(c, i);

      result = result > (i - start) ? result : (i - start);
    }

    return result;
  }
}
