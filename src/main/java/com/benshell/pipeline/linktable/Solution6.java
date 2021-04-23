package com.benshell.pipeline.linktable;

import java.util.ArrayList;
import java.util.List;

public class Solution6 {

    public static void main(String[] args) {

    }

    public static boolean hasCycle(ListNode head) {
        List<ListNode> recordList = new ArrayList<>();
        while(null != head){
            if(recordList.contains(head)){
                return false;
            }
            else{
                recordList.add(head);
            }
            head = head.next;
        }
        return true;
    }

    public static boolean hasCycle1(ListNode head){
        if(null == head){
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        do{
            if(null != fast.next ){
                fast = fast.next.next;
            }
            else{
                return false;
            }
            slow = slow.next;
            if(slow == fast){
                return true;
            }
        }while(null != fast);
        return false;
    }
}
