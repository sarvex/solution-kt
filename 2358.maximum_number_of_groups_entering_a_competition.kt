class Solution {
  fun maximumGroups(grades: IntArray): Int {
    val n = grades.size
    var l = 0
    var r = n
    while (l < r) {
      val mid = l + r + 1 shr 1
      if (1L * mid * mid + mid > n * 2L) {
        r = mid - 1
      } else {
        l = mid
      }
    }
    return l
  }
}
