package com.benshell.pipeline.string;

public class Solution5 {

    public static void main(String[] args) {
//        System.out.println(strStr2("aaaaa","bba"));
//        int[] result = getNext("ABCAB");
//        for(int i = 0;i<result.length;i++){
//            System.out.print(result[i] + " ");
//        }
        System.out.println(strStrKMP("aaaaa","bba"));
    }

    public static int strStr(String haystack, String needle){
        if(needle.length() == 0){
            return 0;
        }
        for(int i = 0;i<haystack.length(); i++){
            if(haystack.charAt(i) == needle.charAt(0)){
                int j = 1;
                for( ;j<needle.length();j++){
                    if(i + j >= haystack.length()){
                        break;
                    }
                    if(haystack.charAt(i+j) != needle.charAt(j)){
                        break;
                    }
                }
                if( j == needle.length()){
                    return i;
                }
            }
        }
        return -1;
    }

    public static int strStr2(String haystack, String needle){
        if(needle.length() == 0){
            return 0;
        }
        if(haystack.length() < needle.length()){
            return -1;
        }
        int i = 0;
        int j = 0;
        while(i < haystack.length()){
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }
            else{
                if(haystack.length() - i + j <= needle.length()){
                    return -1;
                }
                i = i - j + 1;
                j = 0;
            }
            if(j == needle.length()){
                return i-j;
            }
        }
        return -1;
    }

    public static int strStrKMP(String haystack, String needle){
        if(needle.length() == 0){
            return 0;
        }
        int[] next = getNext(needle);
        char[] haystackchars = haystack.toCharArray();
        char[] needlechars = needle.toCharArray();
        int i =0;
        int j =0;
        while(i < haystackchars.length && j < needlechars.length){
            if(j == -1 || haystackchars[i] == needlechars[j]){
                i++;
                j++;
            }
            else{
                j = next[j];
            }
        }
        if(j >= needlechars.length){
            return i - j;
        }
        return -1;
    }


    public static int[] getNext(String needle){
        int[] next = new int[needle.length()];
        int i =0;
        int j = -1;
        next[0] = -1;
        while(i < needle.length() - 1 ){
            if(j == -1 || needle.charAt(i) == needle.charAt(j)){
                next[++i] = ++j;
            }
            else{
                j = next[j];
            }
        }
        return next;
    }
}
