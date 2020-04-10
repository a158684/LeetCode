package xx.love.datastructure.java;

/**
 * @author : zhijun.li on 2020/3/16
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * <p>
 * 示例:
 * <p>
 * 现有矩阵 matrix 如下：
 * <p>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * <p>
 * 给定 target = 20，返回 false。
 * <p>
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= n <= 1000
 * <p>
 * 0 <= m <= 1000
 * <p>
 *  
 */
public class FindNumberIn2DArray {
    /**
     * 若使用暴力法遍历矩阵 matrix ，则时间复杂度为 O(N*M)O(N∗M) 。暴力法未利用矩阵 “从上到下递增、从左到右递增” 的特点，显然不是最优解法。
     * 本题解利用矩阵特点引入标志数，并通过标志数性质降低算法时间复杂度。
     * <p>
     * 标志数引入： 此类矩阵中左下角和右上角元素有特殊性，称为标志数。
     * <p>
     * 左下角元素： 为所在列最大元素，所在行最小元素。
     * 右上角元素： 为所在行最大元素，所在列最小元素。
     * 标志数性质： 将 matrix 中的左下角元素（标志数）记作 flag ，则有:
     * <p>
     * 若 flag > target ，则 target 一定在 flag 所在行的上方，即 flag 所在行可被消去。
     * 若 flag < target ，则 target 一定在 flag 所在列的右方，即 flag 所在列可被消去。
     * 本题解以左下角元素为例，同理，右上角元素 也具有行（列）消去的性质。
     * 算法流程： 根据以上性质，设计算法在每轮对比时消去一行（列）元素，以降低时间复杂度。
     * <p>
     * 从矩阵 matrix 左下角元素（索引设为 (i, j) ）开始遍历，并与目标值对比：
     * 当 matrix[i][j] > target 时： 行索引向上移动一格（即 i--），即消去矩阵第 i 行元素；
     * 当 matrix[i][j] < target 时： 列索引向右移动一格（即 j++），即消去矩阵第 j 列元素；
     * 当 matrix[i][j] == target 时： 返回 truetrue 。
     * 若行索引或列索引越界，则代表矩阵中无目标值，返回 falsefalse 。
     * 算法本质： 每轮 i 或 j 移动后，相当于生成了“消去一行（列）的新矩阵”， 索引(i,j) 指向新矩阵的左下角元素（标志数），因此可重复使用以上性质消去行（列）。
     * <p>
     * 复杂度分析：
     * 时间复杂度 O(M+N) ：其中，NN 和 MM 分别为矩阵行数和列数，此算法最多循环 M+NM+N 次。
     * 空间复杂度 O(1) : i, j 指针使用常数大小额外空间。
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int i = matrix.length - 1, j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] > target) {
                i--;
            } else if (matrix[i][j] < target) {
                j++;
            } else {
                return true;
            }
        }
        return false;
    }

}
