import kotlin.math.min

class Solution {
  fun minDifference(nums: IntArray, queries: Array<IntArray>): IntArray {
    val m = nums.size
    val n = queries.size
    val preSum = Array(m + 1) { IntArray(101) }
    for (i in 1..m) {
      for (j in 1..100) {
        val t = if (nums[i - 1] == j) 1 else 0
        preSum[i][j] = preSum[i - 1][j] + t
      }
    }
    val ans = IntArray(n)
    for (i in 0 until n) {
      val left = queries[i][0]
      val right = queries[i][1] + 1
      var t = Int.MAX_VALUE
      var last = -1
      for (j in 1..100) {
        if (preSum[right][j] > preSum[left][j]) {
          if (last != -1) {
            t = min(t.toDouble(), (j - last).toDouble()).toInt()
          }
          last = j
        }
      }
      if (t == Int.MAX_VALUE) {
        t = -1
      }
      ans[i] = t
    }
    return ans
  }
}
