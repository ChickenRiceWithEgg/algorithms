package leetcode.easy;

/**
 * 26和27比较类似
 * <p>
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */
public class RemoveDuplicates_26 {

    public static void main(String[] args) {
//        int[] nums = {0, 3, 1, 7, 5, 2, 6, 1, 9, 2, 7, 3, 3};
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
//        int[] nums = {1, 1, 2};
        System.out.println(removeDuplicates2(nums));
        for (int i : nums) {
            System.out.println("=" + i);
        }
    }

    /**
     * 200多ms 击败5%的用户
     * 自己想的这种解法，可以针对未排序的数组，但题目给的参数是已排好序的数组
     *
     * @param randomNums
     * @return
     */
    public static int removeDuplicates(int[] randomNums) {

        int length = randomNums.length;
        int i = 0;
        int l = 0;
        for (; i < length; ) {
            int flag = 0;
            int v = randomNums[i];
            for (int j = 0; j < i; j++) {
                if (randomNums[j] == v) {
                    flag++;
                    l++;
                    int tmp = randomNums[j];
                    for (int k = i; k < length - 1; k++) {
                        randomNums[k] = randomNums[k + 1];
                    }
                    randomNums[randomNums.length - 1] = tmp;
                }
            }
            if (flag == 0) {
                i++;
            }
            if (length - l + 1 == i) {
                break;
            }

        }
        return i;
    }

    /**
     * 双指针法
     * 对于已经排好序的数组
     * <p>
     * 数组完成排序后，我们可以放置两个指针 ii 和 jj，其中 ii 是慢指针，而 jj 是快指针。只要 nums[i] = nums[j]nums[i]=nums[j]，我们就增加 jj 以跳过重复项。
     * <p>
     * 当我们遇到 nums[j] != nums[i] 时，跳过重复项的运行已经结束，因此我们必须把它（nums[j]nums[j]）的值复制到 nums[i + 1]nums[i+1]。然后递增 ii，接着我们将再次重复相同的过程，直到 jj 到达数组的末尾为止。
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/solution/shan-chu-pai-xu-shu-zu-zhong-de-zhong-fu-xiang-by-/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param sortedNums
     * @return
     */
    public static int removeDuplicates2(int[] sortedNums) {
        int length = sortedNums.length;
        if (length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < length; j++) {
            if (sortedNums[i] != sortedNums[j]) {
                i++;
                sortedNums[i] = sortedNums[j];
            }
        }
        return i + 1;
    }
}