package learn.sort;

/**
 * 希尔排序
 * 本质上就是选用增量，进行多次插入排序
 * 由于上一增量的排序结果是局部有序的，所以对于下一增量的插排来说是有利的
 */
public class Shell {

    public static void main(String[] args) {
        Integer[] nums = {1, 2, 3, 2, 5, 7, 4, 3, 6, 8, 0, 5, 3, 2, 5, 7, 9, 0, 5, 3, 2, 1, 5, 7, 9, 0, 6, 2};
        CommonUtil.show(shell(nums));

    }

    public static Integer[] shell(Integer[] nums) {

        Integer length = nums.length;
        Integer h = length / 2; //选用length/2作为增量

        while (h >= 1) {
            for (int i = 1; i < length; i++) {
                for (int j = i; j >= h && nums[j] < nums[j - h]; j -= h) {
                    CommonUtil.exchange(nums, j, j - h);
                }
            }
            h /= 2;
        }

        return nums;
    }
}