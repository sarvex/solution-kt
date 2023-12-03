class Solution {
  fun minimumRightShifts(nums: List<Int>): Int {
    val n: Int = nums.size()
    var i = 1
    while (i < n && nums[i - 1] < nums[i]) {
      ++i
    }
    var k = i + 1
    while (k < n && nums[k - 1] < nums[k] && nums[k] < nums[0]) {
      ++k
    }
    return if (k < n) -1 else n - i
  }
}
