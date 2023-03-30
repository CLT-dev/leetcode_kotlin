// value:   -1  1   1   4   4   5   6   7   10  12  14  21
// index:   0	1	2	3	4	5   6   7   8   9   10  11
// target = 9
// 输出 `List<IntArray>` 为{(0,8), (3,5), (4,5)} （顺序可乱）
// 由于 Map 有去重的特性，如果我们再用上述方法，就会在遍历到下标为 4 的 4 的时候，将 下标原本为 3 的 4 覆盖 ，然后失去 (3,5) 这个对

// 可以在这里停下思考一下

// 所以我们需要一个不去重，但是可以和 HashMap 拥有同级别的查找效率的数据结构
// 而 HashMap 是用哈希值来计算数组索引，然后进行红黑树查找的，
// 所以要么我们自己重写 HashMap 要么想别的办法

package questions.leetcode.editor.cn

fun main() {
    val solution = TwoSum1Extension.Solution()
    val result = solution.twoSum(intArrayOf(-1, 1, 1, 4, 4, 5, 6, 7, 10, 12, 14, 21), 9)
    for (t in result) {
        println("(${t[0]},${t[1]})")
    }
}

class TwoSum1Extension {

    // 计算有序数组的  两数之和结果
    class Solution {

        /**
         * 分别寻找两个数,小于 target/2 ,并且最接近的 target/2 的数 以及 大于 target/2 ,并且最接近的 target/2 的数
         * 例如：1,2,3,4,5,5,6,7 target = 9,则这两个数为 4 和 5,
         * 例如：-3,-1,0,9,11 target = -1, 则这两个数为 -1 和 0
         * 找到这两个数分别向两边寻找
         */
        fun twoSum(orderedNums: IntArray, target: Int): List<IntArray> {
            if (orderedNums.size < 2) {
                return emptyList()
            }

            val result = ArrayList<IntArray>()
            var closeSmaller = 0
            var closeBigger = 0

            // 如果最小的数小于 target/2 则不存在这样的数对之和等于 target （因为最小的数 ×2 已经大于 target 了）
            if ((target / 2) < orderedNums[closeSmaller]) {
                return emptyList()
            }
            for (i in orderedNums.indices) {
                if (orderedNums[i] < target / 2 + 1) {
                    closeSmaller = i
                } else {
                    break
                }
            }
            if (closeSmaller < orderedNums.size - 1) {
                closeBigger = closeSmaller + 1
            } else {
                return emptyList()
            }

            for (i in closeSmaller downTo 0) {
                for (j in closeBigger until orderedNums.size) {
                    when {
                        orderedNums[i] + orderedNums[j] == target -> {
                            result.add(intArrayOf(i, j))
                        }

                        orderedNums[i] + orderedNums[j] > target -> {
                            break
                        }
                    }
                }
            }

            return result
        }
    }
}