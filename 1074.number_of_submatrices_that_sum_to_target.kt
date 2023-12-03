internal class Solution {
  fun numSubmatrixSumTarget(matrix: Array<IntArray>, target: Int): Int {
    val m = matrix.size
    val n = matrix[0].size
    var ans = 0
    for (i in 0 until m) {
      val col = IntArray(n)
      for (j in i until m) {
        for (k in 0 until n) {
          col[k] += matrix[j][k]
        }
        ans += f(col, target)
      }
    }
    return ans
  }

  private fun f(nums: IntArray, target: Int): Int {
    val d: Map<Int, Int> = HashMap()
    d.put(0, 1)
    var s = 0
    var cnt = 0
    for (x in nums) {
      s += x
      cnt += d[s - target] ?: 0
      d.merge(s, 1) { a: Int, b: Int -> Integer.sum(a, b) }
    }
    return cnt
  }
}
