package Model.SortAlgorithm_Basic;

// 保证前半部分有序，每次从后向前扫描已排序的数组并将新的数字插入
// 当前要插入的数字要被记录下来，因为数字在不停的变位置，插入之后，原来的位置的元素要向后移动,如果前一个元素比当前元素大的话，前一个元素会后移，导致nums
public class InserstionSort {
    public static void main(String[] args) {
        int[] arr = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};

        for (int i = 1; i < arr.length; i++) {
            int insertNum = arr[i];
            for (int j = i-1; j >= 0; j--) {
                if (insertNum < arr[j]) {
                    arr[j+1] = arr[j];
                    arr[j] = insertNum;
                } else
                    break;
            }
        }

        for (int a: arr) {
            System.out.println(a);
        }
    }
}
