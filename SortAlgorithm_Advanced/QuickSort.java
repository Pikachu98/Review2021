package Model.SortAlgorithm_Advanced;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};

        quickSort(arr, 0, arr.length-1);

        for (int a: arr) {
            System.out.println(a);
        }
    }


    public static void quickSort (int[] array, int begin, int end) {
        if (end <= begin)
            return;
        int pivot = getPivot(array, begin, end);
        quickSort(array, begin, pivot-1);
        quickSort(array, pivot+1, end);
    }

    public static int getPivot (int[] arr, int begin, int end) {
        // pivot: 标杆位置，counter: 小于pivot的元素的个数
        int count = begin, pivot = end;
        for (int i = begin; i < end; i++) {
            if (arr[i] < arr[pivot]) {
                int tmp = arr[i];
                arr[i] = arr[count];
                arr[count] = tmp;
                count++;
            }
        }
        int tmp = arr[pivot];
        arr[pivot] = arr[count];
        arr[count] = tmp;

        return count;
    }
}
