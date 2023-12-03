internal class Solution {
  fun missingNumber(nums: IntArray): Int {
    val n = nums.size
    var ans = n
    for (i in 0 until n) {
      ans = ans xor (i xor nums[i])
    }
    return ans
  }
}
