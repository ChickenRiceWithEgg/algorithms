package leetcode.easy;

import java.math.BigInteger;

/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * <p>
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 * <p>
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 123
 * 输出：321
 * 示例 2：
 * <p>
 * 输入：x = -123
 * 输出：-321
 * 示例 3：
 * <p>
 * 输入：x = 120
 * 输出：21
 * 示例 4：
 * <p>
 * 输入：x = 0
 * 输出：0
 *  
 * <p>
 * 提示：
 * <p>
 * -231 <= x <= 231 - 1
 */
public class Reverse_7 {

    public static int reverse(int x) {
        if (x == -1 << 31 || x == 0) {
            return 0;
        }

        char[] rawBytes = String.valueOf(x).toCharArray();

        int i, j;
        if (x >= 0) {
            i = 0;
            j = 1;
        } else {
            i = 1;
            j = 2;
        }
        for (; j < rawBytes.length; j++) {
            if (0 != Character.getNumericValue(rawBytes[j])) {
                i = j;
            }
        }

        int reverseLength;
        if (x >= 0) {
            reverseLength = i + 1;
        } else {
            reverseLength = i;
        }
        char[] reverseBytes = new char[reverseLength];
        int k = reverseLength - 1;
        for (char rawByte : rawBytes) {
            if ((byte) '-' != rawByte) {
                reverseBytes[k--] = rawByte;
                if (k < 0) {
                    break;
                }
            }
        }

        int result;
        try {
            result = Integer.parseInt(String.valueOf(reverseBytes));
        } catch (NumberFormatException e) {
            return 0;
        }
        if (x < 0) {
            return -result;
        } else {
            return result;
        }
    }

    public static void main(String[] args) {
        int test = 1534236469;
        System.out.println(reverse(test));
    }
}
