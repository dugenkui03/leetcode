package list;

import resource.ListNode;

/**
 * @author 杜艮魁
 * @date 2018/3/20
 */
public class ReverseKGroup {

    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head==null||head.next==null||k==1) return head;

        ListNode dummy=new ListNode(0),dummy2=dummy;

        dummy.next=head;
        ListNode preCurrent=head,current,countIndex=dummy2;

        while(preCurrent!=null){
            //检查以后的长度是否足够反转用
            int count=k;
            countIndex=dummy2;
            while(countIndex!=null&&count!=0){
                countIndex=countIndex.next;
                count--;
            }
            if(countIndex!=null&&count==0){//此时的长度可供翻滚
                int cou=k;
                while(cou--!=1){
                    current=preCurrent.next;

                    preCurrent.next=current.next;
                    current.next=dummy2.next;
                    dummy2.next=current;
                }
                dummy2=preCurrent;
                preCurrent=preCurrent.next;
            }else break;
        }
        return dummy.next;
    }

}
