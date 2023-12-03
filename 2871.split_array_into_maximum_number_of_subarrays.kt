class Solution {
  fun maxSubarrays(nums: IntArray): Int {
    var score = -1
    var ans = 1
    for (num in nums) {
      score = score and num
      if (score == 0) {
        ans++
        score = -1
      }
    }
    return if (ans == 1) 1 else ans - 1
  }
}
