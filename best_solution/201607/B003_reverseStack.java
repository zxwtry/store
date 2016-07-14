//一个栈依次压入1, 2 ,3, 4, 5，从栈顶到栈底分别是5, 4, 3, 2, 1
//这个栈转置后，从栈顶到栈底为1, 2, 3, 4, 5，也就是实现栈中元素的逆序
//只能使用递归函数来实现
//笔记：stack.iterator()是从栈底到栈顶。
//笔记：当栈过长的时候，会栈溢出
import java.util.Stack;
import java.util.Iterator;
public class B003_reverseStack {
    public static void main(String[] args) {
        Stack<Integer> stk = new Stack<Integer>();
        stk.add(1);
        stk.add(2);
        stk.add(3);
//        Iterator<Integer> it = stk.iterator();
//        while (it.hasNext())
//            System.out.println("origin stk is "+it.next());
//        System.out.println("peek is "+stk.peek());
//        System.out.println("last element is "+getAndRemoveLastElement(stk));
//        it = stk.iterator();
//        while (it.hasNext())
//            System.out.println("origin stk is "+it.next());
        stk.add(4);
        stk.add(5);
        for (int t = 6 ; t < 12900; t ++) {
            stk.add(t);
        }
        reverse(stk);
        Iterator<Integer> it = stk.iterator();
        while(it.hasNext()) {
            System.out.println("reverse stk is " + it.next());
        }
    }
    // 外部保证stk不为null或空栈
    public static int getAndRemoveLastElement(Stack<Integer> stk) {
        int res = stk.pop();
        if (stk.isEmpty()) {
            return res;
        } else {
            int last = getAndRemoveLastElement(stk);
            stk.push(res);
            return last;
        }
    }
    // 外部保证stk不为null
    public static void reverse(Stack<Integer> stk) {
        if (stk.isEmpty())
            return;
        int tmp = getAndRemoveLastElement(stk);
        reverse(stk);
        stk.push(tmp);
    }
}
