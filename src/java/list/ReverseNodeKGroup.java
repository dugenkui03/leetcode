package list;

import resource.ListNode;

/**
 * @author 杜艮魁
 * @date 2018/3/22
 */
public class ReverseNodeKGroup {
    static ListNode tag=new ListNode(0);

    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head==null||head.next==null||k==1) return head;

        ListNode dummy=new ListNode(0),pre=dummy;
        dummy.next=head;

        ListNode tail=head;

        while(true){
            //找到反转的起始节点
            int index=k-1;
            while(index!=0&&tail!=null){//
                tail=tail.next;
                index--;//fixme 放到判定条件处，及时index=0，也会导致其自减
            }

            if(index==0&&tail!=null){//说明tail及之前的都是需要反转的节点
                ListNode next=tail.next;//标志下一段
                pre.next=reverse(head,tail);

                //归位
                head=next;
                pre=tag;
                pre.next=head;
                tail=head;
            }else break;
        }

        return dummy.next;
    }

    //[head,tail]链表段反转
    private static ListNode reverse(ListNode head,ListNode tail){//这两个参数已经没有了前后顺序
        if(head==null||head.next==null) return head;

        tag=head;
        ListNode pre=null;
        while(pre!=tail){//注意这里
            ListNode next=head.next;

            head.next=pre;
            pre=head;
            head=next;
        }

        return pre;
    }

    public static void main(String[] args) {

    }
}
