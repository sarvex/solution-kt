class Solution {
  fun maxNumOfMarkedIndices(nums: IntArray): Int {
    Arrays.sort(nums)
    val n = nums.size
    var ans = 0
    var i = 0
    var j = (n + 1) / 2
    while (j < n) {
      while (j < n && nums[i] * 2 > nums[j]) {
        ++j
      }
      if (j < n) {
        ans += 2
      }
      ++i
      ++j
    }
    return ans
  }
}
