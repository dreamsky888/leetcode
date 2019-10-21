package com.liuzx.sort;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: liuzx
 * @Date: 2019/9/27 14:11
 * @Description: 快速排序
 **/
public class QuickSort {
    //递归实现
    public void quickSort(int[] datas, int begin, int end) {
        if (end - begin < 1) {
            return;
        }

        int position = getPosition(datas, begin, end);
        quickSort(datas, begin, position - 1);
        quickSort(datas, position + 1, end);
    }

    static class Data {

        public int begin;
        public int end;

        Data(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }
    }

    //非递归实现
    public void quickSort2(int[] datas) {
        if (datas.length < 2) {
            return;
        }
        Queue<Data> queue = new LinkedList<>();
        queue.add(new Data(0, datas.length-1));
        while (!queue.isEmpty()) {
            Data data = queue.poll();
            int position = getPosition(datas, data.begin, data.end);
            if (data.begin < position - 1) {
                queue.add(new Data(data.begin, position - 1));
            }
            if (position + 1 < data.end) {
                queue.add(new Data(position + 1, data.end));
            }
        }

    }

    //普通的交换法
    private int getPosition(int[] datas, int begin, int end) {
        int pivot = ((end - begin) >> 1) + begin;
        int pivotValue = datas[pivot];
        swap(datas, pivot, end);
        int i = begin, j = end - 1;
        for (; ; ) {
            while (i <= end && datas[i] < pivotValue) {
                i++;
            }
            while (j >= begin && datas[j] >= pivotValue) {
                j--;
            }
            if (i > j) {
                break;
            }
            swap(datas, i, j);
        }
        swap(datas, i, end);
        return i;
    }

    private void swap(int[] datas, int i, int j) {
        int iValue = datas[i];
        datas[i] = datas[j];
        datas[j] = iValue;
    }

    public static void main(String[] args) {
        QuickSort sort = new QuickSort();
        int[] datas = new int[]{4, 5, 4, 6, 34, 54, 23, 53, 43, 342, 3, 23, 33, 3, 3, 34};
        //  sort.quickSort(datas, 0, datas.length - 1);
        sort.quickSort2(datas);
        Arrays.stream(datas).forEach(data -> {
            System.out.print(data + " ");
        });
    }
}
