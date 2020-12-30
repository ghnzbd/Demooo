package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
  /**
   * lru design
   *
   * @param operators int整型二维数组 the ops
   * @param k int整型 the k
   * @return int整型一维数组
   */
  public int[] LRU(int[][] operators, int k) {

    List<Integer> list = new ArrayList<>();
    LRUCache lruCache = new LRUCache(k);

    int length = operators.length;
    for (int i = 0; i < length; i++) {
      if (operators[i][0] == 1) {
        lruCache.put(operators[i][1], operators[i][2]);
      } else {
        list.add(lruCache.get(operators[i][1]));
      }
    }

    int[] res = new int[list.size()];
    for (int i = 0; i < list.size(); i++) {

      res[i] = list.get(i);
    }

    return res;
  }
}

class LRUCache {

  int capacity;

  private HashMap<Integer, Node> cache = new HashMap<>();

  private Node head;
  private Node tail;

  // 新数据插入头
  public LRUCache(int capacity) {

    this.capacity = capacity;
    head = new Node();
    tail = new Node();
    head.next = tail;
    tail.prev = head;
  }

  public int get(int key) {

    Node node = cache.get(key);
    if (null == node) {
      return -1;
    }
    put(key, node.value);
    return node.value;
  }

  public void put(int key, int value) {

    Node node = cache.get(key);

    if (null != node) {

      // 移除当前节点
      node.next.prev = node.prev;
      node.prev.next = node.next;

      node.value = value;

      head.next.prev = node;
      node.next = head.next;
      node.prev = head;
      head.next = node;

    } else {

      // 长了
      if (cache.size() >= capacity) {
        Node del = tail.prev;
        del.prev.next = tail;
        tail.prev = del.prev;
        cache.remove(del.key);
        del = null;
      }

      Node newNode = new Node(key, value);
      head.next.prev = newNode;
      newNode.next = head.next;
      newNode.prev = head;
      head.next = newNode;
      cache.put(key, newNode);
    }
  }

  class Node {
    public Node(Integer key, Integer value) {
      this.key = key;
      this.value = value;
    }

    public Node() {}

    Integer key;
    Integer value;
    Node next = null;
    Node prev = null;
  }
}
