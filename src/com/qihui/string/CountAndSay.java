package com.qihui.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenqihui
 * @date 2018/11/26
 *
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 *
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 *
 * 注意：整数顺序将表示为一个字符串。
 *
 *
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: "1"
 * 示例 2:
 *
 * 输入: 4
 * 输出: "1211"
 */
public class CountAndSay {
    private static List<String> list = new ArrayList<>(30);

    static {
        String num = "1";
        list.add(num);
        //临时变量
        int temp = 0;
        for (int i = 0; i < 30; i++) {
            char[] chars = num.toCharArray();
            //计数
            int count = 1;
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < chars.length; j++) {
                if (j == 0) {
                    temp = chars[0];
                }
                if (j == chars.length - 1) {
                    sb.append(count);
                    sb.append(chars[j]);
                    continue;
                }
                if (temp != chars[j + 1]) {
                    temp = chars[j + 1];
                    sb.append(count);
                    sb.append(chars[j]);
                    count = 1;
                } else {
                    count ++;
                }
            }
            num = sb.toString();
            list.add(num);
        }
    }

    public String countAndSay(int n) {
        return list.get(n);
    }

}
