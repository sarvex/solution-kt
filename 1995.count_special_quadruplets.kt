class Solution {
  fun countQuadruplets(nums: IntArray): Int {
    var ans = 0
    val n = nums.size
    val counter = IntArray(310)
    for (b in n - 3 downTo 1) {
      val c = b + 1
      for (d in c + 1 until n) {
        if (nums[d] - nums[c] >= 0) {
          ++counter[nums[d] - nums[c]]
        }
      }
      for (a in 0 until b) {
        ans += counter[nums[a] + nums[b]]
      }
    }
    return ans
  }
}
