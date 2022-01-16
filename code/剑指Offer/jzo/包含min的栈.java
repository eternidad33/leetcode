package jzo;

import java.util.Stack;

public class 包含min的栈 {
    private Stack<Integer> minStack;
    private Stack<Integer> stack1;
    private int min;

    public 包含min的栈() {
        this.minStack = new Stack<>();
        this.stack1 = new Stack<>();
        this.min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        //stack1直接入栈，minStack需要比较最小值
        this.stack1.add(x);
        this.min = Math.min(x, this.min);
        this.minStack.add(this.min);
    }

    public void pop() {
        //出栈
        this.stack1.pop();
        this.minStack.pop();
        this.min = this.minStack.empty() ? Integer.MAX_VALUE : this.minStack.peek();
    }

    public int top() {
        return this.stack1.peek();
    }

    public int min() {
        return this.minStack.peek();
    }
}
