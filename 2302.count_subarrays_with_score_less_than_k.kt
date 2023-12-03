class Solution {
  fun countSubarrays(nums: IntArray, k: Long): Long {
    var ans: Long = 0
    var s: Long = 0
    var i = 0
    var j = 0
    while (i < nums.size) {
      s += nums[i].toLong()
      while (s * (i - j + 1) >= k) {
        s -= nums[j++].toLong()
      }
      ans += (i - j + 1).toLong()
      ++i
    }
    return ans
  }
}
