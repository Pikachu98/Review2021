package Model.ComparableSortAlgorithm.SelectionSort;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] nums = {4, 5, 2, 6, 5, 8, 9, 0};

        heapSort(nums);
    }

    private static void heapSort(int[] nums) {
        // 首先要构建一个大顶堆 (已经默认nums这个数组已经是一个完全二叉树了，接下来要做的是将这个完全二叉树调整为大顶二叉堆）
        // 从倒数第二行开始调整 (下标为nums.length / 2, 然后依次递减，直至i = 0, 这是heapify up的过程）
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            // 调整当前元素与其子节点，将当前元素与其子节点中的 较大者 互换
            heapify(nums, i, nums.length);
        }

        // 每次将最大的元素（堆顶元素）和最后一个元素相交换，然后重新构造堆
        for (int i = nums.length-1; i > 0; i--) {
            popTop(nums, i);
        }

        System.out.println(Arrays.toString(nums));
    }

    private static void popTop(int[] nums, int i) {
        // 交换的过程其实就是把堆顶的元素放到最后的过程
        int tmp = nums[0];
        nums[0] = nums[i];
        nums[i] = tmp;

        // 从根结点开始重新构造堆，但是每次数组的范围都在减小
        heapify(nums, 0, i);

    }

    // 构造大顶堆
    /**
     * @param i 需要构建堆的父结点的序号
     * @param len 数组的长度（需要调整的堆的大小）
     * */
    private static void heapify(int[] nums, int i, int len) {
        // i的左子节点是
        int child;
        int fatherVal = nums[i]; // 记录最开始父元素的值

        // 左子节点的idx没超过数组长度
        for (; leftChild(i) < len; i = child) {
            child = leftChild(i); // 要更新一下child的值

            // 这里要找到左子节点和右子节点中较大的一个，
            // 要保证一个条件：左子节点并不是单个的子节点
            if (child != len-1 && nums[child] < nums[child+1]) {
                child++;
            }

            // 判断子节点中较大的和父节点的值谁大
            // 如果子节点大于父节点，交换；然后以这个新节点（新子旧父节点）为根据（虽然位置变了，但是值一直都是fatherVal)，接着判断新子旧父节点的子节点是否有比它大的，
            // 有的话接着交换，没有的话循环结束
            if (fatherVal < nums[child]) {
                // 父节点的值可以改成子节点的值了
                nums[i] = nums[child];      // 这里直接交换两者也行，就是代码变多了，但是简单了
            } else {
                // 如果父节点大于子节点，结束循环
                break;
            }
        }

        // 循环结束之后，把最开始的nums[i]的值赋给nums[child]
        nums[i] = fatherVal;


    }

    private static int leftChild(int i) {
        return 2 * i + 1;
    }



}
