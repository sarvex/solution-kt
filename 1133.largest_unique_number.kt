internal class Solution {
  fun largestUniqueNumber(nums: IntArray): Int {
    val cnt = IntArray(1001)
    for (x in nums) {
      ++cnt[x]
    }
    for (x in 1000 downTo 0) {
      if (cnt[x] == 1) {
        return x
      }
    }
    return -1
  }
}
