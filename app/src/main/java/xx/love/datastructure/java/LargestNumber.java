package xx.love.datastructure.java;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给定一组非负整数 nums，重新排列它们每个数字的顺序（每个数字不可拆分）使之组成一个最大的整数。
 * <p>
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [10,2]
 * 输出："210"
 * 示例 2：
 * <p>
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 * 示例 3：
 * <p>
 * 输入：nums = [1]
 * 输出："1"
 * 示例 4：
 * <p>
 * 输入：nums = [10]
 * 输出："10"
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LargestNumber {


    public static String largestNumber(int[] nums) {
        final int length = nums.length;
        if (length > 0) {
            if (length == 1) {
                return String.valueOf(nums[0]);
            }
            String[] str = new String[nums.length];
            for (int i = 0; i < nums.length; i++) {
                str[i] = String.valueOf(nums[i]);
            }

            Arrays.sort(str, new Comparator<String>() {
                @Override
                public int compare(String s, String t1) {
                    String a = s + t1;
                    String b = t1 + t1;
                    final int i = b.compareTo(a);
                    System.out.println("对比 [" + s + "," + t1 + "]  " + i);
                    return i;
                }
            });
            if (str[0].equals("0")){
                return "0";
            }
            StringBuilder s= new StringBuilder();
            for (String s1 : str) {
                s.append(s1);
            }
            return s.toString();
        }

        return "0";


    }

    public static void main(String[] args) {
        System.out.println(largestNumber(new int[]{0,0}));
    }
}
