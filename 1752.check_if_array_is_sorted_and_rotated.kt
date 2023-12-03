class Solution {
  fun check(nums: IntArray): Boolean {
    var cnt = 0
    var i = 0
    val n = nums.size
    while (i < n) {
      if (nums[i] > nums[(i + 1) % n]) {
        ++cnt
      }
      ++i
    }
    return cnt <= 1
  }
}
