package com.benshell.pipeline.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StringDecode {

    public String decodeString(String s) {
        StringBuilder result = new StringBuilder();
        Stack<String> strStack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        char[] chars = s.toCharArray();
        int nums = 0;
        for(int i = 0;i<chars.length;i++){
            if(chars[i] >= '0' && chars[i] <= '9'){
                //遇到数字了
                nums = nums * 10 + (chars[i] - '0');
            }
            else if((chars[i] == '[' || !strStack.isEmpty())  && chars[i] != ']'){
                if(chars[i] == '['){
                    countStack.add(nums);
                    nums = 0;
                }
                strStack.add(String.valueOf(chars[i]));
            }
            else if(chars[i] == ']'){
                //occur end symbol
                int count = countStack.pop();
                List<String> subResult = new ArrayList<>();
                while(!strStack.peek().equals("[")){
                    subResult.add(0,strStack.pop());
                }
                strStack.pop();
                StringBuilder subStr = new StringBuilder();
                for(int j = 0 ;j<count;j++){
                    // copy subResult count times
                    subStr.append(String.join("",subResult.toArray(new String[0])));
                }
                if(!strStack.isEmpty()){
                    strStack.add(subStr.toString());
                }
                else{
                    result.append(subStr.toString());
                }
            }
            else{
                result.append(chars[i]);
            }
        }
        return result.toString();
    }


    public static void main(String[] args) {
        StringDecode stringDecode = new StringDecode();
        System.out.println("result:" + stringDecode.decodeString("100[leetcode]"));
    }

}
