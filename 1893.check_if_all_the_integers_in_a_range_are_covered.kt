class Solution {
  fun isCovered(ranges: Array<IntArray>, left: Int, right: Int): Boolean {
    val diff = IntArray(52)
    for (range in ranges) {
      val l = range[0]
      val r = range[1]
      ++diff[l]
      --diff[r + 1]
    }
    var cur = 0
    for (i in diff.indices) {
      cur += diff[i]
      if (i >= left && i <= right && cur == 0) {
        return false
      }
    }
    return true
  }
}
