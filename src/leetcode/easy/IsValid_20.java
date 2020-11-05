package leetcode.easy;

import java.util.*;

/**
 * parentheses：圆括号
 * brackets：方括号
 * braces：大括号
 */
public class IsValid_20 {

    public static void main(String[] args) {
        String s = "{{{}}}";
        System.out.println(m1(s));
        System.out.println(m2(s));
    }

    /**
     * 暴力解法
     * 思路是对的，但是使用的是List来做栈，应该用java 的Deque
     *
     * @param s
     * @return
     */
    public static boolean m1(String s) {
        HashMap<Character, Character> brackets = new HashMap<>();
        brackets.put(')', '(');
        brackets.put(']', '[');
        brackets.put('}', '{');

        int length = s.length();
        if (length == 0) {
            return false;
        }
        List<Character> tmp = new ArrayList<>(length);
        if (brackets.containsKey(s.charAt(0))) {
            return false;
        } else {
            tmp.add(s.charAt(0));
        }

        for (int i = 1; i < length; i++) {
            char c = s.charAt(i);
            //左括号直接放入临时数组
            if (brackets.containsValue(c)) {
                tmp.add(c);
            }
            //右括号则判断临时数组最后一个元素x能否匹配，若匹配则弹出元素x，若不匹配则返回false
            if (brackets.containsKey(c)) {
                if (tmp.size() == 0) {
                    return false;
                }
                int x = tmp.size() - 1;
                if (tmp.get(x) == brackets.get(c)) {
                    tmp.remove(x);
                } else {
                    return false;
                }
            }
        }
        if (tmp.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean m2(String s) {
        int length = s.length();
        if (length % 2 != 0) {
            return false;
        }

        HashMap<Character, Character> brackets = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};

        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            //右括号
            if (brackets.containsKey(c)) {
                //放入右括号时，如果栈为空或栈尾元素不匹配，则表示错误
                if (stack.isEmpty() || stack.peek() != brackets.get(c)) {
                    return false;
                }
                //放入右括号时，和栈尾元素匹配，则将栈尾元素弹出
                stack.pop();
            } else {
                stack.push(c); //左括号则放入
            }
        }
        return stack.isEmpty();
    }
}