import java.util.Stack;

/**
 * @author chaird
 * @create 2020-12-22 14:15
 */
public class Start {

  public static void main(String[] args) {

    //    5
    // 3    10
    // 1  4  9  11
    TreeNode root = new TreeNode(5);
    TreeNode l = new TreeNode(3);
    TreeNode ll = new TreeNode(1);
    TreeNode lr = new TreeNode(4);
    root.left = l;
    l.left = ll;
    l.right = lr;

    TreeNode r = new TreeNode(10);
    TreeNode rl = new TreeNode(9);
    TreeNode rr = new TreeNode(11);
    root.right = r;
    r.left = rl;
    r.right = rr;

    inOrder(root);
  }
  // 前序
  public static void inOrder(TreeNode root) {

    if (null == root) {
      return;
    }
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    while (stack.size() > 0) {

      TreeNode pop = stack.pop();
      System.out.println(pop.value);
      if (null != pop.right) {
        stack.push(pop.right);
      }
      if (null != pop.left) {
        stack.push(pop.left);
      }
    }
  }
}

class TreeNode {
  int value;
  TreeNode left;
  TreeNode right;

  public TreeNode(int value) {
    this.value = value;
  }
}
