class Solution {
  fun maxStrength(nums: IntArray): Long {
    Arrays.sort(nums)
    val n = nums.size
    if (n == 1) {
      return nums[0].toLong()
    }
    if (nums[1] == 0 && nums[n - 1] == 0) {
      return 0
    }
    var ans: Long = 1
    var i = 0
    while (i < n) {
      if (nums[i] < 0 && i + 1 < n && nums[i + 1] < 0) {
        ans *= (nums[i] * nums[i + 1]).toLong()
        i += 2
      } else if (nums[i] <= 0) {
        i += 1
      } else {
        ans *= nums[i].toLong()
        i += 1
      }
    }
    return ans
  }
}
