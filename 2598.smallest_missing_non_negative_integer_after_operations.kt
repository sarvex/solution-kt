class Solution {
  fun findSmallestInteger(nums: IntArray, value: Int): Int {
    val cnt = IntArray(value)
    for (x in nums) {
      ++cnt[(x % value + value) % value]
    }
    var i = 0
    while (true) {
      if (cnt[i % value]-- == 0) {
        return i
      }
      ++i
    }
  }
}
