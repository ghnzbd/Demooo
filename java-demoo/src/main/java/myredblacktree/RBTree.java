package myredblacktree;

import lombok.Data;

/**
 * @author chaird
 * @create 2021-01-03 13:52<br>
 *     红黑树
 */
@Data
public class RBTree<K extends Comparable<K>, V> {

  // 根节点
  private Node root;

  // 定义红黑树常量
  private static final boolean RED = true;
  private static final boolean BLACK = false;

  /**
   * 当前节点是否是红色
   *
   * @param node
   * @return
   */
  private Boolean isRed(Node node) {
    if (null != node) {

      return node.getColor() == RED;
    }
    return false;
  }

  /**
   * 当前节点是否是黑色
   *
   * @param node
   * @return
   */
  private Boolean isBlack(Node node) {
    if (null != node) {

      return node.getColor() == BLACK;
    }
    return false;
  }

  /**
   * 设置节点为红色
   *
   * @param node
   */
  private void setRed(Node node) {
    if (null != node) {
      node.setColor(RBTree.RED);
    }
  }

  /**
   * 设置节点为黑色
   *
   * @param node
   */
  private void setBlack(Node node) {
    if (null != node) {
      node.setColor(RBTree.BLACK);
    }
  }

  /**
   * 左旋
   *
   * @param x <br>
   *     图片：https://www.processon.com/view/link/5ff15f05e0b34d19e4f880f1
   */
  private void leftRotate(Node x) {

    if (x == null) {
      return;
    }

    // 记录父节点
    Node parent = x.getParent();
    // 记录X节点的左子树和右子树
    Node xl = x.getLeft();
    Node xr = x.getRight();

    // ---> 修改父节点的指针
    if (null != parent) {
      if (x == parent.left) {
        parent.left = xr;
      } else {
        parent.right = xr;
      }

    } else {
      // parent=null表示为根
      this.root = xr;
      xr.parent = null;
    }

    // ---> 修改x节点的指针
    // 修改左子树(不需要修改)
    // 修改右子树
    if (xr != null) {
      x.right = xr.left;
    }
    // 修改父节点
    x.parent = xr;

    // ---> 修改xl节点的指针（不需要修改）

    // ---> 修改xr节点的指针
    if (xr != null) {
      // 修改左子树
      xr.left = x;
      // 修改右子树(不需要修改)
      // 修改父节点
      if (null != parent) {
        xr.parent = parent;
      }
    }

    // ---> 修改xrl节点的指针
    // 修改左子树(不需要修改)
    // 修改右子树(不需要修改)
    // 修改父节点
    if (xr.left != null) {
      xr.left.parent = x;
    }
  }

  /**
   * 右旋
   *
   * @param x <br>
   *     图片：https://www.processon.com/view/link/5ff1660807912977bede44d5
   */
  private void rightRotate(Node x) {

    if (null == x) {
      return;
    }

    // 记录父节点
    Node parent = x.getParent();
    // 记录X节点的左子树和右子树
    Node xl = x.getLeft();
    Node xr = x.getRight();

    // ---> 修改父节点的指针
    if (null != parent) {
      if (x == parent.left) {
        parent.left = xl;
      } else {
        parent.right = xl;
      }

    } else {
      // parent=null表示为根
      this.root = xl;
      xl.parent = null;
    }

    // ---> 修改X节点的指针
    // 修改左子树
    if (xl != null) {
      x.left = xl.right;
    }
    // 修改右子树(不需要修改)
    // 修改父节点
    x.parent = xl;

    // ---> 修改xl节点的指针
    // 修改左子树(不需要修改)
    // 修改右子树
    xl.right = x;
    // 修改父节点
    xl.parent = parent;

    // ---> 修改XR节点的指针(不需要修改)

    // ---> 修改XLR节点的指针
    // 修改左子树(不需要修改)
    // 修改右子树(不需要修改)
    // 修改父节点
    if (xl.right != null) {
      xl.parent = x;
    }
  }

  public void insert(K key, V value) {

    Node node = new Node(key, value);
    // 新阶段一定是红色
    node.setColor(RED);
    insert(node);
  }

  private void insert(Node node) {

    // 第一步：查找当前的node的父节点
    Node parent = null;
    Node x = this.root;

    while (x != null) {
      parent = x;
      int cmp = node.getKey().compareTo(x.getKey());
      if (cmp > 0) {
        x = x.getRight();
      } else if (cmp < 0) {
        x = x.getLeft();
      } else if (cmp == 0) {
        x.setValue(node.getValue());
        return;
      }
    }

    node.setParent(parent);
    // 判断node是parent的左子树还是右子树
    if (parent != null) {
      int cmp = node.getKey().compareTo(parent.getKey());

      if (cmp > 0) {
        parent.setRight(node);
      } else {
        parent.setLeft(node);
      }
    } else {
      this.root = node;
    }

    // 需要调用红黑树平衡的方法
    insertFixUp(node);
  }

  // 修复红黑树(复杂)

  /**
   * 插入后修复红黑树平衡的方法<br>
   * 情景1：红黑树为空树，将根节点染色为黑色。 <br>
   * 情景2：插入节点的key已经存在（不需要处理） <br>
   * 情景3：插入节点的父节点为黑色（因为插入的的为红色，黑色节点没有变化，所以红黑树依然平衡，所以不需要处理） <br>
   * 情景4：插入节点的父节点为红色（复杂） 情景4-1：叔叔节点存在。并且为红色(父-叔 双红)。将爸爸和叔叔染色为黑色，将爷爷染色为红色，并且在以爷爷节点为当前节点，进行下一轮处理
   * 情景4-2：叔叔节点不存在，或者为黑色。父节点为爷爷节点的左子树 <br>
   * 情景4-2-1：插入节点为其父节点的左子节点（LL情景）。将爸爸染色为黑色，将爷爷染色为红色，然后以爷爷节点右旋，就结束了
   * 情景4-2-2：插入节点为其父节点的右子节点（LR情景）。以爸爸节点进行一次左旋，得到LL双红的情景（4.2.1），然后指定爸爸节点为当前节点进行下一轮处理
   * 情景4-3：叔叔节点不存在，或者为黑色。父节点为爷爷节点的右子树 <br>
   * 情景4-3-1：插入节点为其父节点的右子节点（RR情景）。将爸爸染色为黑色，将爷爷染色为红色，然后以爷爷节点左旋，就结束了
   * 情景4-3-2：插入节点为其父节点的左子节点（RR情景）。以爸爸节点进行一次右旋，得到RR双红的情景（4.3.1），然后指定爸爸节点为当前节点进行下一轮处理
   *
   * @param node
   */
  private void insertFixUp(Node node) {
    // 情景1：红黑树为空树，将根节点染色为黑色。
    if (this.root == node) {
      setBlack(node);
    }

    // 情景2：插入节点的key已经存在（不需要处理） (走不到这里)

    // 情景3：插入节点的父节点为黑色（因为插入的的为红色，黑色节点没有变化，所以红黑树依然平衡，所以不需要处理） <br>
    if (node.getParent() != null && isBlack(node.getParent())) {
      return;
    }

    // 情景4：插入节点的父节点为红色（复杂）
    if (node.getParent() != null && isRed(node.getParent())) {

      Node parent = node.getParent();
      Node gParent = parent.getParent();

      Node uncle = null;
      if (parent == gParent.left) {
        // 爸爸是爷爷的左子树
        uncle = gParent.right;
      } else {
        // 爸爸是爷爷的右子树
        uncle = gParent.left;
      }

      // 情景4-1：叔叔节点存在。并且为红色(父-叔 双红)。将爸爸和叔叔染色为黑色，将爷爷染色为红色，并且在以爷爷节点为当前节点，进行下一轮处理
      if (null != uncle && isRed(uncle)) {
        setBlack(parent);
        setBlack(uncle);
        setRed(gParent);
        insertFixUp(gParent);
        return;
      }

      // 情景4-2：叔叔节点不存在，或者为黑色。父节点为爷爷节点的左子树
      if (null == uncle || isBlack(uncle)) {
        if (parent == gParent.left) {
          // 情景4-2-1：插入节点为其父节点的左子节点（LL情景）。将爸爸染色为黑色，将爷爷染色为红色，然后以爷爷节点右旋，就结束了
          if (node == parent.left) {
            setBlack(parent);
            setRed(gParent);
            rightRotate(gParent);
            return;
          } else {
            leftRotate(parent);
            insertFixUp(parent);
            return;
          }
        }
      }

      // 情景4-3：叔叔节点不存在，或者为黑色。父节点为爷爷节点的右子树
      if (null == uncle || isBlack(uncle)) {
        if (parent == gParent.right) {
          if (node == parent.right) {
            setBlack(parent);
            setRed(gParent);
            leftRotate(gParent);
            return;

          } else {

            rightRotate(parent);
            insertFixUp(parent);
            return;
          }
        }
      }
    }
  }
}
