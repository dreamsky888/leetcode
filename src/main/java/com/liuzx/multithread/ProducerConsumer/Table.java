package com.liuzx.multithread.ProducerConsumer;

/**
 * @author 刘钟鑫
 * @date 2019-12-03 14:50
 * @desc 队列
 **/
public class Table {

    private final String[] buffer;
    private int head;
    private int tail;
    private int count;
    private int total;

    public Table(int total) {
        this.buffer = new String[total];
        this.count = 0;
        this.head = 0;
        this.tail = 0;
        this.total = total;
    }

    public synchronized void put(String cake) throws InterruptedException {

        while (count == total) {
            this.wait();
        }
        System.out.println(
            "----------------------------------" + Thread.currentThread().getName() + " puts "
                + cake);
        buffer[tail] = cake;
        tail = (tail + 1) % total;
        count++;
        this.notifyAll();
    }

    public synchronized String take() throws InterruptedException {
        while (count <= 0) {
            this.wait();
        }
        String cake = buffer[head];
        head = (head + 1) % total;
        count--;
        this.notifyAll();
        System.out.println(Thread.currentThread().getName() + " takes " + cake);
        return cake;
    }
}
