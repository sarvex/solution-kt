class Solution {
  fun minimumReplacement(nums: IntArray): Long {
    var ans: Long = 0
    val n = nums.size
    var mx = nums[n - 1]
    for (i in n - 2 downTo 0) {
      if (nums[i] <= mx) {
        mx = nums[i]
        continue
      }
      val k = (nums[i] + mx - 1) / mx
      ans += (k - 1).toLong()
      mx = nums[i] / k
    }
    return ans
  }
}
