package com.benshell.pipeline.linktable;

public class Solution4 {

    public static void main(String[] args) {
        ListNode l1 = generateListNode(new int[]{1,2,5,6,30});
        ListNode l2 = generateListNode(new int[]{1,3,4});
        ListNode result = mergeTwoListsTest(l1,l2);
        while(result != null){
            System.out.print(result.val + "----->");
            result = result.next;
        }
        System.out.println(result == null);
    }

    public static ListNode generateListNode(int[] values){
        ListNode endNode = new ListNode(values[values.length - 1]);
        for(int i = values.length - 2; i>= 0; i--){
            endNode = new ListNode(values[i],endNode);
        }
        return endNode;
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(null == l1 && null == l2){
            return null;
        }
        else if(null == l1 && null != l2){
            return l2;
        }
        else if(null != l1 && null == l2){
            return l1;
        }
        else{
            //两个都不为空
            ListNode head = null;
            ListNode current = null;
            while(null != l1 && null != l2){
                if(l1.val < l2.val){
                    if(head == null){
                        head = l1;
                        current = l1;
                    }
                    else{
                        current.next = l1;
                        current = l1;
                    }
                    l1 = l1.next;
                    if(null == l1){
                        current.next = l2;
                    }
                }
                else{
                    if(head == null){
                        head = l2;
                        current = l2;
                    }
                    else{
                        current.next = l2;
                        current = current.next;
                    }
                    l2 = l2.next;
                    if(null == l2){
                        current.next = l1;
                    }
                }

            }
            return head;
        }
    }


    public static ListNode mergeTwoListsTest(ListNode l1, ListNode l2){
        if(null == l1){
            return l2;
        }
        if(null == l2){
            return l1;
        }
        if(l1.val < l2.val){
            ListNode result = mergeTwoListsTest(l1.next,l2);
            l1.next = result;
            return l1;
        }
        else{
            ListNode result = mergeTwoListsTest(l1,l2.next);
            l2.next = result;
            return l2;
        }
    }

}
