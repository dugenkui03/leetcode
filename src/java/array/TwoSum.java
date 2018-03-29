package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 杜艮魁
 * @date 2018/3/29
 */
public class TwoSum {
    /**
     *  返回数组后欧能和为target的两个数的下标
     */
    public int[] twoSum(int[] nums, int target) {
        //key是数值大小，value是数组下标
        Map<Integer,Integer> result=new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            //如果数组中已经有值为 target-nums[i] 的数，即两者之和为target，则返回
            if(result.containsKey(target-nums[i])){
                return new int[]{i,result.get(target-nums[i])};
            }
            result.put(nums[i],i);
        }
        return null;
    }
}
