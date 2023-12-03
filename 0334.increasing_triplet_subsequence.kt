internal class Solution {
  fun increasingTriplet(nums: IntArray): Boolean {
    var min = Int.MAX_VALUE
    var mid = Int.MAX_VALUE
    for (num in nums) {
      if (num > mid) {
        return true
      }
      if (num <= min) {
        min = num
      } else {
        mid = num
      }
    }
    return false
  }
}
