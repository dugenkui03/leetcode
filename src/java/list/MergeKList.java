package list;

import resource.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author 杜艮魁
 * @date 2018/3/20
 */
public class MergeKList {

    public static ListNode mergeKLists(ListNode[] lists) {
        //如果没有或者只有一个链表，则直接返回即可
        if(lists==null|| lists.length==0||lists.length==1){
            return (lists==null|| lists.length==0)?null:lists[0];
        }

        //设置优先队列：插入和删除的时间复杂度都是O(n)。注意其构造参数是队列容量和“比较类”；
        PriorityQueue<ListNode> queue=new PriorityQueue<>(lists.length,new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if(o1.val<o2.val)
                    return -1;
                return 1;
            }
        });

        // 将所有元素插入有限队列，时间复杂度是O(nlogn)；
        for (ListNode list:lists) {
            if(list!=null){
                queue.add(list);
            }
        }
        //取出所有元素并插入虚头部后边
        ListNode dummy=new ListNode(0),pre=dummy;
        while(!queue.isEmpty()){
            pre.next=queue.poll();
            pre=pre.next;

            if(pre.next!=null)
                queue.add(pre.next);
        }

        return dummy.next;
    }

}
