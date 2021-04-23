package com.benshell.pipeline.string;

public class Solution7 {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"dog","racecar","car"}));
    }

    public static String longestCommonPrefix(String[] strs){
        if(strs.length == 0){
            return "";
        }
        else if(strs.length == 1){
            return strs[0];
        }
        else{
            String common = common(strs[0],strs[1]);
            for(int i = 2; i<strs.length;i++){
                if(common.isEmpty()){
                    return "";
                }
                else{
                    common = common(common,strs[i]);
                }
            }
            return common;
        }
    }

    public static String common(String a,String b){
        char[] achars = a.toCharArray();
        char[] bchars = b.toCharArray();
        int length = Math.min(achars.length, bchars.length);
        StringBuilder result = new StringBuilder();
        for(int i = 0; i<length;i++){
            if(achars[i] == bchars[i]){
                result.append(achars[i]);
            }
            else{
                break;
            }
        }
        return result.toString();
    }
}
