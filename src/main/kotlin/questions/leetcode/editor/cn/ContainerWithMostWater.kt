//给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。 
//
// 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 返回容器可以储存的最大水量。 
//
// 说明：你不能倾斜容器。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：[1,8,6,2,5,4,8,3,7]
//输出：49 
//解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 示例 2： 
//
// 
//输入：height = [1,1]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 2 <= n <= 10⁵ 
// 0 <= height[i] <= 10⁴ 
// 
//
// Related Topics 贪心 数组 双指针 👍 4253 👎 0

package questions.leetcode.editor.cn

fun main() {
    val solution = ContainerWithMostWater.Solution()
    val result = solution.maxArea(intArrayOf(1, 3, 2, 5, 25, 24, 5))
    println(result)
}

class ContainerWithMostWater {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun maxArea(height: IntArray): Int {
            var left = 0
            var right = height.size - 1
            var areaMax = 0
            var areaNow: Int
            var needMove: Int
            while (right > left) {
                needMove = minOf(height[left], height[right])
                areaNow = minOf(height[left], height[right]) * (right - left)
                if (areaNow > areaMax) {
                    areaMax = areaNow
                }
                if (height[right] == needMove) {
                    right--
                } else {
                    left++
                }
            }
            return areaMax
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}

