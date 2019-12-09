package com.liuzx.SortSearch;

/**
 * @Author: liuzx
 * @Date: 2019/10/28 15:27
 * @Description: 第一个错误的版本
 **/
public class VersionControl {
    boolean isBadVersion(int version) {
        return false;
    }

    public int firstBadVersion(int n) {
        if (isBadVersion(1)) {
            return 1;
        }
        int min = 1;
        for (; ; ) {
            if (min == n - 1) {
                return n;
            }
            int mid = (n - min) / 2 + min;
            if (isBadVersion(mid)) {
                n = mid;
            } else {
                min = mid;
            }
        }
    }
}
