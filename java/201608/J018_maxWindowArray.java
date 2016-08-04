/*
	需要完成的工作是：
		arr = [1, 9, 2, 8, 3, 7, 4, 6, 5]
		w = 3
		输出的是一个9-3+1长度的数组，对应一个长度为3的框，框住的子数组中的最大值。
*/
import java.util.LinkedList;
public class J018_maxWindowArray {
	public static void main(String[] args) throws Exception{
		int[] arr = {1, 9, 2, 8, 3, 7, 4, 6, 5};
		int w = 3;
		int[] ans = mysolve_nw(arr, w);
		print(arr);
		print(ans);
	}
	static int[] mysolve_nw(int[] arr, int w) throws Exception{
		int len = 0;
		if (arr == null || (len = arr.length) == 0 || w < 1)
			throw new Exception("输入参数出错!");
		int anslen = len - w + 1;
		int[] ans = new int[anslen];
		for (int i = 0; i != anslen; i ++) {
			int jend = i + w;
			int max = Integer.MIN_VALUE;
			for (int j = i; j != jend; j ++) {
				if (arr[j] > max)
					max = arr[j];
			}
			ans[i] = max;
		}
		return ans;
	}
	static void mysolve_n(int[] arr, int w) throws Exception{
		int len = 0;
		if (arr == null || (len = arr.length) == 0 || w < 1)
			throw new Exception("输入参数出错!");
		
	}
	static void print(int[] arr) throws Exception{
		int len = 0;
		if (arr == null || (len = arr.length) == 0)
			throw new Exception("输入参数出错！");
		for (int i = 0; i != len-1; i ++) {
			System.out.printf("%d\t", arr[i]);
		}
		System.out.println(arr[len-1]);
	}
}
