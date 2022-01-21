package Model;

public class BinarySearch {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        //left <= right, 等于的情况处理的是数组里只有一个元素，否则会报错
        while (left <= right) {
            // 这里这样计算好一些,内存消耗会变小
            int mid = (right - left) / 2 + left;
            if (target == nums[mid]) {
                return mid;
            }
            if (target < nums[mid]) {
                right = mid - 1;
            }

            else if (target > nums[mid]) {
                left = mid + 1;
            }
        }

        return -1;
    }
}
