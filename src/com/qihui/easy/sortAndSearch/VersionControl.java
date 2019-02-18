package com.qihui.easy.sortAndSearch;

/**
 * @author chenqihui
 * @date 2018/12/4
 */
public class VersionControl {
    boolean isBadVersion(int version) {
        if (version >= 2147483647) {
            return true;
        }
        return false;
    }
}
