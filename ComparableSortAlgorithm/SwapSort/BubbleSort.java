package Model.ComparableSortAlgorithm.SwapSort;

// 每次都查看两个相邻元素是否逆序，逆序则交换两者的顺序，如果是从大到小的话，最大的就会被冒泡冒到最后面去
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};

        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }

        /*
        // 从大到小排列，只有后一个元素比前一个元素小的时候，两者才会交换，最小的就会被冒泡到最后面
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if (arr[j] < arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
*/

        for (int a: arr) {
            System.out.println(a);
        }
    }
}
