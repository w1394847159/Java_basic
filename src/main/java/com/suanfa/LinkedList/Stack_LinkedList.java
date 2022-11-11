package com.suanfa.LinkedList;

import java.util.LinkedList;
import java.util.Stack;

public class Stack_LinkedList {


}


class CQueue {

    LinkedList<Integer> A;
    public CQueue() {
        A =  new LinkedList<Integer>();
    }

    public void appendTail(int value) {
        A.addLast(value);

    }

    public int deleteHead() {
        return A.size() == 0 ? -1 : A.removeFirst();
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */


class MinStack {
    //使用两个栈来存储，一个栈存储正常数据，另一个栈存储最大的数据
    Stack<Integer> a;
    Stack<Integer> b;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        a = new Stack<>();
        b = new Stack<>();

    }

    public void push(int x) {
        a.add(x);
        if (b.empty() || b.peek() >= x) {
            b.add(x);
        }
    }

    public void pop() {
        //如果b栈第一个元素和a要删除元素相同，则删除B
        if (a.pop().equals(b.peek())) {
            b.pop();
        }


    }

    public int top() {
        return a.peek();

    }

    //min时间复杂度为1，需要从b栈获取
    public int min() {
        return b.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */


class CQueue1 {
    //栈：先进后出
    //队列 先进先出
    //a栈顺序存储
    //b栈逆序存储
    Stack<Integer> a;
    Stack<Integer> b;

    public CQueue1() {
        a = new Stack<>();
        b = new Stack<>();
    }

    public void appendTail(int value) {
        a.push(value);


    }

    public int deleteHead() {
        int ans = -1;
        //将a中所有数据给b
        while(!a.empty()){
            b.push(a.pop());
        }
        //此时b中首数据即为a刚Push的数据
        if(!b.empty()){
            ans = b.pop();
        }
        //将b中所有数据重新按照顺序写回a中
        while(!b.empty()){
            a.push(b.pop());
        }
        //拿到返回的头节点
        return ans;
        
    }

}