package leetcode.easy;


/**
 * 26和27比较类似
 * <p>
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */
public class RemoveElement_27 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 4, 2, 8, 5, 6, 8, 0, 4, 6, 2, 8};
//        System.out.println(removeElement1(nums, 5));
        System.out.println(removeElement2(nums, 5));
    }

    /**
     * 双指针法1  这是比较高效的方法
     * 缺点：几乎每个不等于指定值的数字都要进行位移
     * 若值不等于指定值，则将k下标值设为当前值（即将元素左移），并将k+1
     * 如果值等于指定值，则进行下一次循环，
     *
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement1(int[] nums, int val) {
        int k = 0;  //k是短指针
        for (int i = 0; i < nums.length; i++) { //i是长指针
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

    /**
     * 双指针法2  这种方法比较适合重复数字比较少的情况，
     * 优点：避免了每次不重复数字的位移
     * 如果k下标的值==val就将数组最后一个数组提到k下标处，然后将数组长度减一（即将原k下标的值给删掉了）
     * 如果k下标的值!=val就将短指针+1
     *
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement2(int[] nums, int val) {
        int k = 0;  //k是短指针
        int n = nums.length;//n是长指针
        while (k < n) {
            if (nums[k] == val) {
                nums[k] = nums[n - 1];
                n--;
            } else {
                k++;
            }
        }
        return k;
    }
}