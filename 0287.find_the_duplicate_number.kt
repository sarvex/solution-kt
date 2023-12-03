internal class Solution {
  fun findDuplicate(nums: IntArray): Int {
    var l = 0
    var r = nums.size - 1
    while (l < r) {
      val mid = l + r shr 1
      var cnt = 0
      for (v in nums) {
        if (v <= mid) {
          ++cnt
        }
      }
      if (cnt > mid) {
        r = mid
      } else {
        l = mid + 1
      }
    }
    return l
  }
}
