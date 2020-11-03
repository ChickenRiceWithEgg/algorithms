package leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 简单第一题，两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoSum_1 {

    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 6, 7, 8, 9};
        show(m1(nums, 10));
        show(m2(nums, 10));

    }

    /**
     * 暴力解法
     * 直接两次遍历求和
     * O(n^2)
     *
     * @param nums
     * @param target
     * @return
     */
    public static Integer[] m1(int[] nums, int target) {
        Integer[] result = new Integer[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return null;
    }

    /**
     * 使用hash
     * 只需要一次遍历
     * O(n)
     *
     * @param nums
     * @param target
     * @return
     */
    public static Integer[] m2(int[] nums, int target) {
        Integer[] result = new Integer[2];
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer num2 = target - nums[i];
            if (hash.containsKey(num2)) {
                result[0] = i;
                result[1] = hash.get(num2);
                return result;
            } else {
                hash.put(nums[i], i);
            }
        }
        return null;
    }

    public static void show(Integer[] nums) {
        Arrays.asList(nums).forEach(System.out::println);
    }

}
