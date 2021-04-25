package com.benshell.pipeline.recursion;

public class StringReverse {


    public static void main(String[] args) {
        String test = "helloworld";
        char[] result = test.toCharArray();
        reverse(result,0,result.length - 1);
        System.out.println("result:" + new String(result));
    }

    public static void reverse(char[] result, int first,int end){
        if(first >= end){
            return ;
        }
        else{
            char temp = result[first];
            result[first] = result[end];
            result[end] = temp;
            reverse(result,++first,--end);
        }
    }
}
