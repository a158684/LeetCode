package xx.love.datastructure.java;

import java.util.HashSet;

/**
 * @author : zhijun.li on 2020/3/16
 * 找出数组中重复的数字。
 * <p>
 * <p>
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *  
 * <p>
 * 限制：
 * <p>
 * 2 <= n <= 100000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindRepeatNumber {
    public int findRepeatNumber(int[] nums) {
        return soluteTwo(nums);
    }

    //标签：哈希
    //使用 HashSet 来进行处理，因为 HashSet 本身不允许出现重复元素，所以当添加元素失败或已经包含该数字时，则表示出现了重复元素，将其返回即可。思路较为简单，就不给图了
    //时间复杂度：O(n)，空间复杂度：O(n)
    private int soluteOne(int[] nums) {
        HashSet<Integer> hashSet=new HashSet<>();
        for (int num : nums) {
            if (!hashSet.add(num)){
                return num;
            }
        }
        return -1;
    }

    /**
     * 标签：哈希
     * 从题目描述中我们可以看出，因为所有数字都在 0 ～ n-1 的范围内，其实完全可以省掉额外的空间开辟，将每个位置的数交换映射到其对应的数组下标下面，当出现新的元素与其对应的下标中的数字相等时，即为重复数字
     * 这本质还是哈希的思想，思路 1 是使用库函数申请额外空间，思路 2 则是数组本身做哈希表，达到了节省空间的目的
     * 此处会用到 while 循环，原因是保证交换过来的新元素位置也要正确
     * 时间复杂度：O(n)，空间复杂度：O(1)
     */
    private int soluteTwo(int[] nums) {
        final int length = nums.length;
        for (int i = 0; i < length; i++) {
            while (nums[i]!=i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                int temp = nums[i];
                System.out.println("i="+i+",temp="+temp);
                nums[i] = nums[temp];
                System.out.println("i="+i+",nums[i]="+nums[i]);
                nums[temp] = temp;
                System.out.println("2 i="+i+",nums[i]="+nums[i]);
                System.out.println("i="+i+",nums[temp]="+nums[temp]);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums={2, 3, 1, 0, 2, 5, 3};
        System.out.println(new FindRepeatNumber().findRepeatNumber(nums));
    }
}
