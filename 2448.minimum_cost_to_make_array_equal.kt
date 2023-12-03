import kotlin.math.min

class Solution {
  fun minCost(nums: IntArray, cost: IntArray): Long {
    val n = nums.size
    val arr = Array(n) { IntArray(2) }
    for (i in 0 until n) {
      arr[i] = intArrayOf(nums[i], cost[i])
    }
    Arrays.sort(arr) { a, b -> a.get(0) - b.get(0) }
    val f = LongArray(n + 1)
    val g = LongArray(n + 1)
    for (i in 1..n) {
      val a = arr[i - 1][0].toLong()
      val b = arr[i - 1][1].toLong()
      f[i] = f[i - 1] + a * b
      g[i] = g[i - 1] + b
    }
    var ans = Long.MAX_VALUE
    for (i in 1..n) {
      val a = arr[i - 1][0].toLong()
      val l = a * g[i - 1] - f[i - 1]
      val r = f[n] - f[i] - a * (g[n] - g[i])
      ans = min(ans.toDouble(), (l + r).toDouble()).toLong()
    }
    return ans
  }
}
