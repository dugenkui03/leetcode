package list;

import resource.ListNode;

/**
 * 237
 * @author 杜艮魁
 * @date 2018/3/20
 */
public class DelNodeInList {
    public void deleteNode(ListNode node) {
       node.val=node.next.val;
       node.next=node.next.next;
    }
}
