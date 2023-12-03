class Solution {
  fun smallestDivisor(nums: IntArray, threshold: Int): Int {
    var l = 1
    var r = 1000000
    while (l < r) {
      val mid = l + r shr 1
      var s = 0
      for (x in nums) {
        s += (x + mid - 1) / mid
      }
      if (s <= threshold) {
        r = mid
      } else {
        l = mid + 1
      }
    }
    return l
  }
}
