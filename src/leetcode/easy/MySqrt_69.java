package leetcode.easy;

/**
 * 实现 int sqrt(int x) 函数。
 * <p>
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * <p>
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sqrtx
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MySqrt_69 {

    /**
     * 思路：
     * 如果从0开始遍历计算值的平方然后比较，那么当输入的值时2^31-1时，需要遍历2^30次。所以需要缩小遍历的范围
     * 让输入的值除以2，记录次数n，那么这个数就是2^n，即(2^(n/2))^2。
     * <p>
     * 写不出来，总是不对
     *
     * @param x
     * @return
     */
    public static int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int i = mySqrtRecursion(x);
        if (Math.pow(i, 2) >= x) {
            return (int) Math.ceil(Math.pow(2, i / 2.0));
        } else {
            return (int) Math.ceil(Math.pow(2, i / 2.0 + 1));
        }
    }

    public static int mySqrtRecursion(int x) {

        if (x == 1) {
            return 0;
        }

        return 1 + mySqrtRecursion(x / 2);
    }

    /**
     * 暴力解法
     * 46341 * 46341 结果是负数，因为结果溢出了
     * @param x
     * @return
     */
    public static int mySqrt2(int x) {
        for (int i = 0; ; i++) {
            if (i * i > x || i * i < 0) {
                return i - 1;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(mySqrt2(2147395600));
//
//        System.out.println(289398*289398);
//        System.out.println(46340*46340);

    }

}
