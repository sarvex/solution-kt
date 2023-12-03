class Solution {
  fun divideArray(nums: IntArray): Boolean {
    val cnt = IntArray(510)
    for (v in nums) {
      ++cnt[v]
    }
    for (v in cnt) {
      if (v % 2 != 0) {
        return false
      }
    }
    return true
  }
}
