class Solution {
  fun findKOr(nums: IntArray, k: Int): Int {
    var ans = 0
    for (i in 0..31) {
      var cnt = 0
      for (x in nums) {
        cnt += x shr i and 1
      }
      if (cnt >= k) {
        ans = ans or (1 shl i)
      }
    }
    return ans
  }
}
