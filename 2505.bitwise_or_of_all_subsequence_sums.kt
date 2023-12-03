class Solution {
  fun subsequenceSumOr(nums: IntArray): Long {
    val cnt = LongArray(64)
    var ans: Long = 0
    for (v in nums) {
      for (i in 0..30) {
        if (v shr i and 1 == 1) {
          ++cnt[i]
        }
      }
    }
    for (i in 0..62) {
      if (cnt[i] > 0) {
        ans = ans or (1L shl i)
      }
      cnt[i + 1] += cnt[i] / 2
    }
    return ans
  }
}
