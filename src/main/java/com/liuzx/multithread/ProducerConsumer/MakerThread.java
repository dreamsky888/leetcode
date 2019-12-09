package com.liuzx.multithread.ProducerConsumer;

import java.util.Random;

/**
 * @author 刘钟鑫
 * @date 2019-12-03 14:49
 * @desc 生产者线程
 **/
public class MakerThread extends Thread {

    private final Random random;
    private final Table table;
    private static int id = 0;

    public MakerThread(String name, Table table, long seed) {
        super(name);
        this.table = table;
        random = new Random(seed);
    }

    @Override
    public void run() {
        try {
            for (; ; ) {
                Thread.sleep(random.nextInt(1000));
                String cake = "[cake NO.%s by %s]";
                table.put(String.format(cake, getNextId(), Thread.currentThread().getName()));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static synchronized int getNextId() {
        return ++id;
    }
}
