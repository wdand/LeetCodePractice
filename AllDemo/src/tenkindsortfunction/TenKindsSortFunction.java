package tenkindsortfunction;

import java.util.Arrays;

public class TenKindsSortFunction {
    public static void main(String args[]) {
        int num[] = {2,5,8,9,4,7,6,3,1};
//        System.out.print(reverse(12345));
        quicklySort(num,0,num.length-1);
    }

    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            rev = rev * 10 + digit;
        }
        return rev;
    }



    /**
     * ①. 挖坑法
     * 用伪代码描述如下：
     * （1）low = L; high = R; 将基准数挖出形成第一个坑a[low]。
     * （2）high--，由后向前找比它小的数，找到后挖出此数填前一个坑a[low]中。
     * （3）low++，由前向后找比它大的数，找到后也挖出此数填到前一个坑a[high]中。
     * （4）再重复执行②，③二步，直到low==high，将基准数填入a[low]中。
     * 举例说明：
     * 一个无序数组：[4, 3, 7, 5, 10, 9, 1, 6, 8, 2]
     * （1）随便先挖个坑，就在第一个元素（基准元素）挖坑，挖出来的“萝卜”（第一个元素4）在“篮子”（临时变量）里备用。
     * 挖完之后的数组是这样：[ 坑, 3, 7, 5, 10, 9, 1, 6, 8,2]
     * （2）挖右坑填左坑：从右边开始，找个比“萝卜”（元素4）小的元素，挖出来，填到前一个坑里面。
     * 填坑之后：[ 2, 3, 7, 5, 10, 9, 1, 6, 8,坑]
     * （3）挖左坑填右坑：从左边开始，找个比“萝卜”（元素4）大的元素，挖出来，填到右边的坑里面。
     * 填坑之后：[ 2, 3,坑, 5, 10, 9, 1, 6, 8, 7]
     * （4）挖右坑填左坑：从右边开始，找个比“萝卜”（元素4）小的元素，挖出来，填到前一个坑里面。
     * 填坑之后：[ 2, 3, 1, 5, 10, 9,坑, 6, 8, 7]
     * （5）挖左坑填右坑：从左边开始，找个比“萝卜”（元素4）大的元素，挖出来，填到右边的坑里面。
     * 填坑之后：[ 2, 3, 1,坑, 10, 9, 5, 6, 8, 7]
     * （6）挖右坑填左坑：从右边开始，找个比“萝卜”（元素4）小的元素，挖出来，填到前一个坑里面，这一次找坑的过程中，找到了上一次挖的坑了，说明可以停了，用篮子里的的萝卜，把这个坑填了就行了，并且返回这个坑的位置，作为分而治之的中轴线。
     * 填坑之后：[ 2, 3, 1, 4, 10, 9, 5, 6, 8, 7]
     * 上面的步骤中，第2，4, 6其实都是一样的操作，3和5的操作也是一样的，代码如下：
     *
     * @param arr   待排序数组
     * @param low   左边界
     * @param high  右边界
     */
    public static void quicklySort(int arr[], int low, int high) {
        if (arr == null || arr.length <= 0) {
            return;
        }
        if (low >= high) {
            return;
        }

        int left = low;
        int right = high;
        int temp = arr[left]; //挖坑1：保存基准的值
        int num[] = {2,8,1,9,4,7,6,3,5};

        while (left < right) {
            while (arr[right] >= temp) {
                right--;
            }
            arr[left] = arr[right]; //坑2：从后向前找到比基准小的元素，插入到基准位置坑1中
            while (arr[left] <= temp) {
                left ++;
            }
            arr[right] = arr[left]; //坑3：从前往后找到比基准大的元素，放到刚才挖的坑2中
            System.out.println("Sorting: " + Arrays.toString(arr));

        }
        System.out.println("**********************");

        arr[left] = temp; //基准值填补到坑3中，准备分治递归快排
        quicklySort(arr, low, left-1);
        quicklySort(arr, left + 1, high);
    }



    /**
     * ②.  左右指针法
     * 用伪代码描述如下：
     * （1）low = L; high = R; 选取a[low]作为关键字记录为key。
     * （2）high--，由后向前找比它小的数
     * （3）low++，由前向后找比它大的数
     * （4）交换第（2）、（3）步找到的数
     * （5）重复（2）、（3），一直往后找，直到left和right相遇，这时将key和a[low]交换位置。
     * 代码如下：
     * 快速排序（左右指针法）
     * @param arr 待排序数组
     * @param low 左边界
     * @param high 右边界
     */
    public static void quicklySort2(int arr[], int low, int high) {
        if (arr == null || arr.length <= 0) {
            return;
        }
        if (low >= high) {
            return;
        }
        int left = low;
        int right = high;
        int key = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= key) {
                right--;
            }
            while (left < right && arr[left] <= key) {
                left++;
            }
            if (left < right) {
                swap(arr, left, right);
            }
        }
        swap(arr, low, left);
        System.out.println("Sorting: " + Arrays.toString(arr));
        quicklySort2(arr, low, left - 1);
        quicklySort2(arr, left + 1, high);
    }

    public static void swap(int arr[], int low, int high) {
        int tmp = arr[low];
        arr[low] = arr[high];
        arr[high] = tmp;
    }



    //选择排序
    public static int[] selectSort(int[] array) {
        if (array.length == 0)
            return array;
        for (int i = 0; i < array.length; i++) {
            int minIndex=i;/*最小数的下标，每个循环开始总是假设第一个数最小*/
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex]) /*找到最小的数*/
                    minIndex = j; /*将最小数的索引保存*/
            }
            System.out.println("最小数为："+array[minIndex]);
            /*交换最小数和i当前所指的元素*/
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        return array;
    }

    //插入排序
    public static int[] insertSort(int[] array) {
        if (array.length == 0)
            return array;
        int currentValue;/*当前待排序数据，该元素之前的元素均已被排序过*/
        for (int i = 0; i < array.length - 1; i++) {
            int preIndex = i;/*已被排序数据的索引*/
            currentValue = array[preIndex + 1];
            System.out.println("待排序元素索引:"+(i + 1)+"，值为：" +currentValue+
                    ",已被排序数据的索引:"+preIndex);

            /*在已被排序过数据中倒序寻找合适的位置，如果当前待排序数据比比较的元素要小，
            将比较的元素元素后移一位*/
            while (preIndex >= 0 && currentValue < array[preIndex]) {
                //将当前元素后移一位
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            /*while循环结束时，说明已经找到了当前待排序数据的合适位置，插入*/
            array[preIndex + 1] = currentValue;
            System.out.println("本轮被插入排序后的数组");
            PrintArray.print(array);
            System.out.println("--------------------");
        }
        return array;
    }

    static class PrintArray{
        public static void print(int [] nums){
            for (int num : nums) {
                System.out.print(num);
            }
        }
    }
}
