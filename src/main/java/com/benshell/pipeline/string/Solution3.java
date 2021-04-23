package com.benshell.pipeline.string;

public class Solution3 {

    public static void main(String[] args) {
        System.out.println(isPalidrome("A man, a plan, a canal: Panama"));
    }


    public static boolean isPalidrome(String s){
        char[] result = s.toCharArray();
        int i = 0;
        int j = result.length - 1;
        do{
            char first = result[i];
            char last = result[j];
            if(!((first >= 'a' && first<='z') || (first >= 'A' && first <='Z') || (first >= '0' && first <= '9'))){
                //不是小写或大写或数字
                i++;
                continue;
            }
            else if(first >= 'A' && first <='Z'){
                first = (char)(first + 32);
            }
            if(!((last >= 'a' && last<='z') || (last >= 'A' && last <='Z') || (last >= '0' && last <= '9'))){
                //不是小写或大写或数字
                j--;
                continue;
            }
            else if(last >= 'A' && last <= 'Z'){
                last = (char)(last + 32);
            }
            //比较first和last
            if(first != last){
                return false;
            }
            else{
                i++;
                j--;
            }
        }
        while(i<j);
        return true;
    }
}
