public class J003_algorithm_Quicksort {
    public static void main(String[] args) {
        int[] arr = {1, 9, 2, 8, 3, 7, 5, 5, 6, 5};
        quicksort(arr, 0, arr.length-1);
        for (int i = 0; i < arr.length; i ++) {
            System.out.printf("%d ", arr[i]);
        }
        System.out.println();
    }
    static void quicksort(int[] arr, int l, int r) {
        if (l >= r) return;
        int p = partition(arr, l, r);
        quicksort(arr, l, p-1);
        quicksort(arr, p+1, r);
    }
    static int partition(int[] arr, int l, int r) {
        int p = arr[l];
        int mr = arr.length - 1;
        while (l < r) {
            while (l < r && arr[r] >= p) r --;
            arr[l] = arr[r];
            while (l < r && arr[l] <= p) l ++;
            arr[r] = arr[l];
        }
        arr[l] = p;
        return l;
    }
}
