internal class Solution {
  fun majorityElement(nums: IntArray): Int {
    var cnt = 0
    var m = 0
    for (x in nums) {
      if (cnt == 0) {
        m = x
        cnt = 1
      } else {
        cnt += if (m == x) 1 else -1
      }
    }
    return m
  }
}
