package leetcode;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

  public static void main(String[] args) {

    List<User> uList = new ArrayList<>();
    User u1 = new User();
    u1.setAddr("a1;a2;a3;a4;a5");

    User u2 = new User();
    u2.setAddr("b1;b2;b3;b4;b5");

    uList.add(u1);
    uList.add(u2);

    List<String> addrList =
        uList.stream()
            .map(x -> x.getAddr())
            .flatMap(x -> Arrays.stream(x.split(";")))
            .collect(Collectors.toList());


    String[] strings=new String[]{"abc-abc","def-def"};
     Arrays.stream(strings).flatMap(x -> Arrays.stream(x.split("-"))).forEach(System.out::println);


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
