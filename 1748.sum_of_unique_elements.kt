class Solution {
  fun sumOfUnique(nums: IntArray): Int {
    val cnt = IntArray(101)
    for (x in nums) {
      ++cnt[x]
    }
    var ans = 0
    for (x in 0..100) {
      if (cnt[x] == 1) {
        ans += x
      }
    }
    return ans
  }
}
