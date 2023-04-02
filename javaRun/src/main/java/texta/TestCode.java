package main.java.texta;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Zhanghuihui
 * @date 2023/3/24 17:42
 * @description
 */
public class TestCode {

  public static int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int diff = target - nums[i];
      if (map.containsKey(diff)) {
        return new int[] {map.get(diff), i};
      }
      map.put(nums[i], i);
    }
    return null;
  }

  public static void main(String[] args) {

    int nums[]={1,2,3,4};
    int target=4;
    int[] ints = twoSum(nums, target);
    System.out.println(Arrays.toString(ints));
  }

}
