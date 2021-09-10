import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 * <p>
 * 示例 1：
 * 输入：nums=[2,7,11,15],target=9
 * 输出：[0,1]
 * 解释：因为 nums[0]+nums[1]==9 ，返回[0,1] 。
 * <p>
 * 示例 2：
 * 输入：nums=[3,2,4],target=6
 * 输出：[1,2]
 * <p>
 * 示例 3：
 * 输入：nums=[3,3],target=6
 * 输出：[0,1]
 * <p>
 * 提示：
 * 2<=nums.length<=103
 * -109<=nums[i]<=109
 * -109<=target<=109
 * 只会存在一个有效答案
 */
public class TwoNumbersSum {

    public static void main(String[] args) {
        int num[] = {1,4,7,8,5,2,3,6,9};
        selectSort(num);
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
            System.out.println("---------------");
            //PrintArray.print(array);
        }
        return array;
    }

    public static int[] twoSumb(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j <nums.length ; j++) {
                if (nums[j] == target - nums[i]){
                    return new int[]{i, j};
                }
            }
        }
        return new int [0];
    }

    //    solution
    public static int[] twoSuma(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        System.out.println("1");
        throw new IllegalArgumentException("No two sum solution");
    }





}
