/**
 * @author chaird
 * @create 2020-12-22 14:15
 */
public class Start {

  public static void main(String[] args) {

    Start start = new Start();

    int[][] data = new int[][] {{1, 4}, {0, 4}};
  }

  public int[][] insert(int[][] intervals, int[] newInterval) {

    int step = -1;

    int[][] res = new int[intervals.length + 1][2];

    for (int[] interval : intervals) {

      if (step==-1||res[step][2]>1){
        //空或者
      }


    }

    return null;
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
