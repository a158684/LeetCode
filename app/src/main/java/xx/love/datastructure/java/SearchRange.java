package xx.love.datastructure.java;

import java.util.Arrays;

/**
 * @author : zhijun.li on 2020/4/16
 * Find First and Last Position of Element in Sorted Array
 *
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 */
public class SearchRange {
    public static int[] searchRange(int[] nums, int target) {
        if (nums==null){
            return new int[]{-1,-1};
        }
        final int length = nums.length;
        if (length==0){
            return new int[]{-1,-1};
        }
        if (length==1){
            if (nums[0]==target){
                return new int[]{0,0};
            }
            return new int[]{-1,-1};
        }
        int left=0, right=length;
        while (left<right){
            int min=(left+right)>>1;
            if (nums[min]<target){
                left=min+1;
            }else if (nums[min]>target){
                right=min-1;
            }else {
                if (nums[min]==target){
                    left=min-1;
                    right=min+1;
                    while (left>-1){
                       if (nums[left]==target){
                           left--;
                       }else {
                           left++;
                           break;
                       }
                    }
                    while (right<length){
                        if (nums[right]==target){
                            right++;
                        }else {
                            right--;
                            break;
                        }
                    }
                    if (left<0){
                        left=0;
                    }
                    if (right==length){
                        right=length-1;
                    }
                    return new int[]{left,right};
                }
            }
        }
        if (left==right&&left<length&&nums[left]==target){
            return new int[]{left,left};
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
//        int[] test1={5,7,7,8,8,10};
        int[] test1={1,2};
//        System.out.println(Arrays.toString(SearchRange.searchRange(test1, 8)));
        System.out.println(Arrays.toString(SearchRange.searchRange(test1, 2)));
    }
}
