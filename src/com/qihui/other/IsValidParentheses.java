package com.qihui.other;

import org.junit.Test;

import java.util.Stack;

/**
 * @author chenqihui
 * @date 2018/12/24
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 */
public class IsValidParentheses {

    public boolean isValid(String s) {
        if (s.isEmpty()){
            return true;
        }
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0;i<chars.length;i++){
            if (chars[i] == '{'){
                stack.push('}');
            }else if (chars[i] == '['){
                stack.push(']');
            }else if (chars[i] == '('){
                stack.push(')');
            }else if (stack.isEmpty() || chars[i] != stack.pop()){
                return false;
            }
        }
        return stack.isEmpty();
    }
}
