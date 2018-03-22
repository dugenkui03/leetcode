package list;

import resource.ListNode;

/**
 * @author 杜艮魁
 * @date 2018/3/20
 */
public class ReverseList {

    //指针方式
    public ListNode reverseListPoint(ListNode head) {
        if(head==null||head.next==null) return head;

        ListNode dummy=new ListNode(0),current=dummy;
        dummy.next=head;

        while(head.next!=null){
            current=head.next;

            head.next=current.next;
            current.next=dummy.next;
            dummy.next=current;
        }

        return dummy.next;
    }

    //递归方式
    public ListNode reverseListRecursive(ListNode head) {
        if(head==null||head.next==null) return head;

        ListNode next=head.next;
        ListNode newHead=reverseListRecursive(next);
        next.next=head;
        head.next=null;//fixme 不可缺少，否则最后一个节点即原head会进入死循环

        return newHead;
    }
}
