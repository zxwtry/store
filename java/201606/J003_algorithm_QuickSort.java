public class J003_algorithm_Quicksort {
    public static void main(String[] args) {
        int[] arr = null;
        arr = new int[]{1, 9, 2, 8, 3, 7, 5, 5, 6, 5};
//        arr = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        quicksort002(arr, 0, arr.length-1);
        for (int i = 0; i < arr.length; i ++) {
            System.out.printf("%d ", arr[i]);
        }
        System.out.println();
    }
    static void quicksort001(int[] arr, int l, int r) {
        int mr = 0;
        if (arr == null ||(mr = arr.length-1) < 0 || l < 0 || r < 0 || r > mr || l > mr || l >= r)
            return;
        int p = partition001(arr, l, r);
        quicksort001(arr, l, p-1);
        quicksort001(arr, p+1, r);
    }
    static int partition001(int[] arr, int l, int r) {
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
    //  在网上看到的第二种排序
    static void quicksort002(int[] arr, int l, int r) {
        int mr = 0;
        if (arr == null ||(mr = arr.length-1) < 0 || l < 0 || r < 0 || r > mr || l > mr || l >= r)
            return;
        int p = partition002(arr, l , r);
        quicksort002(arr, l, p-1);
        quicksort002(arr, p+1, r);
        
    }
    static int partition002(int[] arr, int l, int r) {
        int p = arr[l], i = l - 1, tmp;
        for (int j = l; j <= r; ++ j) {
            if (arr[j] < p) {
                ++ i;
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        arr[r] = arr[i+1];
        arr[i+1] = p;
        return i+1;
    }
}
