package com.qihui.easy.other;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenqihui
 * @date 2018/12/21
 *
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */
public class Generate {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> generate = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>(i + 1);
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(generate.get(i - 1).get(j - 1) + generate.get(i - 1).get(j));
                }
            }
            generate.add(row);
        }

        return generate;
    }
}
