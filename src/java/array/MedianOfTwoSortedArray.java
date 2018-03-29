package array;

/**
 * @author 杜艮魁
 * @date 2018/3/23
 */
public class MedianOfTwoSortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length,n=nums2.length;

        //保证第一个数组长度小于第二个数组长度
        if(m>n) return findMedianSortedArrays(nums2,nums1);

        /**
         * 1. i和j分别是nums1和nums2分割线的位置：比如 i=x标识nums1有x个元素在左半段
         * 2. imin和imax分别指向可以对nums1进行分割的两个位置，初始化为两个端点；
         * 3. half是计算中位数的数值的位置：奇数时指向中位数，偶数时指向分界前一个;
         * 4. maxLeft和minRight是两个左半段最大的值（在两个右边界取)和两个右半段最小的值；
         */
        int i=0,j=0,imin=0,imax=m,half=(m+n+1)/2;
        double maxLeft=0,minRight=0;

        while(imin<=imax){
            i=(imin+imax)/2;//”中间分界位置“
            j=half-i;   //保证i+j=half,即两个分界线的左半部分元素数量为全部的一半；

            //如果i、j都不在边界而且nums1的minRight小于nums2的maxLeft，说明i应该向右移动了；
            if(j>0&&i<m&&nums2[j-1]>nums1[i]){
                imin=i+1;//调整左边界的位置，下次去中间值时用后半段——都是针对nums1的
            }else if(i>0&&j<n&&nums1[i-1]>nums2[j]){//如果都没在边界而且..
                imax=i-1;//移动到中间位置靠左的一个
            }else{
                if(i==0){//说明imin和imax两个分界标识都在最左边，nums1全部数据都属于right域，因此MaxLeft在nums2中找
                    maxLeft=(double)nums2[j-1];
                }else if(j==0){//同上
                    maxLeft=(double)nums1[i-1];
                }
                else{
                    maxLeft=(double)Math.max(nums1[i-1],nums2[j-1]);
                }
                break;
            }
        }
        if((m+n)%2==1){//有奇数个元素，直接返回做半段最大值即可
            return maxLeft;
        }
        if(i==m){//如果nums1的分割线在最右边(即全部元素为“左半部分”）
            minRight=(double)nums2[j];
        }else if(j==n){//如果nums2的分割线在最右边(即全部元素为“左半部分”）
            minRight=(double)nums1[i];
        }else{
            minRight=(double)Math.min(nums1[i],nums2[j]);
        }

        return (double)(maxLeft+minRight)/2;
    }
}
