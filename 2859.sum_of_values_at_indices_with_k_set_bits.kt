class Solution {
  fun sumIndicesWithKSetBits(nums: List<Int>, k: Int): Int {
    var ans = 0
    for (i in 0 until nums.size()) {
      if (Integer.bitCount(i) == k) {
        ans += nums[i]
      }
    }
    return ans
  }
}
