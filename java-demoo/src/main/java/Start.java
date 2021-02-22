import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author chaird
 * @create 2020-12-22 14:15
 */
public class Start {

  public static void main(String[] args) throws Exception {


  }


  /**
   * N皇后
   *
   * @param n
   * @return
   */
  public List<List<String>> solveNQueens(int n) {
    List<List<String>> res = new ArrayList<>();
    AtomicInteger sum = new AtomicInteger(0);
    boolean[][] dp = new boolean[n][n];
    boolean[] hang = new boolean[n];
    boolean[] lie = new boolean[n];
    Map<String, Integer> cache = new HashMap<>();

    dfs(0, dp, sum, cache, hang, lie, res);

    return res;
  }

  public void dfs(
      int lineIndex,
      boolean[][] dp,
      AtomicInteger sum,
      Map<String, Integer> cache,
      boolean[] hang,
      boolean[] lie,
      List<List<String>> res) {

    if (sum.intValue() == dp.length) {

      List<String> list = new ArrayList<>();

      for (int i = 0; i < dp.length; i++) {
        StringBuilder builder = new StringBuilder();
        for (int j = 0; j < dp[i].length; j++) {
          if (dp[i][j]) {
            builder.append("Q");
          } else {
            builder.append(".");
          }
        }

        list.add(builder.toString());
      }

      res.add(list);

      return;
    }

    if (lineIndex >= dp.length) {
      return;
    }

    for (int i = 0; i < dp.length; i++) {

      if (voladate(i, lineIndex, cache, hang, lie)) {

        // 修改参数
        String key1 = "1-" + (lineIndex - i);
        cache.put(key1, 1);
        String key2 = "-1-" + (lineIndex + i);
        cache.put(key2, 1);
        hang[lineIndex] = true;
        lie[i] = true;
        dp[i][lineIndex] = true;

        sum.incrementAndGet();
        dfs(lineIndex + 1, dp, sum, cache, hang, lie, res);
        sum.decrementAndGet();
        // 撤销参数
        cache.remove(key1);
        cache.remove(key2);
        hang[lineIndex] = false;
        lie[i] = false;
        dp[i][lineIndex] = false;
      }
    }
  }

  public boolean voladate(int x, int y, Map<String, Integer> cache, boolean[] hang, boolean[] lie) {

    if (hang[y] == true) {
      return false;
    }

    if (lie[x] == true) {
      return false;
    }

    // 求 y=x+b
    String key = "1-" + (y - x);
    if (cache.containsKey(key)) {
      return false;
    }

    // 求 y=-x+b
    key = "-1-" + (y + x);
    if (cache.containsKey(key)) {
      return false;
    }

    return true;
  }

  public void swap(int a, int b, int[] data) {
    int temp = data[a];
    data[a] = data[b];
    data[b] = temp;
  }

  public void generateList() {
    //    int[] data = new int[] {1, 2, 3, 4, 5};
    //    ListNode[] nodes = new ListNode[data.length];
    //    for (int i = 0; i < data.length; i++) {
    //      nodes[i] = new ListNode(data[i]);
    //    }
    //    for (int i = 0; i < data.length - 1; i++) {
    //      nodes[i].next = nodes[i + 1];
    //    }
  }
}

class ListNode {
  int val;
  ListNode next;

  ListNode() {}

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {}

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}
