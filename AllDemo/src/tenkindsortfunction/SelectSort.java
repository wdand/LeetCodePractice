package tenkindsortfunction;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int num[] = {1, 4, 7, 8, 5, 2, 3, 6, 9};
        sort(num);
    }

    /**
     * ①. 从待排序序列中，找到关键字最小的元素；
     * ②. 如果最小元素不是待排序序列的第一个元素，将其和第一个元素互换；
     * ③. 从余下的 N - 1 个元素中，找出关键字最小的元素，重复①、②步，直到排序结束。
     */
    public static void sort(int[] num) {
        int temp = 0;
        for (int i = 0; i < num.length; i++) {
            int minIndex = i ;
            for (int j = i; j < num.length; j++) {
                if (num[minIndex] < num[j]) {
                    minIndex = j;
                }
            }
            temp = num[i];
            num[i] = num[minIndex];
            num[minIndex] = temp;
            System.out.println(Arrays.toString(num));
        }

    }


    //选择排序
    public static int[] selectSort(int[] array) {
        if (array.length == 0 || array == null)
            return array;
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;/*最小数的下标，每个循环开始总是假设第一个数最小*/
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex]) /*找到最小的数*/
                    minIndex = j; /*将最小数的索引保存*/
            }
            System.out.println("最小数为：" + array[minIndex]);
            /*交换最小数和i当前所指的元素*/
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        return array;
    }
}
