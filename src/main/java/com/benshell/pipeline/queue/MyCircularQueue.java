package com.benshell.pipeline.queue;

public class MyCircularQueue {

    int[] queue;
    int size =0;
    int first=0;
    int end=0;

    public MyCircularQueue(int k){
        queue = new int[k];
    }

    public boolean enQueue(int value) {
        if(size == queue.length){
            return false;
        }
        queue[end++] = value;
        if(end  == queue.length){
            end = 0;
        }
        size++;
        return true;
    }

    public boolean deQueue() {
        if(size == 0){
            return false;
        }
        size--;
        first = (first + 1) % queue.length;
        return true;
    }

    public int Front() {
        if(size > 0){
            return queue[first];
        }
        return -1;
    }

    public int Rear() {
        if(size > 0){
            return queue[(end - 1 + queue.length) % queue.length];
        }
        return -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == queue.length;
    }

    public static void main(String[] args) {
        MyCircularQueue circularQueue = new MyCircularQueue(3);
        circularQueue.enQueue(1);
        circularQueue.enQueue(2);
        circularQueue.enQueue(3);
        System.out.println(circularQueue.enQueue(4));
        System.out.println(circularQueue.Rear());
        System.out.println(circularQueue.isFull());
        System.out.println(circularQueue.deQueue());
        System.out.println(circularQueue.enQueue(4));
        System.out.println(circularQueue.Rear());
    }
}
