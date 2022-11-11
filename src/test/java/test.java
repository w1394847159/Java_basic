import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class test {


    @Test
    public void test1(){

        ArrayList<Object> objects = new ArrayList<>();
        LinkedList<Object> objects1 = new LinkedList<>();
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
    }


    @Test
    public void test2(){
        //使用两个栈来实现链表
        //链表是先进先出的，栈是先进后出的
        //将a栈中所有数据弹出，b栈将所有弹出数据弹入，此时b栈中数据顺序与a栈相反，b栈栈顶元素即为a栈中先入元素，实现先入先出

        //创建两个栈，将数据写入
        Stack<Integer> a = new Stack<>();
        Stack<Integer> b = new Stack<>();

        //写入数据
        a.push(6);
        a.push(4);
        int t = -1;

        //弹出3
        while (!a.empty()){
            b.push(a.pop());
        }
        if(!b.empty()){
            t = b.pop();
        }

        while (!b.empty()){
            a.push(b.pop());
        }

        for (int i = 0; i < a.size(); i++) {
            System.out.println(a.get(i));
        }

        System.out.println("弹出的数为:"+ t);



    }








}

//找到栈中最小元素，要求Min函数时间复杂度为 O(1)
class MinStack {
    //使用两个栈来存储元素
    //元素存储到a栈后与b栈栈顶元素比对，小则写入b栈栈顶
    Stack<Integer> a;
    Stack<Integer> b;
    int m = 0;

    public MinStack() {
        a = new Stack<>();
        b = new Stack<>();
    }

    public void push(int val) {
        a.add(val);
        if(b.empty() || !(val > b.peek())){
            b.add(val);
            m = val;
        }
    }

    public void pop() {
        //弹出元素，如果b栈顶部元素与弹出元素相同，则弹出
        if(a.pop().equals(b.peek())){
            b.pop();
        }

    }

    public int top() {
        //获取a栈中顶部元素
        return a.peek();

    }

    public int getMin() {
        return b.peek();
    }
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
