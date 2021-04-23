package com.benshell.pipeline.linktable;

public class Solution2 {

    public static void main(String[] args) {
        ListNode five = new ListNode(5);
        ListNode four = new ListNode(4,five);
        ListNode three = new ListNode(3,four);
        ListNode second = new ListNode(2,three);
        ListNode first = new ListNode(1,second);
//        ListNode second = new ListNode(2);
//        ListNode first = new ListNode(1,second);
//        ListNode result = removeNthFromEnd(first,1);
        ListNode result = removeNtHFromEnd1(first,2);
        while(result != null){
            System.out.print(result.val + "----->");
            result = result.next;
        }
        System.out.println(result == null);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        //方法1
        int size = 0 ;
        ListNode indexHead = head;
        while(indexHead != null){
            size++;
            indexHead = indexHead.next;
        }
        int target =  size - n;
        int count = 0;
        indexHead = head;
        ListNode prev = null;
        ListNode delete = null;
        while(indexHead != null){
            if(target == count){
                delete = indexHead;
                break;
            }
            else{
                prev = indexHead;
                indexHead = indexHead.next;
                count++;
            }
        }
        if(null != delete){
            if(null != prev){
                prev.next = delete.next;
                return head;
            }
            else{
                return delete.next;
            }
        }
        return null;
    }

    public static ListNode removeNtHFromEnd1(ListNode head,int n){
        int i = 0;
        int j = 0;
        ListNode prev = null;
        ListNode current = head;
        while(null != current){
            if(i - j >= n){
                if(prev == null){
                    prev = head;
                }
                else{
                    prev = prev.next;
                }
                j++;
            }
            current = current.next;
            i++;
        }
        if(null == prev){
            return head.next;
        }
        else{
            ListNode deleteNode = prev.next;
            prev.next = deleteNode.next;
            return head;
        }
    }
}
