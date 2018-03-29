package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 杜艮魁
 * @date 2018/3/29
 */
public class FourSum {


    public List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        int len = nums.length;
        if (nums == null || len < 4)
            return res;

        Arrays.sort(nums);

        int max = nums[len - 1];
        if (4 * nums[0] > target || 4 * max < target)
            return res;

        int i, z;
        for (i = 0; i < len; i++) {
            z = nums[i];
            // 避免重复
            if (i > 0 && z == nums[i - 1])
                continue;
            // z太小了
            if (z + 3 * max < target)
                continue;
            // z太大了
            if (4 * z > target)
                break;
            // z是边界值，理由见嵌套的if
            if (4 * z == target) {
                if (i + 3 < len && nums[i + 3] == z)
                    res.add(Arrays.asList(z, z, z, z));
                break;
            }

            //在数组nums中下标范围在i+1(因为i是z的小标)和len-1数字中，找到目标值为target-z的三个数，然后将这三个数和z放进返回值res中
            threeSumForFourSum(nums, target - z, i + 1, len - 1, res, z);
        }

        return res;
    }

    //在数组nums中下标范围在[low，high]数字中，找到目标值为target的三个数，然后将这三个数和z1放进返回值fourSumList中
    public void threeSumForFourSum(int[] nums, int target, int low, int high, ArrayList<List<Integer>> fourSumList,
                                   int z1) {
        //此条件限定[low,high]之间有三个数
        if (low + 1 >= high)
            return;

        //如果最大的三个数小于目标值或者最小的三个数大于目标值，则不可能出现三个数等于目标值
        int max = nums[high];
        if (3 * nums[low] > target || 3 * max < target)
            return;


        int i, z;
        for (i = low; i < high - 1; i++) {
            z = nums[i];
            // 避免重复
            if (i > low && z == nums[i - 1])
                continue;
            // z is too small
            if (z + 2 * max < target)
                continue;
            // z is too large
            if (3 * z > target)
                break;

            // z is the boundary
            if (3 * z == target) {
                if (i + 1 < high && nums[i + 2] == z)
                    fourSumList.add(Arrays.asList(z1, z, z, z));
                break;
            }

            //大致含义同此函数
            twoSumForFourSum(nums, target - z, i + 1, high, fourSumList, z1, z);
        }

    }

    //含义大致同threeSumForFourSum
    public void twoSumForFourSum(int[] nums, int target, int low, int high, ArrayList<List<Integer>> fourSumList,
                                 int z1, int z2) {

        if (low >= high)
            return;

        if (2 * nums[low] > target || 2 * nums[high] < target)
            return;

        int i = low, j = high, sum, x;
        while (i < j) {
            sum = nums[i] + nums[j];
            if (sum == target) {
                fourSumList.add(Arrays.asList(z1, z2, nums[i], nums[j]));

                x = nums[i];
                while (++i < j && x == nums[i]) // avoid duplicate
                    ;
                x = nums[j];
                while (i < --j && x == nums[j]) // avoid duplicate
                    ;
            }
            if (sum < target)
                i++;
            if (sum > target)
                j--;
        }
        return;
    }

    public static void main(String[] args) {
        int a[]={0,0,0,0};

        new FourSum().fourSum(a,0);
    }
}
