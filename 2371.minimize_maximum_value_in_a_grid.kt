import kotlin.math.max

class Solution {
  fun minScore(grid: Array<IntArray>): Array<IntArray> {
    val m = grid.size
    val n = grid[0].size
    val nums: List<IntArray> = ArrayList()
    for (i in 0 until m) {
      for (j in 0 until n) {
        nums.add(intArrayOf(grid[i][j], i, j))
      }
    }
    Collections.sort(nums) { a, b -> a.get(0) - b.get(0) }
    val rowMax = IntArray(m)
    val colMax = IntArray(n)
    val ans = Array(m) { IntArray(n) }
    for (num in nums) {
      val i = num[1]
      val j = num[2]
      ans[i][j] = (max(rowMax[i].toDouble(), colMax[j].toDouble()) + 1).toInt()
      rowMax[i] = ans[i][j]
      colMax[j] = ans[i][j]
    }
    return ans
  }
}
