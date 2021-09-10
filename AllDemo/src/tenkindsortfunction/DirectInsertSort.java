package tenkindsortfunction;

import java.util.Arrays;

public class DirectInsertSort {
    public static void main(String args[]) {
        int num[] = {2, 5, 8, 9, 4, 7, 6, 3, 1};
        directInsertSort(num);
    }

    /**
     * ①. 从第一个元素开始，该元素可以认为已经被排序
     * ②. 取出下一个元素，在已经排序的元素序列中从后向前扫描
     * ③. 如果该元素（已排序）大于新元素，将该元素移到下一位置
     * ④. 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
     * ⑤. 将新元素插入到该位置后
     * ⑥. 重复步骤②~⑤
     * <p>
     * 将一个元素插入到已有序的数组中，在初始时未知是否存在有序的数据，因此将元素第一个元素看成是有序的
     * 与有序的数组进行比较，比它大则直接放入，比它小则移动数组元素的位置，找到个合适的位置插入
     * 当只有一个数时，则不需要插入了，因此需要n-1趟排序，比如10个数，需要9趟排序
     */
    //直接插入排序
    public static void directInsertSort(int[] arrays) {
        //临时变量
        int temp;
        //外层循环控制需要排序的趟数(从1开始因为将第0位看成了有序数据)
        int num[] = {5, 2, 1, 9, 4, 7, 6, 3, 8};

        for (int i = 1; i < arrays.length; i++) {
            temp = arrays[i];
            //如果前一位(已排序的数据)比当前数据要大，那么就进入循环比较[参考第二趟排序]
            int j = i - 1;
            while (j >= 0 && arrays[j] > temp) {
                //往后退一个位置，让当前数据与之前前位进行比较
                arrays[j + 1] = arrays[j];
                //不断往前，直到退出循环
                j--;
            }
            //退出了循环说明找到了合适的位置了，将当前数据插入合适的位置中
            arrays[j + 1] = temp;
            System.out.println(Arrays.toString(arrays) ); 

        }

    }
}
