internal class Solution {
  fun maxSumOfThreeSubarrays(nums: IntArray, k: Int): IntArray {
    val n = nums.size
    val s = IntArray(n + 1)
    for (i in 0 until n) {
      s[i + 1] = s[i] + nums[i]
    }
    val pre = Array(n) { IntArray(0) }
    val suf = Array(n) { IntArray(0) }
    run {
      var i = 0
      var t = 0
      var idx = 0
      while (i < n - k + 1) {
        val cur = s[i + k] - s[i]
        if (cur > t) {
          pre[i + k - 1] = intArrayOf(cur, i)
          t = cur
          idx = i
        } else {
          pre[i + k - 1] = intArrayOf(t, idx)
        }
        ++i
      }
    }
    run {
      var i = n - k
      var t = 0
      var idx = 0
      while (i >= 0) {
        val cur = s[i + k] - s[i]
        if (cur >= t) {
          suf[i] = intArrayOf(cur, i)
          t = cur
          idx = i
        } else {
          suf[i] = intArrayOf(t, idx)
        }
        --i
      }
    }
    var ans = IntArray(0)
    var i = k
    var t = 0
    while (i < n - 2 * k + 1) {
      val cur = s[i + k] - s[i] + pre[i - 1][0] + suf[i + k][0]
      if (cur > t) {
        ans = intArrayOf(pre[i - 1][1], i, suf[i + k][1])
        t = cur
      }
      ++i
    }
    return ans
  }
}
