internal class Solution {
  fun hIndex(citations: IntArray): Int {
    val n = citations.size
    var left = 0
    var right = n
    while (left < right) {
      val mid = left + right + 1 shr 1
      if (citations[n - mid] >= mid) {
        left = mid
      } else {
        right = mid - 1
      }
    }
    return left
  }
}
