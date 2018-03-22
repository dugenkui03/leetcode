package list;

import resource.ListNode;

import java.util.Stack;

/**
 * @author 杜艮魁
 * @date 2018/3/20
 */
public class AddTwoNum {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null||l2==null) return l1==null?l2:l1;

        ListNode ta=l1,tb=l2;
        Stack<Integer> sa=new Stack<>();
        Stack<Integer> sb=new Stack<>();
        while(ta!=null){
            sa.push(ta.val);
            ta=ta.next;
        }
        while(tb!=null){
            sb.push(tb.val);
            tb=tb.next;
        }

        ListNode result=new ListNode(0),pre=result;
        int sum=0;
        while(!sa.empty()||!sb.empty()){
            if(!sa.empty()) sum+=sa.pop();
            if(!sb.empty()) sum+=sb.pop();

            ListNode tmp=new ListNode(sum%10);
            tmp.next=result.next;
            result.next=tmp;

            sum/=10;
        }

        if(sum==1){
            result.val=1;
            return result;
        }

        return result.next;
    }
}
