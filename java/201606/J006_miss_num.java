public class J006_miss_num {
    public static void main (String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        arr = new int[] {2, 3, 4, -1, 6};
        System.out.println(missNum(arr));
    }
    static int missNum(int[] arr) {
        int l = 0, r = arr.length;
        while (l < r) {
            if (arr[l] == l + 1)
                l ++;
            else if (arr[l] <= l || arr[l] > r || arr[arr[l]-1] == arr[l])
                arr[l] = arr[--r];
            else
                swap(arr, l, arr[l]-1);
        }
        return l+1;
    }
    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
