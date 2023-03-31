//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：2
//解释：有两种方法可以爬到楼顶。
//1. 1 阶 + 1 阶
//2. 2 阶 
//
// 示例 2： 
//
// 
//输入：n = 3
//输出：3
//解释：有三种方法可以爬到楼顶。
//1. 1 阶 + 1 阶 + 1 阶
//2. 1 阶 + 2 阶
//3. 2 阶 + 1 阶
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 45 
// 
//
// Related Topics 记忆化搜索 数学 动态规划 👍 2952 👎 0

package questions.leetcode.editor.cn

fun main() {
    val solution = ClimbingStairs.Solution()
    println(solution.climbStairs(1))

}

class ClimbingStairs {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun climbStairs(n: Int): Int {
//            递归
//            if (n == 1)
//                return 1
//            if (n == 2) {
//                return 2
//            }
//            return climbStairs(n - 1) + climbStairs(n - 2)

            // 循环
            val array = IntArray(n)

            array[0] = 1
            if (n == 1) {
                return array[0]
            }

            array[1] = 2
            if (n == 2) {
                return array[1]
            }

            for (i in 2 until n) {
                array[i] = array[i - 1] + array[i - 2]
            }

            return array[n - 1]
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}

