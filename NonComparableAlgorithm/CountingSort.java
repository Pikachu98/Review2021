package Model.NonComparableAlgorithm;
/**
 * 其核心在于将输入的数据值转化为键存储在额外开辟的数组空间中
 *
 * 1. 找出待排序的数组中最大元素(max)和最小元素(min)；
 * 2. 声明一个额外的数组空间，长度为max-min+1
 * 3. 统计每个数字出现的次数，并将这个值放到额外数组空间中
 * 4. 通过额外生命的数组还原排好序的结果
 * 
 * 这里就是利用了额外的数组空间的下标是有序的特点
 *
 * 时间复杂度：O(n+k) 统计数量+还原
 * 空间复杂度：O(n+k) 需要额外的空间来存储元素
 * 稳定性：稳定
 * */

public class CountingSort {
    public static void main(String[] args) {
        int[] nums = {4, 5, 2, 6, 5, 8, 9, 0};

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;


        // 先找数组中的最大值和最小值
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }

        int[] tmp = new int[max-min+1];

        // 统计数组中每个数字出现的频次
        for (int j = 0; j < nums.length; j++) {
            tmp[nums[j]-min] = tmp[nums[j]-min]+1;
        }


        // 还原数组, 这里应该声明一个额外的变量，用来记录当前要还原的元素的下标
        int idx = 0;
        for (int k = 0; k < tmp.length; k++) {
            int count = tmp[k];
            while (count-- > 0) {
                nums[idx++] = k+min;
            }
        }

        // 打印排好序的元素
        for (int num: nums) {
            System.out.print(num + " ");
        }
    }
}
