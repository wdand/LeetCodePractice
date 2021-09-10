package tenkindsortfunction;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MaoPaoSort {
    public static void main(String args[]) {
        int num[] = {2,5,8,9,4,7,6,3,1};
        maoPaoSort(num);
    }
    /**
     * 冒泡排序算法的算法过程如下：
     * ①. 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
     * ②. 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
     * ③. 针对所有的元素重复以上的步骤，除了最后一个。
     * ④. 持续每次对越来越少的元素重复上面的步骤①~③，直到没有任何一对数字需要比较。
     * 时间复杂度 O(n2) 空间复杂度 O(1)
     * */
    //冒泡排序
    public static int[] maoPaoSort(int[] array) {
        if (array.length == 0)
            return array;
        /*循环数组长度的次数*/
        for (int i = 0; i < array.length; i++){
            /*从第0个元素开始，依次和后面的元素进行比较
             * j < array.length - 1 - i表示第[array.length - 1 - i]
             * 个元素已经冒泡到了合适的位置，无需进行比较，可以减少比较次数*/
            for (int j = 0; j < array.length - 1 - i; j++){
                /*如果第j个元素比后面的第j+1元素大，交换两者的位置*/
                if (array[j + 1] < array[j]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
            System.out.println(Arrays.toString(array));
        }
        return array;
    }
}
