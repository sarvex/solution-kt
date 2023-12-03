class Solution {
  fun waysToSplit(nums: IntArray): Int {
    val n = nums.size
    val s = IntArray(n)
    s[0] = nums[0]
    for (i in 1 until n) {
      s[i] = s[i - 1] + nums[i]
    }
    var ans = 0
    for (i in 0 until n - 2) {
      val j = search(s, s[i] shl 1, i + 1, n - 1)
      val k = search(s, (s[n - 1] + s[i] shr 1) + 1, j, n - 1)
      ans = (ans + k - j) % Solution.Companion.MOD
    }
    return ans
  }

  private fun search(s: IntArray, x: Int, left: Int, right: Int): Int {
    var left = left
    var right = right
    while (left < right) {
      val mid = left + right shr 1
      if (s[mid] >= x) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    return left
  }

  companion object {
    private const val MOD = 1e9.toInt() + 7
  }
}
