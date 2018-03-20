package list;

import resource.ListNode;

/**
 * @author 杜艮魁
 * @date 2018/3/20
 */
public class MergeKList {

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length==0)
            return null;
        if(lists.length==1)
            return lists[0];

        ListNode dummy=new ListNode(Integer.MIN_VALUE);
        for (ListNode s1:lists) {
            dummy=merge(s1,dummy);
        }

        return dummy.next;
    }

    public static ListNode merge(ListNode l1,ListNode l2){
        if(l1==null||l2==null)
            return l1==null?l2:l1;

        ListNode dummy=new ListNode(0),sma=dummy;

        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                sma.next=l1;
                l1=l1.next;
            }else{
                sma.next=l2;
                l2=l2.next;
            }
            sma=sma.next;
        }

        if(l1==null){
            sma.next=l2;
        }else{
            sma.next=l1;
        }

        return dummy.next;
    }
}
