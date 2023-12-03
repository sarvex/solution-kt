class Solution {
  fun countWays(nums: List<Int>): Int {
    Collections.sort(nums)
    val n: Int = nums.size()
    var ans = 0
    for (i in 0..n) {
      if ((i == 0 || nums[i - 1] < i) && (i == n || nums[i] > i)) {
        ans++
      }
    }
    return ans
  }
}
