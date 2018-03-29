package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 杜艮魁
 * @date 2018/3/29
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> res=new ArrayList<>();

        for(int i=0;i<nums.length-2;i++){
            if(i>0&&nums[i]==nums[i-1]) continue;

            //i后续数据段的上下边界
            int low=i+1;
            int high=nums.length-1;

            while(low<high){
                if(nums[i]+nums[low]+nums[high]<0){//1. while(low<high){ if(XX) ... }应该等价于while(YY&&XX){...}
                    low++;
                }else if(nums[i]+nums[low]+nums[high]>0){
                    high--;
                }else{
                    res.add(Arrays.asList(nums[i],nums[low],nums[high]));

                    //这里会知道找到一个与nums[low]不同的数才停止自增
                    //注意：low和high开始时已经变了一次了，因此nums[low-1]是旧的位置，nums[low]是新的位置
                    do{ low++; }while(low<high&&nums[low]==nums[low-1]);
                    do{ high--;}while(low<high&&nums[high]==nums[high+1]);
                }
            }
        }
        return res;
    }

}
