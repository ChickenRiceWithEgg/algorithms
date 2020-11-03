package learn.sort;

import java.util.Arrays;

public class CommonUtil {

    public static void show(Integer[] a) {
        Arrays.asList(a).forEach(System.out::println);
    }

    public static void exchange(Integer[] a, int index1, int index2) {
        int tmp = a[index1];
        a[index1] = a[index2];
        a[index2] = tmp;
    }
}
