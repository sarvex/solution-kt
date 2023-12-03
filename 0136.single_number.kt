internal class Solution {
  fun singleNumber(nums: IntArray): Int {
    var ans = 0
    for (v in nums) {
      ans = ans xor v
    }
    return ans
  }
}
