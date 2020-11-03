package leetcode.easy;

/**
 * 回文数
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 */
public class IsPalindrome_9 {

    public static void main(String[] args) {
        int a = 112303211;
        System.out.println(m2(a));
    }

    /**
     * 暴力解法
     * O(n)
     * 将int转成字符串再转成数组遍历
     *
     * @param x
     * @return
     */
    public static boolean m1(int x) {
        char[] chars = String.valueOf(x).toCharArray();
        int length = chars.length;
        int half = length / 2;
        for (int i = 0; i < half; i++) {
            if (chars[i] == chars[length - i - 1]) {
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * 优化解法
     * 不将int转成字符串
     * 通过 / 和 % 运算分别获得首位和末尾数字进行比较
     *
     * @param x
     * @return
     */
    public static boolean m2(int x) {
        if (x < 0) {
            return false;
        }

        int help = 1;
        int tmp = x;
        while (tmp >= 10) {
            help = help * 10;
            tmp = tmp / 10;
        }

        while (x != 0) {
            int first = x / help;  //首位数字
            int last = x % 10;     //末尾数字
            if (!(first == last)) {
                return false;
            }
            x = x % help / 10;      //去掉首位和末尾数字
            help = help / 100;      //因为x减少了2位，所以help要/100L
        }
        return true;
    }
}