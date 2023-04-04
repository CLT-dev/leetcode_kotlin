//给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。 
//
// 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。 
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 
//
// 示例 1： 
//
// 
//输入：k = 2, prices = [2,4,1]
//输出：2
//解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。 
//
// 示例 2： 
//
// 
//输入：k = 2, prices = [3,2,6,5,0,3]
//输出：7
//解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
//     随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 
//。 
//
// 
//
// 提示： 
//
// 
// 0 <= k <= 100 
// 0 <= prices.length <= 1000 
// 0 <= prices[i] <= 1000 
// 
//
// Related Topics 数组 动态规划 👍 912 👎 0

package questions.leetcode.editor.cn

fun main() {
    val solution = BestTimeToBuyAndSellStockIv.Solution()
    val result = solution.maxProfit(2, intArrayOf(3, 2, 6, 5, 0, 3))
    println(result)

}

class BestTimeToBuyAndSellStockIv {

    // dp[d][0][0] = 0
    // dp[d][0][1] = 不合法

    // dp[d][k][2]
    // dp[d][k][0] = max(dp[d-1][k][0], dp[d-1][k][1]+prices[d])
    // dp[d][k][1] = max(dp[d-1][k][1], dp[d-1][k-1][0]-prices[d])

    // dp[d][1][0] = max(dp[d-1][1][0], dp[d-1][0][1]+prices[d])
    //             = max(dp[d-1][1][0], 不合法)
    // dp[d][1][1] = max(dp[d-1][1][1], dp[d-1][0][0]-prices[d])
    //             = max(dp[d-1][1][1], -prices[d])

    // dp[0][k][0] = max(dp[-1][k][0], dp[-1][k-1][1]+prices[d])
    //             = 0
    // dp[0][k][1] = max(dp[-1][k][1], dp[-1][k][0]-prices[d])
    //             = -prices[d]
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun maxProfit(kk: Int, prices: IntArray): Int {
            val days = prices.size
            if (days == 0) {
                return 0
            }
            val dp = Array(days) {
                Array(kk + 1) {
                    IntArray(2)
                }
            }
            for (d in 0 until days) {
                dp[d][0][0] = 0
                dp[d][0][1] = Int.MIN_VALUE
            }
            for (d in 0 until days) {
                for (k in 1..kk) {
                    if (d == 0) {
                        dp[d][k][0] = 0
                        dp[d][k][1] = -prices[d]
                        continue
                    }

                    dp[d][k][0] = maxOf(dp[d - 1][k][0], dp[d - 1][k][1] + prices[d])
                    dp[d][k][1] = maxOf(dp[d - 1][k][1], dp[d - 1][k - 1][0] - prices[d])
                }
            }
            return dp[days - 1][kk][0]
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}

