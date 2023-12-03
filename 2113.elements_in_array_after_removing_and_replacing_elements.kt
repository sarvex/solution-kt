internal class Solution {
  fun elementInNums(nums: IntArray, queries: Array<IntArray>): IntArray {
    val n = nums.size
    val m = queries.size
    val ans = IntArray(m)
    for (j in 0 until m) {
      ans[j] = -1
      var t = queries[j][0]
      val i = queries[j][1]
      t %= 2 * n
      if (t < n && i < n - t) {
        ans[j] = nums[i + t]
      } else if (t > n && i < t - n) {
        ans[j] = nums[i]
      }
    }
    return ans
  }
}
