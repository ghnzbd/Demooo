package leetcode;

import lombok.Data;

public class Solution {

  public static void main(String[] args) {




  }

  void swap(int[] data, int left, int right) {
    int temp = data[left];
    data[left] = data[right];
    data[right] = temp;
  }
}

class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
  }
}

@Data
class User {
  String addr;
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
}
