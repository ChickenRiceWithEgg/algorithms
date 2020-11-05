package leetcode.easy;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class MergeTwoLists_21 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(3, new ListNode(5)));
        ListNode l2 = new ListNode(2, new ListNode(4, new ListNode(6)));
//        ListNode l1 = null;
//        ListNode l2 = new ListNode(2, new ListNode(4, new ListNode(6)));

        ListNode l3 = m2(l1, l2);
        while (l3 != null) {
            System.out.println(l3.val);
            l3 = l3.next;
        }

    }

    /**
     * 迭代写法
     * 创建第三个链表用来保存最后结果
     * 注意两种链表的循环比较的方法
     * 判断 l1 和 l2 哪一个链表的头节点的值更小，将较小值的节点添加到结果里，当一个节点被添加到结果里之后，将对应链表中的节点向后移一位。
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode();
        ListNode l3_ = l3;
        while (l1 != null && l2 != null) {
            ListNode tmp;
            if (l1.val < l2.val) {
                l3_.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                l3_.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            l3_ = l3_.next;
        }


        l3_.next = l1 == null ? l2 : l1;
//        if (l1 == null && l2 != null) {
//            l3_.next = l2;
//        }
//        if (l1 != null && l2 == null) {
//            l3_.next = l1;
//        }

        return l3.next;
    }

    /**
     * 不是很理解递归（不限于这道题）
     * <p>
     * 如果 l1 或者 l2 一开始就是空链表 ，那么没有任何操作需要合并，所以我们只需要返回非空链表。
     * 否则，我们要判断 l1 和 l2 哪一个链表的头节点的值更小，然后递归地决定下一个添加到结果里的节点。
     * 如果两个链表有一个为空，递归结束。
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists/solution/he-bing-liang-ge-you-xu-lian-biao-by-leetcode-solu/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode m2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = m2(l1.next, l2);
            return l1;
        } else {
            l2.next = m2(l1, l2.next);
            return l2;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}

