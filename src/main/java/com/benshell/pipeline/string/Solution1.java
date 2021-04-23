package com.benshell.pipeline.string;

public class Solution1 {

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
        String jj ="ss";
    }

    public static int reverse(int x){
        int value = 0;
        do{
            if(value == 0){
                value = x % 10;
            }
            else{
                value = value * 10 + x % 10;
            }
            x = x/10;
            if((value > 2147483647/10  &&  x != 0) || (value == 2147483647/10 && x < 2147483647 %7)){
                return 0;
            }
            if((value < -2147483648 / 10 &&  x != 0) || (value == -2147483648 / 10 && x != 0 && x > -2147483648 % 10)){
                return 0;
            }
        }
        while (x != 0);
        return value;
    }
}
