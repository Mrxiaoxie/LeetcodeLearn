package com.benshell.pipeline.queue;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SquareSum {

    public static void main(String[] args) {
        SquareSum squareSum = new SquareSum();
        System.out.println(squareSum.numSquares(7168));
    }

    public int numSquares(int n) {
        int count = 1;
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        //获取第一层
        for(int i = 1; i<=n;i++){
            if(i*i < n){
                visited.add(i * i);
                queue.add(i*i);
            }
            else if(i * i == n){
                return count;
            }
            else{
                break;
            }
        }
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i =0;i<size;i++){
                Integer item = queue.poll();
                //不等于n 则尝试把平方数加入队列直到item + 平方数 > n
                for(int j = 1;j<=n-item;j++){
                    if(j * j < n - item){
                        if(!visited.contains(j * j + item)){
                            //去掉重复结果 例如 某个节点为10 另外一个节点也为10 就没有必要查找后面的10节点了
                            queue.add(j * j + item);
                            visited.add(j * j + item);
                        }
                    }
                    else if(j* j + item == n){
                        return count + 1;
                    }
                    else{
                        break;
                    }
                }
            }
            count++;
        }
        return count;
    }
}
