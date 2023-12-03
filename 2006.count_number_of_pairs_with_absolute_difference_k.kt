internal class Solution {
  fun countKDifference(nums: IntArray, k: Int): Int {
    var ans = 0
    val cnt = IntArray(110)
    for (num in nums) {
      if (num >= k) {
        ans += cnt[num - k]
      }
      if (num + k <= 100) {
        ans += cnt[num + k]
      }
      ++cnt[num]
    }
    return ans
  }
}
