package xx.love.datastructure.java;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : zhijun.li on 2019/1/15
 * email : zhijun.li@timanetworks.com
 */
//两数之和
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map =new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            int complement=target-nums[i];
            if(map.containsKey(complement)&&map.get(complement)!=i){
                return new int[] {i,map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
