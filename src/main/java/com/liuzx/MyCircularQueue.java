package com.liuzx;

/**
 * @Author: liuzx
 * @Date: 2019/8/20 17:50
 * @Description:
 **/
public class MyCircularQueue {

    int[] datas;
    int head;
    int tail;
    int size;
    int capacity;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public MyCircularQueue(int k) {
        datas = new int[k];
        head = -1;
        tail = -1;
        size = 0;
        capacity = k;
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (size == capacity) {
            return false;
        }
        if (size == 0) {
            head = tail = 0;
        } else {
            if (++tail == capacity) {
                tail = 0;
            }
        }
        datas[tail] = value;
        size++;
        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (size == 0) {
            return false;
        }
        if (size == 1) {
            head = tail = -1;
        } else {
            if (++head == capacity) {
                head = 0;
            }
        }
        size--;
        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        return size == 0 ? -1 : datas[head];
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        return size == 0 ? -1 : datas[tail];
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return size == capacity;
    }

    public static void main(String[] args) {
        MyCircularQueue obj = new MyCircularQueue(6);
        obj.enQueue(6);
        obj.Rear();
        obj.Rear();
        obj.deQueue();
        obj.enQueue(5);
        obj.Rear();
        obj.deQueue();
        obj.Front();
        obj.deQueue();
        obj.deQueue();
        obj.deQueue();
    }
}
