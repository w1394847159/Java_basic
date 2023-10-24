import org.junit.Test;

import java.util.*;

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


   /* public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        //使用数组来存储
        //todo 使用数组
        int[] it = new int[0];
        //ArrayList<Integer> it = new ArrayList<>();
        //第一次a 是怪物数量，第二次开始 b a b a 即为怪物血量
        //使用列表存储怪物血量，列表大小即为怪物血量
        int i = 0;
        int count = 0;
        while (in.hasNextLine()) { // 注意 while 处理多个 case

            //it = new ArrayList<>();
            int a = 0;
            if(it.length == 0){
                //第一次设置怪物数量
                a = in.nextInt();
                it = new int[a];
            }else {
                if(i == it.length){
                    //此时已经输入所有数据
                    break;
                }
                a = in.nextInt();
                it[i] = a;
                i++;
            }

            if(i == it.length){
                //此时已经输入所有数据
                break;
            }

            int b = in.nextInt();
            it[i] = b;
            i++;

            //System.out.println(a + b);


        }

        //使用h 存储斩击的目标
        int h = 0;
        int h1 = 1;
        //记录斩击目标死亡
        while (true){
            //当前怪物死亡时，斩杀后面怪物
            if(it[h] < 0){
                h += 1;
                h1 += 1;
            }
            if(h1 > it.length - 1 ){
                h1 = it.length -1;
            }

            if(it[h] > 0 || it[h1] > 0 ){
                it[h] = it[h] - 1;
                if(h < it.length - 1){
                    it[h1] = it[h1] -2;
                }
                //斩击1次
                count ++;
            }
            //当检测出有两个怪物血量低于1时，判定成功
            int die = 0;
            for (int i1 : it) {
                if(i1 < 1) {
                    die ++;
                }
            }
            if(die > 1){
                break;
            }
        }
        System.out.println("共需要:" + count + "次斩击");
    }

*/


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        //使用数组来存储
        //todo 使用数组
        int[] it = new int[0];
        //列表
        ArrayList<Integer> as = new ArrayList<>();
        //存储日期增加
        int i = -1;
        while (in.hasNextLine()) {

            //第一次输入的数据,为列表大小
            if(i == as.size()){
                break;
            }
            int a = in.nextInt();
            if(i == -1){
                i = a;
            }else {
                as.add(a);

            }
        }

        //斩击数
        int count = 0;
        //怪物死亡数

        //获取数组最小值，不包含第一个数
        //m1s mn1下标
        int m1s = 0;
        //m2s mn2下标
        int m2s = 0;
        int mn2 = Integer.MAX_VALUE;
        int mn1 = 0;
        while (true){


        if(i > 2){
             mn1= Integer.MAX_VALUE;
            for (int j = 1; j < as.size(); j++) {
                if(as.get(j) < mn1 && as.get(j) > 0){
                    mn1 = as.get(j);
                    m1s = j;
                }
            }
        }else {
            //只有两个怪物的时候
            if(as.get(0) > as.get(1) && as.get(1) > 0){
                mn1 = as.get(1);
                m1s = 1;
            }else {
                mn1 = as.get(0);
                m1s = 0;
            }
        }

        //获取最小的数，对其前一位进行减
            Integer a2 = as.get(m1s);
            if(m1s > 0){
                Integer a1 = as.get(m1s - 1);
                as.set(m1s - 1,a1 - 1);
                as.set(m1s,a2 - 2);
            }else {
                as.set(0,a2 - 1);
            }
            //斩击一次
            count ++;
            int die = 0;
            for (Integer a : as) {
                if( a < 1){
                    die ++;
                }
            }
            if(die > 1){
                break;
            }


        }

        System.out.println( count);
    }


    @Test
    public void test3(){
        int count = 3;

        //瓶子数
        //地板除
        int i = count / 3;
        int i1 = count % 3;
        int a = 0;
        while (true){
            if(count != 0){
                i = count / 3;
                i1 = count % 3;
                a += i;
                count = i + i1;
                if(count == 2){
                    //向老板借一个瓶子
                    a += 1;
                    count = 0;
                }else if(count == 1){
                    //只有一个瓶子时没办法换，结束
                    break;
                }
            }else {
                break;
            }
        }
        System.out.println(a);
    }


    @Test
    public void test4(){
        //使用列表存储数据
        ArrayList<Integer> list = new ArrayList<>();
        int m = 0;
        //生成随机数
        for (int i = 0; i < 3; i++) {
           /*j  = new Random().nextInt() * 1000;*/
            m = 3;
            System.out.println(m);
           list.add(m);
        }

        //使用列表存储重复下标
        ArrayList<Integer> list1 = new ArrayList<>();

        System.out.println("-------");
        for (int i = 0; i < list.size(); i++) {
            for (int j = 1; j < list.size() - i; j++) {
                if(list.get(i) == list.get(j)){
                    list1.add(j);
                }
            }
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(0));
        }


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
