//栈的排序
//目标是从栈顶到栈底，由小到大
//注意，如果cur >= help.peek()，会陷入死循环
import java.util.Stack;
import java.util.Iterator;
public class B005_stackSort {
    public static void main(String[] args) {
        Stack<Integer> stk = new Stack<Integer>();
        stk.push(5);
        stk.push(1);
        stk.push(3);
        stk.push(3);
        stk.push(2);
        stk.push(2);
        stk.push(3);
        stk.push(4);
        sort(stk);
        print(stk);
    }
    static void sort(Stack<Integer> stk) {
        Stack<Integer> help = new Stack<Integer>();
        while (! stk.isEmpty()) {
            int cur = stk.pop();
            while (! help.isEmpty() && cur > help.peek() )
                stk.push(help.pop());
            help.push(cur);
        }
        while (! help.isEmpty())
            stk.push(help.pop());
    }
    static void print(Stack<Integer> stk) {
        Iterator<Integer> it = stk.iterator();
        while (it.hasNext()) {
            System.out.printf("%d\t", it.next());
        }
        System.out.println();
    }
}
