package leetcode.easy;

/**
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * 示例 2：
 * <p>
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 * 示例 3：
 * <p>
 * 输入：digits = [0]
 * 输出：[1]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 */
public class PlusOne_66 {

    /**
     * 会溢出
     *
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {
        int old = 0;
        int length = digits.length;
        for (int i = 0; i < length; i++) {
            old += (int) (digits[i] * (Math.pow(10, digits.length - i - 1)));
        }
        old++;

        int newLength = length;
        if (Math.pow(10, digits.length) == old) {
            newLength = length + 1;
        }
        int[] newDigits = new int[newLength];
        while (old != 0) {
            int digit = old % 10;
            newDigits[--newLength] = digit;
            old = old / 10;
        }
        return newDigits;
    }

    /**
     * 两个循环，不是最优解
     *
     * @param digits
     * @return
     */
    public static int[] plusOne2(int[] digits) {
        boolean sumUp = true;
        for (int digit : digits) {
            if (digit != 9) {
                sumUp = false;
                break;
            }
        }
        int length = digits.length;
        if (sumUp) {
            int[] newDigits = new int[length + 1];
            newDigits[0] = 1;
            return newDigits;
        }

        int[] newDigits = new int[length];
        int lastUp = 1;
        for (int i = length - 1; i >= 0; i--) {
            int val = digits[i] + lastUp;
            lastUp = val / 10;
            newDigits[i] = val % 10;
        }
        return newDigits;
    }

    /**
     * 答案：
     * <p>
     * 末位无进位，则末位加一即可，因为末位无进位，前面也不可能产生进位，比如 45 => 46
     * 末位有进位，在中间位置进位停止，则需要找到进位的典型标志，即为当前位 %10后为 0，则前一位加 1，直到不为 0 为止，比如 499 => 500
     * 末位有进位，并且一直进位到最前方导致结果多出一位，对于这种情况，需要在第 2 种情况遍历结束的基础上，进行单独处理，比如 999 => 1000
     * <p>
     * 作者：guanpengchn
     * 链接：https://leetcode-cn.com/problems/plus-one/solution/hua-jie-suan-fa-66-jia-yi-by-guanpengchn/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param digits
     * @return
     */
    public static int[] plusOne3(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;//对于最低为数字默认+1，对于其他数字默认有进位
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) {//!=0表示当前不需要进位，那么直接退出就好
                return digits;
            }
        }
        //如果遍历完整个数组，都需要进位的话，表示每个元素都是9，那么需要构造一个新的数据
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {
        int[] ints = plusOne3(new int[]{1, 9, 9, 9, 9, 9});
        System.out.println();
    }

}
