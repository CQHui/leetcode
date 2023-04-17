package com.qihui.medium.linklist;

import java.util.concurrent.DelayQueue;

public class Steps {

    public static void main(String[] args) {
        int result = jump(4);
        System.out.println(result);
        System.out.println(jump(10) == jumpV1( 10)); // 输出3
        System.out.println(jump(100) == jumpV1( 100)); // 输出3
        System.out.println(jump(50) == jumpV1( 50)); // 输出3
        System.out.println(jump(80) == jumpV1( 80)); // 输出3

        DelayQueue delayQueue = new DelayQueue();


    }

    public static int jump(int n) {
        if (n < 2) return -1;
        int[] dp = new int[n + 1];
        dp[0] = -1;
        dp[1] = -1;
        dp[2] = 1;
        dp[3] = 1;
        for (int i = 4; i <= n; i++) {
            dp[i] = Math.min(dp[i - 2], dp[i - 3]) + 1;
        }
        return dp[n];
    }


    public static int jumpV1(int n) {
        return (n - 1) / 3 + 1;
    }
}
