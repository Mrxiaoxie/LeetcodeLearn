package com.benshell.pipeline.other;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class GCD {

    public static void main(String[] args) {
//        System.out.println(gcd(0,270));
        List<Integer> testList = new ArrayList<>();
        testList.add(1);
        testList.add(6);
        testList.add(3);
        testList.add(4);
        testList.add(5);
//        System.out.println(sum(testList));
//        System.out.println(count(testList));
//        System.out.println(max(testList));
        System.out.println(binarySearch(new int[]{1,2,3},1,0,2));
    }

    public static int gcd(int val1, int val2){
        if(val2 == 0){
            return val1;
        }
        if(val1 == 0){
             return val2;
        }
        if(val1 > val2){
            return gcd(val2, val1 % val2);
        }
        else{
            return gcd(val2,val2 %val1);
        }
    }

    public static int sum(List<Integer> sumList){
        if(sumList.isEmpty()) {
            return 0;
        }
        if(sumList.size() == 1){
            return sumList.get(0);
        }
        else{
            Integer pop = sumList.remove(0);
            return pop + sum(sumList);
        }
    }

    public static int count(List<Integer> list){
        if(list.isEmpty()){
            return 0;
        }
        else{
            list.remove(0);
            return 1 + count(list);
        }
    }

    public static int max(List<Integer> list){
        if(list.isEmpty()){
            throw new RuntimeException("列表中没有数字");
        }
        Integer first = list.remove(0);
        System.out.println("first:" + first);
        if(list.size() == 0) {
            return first;
        }
        return Math.max(first,max(list));
    }

    public static int binarySearch(int[] list, int num, int begin, int end){
        if(null == list || begin < 0  || end > list.length || begin > end){
            return -1;
        }
        int mid = (begin + end) / 2;
        if(list[mid] > num){
            //front part
            return binarySearch(list,num,begin,mid - 1);
        }
        else if(list[mid] < num){
            // 后面的部分
            return binarySearch(list,num,mid + 1,end);
        }
        else{
            return mid;
        }
    }
}
