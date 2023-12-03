class Solution {
  fun averageValue(nums: IntArray): Int {
    var s = 0
    var n = 0
    for (x in nums) {
      if (x % 6 == 0) {
        s += x
        ++n
      }
    }
    return if (n == 0) 0 else s / n
  }
}
