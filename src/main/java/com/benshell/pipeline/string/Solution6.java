package com.benshell.pipeline.string;

public class Solution6 {

    public static void main(String[] args) {
        System.out.println(countAndSay1(2));
    }

    public static String countAndSay(int n){
        String value = "1";
        for(int i =1;i<n;i++){
            value = say(value);
        }
        return value;
    }

    public static String say(String value){
        char[] valueChars = value.toCharArray();
        char prev = valueChars[0];
        int count = 1;
        StringBuilder result = new StringBuilder();
        for(int i = 1; i< valueChars.length;i++){
            if(prev == valueChars[i]){
                count++;
            }
            else{
                result.append(count).append(prev);
                count=1;
                prev=valueChars[i];
            }
        }
        result.append(count).append(prev);
        return result.toString();
    }


    public static String countAndSay1(int n ){
        if(n == 1){
            return "1";
        }
        String val = countAndSay1(n-1);
        char[] valchars = val.toCharArray();
        StringBuilder result = new StringBuilder();
        int count = 1;
        char prev = valchars[0];
        for(int i = 1;i<=valchars.length;i++){
            if(i == valchars.length){
                result.append(count).append(prev);
            }
            else{
                if(prev == valchars[i]){
                    count ++;
                }
                else{
                    result.append(count).append(prev);
                    prev = valchars[i];
                    count = 1;
                }
            }
        }
        return result.toString();
    }
}
