package Model.ComparableSortAlgorithm.InsertionSort;
/**
 * Shell Sort就是特殊的插入排序；对于部分有序的数组，插入排序的效率会提高
 *
 * Key point: 在相对有序数组里的插入排序更有效率
 * 视频参考： https://www.bilibili.com/video/BV1rE411g7rW
 * 动画：    https://www.cnblogs.com/onepixel/p/7674659.html
 * 代码参考： http://data.biancheng.net/view/119.html#:~:text=%E5%B8%8C%E5%B0%94%E6%8E%92%E5%BA%8F%E7%9A%84%E5%9F%BA%E6%9C%AC,%E4%BD%BF%E7%94%A8%E6%8F%92%E5%85%A5%E6%8E%92%E5%BA%8F%E5%A4%84%E7%90%86%E6%95%B0%E5%88%97%E3%80%82
 *
 * 1st loop: 初始gap为数组长度除以2，之后每次都是前一次的1/2；最后一次gap是1，其实就是插入排序，但是因为之前已经让数组变得相对有序了，因此时间变短
 * 2nd loop: 从gap开始依次向后遍历，将当前的数计作k
 * 3nd loop: 找与k间隔为gap，2gap，3gap的数，直到最前面，如果k-gap*n处的数字大于k-gap*(n+1)处的数字，两者交换
 *
 * O(n¹﹒³）
 * */

public class ShellSort {
    public static void main(String[] args) {
        int[] nums = {4, 5, 2, 6, 8, 9, 0};

        for (int gap = nums.length / 2; gap > 0; gap /= 2) {
            for (int item = gap; item < nums.length; item++) {  // 从gap开始往后遍历
                for (int k = item; k >= gap; k -= gap) {        // 找与当前所在位置间隔为gap, 2gap, 3gap的数字依次比较换位置
                    if (nums[k-gap] > nums[k]) {
                        int tmp = nums[k-gap];
                        nums[k-gap] = nums[k];
                        nums[k] = tmp;
                    }
                }
            }
        }

        for (int num: nums)
            System.out.print(num + " ");
    }
}
