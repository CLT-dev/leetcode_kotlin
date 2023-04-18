//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= height[i] <= 10⁵ 
// 
//
// Related Topics 栈 数组 双指针 动态规划 单调栈 👍 4228 👎 0

package questions.leetcode.editor.cn


fun main() {
    val solution = TrappingRainWater.Solution()
    val result = solution.trap(intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1))
    println(result)

}

class TrappingRainWater {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun trap(height: IntArray): Int {
            if (height.size <= 2) {
                return 0
            }
//            val lMax = IntArray(height.size)
//            val rMax = IntArray(height.size)
//            lMax[0] = height[0]
//            rMax[height.lastIndex] = height[height.lastIndex]
//            for (i in 1..height.lastIndex) {
//                lMax[i] = maxOf(lMax[i - 1], height[i])
//                rMax[height.lastIndex - i] = maxOf(rMax[height.lastIndex - i + 1], height[height.lastIndex - i])
//            }
//            var count = 0
//            for (i in height.indices) {
//                count += (minOf(rMax[i], lMax[i]) - height[i])
//                println(count)
//            }

            // 其实我们不需要确定两个最大值，只需确定一个最大值，并且另一个最大值一定比这个大，就可以了
            // 举个例子，我们知道一个柱子lMax是2，而不知道rMax，但是知道rMax肯定>=2，所以minOf(lMax,rMax)的结果就已经可以确定了
            var lM = 0
            var rM = 0
            var left = 0
            var right = height.lastIndex
            var count = 0
            while (left < right) {
                lM = maxOf(lM, height[left])
                rM = maxOf(rM, height[right])

                if (lM < rM) {
                    count += lM - height[left]
                    left++
                } else {
                    count += rM - height[right]
                    right--
                }
            }
            return count
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}

