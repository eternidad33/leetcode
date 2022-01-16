package jzo;

import java.util.Stack;

public class 两个栈实现队列 {
    /*
    栈1负责入栈，栈2负责出栈
     */
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public 两个栈实现队列() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        //栈1不满，直接入栈
        this.stack1.add(value);
    }

    public int deleteHead() {
        if (!this.stack2.empty()) {
            return this.stack2.pop();
        } else {
            //当栈2为空时将栈1中的元素全部移到栈2中
            while (!this.stack1.empty()) {
                int temp = this.stack1.pop();
                this.stack2.add(temp);
            }
        }
        return this.stack2.empty() ? -1 : this.stack2.pop();
    }
}
