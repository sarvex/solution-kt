internal class Solution {
  fun maximizeSweetness(sweetness: IntArray, k: Int): Int {
    var l = 0
    var r = 0
    for (v in sweetness) {
      r += v
    }
    while (l < r) {
      val mid = l + r + 1 shr 1
      if (check(sweetness, mid, k)) {
        l = mid
      } else {
        r = mid - 1
      }
    }
    return l
  }

  private fun check(nums: IntArray, x: Int, k: Int): Boolean {
    var s = 0
    var cnt = 0
    for (v in nums) {
      s += v
      if (s >= x) {
        s = 0
        ++cnt
      }
    }
    return cnt > k
  }
}
