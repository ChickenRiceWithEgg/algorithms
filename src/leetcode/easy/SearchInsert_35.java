package leetcode.easy;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素
 * <p>
 * <p>
 * 二分查找也很难啊。。。各种边界问题
 */
public class SearchInsert_35 {

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 5, 6};
        System.out.println(m1(nums, 4));
    }

    /**
     * 暴力解法，从头开始查
     *
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (target <= nums[i]) {
                return i;
            }
        }
        return nums.length;
    }

    /**
     * 有序数组中查找某个值，使用二分查找
     *
     * @param nums
     * @param target
     * @return
     */
//    public static int m1(int[] nums, int target) {
//        int n = nums.length;
//        int low = 0, high = n - 1, mid = (high - low) >> 2 + low;
//        while (true) {
//            if (low >= high) {
//                return high;
//            }
//            if (target < nums[mid]) {
//                high = mid - 1;
//                mid = (mid - low) >> 2 + low;
//            }
//            if (target > nums[mid]) {
//                low = mid + 1;
//                mid = (high - mid) >> 2 + mid;
//            }
//            if (target == nums[mid]) {
//                return mid;
//            }
//
//        }
//    }
    public static int m1(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = ((high - low) >> 1) + low;
            if (target <= nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low; //当最后锁定到target的时候。low=high，这时候while循环里面mid=low=high，第一个if判断通过计算high=mid-1=low-1，下一次while循环不满足，所有应该返回low的值
    }
}