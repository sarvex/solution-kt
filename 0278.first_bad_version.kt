class Solution : VersionControl() {
  fun firstBadVersion(n: Int): Int {
    var left = 1
    var right = n
    while (left < right) {
      val mid = left + right ushr 1
      if (isBadVersion(mid)) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    return left
  }
}
