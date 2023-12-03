internal class Solution {
  fun getAverages(nums: IntArray, k: Int): IntArray {
    val n = nums.size
    val s = LongArray(n + 1)
    for (i in 0 until n) {
      s[i + 1] = s[i] + nums[i]
    }
    val ans = IntArray(n)
    Arrays.fill(ans, -1)
    for (i in 0 until n) {
      if (i - k >= 0 && i + k < n) {
        ans[i] = ((s[i + k + 1] - s[i - k]) / (k shl 1 or 1)).toInt()
      }
    }
    return ans
  }
}
