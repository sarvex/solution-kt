import kotlin.math.max

internal class Solution {
  fun maxSumSubmatrix(matrix: Array<IntArray>, k: Int): Int {
    val m = matrix.size
    val n = matrix[0].size
    val inf = 1 shl 30
    var ans = -inf
    for (i in 0 until m) {
      val nums = IntArray(n)
      for (j in i until m) {
        for (h in 0 until n) {
          nums[h] += matrix[j][h]
        }
        var s = 0
        val ts: TreeSet<Int> = TreeSet()
        ts.add(0)
        for (x in nums) {
          s += x
          val y: Int = ts.ceiling(s - k)
          if (y != null) {
            ans = max(ans.toDouble(), (s - y).toDouble()).toInt()
          }
          ts.add(s)
        }
      }
    }
    return ans
  }
}
