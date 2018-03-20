package list;

import resource.ListNode;
/**
 * @author 杜艮魁
 * @date 2018/3/19
 */
public class MergeSortList {
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode pointer = head.next;
        ListNode middle = head;
        middle.next = null;
        ListNode left = null;
        ListNode right = null;
        while (pointer != null) {
            ListNode buffer = pointer;
            pointer = pointer.next;
            if (buffer.val == middle.val) {
                buffer.next = middle;
                middle = buffer;
            } else if (buffer.val < middle.val) {
                buffer.next = left;
                left = buffer;
            } else {
                buffer.next = right;
                right = buffer;
            }
        }
        left = sortList(left);
        right = sortList(right);
        if (left == null) {
            left = middle;
        } else {
            pointer = left;
            while (pointer.next != null) {
                pointer = pointer.next;
            }
            pointer.next = middle;
        }
        head.next = right;
        return left;
    }

    public static void main(String[] args) {
        while('a'==1||2==2){

        }
    }
}
