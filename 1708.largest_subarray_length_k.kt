class Solution {
  fun largestSubarray(nums: IntArray, k: Int): IntArray {
    var i = 0
    var mx = 0
    for (j in 0 until nums.size - k + 1) {
      if (mx < nums[j]) {
        mx = nums[j]
        i = j
      }
    }
    val ans = IntArray(k)
    for (j in 0 until k) {
      ans[j] = nums[i + j]
    }
    return ans
  }
}
