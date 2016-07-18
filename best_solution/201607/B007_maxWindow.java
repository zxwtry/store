/*
	[题目]
		有一个整型数组arr和一个大小为w的窗口从数组的最左边滑到最右边，
		窗口每次向右滑一个位置。
	zuo的代码好短!!!!!
	这里有可能会不敢使用pushLast和pollLast，可能的原因是链表N的恐惧。
	在Java的实现类LinkedList里面都有一个transient Node<E> last;和
	transient Node<E> first;来指向最后一个和第一个.
	所以在Java中仍然是O(1)
	my版本还没有写完，太长，不想写了。
*/

import java.util.LinkedList;
public class B007_maxWindow {
	public static void main(String[] args) {
		int[] arr = new int[] {4, 3, 5, 4, 3, 3, 6, 7};
		int[] ans = zuoSolve(arr, 3);
		for (int i = 0; i < ans.length; i ++) {
			System.out.printf("%d\t", ans[i]);
		}
		System.out.println();
	}
	//这份代码肯定不是最优代码，最优代码是mySolve的这种写法
	//可是mySolve的实在是太麻烦了。节省的也只是内存少了一点点。
	public static int[] zuoSolve(int[] arr, int w) {
		int len = 0;
		if (arr == null || w < 1 || (len = arr.length) < w)
			return null;
		LinkedList<Integer> qm = new LinkedList<Integer>();
		int[] res = new int[len - w + 1];
		int index = 0;
		for (int i = 0; i < len; i ++) {
			while (! qm.isEmpty() && arr[qm.peekLast()] < arr[i])
				qm.pollLast();
			qm.addLast(i);
			if (qm.peekFirst() == i - w)
				qm.pollFirst();
			if (i >= w - 1)
				res[index ++] = arr[qm.peekFirst()];
		}
		return res;
	}
	public static int[] mySolve(int[] arr, int w) {
		int end = arr.length - 1;
		int[] ans = new int[end-w+2];
		int mc = 0, nc = 0, mv = Integer.MIN_VALUE, nv = Integer.MIN_VALUE;
		for (int i = w - 2; i >= 0; i --) {
			if (arr[i] > mv) {
				nv = mv;
				nc = mc;
				mv = arr[i];
				mc = 1;
			} else if (arr[i] == mv) {
				mc ++;
			} else if (arr[i] > nv && arr[i] < mv) {
				nv = arr[i];
				nc = 1;
			} else if (arr[i] == nv) {
				nc ++;
			}
		}
		for (int i = w - 1; i < ans.length; i ++) {
			if (arr[i] > mv) {
				nv = mv;
				nc = mc;
				mv = arr[i];
				mc = 1;
			} else if (arr[i] == mv) {
				mc ++;
			} else if (arr[i] > nv && arr[i] < mv) {
				nv = arr[i];
				nc = 1;
			} else if (arr[i] == nv) {
				nc ++;
			}
			
			ans[i-w+1] = mv;
		}
		return ans;
	}
}
