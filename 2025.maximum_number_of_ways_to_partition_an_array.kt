import kotlin.math.max

internal class Solution {
  fun waysToPartition(nums: IntArray, k: Int): Int {
    val n = nums.size
    val s = IntArray(n)
    s[0] = nums[0]
    val right: Map<Int, Int> = HashMap()
    for (i in 0 until n - 1) {
      right.merge(s[i], 1) { a: Int, b: Int -> Integer.sum(a, b) }
      s[i + 1] = s[i] + nums[i + 1]
    }
    var ans = 0
    if (s[n - 1] % 2 == 0) {
      ans = right[s[n - 1] / 2] ?: 0
    }
    val left: Map<Int, Int> = HashMap()
    for (i in 0 until n) {
      val d = k - nums[i]
      if ((s[n - 1] + d) % 2 == 0) {
        val t = ((left[(s[n - 1] + d) / 2] ?: 0)
            + (right[(s[n - 1] - d) / 2] ?: 0))
        ans = max(ans.toDouble(), t.toDouble()).toInt()
      }
      left.merge(s[i], 1) { a: Int, b: Int -> Integer.sum(a, b) }
      right.merge(s[i], -1) { a: Int, b: Int -> Integer.sum(a, b) }
    }
    return ans
  }
}
