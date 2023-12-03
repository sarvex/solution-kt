class Solution {
  fun arraySign(nums: IntArray): Int {
    var ans = 1
    for (v in nums) {
      if (v == 0) {
        return 0
      }
      if (v < 0) {
        ans *= -1
      }
    }
    return ans
  }
}
