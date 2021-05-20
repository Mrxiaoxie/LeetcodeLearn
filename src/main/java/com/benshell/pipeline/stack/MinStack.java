package com.benshell.pipeline.stack;

import java.util.ArrayList;
import java.util.List;

public class MinStack {

    private List<Integer> stack;
    private Integer min;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new ArrayList<>();
    }

    public void push(int val) {
        stack.add(val);
        if(min == null){
            min = val;
        }
        else if(min > val){
            min = val;
        }
    }

    public void pop() {
        Integer remove = stack.remove(stack.size() - 1);
        if(min.equals(remove)){
            //重新获取最新
            min = stack.get(0);
            for(int i = 1;i<stack.size();i++){
                if(min > stack.get(i)){
                    min = stack.get(i);
                }
            }
        }
    }

    public int top() {
        return stack.get(stack.size() - 1);
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}
