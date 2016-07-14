//两个栈，组成一个队列
//实现队列的add pop peek的功能
import java.util.Stack;
public class B002_Queue {
    public static void main(String[] args) throws Exception{
       MyQueue mq = new MyQueue();
       mq.add(1);
       System.out.println(mq.peek());
       mq.pop();
       mq.add(2);
       System.out.println(mq.peek());
       mq.add(3);
       System.out.println(mq.pop());
       System.out.println(mq.pop());
       System.out.println(mq.peek());
       mq.add(4);
       System.out.println(mq.peek());
    }
    static class MyQueue {
        private Stack<Integer> st1 = null;
        private Stack<Integer> st2 = null;
        public MyQueue() {
            st1 = new Stack<Integer>();
            st2 = new Stack<Integer>();
        }
        public void add(int val) {
            st1.add(val);
        }
        public int pop() throws Exception {
            if (st2.size() == 0) {
                while (st1.size() != 0)
                    st2.add(st1.pop());
                if (st2.size() == 0)
                    throw new Exception("栈是空栈");
            }
            return st2.pop();
        }
        public int peek() throws Exception {
            if (st2.size() == 0) {
                while (st1.size() != 0)
                    st2.add(st1.pop());
                if (st2.size() == 0)
                    throw new Exception("栈是空栈");
            }
            return st2.peek();
        }
    }
}
