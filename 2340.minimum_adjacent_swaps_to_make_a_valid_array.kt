class Solution {
  fun minimumSwaps(nums: IntArray): Int {
    val n = nums.size
    var i = 0
    var j = 0
    for (k in 0 until n) {
      if (nums[k] < nums[i] || nums[k] == nums[i] && k < i) {
        i = k
      }
      if (nums[k] > nums[j] || nums[k] == nums[j] && k > j) {
        j = k
      }
    }
    return if (i == j) {
      0
    } else i + n - 1 - j - if (i > j) 1 else 0
  }
}
