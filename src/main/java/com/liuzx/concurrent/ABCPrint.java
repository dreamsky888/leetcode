package com.liuzx.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: liuzx
 * @Date: 2019/10/17 17:32
 * @Description:
 **/
public class ABCPrint {
    private AtomicInteger num = new AtomicInteger(0);
    private AtomicInteger count = new AtomicInteger(1);
    private ReentrantLock lock = new ReentrantLock();
    private Condition[] conditions = new Condition[3];
    private char[] alp = new char[]{'A', 'B', 'C'};

    {
        for (int i = 0; i < 2; i++) {
            conditions[i] = lock.newCondition();
        }
    }

    class MyThread implements Runnable {
        private int index;

        public MyThread(int index) {
            this.index = index;
        }

        @Override
        public void run() {
            while (count.get() <= 3) {
                System.out.println("线程" + index + "轮询");
                lock.lock();
                System.out.println("线程" + index + "拿到锁");
                try {
                    if (num.get() != index) {
                       continue;
                    }
                    if (count.get() <= 3) {
                        System.out.println(Thread.currentThread().getId() + ":" + alp[index]);
                        if (index == 2) {
                            count.incrementAndGet();
                        }

                    }
                    int i = num.get();
                    int nextIndex = i+1;
                    if (nextIndex == 3) {
                        nextIndex=0;
                        num.set(nextIndex);
                    }
                    conditions[nextIndex].signal();
                    System.out.println("线程" + index + "唤醒线程" + num.get());
                    conditions[i].await();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }

            }
        }
    }

    public static void main(String[] args) {
        ABCPrint abcPrint = new ABCPrint();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(abcPrint.new MyThread(0));
        executorService.submit(abcPrint.new MyThread(1));
        executorService.submit(abcPrint.new MyThread(2));
    }
}
