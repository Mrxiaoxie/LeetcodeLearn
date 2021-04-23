package com.benshell.pipeline.linktable;

import java.util.ArrayList;
import java.util.List;

public class Solution5 {

    public static void main(String[] args) {
        ListNode head = Solution4.generateListNode(new int[]{1,2,2,2,1});
        System.out.println(isPalindrome(head));
    }

    public static boolean isPalindrome(ListNode head) {
        List<Integer> values = new ArrayList<>();
        while(head != null){
            values.add(head.val);
            head = head.next;
        }
        for(int i = 0;i<values.size()/2;i++){
            if(values.get(i) != values.get(values.size() - i - 1)){
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindromeUp(ListNode head){
        return false;
    }
}
