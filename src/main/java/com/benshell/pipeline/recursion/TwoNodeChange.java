package com.benshell.pipeline.recursion;

import com.benshell.pipeline.linktable.ListNode;

public class TwoNodeChange {

    public static void main(String[] args) {

    }

    public ListNode swapPairs(ListNode head){
        if(null == head || null == head.next){
            return head;
        }
        ListNode thirdNode = head.next.next;
        ListNode secondNode = head.next;
        secondNode.next = head;
        head.next = swapPairs(thirdNode);
        return secondNode;
    }

}
