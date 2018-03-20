package list;

import resource.RandomListNode;

/**
 * @author 杜艮魁
 * @date 2018/3/20
 */
public class CopyRandomList {

    public RandomListNode copyRandomList(RandomListNode head){
        RandomListNode iter=head,next;

        while(iter!=null){
            next=iter.next;

            RandomListNode copy=new RandomListNode(iter.label);
            iter.next=copy;
            copy.next=next;

            iter=next;
        }

        iter=head;
        while(iter!=null){
            if(iter.random!=null){
                iter.next.random=iter.random.next;
            }
            iter=iter.next.next;
        }

        iter=head;
        RandomListNode pseudoHead=new RandomListNode(0);
        RandomListNode copy,copyIter=pseudoHead;

        while(iter!=null){
            next=iter.next.next;

            copy=iter.next;
            copyIter.next=copy;
            copyIter=copy;

            iter.next=next;
            iter=next;
        }
        return pseudoHead.next;
    }
}
