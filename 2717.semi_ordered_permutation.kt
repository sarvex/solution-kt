class Solution {
  fun semiOrderedPermutation(nums: IntArray): Int {
    val n = nums.size
    var i = 0
    var j = 0
    for (k in 0 until n) {
      if (nums[k] == 1) {
        i = k
      }
      if (nums[k] == n) {
        j = k
      }
    }
    val k = if (i < j) 1 else 2
    return i + n - j - k
  }
}
