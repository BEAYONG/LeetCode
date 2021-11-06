import java.beans.beancontext.BeanContextServicesListener;

public class Exercise21 {

    // Definition for singly-linked list.
    public static class ListNode {
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


    /**
     *
     * @param l1
     * @param l2
     * @return
     * 思路: 链表的值在做题的时候可以理解为存储了链表头节点的地址的数值,
     *       所以在赋值的时候也是赋地址值,
     *       不同的链表之间赋值可以理解为旧的指针指向了新的链表的头节点
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 创建一个链表结点,这个结点也叫哨兵结点
        // 可以在最后让我们比较容易地返回合并后的链表,result.next就是结果
        ListNode result = new ListNode(-1);
        ListNode temp = result;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                temp.next = l1;
                // l1指针后移
                l1 = l1.next;
            }else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        temp.next = (l1 == null) ? l2 : l1;
        return result.next;
    }
}
