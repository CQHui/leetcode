package com.qihui.design;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author chenqihui
 * @date 2018/12/13
 *
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 */
public class MinStack {
    List<Integer> elements = new ArrayList<>();
    List<Integer> minStack = new ArrayList<>();

    public MinStack() {

    }

    public void push(int x) {
        if (minStack.isEmpty() || x <= minStack.get(minStack.size() - 1)){
            minStack.add(x);
        }
        elements.add(x);
    }

    public void pop() {
        Integer remove = elements.remove(elements.size() - 1);
        if (minStack.get(minStack.size() - 1).equals(remove)){
            minStack.remove(minStack.size() - 1);
        }
    }

    public int top() {
        return elements.get(elements.size() - 1);
    }

    public int getMin() {
        return minStack.get(minStack.size() - 1);
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }

}
