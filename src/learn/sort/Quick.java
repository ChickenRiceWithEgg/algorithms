package learn.sort;

import java.util.Random;

public class Quick {

    public static void sort(int[] nums) {


    }

    public static void sort(int[] nums, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int j = partition(nums, lo, hi);
        sort(nums, lo, j - 1);
        sort(nums, j + 1, hi);
    }

    /**
     * 注意 ： i和j的先++ --然后再进行比较
     *
     * @param nums
     * @param lo
     * @param hi
     * @return
     */
    public static int partition(int[] nums, int lo, int hi) {
        int i = lo, j = hi + 1;
        while (true) {
            //下面两个while使用的是++i和--j，所以当找到判断不通过时，也会提前加1，当i和j相遇时，会“越位”，i和j位置会交换
            //如num[3]=5，num[4]=3，两次未通过的while之后，i=4，j=3，这时外层while会break，这个时候j=3的位置是需要和lo位置元素互换的
            while (nums[lo] > nums[++i]) {
                if (i >= hi) {
                    break;
                }
            }
            while (nums[lo] < nums[--j]) {
                if (j <= lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            //交换大小两侧的值
            CommonUtil.exchange(nums, i, j);
        }
        //需要把基准值放到指定位置
        CommonUtil.exchange(nums, lo, j);
        return j;
    }

}
