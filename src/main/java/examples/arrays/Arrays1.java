package examples.arrays;

public class Arrays1 {
  public static void main(String[] args) {
    System.out.println(centeredAverage(new int[] {1, 2, 3, 4, 100}));
  }
  public static int centeredAverage(int[] nums) {
    int low = nums[0];
    int high = nums[0];
    for (int num: nums) {
      if (num < low) low = num;
      if (num > high) high = num;
    }
    boolean lowSkipped = false;
    boolean highSkipped = false;
    int sum = 0;
    for (int num: nums) {
      if (num == low && ! lowSkipped)
        lowSkipped = true;
      else if (num == high && ! highSkipped)
        highSkipped = true;
      else sum += num;
    }
    return sum / (nums.length - 2 /* the skipped low and high elements */);
  }
}
