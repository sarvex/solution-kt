class Solution {
  fun sumOfSquares(nums: IntArray): Int {
    val n = nums.size
    var ans = 0
    for (i in 1..n) {
      if (n % i == 0) {
        ans += nums[i - 1] * nums[i - 1]
      }
    }
    return ans
  }
}
