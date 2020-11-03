package leetcode.easy;

import java.util.Arrays;
import java.util.List;

/**
 * 罗马数字转整数
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/roman-to-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处
 */
public class RomanToInt_13 {

    public static void main(String[] args) {
//        String s = "III";
//        String s = "XII";
//        String s = "IX";
//        String s = "XXVII";
//        String s = "LVIII";
        String s = "MCMXCIV";
        System.out.println(m1(s));
        System.out.println(m2(s));
        System.out.println(m3(s));
    }

    /**
     * 暴力解法
     *
     * @param s
     * @return
     */
    public static int m1(String s) {
        List<Character> special = Arrays.asList('I', 'X', 'C');

        char[] chars = s.toCharArray();
        int result = 0;
        for (int i = 0; i < chars.length; i++) {
            char ele = chars[i];
            if (i != chars.length - 1) {
                char eleNext = chars[i + 1];
                if (special.contains(ele)) {
                    if ('I' == ele) {
                        if ('V' == eleNext) {
                            result += 4;
                            i++;
                            continue;
                        }
                        if ('X' == eleNext) {
                            result += 9;
                            i++;
                            continue;
                        }
                        result += 1;
                    }
                    if ('X' == ele) {
                        if ('L' == eleNext) {
                            result += 40;
                            i++;
                            continue;
                        }
                        if ('C' == eleNext) {
                            result += 90;
                            i++;
                            continue;
                        }
                        result += 10;
                    }
                    if ('C' == ele) {
                        if ('D' == eleNext) {
                            result += 400;
                            i++;
                            continue;
                        }
                        if ('M' == eleNext) {
                            result += 900;
                            i++;
                            continue;
                        }
                        result += 100;
                    }
                } else {
                    switch (ele) {
                        case 'I':
                            result += 1;
                            break;
                        case 'V':
                            result += 5;
                            break;
                        case 'X':
                            result += 10;
                            break;
                        case 'L':
                            result += 50;
                            break;
                        case 'C':
                            result += 100;
                            break;
                        case 'D':
                            result += 500;
                            break;
                        case 'M':
                            result += 1000;
                    }
                }
            } else {
                switch (ele) {
                    case 'I':
                        result += 1;
                        break;
                    case 'V':
                        result += 5;
                        break;
                    case 'X':
                        result += 10;
                        break;
                    case 'L':
                        result += 50;
                        break;
                    case 'C':
                        result += 100;
                        break;
                    case 'D':
                        result += 500;
                        break;
                    case 'M':
                        result += 1000;
                }
            }
        }
        return result;
    }

    /**
     * 漂亮解法1
     * 小值在大值左边表示减去小值
     * 大值在小值左边表示加上大值
     *
     * @param s
     * @return
     */
    public static int m2(String s) {
        char[] eles = s.toCharArray();
        int preNum = swith(eles[0]);
        int result = 0;
        for (int i = 1; i < eles.length; i++) {
            int num = swith(eles[i]);
            if (preNum < num) {
                result -= preNum;
            }
            if (preNum >= num) {
                result += preNum;
            }
            preNum = num;
        }
        result += preNum;
        return result;
    }

    public static int swith(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    /**
     * 漂亮解法2
     * 将特殊数字替换成特定字符，然后直接获得数字
     *
     * @param s
     * @return
     */
    public static int m3(String s) {
        s = s.replace("IV", "a");
        s = s.replace("IX", "b");
        s = s.replace("XL", "c");
        s = s.replace("XC", "d");
        s = s.replace("CD", "e");
        s = s.replace("CM", "f");

        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result += swithForce(s.charAt(i));
        }
        return result;
    }

    public static int swithForce(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            case 'a':
                return 4;
            case 'b':
                return 9;
            case 'c':
                return 40;
            case 'd':
                return 90;
            case 'e':
                return 400;
            case 'f':
                return 900;
        }
        return 0;
    }
}