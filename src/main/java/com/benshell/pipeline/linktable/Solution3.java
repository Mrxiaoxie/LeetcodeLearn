package com.benshell.pipeline.linktable;

public class Solution3 {

    public static void main(String[] args) {
        ListNode five = new ListNode(5);
        ListNode four = new ListNode(4,five);
        ListNode three = new ListNode(3,four);
        ListNode second = new ListNode(2,three);
        ListNode first = new ListNode(1,second);
        ListNode result = reverseList(first);
        while(result != null){
            System.out.print(result.val + "----->");
            result = result.next;
        }
        System.out.println(result == null);
    }

    public static ListNode reverseList(ListNode head){
        ListNode current = head;
        ListNode prev = null;
        while(current != null){
            ListNode temp = current.next;
            if(prev == null){
                current.next = null;
            }
            else {
                current.next = prev;
            }
            prev = current;
            current = temp;
        }
        return prev;
    }

    public static ListNode reverseList1(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode result = reverseList1(head.next);
        result.next.next = head;
        head.next = null;
        return result;
    }
}
