/*
	定义一个二叉树节点
	一个数组的MaxTree定义如下：
		*数组必须没有重复元素
		*MaxTree是一棵二叉树，数组的每一个值对应一个二叉树节点。
		*包括MaxTree树在内且在其中的每一棵子树上，值最大的节点都是树的头。
	给定一个没有重复元素的数组arr，写出生成这个数组的MaxTree的函数，
	要求如果数组长度是N，则时间复杂度为O(N)，额外空间复杂度为O(N)。
*/
/*
	举一个例子，满足时间和空间复杂度的条件下，生成MaxTree
	arr = {3, 4, 5, 1, 2};
	3的左边第一个比3大的数：无		3的右边第一个比3大的数：4
	4的左边第一个比4大的数：无		4的右边第一个比4大的数：5
	5的左边第一个比5大的数：无		5的右边第一个比5大的数：无
	1的左边第一个比1大的数：5		1的右边第一个比1大的数：2
	2的左边第一个比2大的数：5		2的右边第一个比2大的数：无
	以下列规则来建立这棵树：
	*每一个数的父节点是是它左边的第一个比它大的数和它右边第一个比它大的数中，较小的那个。
	*如果一个数左边没有比它大的数，右边也没有。也就是说，这个数是整个数组的最大值，那么这个数是MaxTree的头节点。
*/

import java.util.Stack;
import java.util.HashMap;
import java.util.LinkedList;
public class B008_maxTree {
	public static void main(String[] args) {
		int[] arr = {3, 4, 5, 1, 2};
		Node head = getMaxTree(arr);
		printLayer(head);
	}
	static void printLayer(Node head) {
		LinkedList<Node> ll = new LinkedList<Node>();
		ll.add(head);
		while (ll.size() != 0) {
			Node cur = ll.poll();
			if (cur.l != null)
				ll.add(cur.l);
			if (cur.r != null)
				ll.add(cur.r);
			System.out.printf("%d\t", cur.v);
		}
		System.out.println();
	}
	static Node getMaxTree(int[] arr) {
		Node[] na = new Node[arr.length];
		for (int i = 0; i != arr.length; i ++)
			na[i] = new Node(arr[i]);
		Stack<Node> stk = new Stack<Node>();
		HashMap<Node, Node> lm = new HashMap<Node, Node>();
		HashMap<Node, Node> rm = new HashMap<Node, Node>();
		for (int i = 0; i != arr.length; i ++) {
			while (! stk.isEmpty() && stk.peek().v < na[i].v)
				popStkSetMap(stk, lm);
			stk.push(na[i]);
		}
		while (! stk.isEmpty())
			popStkSetMap(stk, lm);
		for (int i = na.length - 1; i != -1; i --) {
			while (! stk.isEmpty() && stk.peek().v < na[i].v)
				popStkSetMap(stk, rm);
			stk.push(na[i]);
		}
		while (! stk.isEmpty())
			popStkSetMap(stk, rm);
		Node head = null;
		for (int i = 0; i != na.length; i ++) {
			Node cur = na[i];
			Node ln = lm.get(cur);
			Node rn = rm.get(cur);
			if (ln == null && rn == null) {
				head = cur;
			} else if (ln == null) {
				if (rn.l == null)
					rn.l = cur;
				else
					rn.r = cur;
			} else if (rn == null) {
				if (ln.l == null)
					ln.l = cur;
				else
					ln.r = cur;
			} else {
				Node p = ln.v < rn.v ? ln : rn;
				if (p.l == null)
					p.l = cur;
				else
					p.r = cur;
			}
		}
		return head;
	}
	static void popStkSetMap(Stack<Node> stk, HashMap<Node, Node> map) {
		Node pop = stk.pop();
		if (stk.isEmpty())
			map.put(pop, null);
		else
			map.put(pop, stk.peek());
	}
	static class Node {
		public int v;
		public Node l, r;
		public Node(int data) {
			this.v = data;
		}
	}
}
