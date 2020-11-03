package learn.sort;

/**
 * 插入排序
 * 稳定的
 * O(n^2)
 */
public class Insertion {

    public static void main(String[] args) {
        Integer[] a = {1, 2, 3, 4, 3, 2, 6, 7, 8, 3, 1, 5};
        CommonUtil.show(insertion(a));
    }

    public static Integer[] insertion(Integer[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j > 0 && nums[j] < nums[j - 1]; j--) {
                CommonUtil.exchange(nums, j, j - 1);
            }
        }
        return nums;
    }
}
