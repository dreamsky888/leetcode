package com.liuzx.multithread.ProducerConsumer;

import java.util.Random;

/**
 * @author 刘钟鑫
 * @date 2019-12-03 14:49
 * @desc 消费者线程
 **/
public class EaterThread extends Thread {

    private final Random random;
    private final Table table;

    public EaterThread(String name, Table table, long seed) {
        super(name);
        this.table = table;
        random = new Random(seed);
    }

    @Override
    public void run() {
        try {
            for (; ; ) {
                Thread.sleep(random.nextInt(1000));
                table.take();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
