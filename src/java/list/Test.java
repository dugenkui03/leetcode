package list;

import resource.ListNode;

/**
 * @author 杜艮魁
 * @date 2018/3/20
 */
public class Test {
    public static void main(String[] args) {
        ListNode head=new ListNode(-1);
        head.next=new ListNode(-1);
        head.next.next=new ListNode(-1);
        ListNode head2=new ListNode(-2);
        head2.next=new ListNode(-2);
        head2.next.next=new ListNode(-1);

        ListNode lists[]={head,head2};

        long t1=System.currentTimeMillis();

        MergeKList.mergeKLists(lists);
        MergeKList.mergeKLists(lists);


        long t2=System.currentTimeMillis();

        System.out.println(t2-t1);

    }
}
