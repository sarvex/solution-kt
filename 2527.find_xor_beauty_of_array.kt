class Solution {
  fun xorBeauty(nums: IntArray): Int {
    var ans = 0
    for (x in nums) {
      ans = ans xor x
    }
    return ans
  }
}
