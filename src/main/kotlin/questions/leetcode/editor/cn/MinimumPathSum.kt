//给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
//
// 说明：每次只能向下或者向右移动一步。 
//
// 
//
// 示例 1： 
// 
// 
//输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
//输出：7
//解释：因为路径 1→3→1→1→1 的总和最小。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[1,2,3],[4,5,6]]
//输出：12
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 200 
// 0 <= grid[i][j] <= 100 
// 
//
// Related Topics 数组 动态规划 矩阵 👍 1467 👎 0

package questions.leetcode.editor.cn

fun main() {
    val solution = MinimumPathSum.Solution()

    val result = solution.minPathSum(
        arrayOf(
            intArrayOf(1, 3, 4, 8),
            intArrayOf(3, 2, 2, 4),
            intArrayOf(5, 7, 1, 9),
            intArrayOf(2, 3, 2, 3),
        )
    )

    println(result)
}

class MinimumPathSum {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun minPathSum(grid: Array<IntArray>): Int {

            //递归
//            return helper(grid, grid.size - 1, grid[0].size - 1)

            //循环
            val dp = Array(grid.size) {
                IntArray(grid[0].size)
            }

            dp[0][0] = grid[0][0]
            for (n in 1 until grid[0].size) {
                dp[0][n] = grid[0][n] + dp[0][n - 1]
            }
            for (m in 1 until grid.size) {
                dp[m][0] = grid[m][0] + dp[m - 1][0]
            }

            for (m in 1 until grid.size) {
                for (n in 1 until grid[0].size) {
                    dp[m][n] = grid[m][n] + Integer.min(dp[m - 1][n], dp[m][n - 1])
                }
            }
            return dp[grid.size - 1][grid[0].size - 1]

        }

        private fun helper(grid: Array<IntArray>, m: Int, n: Int): Int {
            if (m == 0) {
                if (n == 0) {
                    return grid[0][0]
                } else {
                    return helper(grid, 0, n - 1) + grid[0][n]
                }
            }

            if (n == 0) {
                return helper(grid, m - 1, 0) + grid[m][0]
            }

            return Integer.min(helper(grid, m - 1, n) + grid[m][n], helper(grid, m, n - 1) + grid[m][n])

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}

