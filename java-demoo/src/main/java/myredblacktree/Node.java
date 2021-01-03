package myredblacktree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chaird
 * @create 2021-01-03 13:46 <br>
 *     红黑树节点
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Node<K extends Comparable<K>, V> {

  public Node(K key, V value) {
    this.key = key;
    this.value = value;
  }

  // 父节点
  Node parent;
  // 左子树
  Node left;
  // 右子树
  Node right;
  // 颜色，红色为true,黑色为false
  Boolean color;
  // key
  K key;
  // vale
  V value;

  @Override
  public String toString() {
    return "Node{" + ", color=" + color + ", key=" + key + ", value=" + value + '}';
  }
}
