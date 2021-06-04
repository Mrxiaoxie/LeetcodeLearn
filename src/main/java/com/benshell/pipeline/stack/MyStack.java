package com.benshell.pipeline.stack;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {

    Queue<Integer> realQueue = new LinkedList<>();
    /** Initialize your data structure here. */
    public MyStack() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        Queue<Integer> queueHelper = new LinkedList<>();
        while(!realQueue.isEmpty()){
            queueHelper.add(realQueue.poll());
        }
        realQueue.add(x);
        while(!queueHelper.isEmpty()){
            realQueue.add(queueHelper.poll());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return realQueue.poll();
    }

    /** Get the top element. */
    public int top() {
        return realQueue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return realQueue.isEmpty();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());
    }
}
