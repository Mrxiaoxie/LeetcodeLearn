package com.benshell.pipeline.string;

public class Solution4 {

    public static void main(String[] args) {
        System.out.println(myAtoi("-2147483649"));
//        System.out.println(-5%10);
    }

    public static int myAtoi(String s){
        char[] result = s.toCharArray();
        int flag = 0;
        int value = 0;
        for(int i =0;i< result.length;i++){
            if(flag == 0 && result[i] == ' '){
                continue;
            }
            else if(flag == 0 && result[i] == '-'){
                //负数
                flag = -1;
                continue;
            }
            else if( flag == 0 && result[i] == '+'){
                //正数
                flag = 1;
                continue;
            }
            if(result[i] < '0' || result[i] > '9'){
                break;
            }
            else{
                int resultInt = result[i] - 48;
                if(flag == 0){
                    flag = 1;
                }
                //判断是否超出范围
                if(value > Integer.MAX_VALUE/10 || (value == Integer.MAX_VALUE /10 && resultInt > Integer.MAX_VALUE % 10)){
                    return Integer.MAX_VALUE;
                }
                if(value < Integer.MIN_VALUE/10 || ( value == Integer.MIN_VALUE / 10 && -resultInt < Integer.MIN_VALUE %10)){
                    return Integer.MIN_VALUE;
                }
                //判断是否首次赋值
                if(value == 0){
                    if(flag == -1 && resultInt != 0){
                        //负数
                        value = -resultInt;
                    }
                    else{
                        value = resultInt;
                    }
                }
                else{
                    if(flag == -1){
                        value = value * 10 - resultInt;
                    }
                    else{
                        value = value * 10 + resultInt;
                    }
                }
            }
        }
        return value;
    }
}
