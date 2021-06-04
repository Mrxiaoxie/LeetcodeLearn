package com.benshell.pipeline.stack;

import java.util.Stack;

public class MyQueue {

    private Stack<Integer> stack = new Stack<>();

    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        Stack<Integer> stackHelper = new Stack<>();
        while(!stack.isEmpty()){
            stackHelper.add(stack.pop());
        }
        stack.add(x);
        while(!stackHelper.isEmpty()){
            stack.add(stackHelper.pop());
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return stack.pop();
    }

    /** Get the front element. */
    public int peek() {
        return stack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return  stack.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
//        System.out.println(myQueue.pop());
        System.out.println(myQueue.empty());
    }
}
