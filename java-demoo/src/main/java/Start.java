import java.util.HashMap;

/**
 * @author chaird
 * @create 2020-12-22 14:15
 */
public class Start {

  public static void main(String[] args) {

    Start start = new Start();

    HashMap map=new HashMap();

    map.put("key", "value");




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
