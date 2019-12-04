package com.liuzx.multithread.ProducerConsumer;

import lombok.val;

/**
 * @author 刘钟鑫
 * @date 2019-12-03 15:11
 * @desc
 **/
public class Main {

    public static void main(String[] args) {
        val table = new Table(3);
        new MakerThread("make_1", table, 3843).start();
        new MakerThread("make_2", table, 454323).start();
        new MakerThread("make_3", table, 56544).start();
        new EaterThread("eater_1", table, 754645).start();
        new EaterThread("eater_2", table, 564553).start();
        new EaterThread("eater_3", table, 5754654).start();

    }
}
