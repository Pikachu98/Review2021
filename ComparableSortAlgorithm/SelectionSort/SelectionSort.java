package Model.ComparableSortAlgorithm.SelectionSort;

// 每次选择最小值，放到待排序数组的起始位置
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};

        for (int i = 0; i < arr.length-1; i++) {
            int min = arr[i];
            int idx = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    idx = j;
                }
            }
            arr[idx] = arr[i];
            arr[i] = min;
        }

        for (int a: arr) {
            System.out.println(a);
        }
    }
}
