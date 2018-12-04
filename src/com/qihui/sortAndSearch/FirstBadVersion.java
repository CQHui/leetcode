package com.qihui.sortAndSearch;

/**
 * @author chenqihui
 * @date 2018/12/4
 */
public class FirstBadVersion extends VersionControl {

    public int firstBadVersion(int n) {
        if (n == 1 || n == Integer.MAX_VALUE) {
            return n;
        }
        int left = 1;
        int right = n;
        int index = (right + left) / 2;
        while (true) {
            if (isBadVersion(index)) {
                if (!isBadVersion(index - 1)) {
                    return index;
                } else {
                    right = index;
                    index = index + (left + 1 - index) / 2;
                }
            } else {
                left = index;
                index = index + (right + 1 - index) / 2;
            }
        }
    }
}
