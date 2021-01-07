/**
 * @author chaird
 * @create 2020-12-22 14:15
 */
public class Start {

  public static void main(String[] args) {

    Start start = new Start();
    // int[] data = new int[] {2, 3, 1, 1, 4};
    // int[] data = new int[] {0};
    int[] data = new int[] {1, 1};
    System.out.println(start.firstMissingPositive(data));
  }

  private void swap(int[] nums, int index1, int index2) {
    int temp = nums[index1];
    nums[index1] = nums[index2];
    nums[index2] = temp;
  }

  public int firstMissingPositive(int[] nums) {
    int length = nums.length;

    for (int i = 0; i < length; i++) {

      int val = nums[i];

      if (val > 0 && val <= length && nums[val - 1] != val) {

        swap(nums, val - 1, i);
        i--;
      }
    }

    for (int i = 0; i < length; i++) {
      if (nums[i] != i + 1) {
        return i + 1;
      }
    }
    return length + 1;
  }
}
