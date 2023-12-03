class Solution {
  fun isGood(nums: IntArray): Boolean {
    val n = nums.size - 1
    val cnt = IntArray(201)
    for (x in nums) {
      ++cnt[x]
    }
    cnt[n] -= 2
    for (i in 1 until n) {
      cnt[i] -= 1
    }
    for (x in cnt) {
      if (x != 0) {
        return false
      }
    }
    return true
  }
}
