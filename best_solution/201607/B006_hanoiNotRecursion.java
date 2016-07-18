/*
	@author: zxwtry
	修改之后的汉诺塔问题：
		不能让任何塔从“左”直接移动到“右”，
		也不能从“右”移动到左
	B006有两份代码，都是汉诺塔问题；
	这份是非递归版本
	另外一份是递归版本
*/

import java.util.Stack;
public class B006_hanoiNotRecursion {
	public static void main(String[] args) {
		System.out.println("总共"+hanoi(4, "左", "中", "右")+"步");
	}
	public static enum Action {
		No, LToM, MToL, MToR, RToM
	}
	public static int hanoi(int n, String l, String m, String r) {
		Stack<Integer> ls = new Stack<Integer>();
		Stack<Integer> ms = new Stack<Integer>();
		Stack<Integer> rs = new Stack<Integer>();
		ls.push(Integer.MAX_VALUE);
		ms.push(Integer.MAX_VALUE);
		rs.push(Integer.MAX_VALUE);
		for (int i  = n; i > 0; i --) {
			ls.push(i);
		}
		Action[] record = {Action.No};
		int step = 0;
		while (rs.size() != n + 1) {
			step += stkToStk(record, Action.MToL, Action.LToM, ls, ms, l, m);
			step += stkToStk(record, Action.LToM, Action.MToL, ms, ls, m, l);
			step += stkToStk(record, Action.RToM, Action.MToR, ms, rs, m, r);
			step += stkToStk(record, Action.MToR, Action.RToM, rs, ms, r, m);
		}
		return step;
	}
	public static int stkToStk(Action[] record, Action preNoAct, Action nowAct, Stack<Integer> fs, Stack<Integer> ts, String f, String t) {
		if (record[0] != preNoAct && fs.peek() < ts.peek()) {
			ts.push(fs.pop());
			System.out.printf("%d从%s到%s\n",ts.peek(), f, t);
			record[0]=nowAct;
			return 1;
		}
		return 0;
	}
}
