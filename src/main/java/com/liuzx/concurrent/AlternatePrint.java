package com.liuzx.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: liuzx
 * @Date: 2019/10/17 15:26
 * @Description: 交替打印1-100
 **/
public class AlternatePrint {
    private static final int MAX_VALUE = 100;
    private AtomicInteger num = new AtomicInteger(1);
    private Object oddLock = new Object();
    private Object evenLock = new Object();

    class MyThread1 implements Runnable {
        private int type;

        public MyThread1(int type) {
            this.type = type;
        }

        @Override
        public void run() {
            while (num.get() <= MAX_VALUE) {
                synchronized (AlternatePrint.class) {
                    if (num.get() <= MAX_VALUE && num.get() % 2 == type) {
                        System.out.println("线程ID：" + Thread.currentThread().getId() + ",值：" + num.getAndIncrement());
                    }
                }
            }
        }
    }

    class MyThread2 implements Runnable {
        private int type;

        public MyThread2(int type) {
            this.type = type;
        }

        @Override
        public void run() {
            while (num.get() <= MAX_VALUE) {
                if (num.get() % 2 == type) {
                    System.out.println("线程ID：" + Thread.currentThread().getId() + ",值：" + num.get());
                    if (type == 0) {
                        synchronized (oddLock) {
                            num.incrementAndGet();
                            oddLock.notify();
                        }
                    } else {
                        synchronized (evenLock) {
                            num.incrementAndGet();
                            evenLock.notify();
                        }
                    }
                    try {
                        if (type == 0) {
                            synchronized (evenLock) {
                                evenLock.wait();
                            }
                        } else {
                            synchronized (oddLock) {
                                oddLock.wait();
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                }

            }
        }
    }

    public static void main(String[] args) {
        AlternatePrint alternatePrint = new AlternatePrint();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(alternatePrint.new MyThread2(0));
        executorService.submit(alternatePrint.new MyThread2(1));
    }
}
