//设计一个栈，完成push pop getMin的功能
//要求：时间复杂度O(1)
import java.util.Stack;
public class B001_getMin {
    public static void main(String[] args) throws Exception {
        MyStack ms = new MyStack();
        ms.push(-2);
        ms.push(1);
        ms.push(2);
        ms.push(-1);
        System.out.println(ms.getMin());
        System.out.println(ms.pop());
        System.out.println(ms.getMin());
        System.out.println(ms.pop());
    }
    static class MyStack {
        private Stack<Integer> stackData = null;
        private Stack<Integer> stackMin = null;
        public MyStack() {
            this.stackData = new Stack<Integer>();
            this.stackMin = new Stack<Integer>();
        }
        public int getMin() throws Exception{
            if (stackMin.size() == 0)
                throw new Exception("栈为空栈");
            return stackMin.peek();
        }
        public int pop() throws Exception{
            if (stackData.size() == 0)
                throw new Exception("栈为空栈");
            stackMin.pop();
            return stackData.pop();
        }
        public void push(int val) {
            int peek = Integer.MAX_VALUE;
            if (stackMin.size() != 0)
                peek = stackMin.peek();
            if (val < peek)
                stackMin.push(val);
            else
                stackMin.push(peek);
            stackData.push(val);
        }
    }
}
