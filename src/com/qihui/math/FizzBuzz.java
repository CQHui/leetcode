package com.qihui.math;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenqihui
 * @date 2018/12/14
 *
 * 写一个程序，输出从 1 到 n 数字的字符串表示。
 *
 * 1. 如果 n 是3的倍数，输出“Fizz”；
 *
 * 2. 如果 n 是5的倍数，输出“Buzz”；
 *
 * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
 *
 * 示例：
 *
 * n = 15,
 *
 * 返回:
 * [
 *     "1",
 *     "2",
 *     "Fizz",
 *     "4",
 *     "Buzz",
 *     "Fizz",
 *     "7",
 *     "8",
 *     "Fizz",
 *     "Buzz",
 *     "11",
 *     "Fizz",
 *     "13",
 *     "14",
 *     "FizzBuzz"
 * ]
 */
public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> fizzBuzz = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            int index = i + 1;
            if (index% 3 == 0 && index % 5 == 0) {
                fizzBuzz.add(i, "FizzBuzz");
            } else if (index % 3 == 0) {
                fizzBuzz.add(i, "Fizz");
            } else if (index % 5 == 0) {
                fizzBuzz.add(i, "Buzz");
            } else {
                fizzBuzz.add(i, String.valueOf(index));
            }
        }
        return fizzBuzz;
    }
}
