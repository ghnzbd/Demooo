package leetcode;

import java.util.HashMap;
import java.util.Map;

class Solution {

  public static void main(String[] args) {
    // [3,9,20,15,7]
    // [9,3,15,20,7]
    int[] preorder = new int[] {3, 9, 20, 15, 7};
    int[] inorder = new int[] {9, 3, 15, 20, 7};

    Solution solution = new Solution();

    TreeNode treeNode = solution.buildTree(preorder, inorder);

    System.out.println(treeNode);
  }

  public TreeNode buildTree(int[] preorder, int[] inorder) {

    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < inorder.length; i++) {

      map.put(inorder[i], i);
    }

    TreeNode treeNode = deepbuildTree(preorder, 0, preorder.length - 1, 0, inorder.length - 1, map);

    return treeNode;
  }

  public TreeNode deepbuildTree(
      int[] preorder,
      Integer preorderStart,
      Integer preorderrnd,
      Integer inorderStart,
      Integer inorderrnd,
      Map<Integer, Integer> map) {

    if (preorderStart > preorderrnd) {
      return null;
    }

    if (inorderStart > inorderrnd) {
      return null;
    }

    Integer rootVal = preorder[preorderStart];
    TreeNode root = new TreeNode(rootVal);

    int i = map.get(rootVal);

    root.left =
        deepbuildTree(
            preorder,
            preorderStart + 1,
            preorderStart + i - inorderStart,
            inorderStart,
            i - 1,
            map);
    root.right =
        deepbuildTree(
            preorder, preorderStart + i - inorderStart + 1, preorderrnd, i + 1, inorderrnd, map);

    return root;
  }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
}
