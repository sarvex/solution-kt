class Solution {
  fun longestOnes(nums: IntArray, k: Int): Int {
    var k = k
    var l = 0
    var r = 0
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
