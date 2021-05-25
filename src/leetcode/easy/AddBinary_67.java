package leetcode.easy;

/**
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * <p>
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 * <p>
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *  
 * <p>
 * 提示：
 * <p>
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 */
public class AddBinary_67 {

    /**
     * 思路：
     * 使用数组存放二进制数据，从后往前遍历。每位相加的操作使用异或操作^，。
     * a，b的长度不等怎么办？遍历长的并直接在上面修改
     * 进位怎么办？使用一个标志位，最后在字符串前面拼接一个'1'
     * <p>
     * 成通过但是不是最优解
     * 主要问题：
     * 1、两位相加之后的值和进位，没能简单明了的通过式子表达出来
     * 2、对于数字内容的字符串不知道怎么获取单个数字
     *
     * @param a
     * @param b
     * @return
     */
    public static String addBinary(String a, String b) {

        String longStr = a.length() > b.length() ? a : b;
        String shortStr = a.length() > b.length() ? b : a;
        String result = "";
        boolean up = false;
        for (int i = longStr.length() - 1; i >= 0; i--) {
            int c1 = Integer.parseInt(longStr.substring(i, i + 1));
            int c2;
            int shortIndex = i - (longStr.length() - shortStr.length());
            if (shortIndex < 0) {
                c2 = 0;
            } else {
                c2 = Integer.parseInt(shortStr.substring(shortIndex, shortIndex + 1));
            }
            int val = c1 ^ c2;
            if (up) {
                val = val ^ 1;
            }
            result = val + result;
            up = (c1 == 1 && c2 == 1) || ((c1 != 0 || c2 != 0) && up);
        }
        if (up) {
            result = '1' + result;
        }
        return result;
    }

    /**
     * 从低位开始遍历，同时遍历a和b，遍历完短的之后就只遍历长的
     * 进位的计算：(a[i] + b[j] + carry) / 2
     * 每一位的值：(a[i] + b[j] + carry) % 2
     *
     * @param a
     * @param b
     * @return
     */
    public static String addBinary2(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        StringBuffer ans = new StringBuffer();

        int carry = 0;
        while (i >= 0 && j >= 0) {
            int sum = carry;
            sum += a.charAt(i--) - '0';
            sum += b.charAt(j--) - '0';
            carry = sum / 2;
            ans.append(sum % 2);
        }
        while (i >= 0) {
            int sum = carry + (a.charAt(i--) - '0');
            carry = sum / 2;
            ans.append(sum % 2);
        }
        while (j >= 0) {
            int sum = carry + (b.charAt(j--) - '0');
            carry = sum / 2;
            ans.append(sum % 2);
        }
        if (carry == 1) {
            ans.append("1");
        }
        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        String s = addBinary2("1010", "1011");
        System.out.println();
    }

}
