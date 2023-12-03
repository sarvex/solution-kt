internal class Solution {
  fun findMaxConsecutiveOnes(nums: IntArray): Int {
    var l = 0
    var r = 0
    var k = 1
    while (r < nums.size) {
      if (nums[r++] == 0) {
        --k
      }
      if (k < 0 && nums[l++] == 0) {
        ++k
      }
    }
    return r - l
  }
}
