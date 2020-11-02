package learn.sort;

import java.util.Arrays;

/**
 * 选择排序
 */
public class Selection {

    public static void main(String[] args) {
        Integer[] a = {4, 2, 7, 9, 3, 5, 7, 9};
        show(selection(a));
    }

    /**
     * 对数据进行选择排序
     *
     * @param a
     */
    public static Integer[] selection(Integer[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            exchange(a, i, min);
        }
        return a;
    }

    public static void exchange(Integer[] a, int index1, int index2) {
        int tmp = a[index1];
        a[index1] = a[index2];
        a[index2] = tmp;
    }

    public static void show(Integer[] a) {
        Arrays.asList(a).forEach(System.out::println);
    }
}
