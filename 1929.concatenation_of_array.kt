class Solution {
  fun getConcatenation(nums: IntArray): IntArray {
    val n = nums.size
    val ans = IntArray(n shl 1)
    for (i in 0 until (n shl 1)) {
      ans[i] = nums[i % n]
    }
    return ans
  }
}
