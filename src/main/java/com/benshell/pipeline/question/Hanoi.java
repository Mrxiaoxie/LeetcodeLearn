package com.benshell.pipeline.question;

import java.util.ArrayList;
import java.util.List;

public class Hanoi {

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>();
        A.add(2);
        A.add(1);
        A.add(0);
        List<Integer> B = new ArrayList<>();
        List<Integer> C = new ArrayList<>();
        hanota(A,B,C);
        for(Integer x : C){
            System.out.println(x);
        }
    }

    public static void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        if(A.isEmpty()){
            return ;
        }
        hanota(A.size(),A,B,C);
    }

    public static void hanota(int n, List<Integer> A,List<Integer> B, List<Integer> C){
        if(n == 1){
            C.add(A.remove(A.size() - 1));
        }
        else{
            hanota(n-1,A,C,B);
            Integer move = A.remove(A.size() -1);
            C.add(move);
            hanota(n-1,B,A,C);
        }
    }
}
