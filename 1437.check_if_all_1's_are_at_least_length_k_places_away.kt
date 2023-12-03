class Solution {
  fun kLengthApart(nums: IntArray, k: Int): Boolean {
    var j = -(k + 1)
    for (i in nums.indices) {
      if (nums[i] == 1) {
        if (i - j - 1 < k) {
          return false
        }
        j = i
      }
    }
    return true
  }
}
