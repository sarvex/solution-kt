class Solution {
  fun countSubarrays(nums: IntArray): Long {
    var ans: Long = 0
    var i = 0
    val n = nums.size
    while (i < n) {
      var j = i + 1
      while (j < n && nums[j] > nums[j - 1]) {
        ++j
      }
      val cnt = (j - i).toLong()
      ans += (1 + cnt) * cnt / 2
      i = j
    }
    return ans
  }
}
