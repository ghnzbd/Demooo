package myredblacktree;

import java.util.Scanner;

/**
 * @author chaird
 * @create 2021-01-03 13:50
 */
public class Main {
  public static void main(String[] args) {

    RBTree<Integer, Object> tree = new RBTree();

    Scanner reader = new Scanner(System.in);

    tree.insert(1, 1);

    tree.insert(2, 2);
    tree.insert(3, 3);
    tree.insert(4, 4);
    tree.insert(5, 5);
    tree.insert(6, 6);
    tree.insert(7, 7);
    tree.insert(8, 8);

    TreeOperation.show(tree.getRoot());

    //    Node root = tree.getRoot();
    //    TreeOperation.getTreeDepth(root);
    // TreeOperation.show(tree.getRoot());

    // how(tree.getRoot());
    //    }while (true) {
    ////      System.out.println("请输入Key");
    ////      String s = reader.nextLine();
    ////
    ////      tree.insert(Integer.parseInt(s), s);
    ////
    ////      TreeOperation.show(tree.getRoot());
    ////    }
  }
}
