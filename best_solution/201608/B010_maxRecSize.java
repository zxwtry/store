import java.util.Stack;
import java.util.Arrays;
public class B010_maxRecSize {
	public static void main(String[] args) {
		int[][] map = new int[4][3];
		for (int i = 0; i != map.length; i ++) {
			Arrays.fill(map[i], 1);
		}
		map[3][0] = 0;
		map[1][2] = 0;
		System.out.println(maxRecSize(map));
	}
	static int maxRecSize(int[][] map) {
		if (map == null || map.length == 0 || map[0].length == 0)
			return 0;
		int maxArea = 0;
		int[] height = new int[map[0].length];
		for (int i = 0; i != map.length; i ++) {
			for (int j = 0; j != map[0].length; j ++) {
				height[j] = map[i][j] == 0 ? 0 : height[j] + 1;
			}
			maxArea = Math.max(maxRecFromBottom(height), maxArea);
		}
		return maxArea;
	}
	static int maxRecFromBottom(int[] height) {
		if (height == null || height.length == 0) 
			return 0;
		int maxArea = 0;
		Stack<Integer> stk = new Stack<Integer>();
		for (int i = 0; i != height.length; i ++) {
			while (! stk.isEmpty() && height[i] <= height[stk.peek()]) {
				int j = stk.pop();
				int k = stk.isEmpty() ? -1 : stk.peek();
				int curArea = (i - k - 1) * height[j];
				maxArea = Math.max(maxArea, curArea);
			}
			stk.push(i);
		}
		while (!stk.isEmpty()) {
			int j = stk.pop();
			int k = stk.isEmpty() ? -1 : stk.peek();
			int curArea = (height.length - k -1) * height[j];
			maxArea = Math.max(maxArea, curArea);
		}
		return maxArea;
	}
}
