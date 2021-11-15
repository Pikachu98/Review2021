package Model.SortAlgorithm_Advanced;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};

        new MergeSort().mergeSort(arr, 0, arr.length-1);

        for (int num: arr) {
            System.out.print(num + " ");
        }

    }
    public void mergeSort(int[] arr, int left, int right) {
        if (right <= left) return;
        int mid = (left + right) >> 1;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid+1, right);
        merge(arr, left, mid, right);
    }

    public void merge(int[] arr, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];
        // k指的是tmp的index
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            tmp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }

        // 上面的循环已经使得某一半的元素都被遍历过了，把另一半剩下的都直接填在tmp的后面
        while (i <= mid) tmp[k++] = arr[i++];
        while (j <= right) tmp[k++] = arr[j++];

        for (int m = 0; m< tmp.length; m++) {
            arr[left+m] = tmp[m];
        }
    }


}
