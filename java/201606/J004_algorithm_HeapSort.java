public class J004_algorithm_HeapSort{
    // 构建大堆
    public static void main(String[] args) {
        int[] arr1 = null;
        int[] arr2 = null;
        arr1 = new int[]{1, 9, 2, 8, 3, 7, 4, 6, 5, 5, 1, 2, 3,};
        arr2 = new int[]{1, 9, 2, 8};
        arr1 = new int[]{1, 9, 2, 8, 3, 7, 4, 6, 5, 3, 4};
        arr2 = new int[]{1, 9, 2, 8};
        solve(arr1, arr2);
        for (int i = 0; i < arr2.length; i ++) {
            System.out.printf("%d ", arr2[i]);        
        }
        System.out.println();
    }
    public static void solve(int[] arr1, int [] arr2) {
        buildHeap(arr2);
        for (int i = arr2.length; i < arr1.length; i ++) {
            add(arr2, arr1[i]);
        }
    }
    // 构建堆的代码开始
    public static void buildHeap(int[] arr) {
        int mr = 0;
        if (arr == null || (mr = arr.length-1) < 1)
            return;
        int ei = (mr-1) >> 1;
        for (int i = ei; i >= 0; i --) {
            down(arr, mr, i, ei);
        }
    }
    public static void down(int[] arr, int r, int i, int ei) {
        while (i <= ei) {
            int cl = (i << 1) + 1;
            if (cl < r && arr[cl] < arr[cl+1])
                cl ++;
            if (arr[i] < arr[cl])
                swap(arr, i, cl);
            i = cl;
        }
    }
    // 构建堆的代码结束

    // 往大堆中添加元素，规则是：
    //      不断更新大堆中的数据
    //      大堆中最终拥有小的数
    // 往大堆中添加元素开始
    public static void add(int[] arr, int val) {
        if (arr[0] <= val)
            return;
        int mr = arr.length-1;
        arr[0] = val;
        down(arr, mr, 0, (mr-1)>>1);
    }
    // 往大堆中添加元素结束
    // 辅助方法
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    // 辅助方法
}
