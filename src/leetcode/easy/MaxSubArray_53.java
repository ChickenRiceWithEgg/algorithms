package leetcode.easy;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 * <p>
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 */
public class MaxSubArray_53 {

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        int[] nums = {-2, 1};
        System.out.println(maxSubArray(nums));
    }

    /**
     * 双循环，暴力解法
     * 181ms，击败5%的用户
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int tmp = nums[i];
            if (tmp > max) {
                max = tmp;
            }
            for (int j = i + 1; j < length; j++) {
                tmp += nums[j];
                if (tmp > max) {
                    max = tmp;
                }
            }
        }
        return max;
    }

    /**
     * 动态规划
     * <p>
     * f(i)表示以第i个数结尾的“连续子数组的最大和”，
     * 考虑nums[i]是单独成为一段，还是加入f(i-1)那一段，这取决于nums[i]和f(i-1)+nums[i]的大小，
     * 我们希望获得一个比较大的，于是可以写出这样的动态规划转移方程
     * f(i) = max{ f(i-1) + nums[i] , nums[i] }
     * <p>
     * 考虑到f(i)只和f(i-1)相关，于是我们可以只用一个变量pre来维护当前f(i)的f(i-1)的值是多少
     * <p>
     * 代码没懂 todo
     *
     * @param nums
     * @return
     */
    public static int m1(int[] nums) {
        int pre = 0, max = nums[0];
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            max = Math.max(pre, max);
        }
        return max;
    }

}
