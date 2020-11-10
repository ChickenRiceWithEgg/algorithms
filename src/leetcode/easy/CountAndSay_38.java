package leetcode.easy;

/**
 * 给定一个正整数 n ，输出外观数列的第 n 项。
 * <p>
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
 * <p>
 * 你可以将其视作是由递归公式定义的数字字符串序列：
 * <p>
 * countAndSay(1) = "1"
 * countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
 * 前五项如下：
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 第一项是数字 1
 * 描述前一项，这个数是 1 即 “ 一 个 1 ”，记作 "11"
 * 描述前一项，这个数是 11 即 “ 二 个 1 ” ，记作 "21"
 * 描述前一项，这个数是 21 即 “ 一 个 2 + 一 个 1 ” ，记作 "1211"
 * 描述前一项，这个数是 1211 即 “ 一 个 1 + 一 个 2 + 二 个 1 ” ，记作 "111221"
 * 要 描述 一个数字字符串，首先要将字符串分割为 最小 数量的组，每个组都由连续的最多 相同字符 组成。然后对于每个组，先描述字符的数量，然后描述字符，形成一个描述组。要将描述转换为数字字符串，先将每组中的字符数量用数字替换，再将所有描述组连接起来。
 * <p>
 * 1 <= n <= 30
 */
public class CountAndSay_38 {

    public static void main(String[] args) {
        int n = 6;
        System.out.println(countAndSay2(n));
    }

    /**
     * 双指针+递归
     * 暴力解法，击败了5.5%的用户
     * 直接字符传拼接太慢了
     *
     * @param n
     * @return
     */
    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        if (n == 2) {
            return "11";
        }
        String n1 = countAndSay(n - 1);

        int length = n1.length();
        int low = 0;
        int num = 1;
        String result = "";
        for (int i = 1; i < length; i++) {
            char c = n1.charAt(i);
            char cLow = n1.charAt(low);
            if (cLow != c) {
                result += num + "" + cLow;
                low = i;
                num = 1;
            } else {
                num++;
            }
            if (i == length - 1) {
                result += num + "" + c;
            }
        }
        return result;
    }

    /**
     * 双指针+递归
     * 25 ms 击败了 8% 的用户
     * 把result改成StringBuffer，就能变成 17ms 击败了20%的用户
     * 把append(i - low + "" + cLow) 改成 append().append  变成了2ms，击败了68%的用户
     *
     * @param n
     * @return
     */
    public static String countAndSay2(int n) {
        if (n == 1) {
            return "1";
        }
        String n1 = countAndSay2(n - 1);

        int length = n1.length();
        int low = 0; //左指针记录某个数字的左边位置，当i遍历到相同数字时左指针不动，当i遍历到不同数字时，low会更新到该不同数字位置
        StringBuffer result = new StringBuffer(); //i作为右指针进行遍历
        for (int i = 0; i < length; i++) {
            char c = n1.charAt(i);
            char cLow = n1.charAt(low);
            if (cLow != c) {
                result.append(i - low).append(cLow);
                low = i;
            }
            if (i == length - 1) {
                result.append(i - low + 1).append(c);
            }
        }
        return result.toString();
    }
}