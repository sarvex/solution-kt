class Solution {
  fun findNumbers(nums: IntArray): Int {
    var ans = 0
    for (v in nums) {
      if (v.toString().length % 2 == 0) {
        ++ans
      }
    }
    return ans
  }
}
