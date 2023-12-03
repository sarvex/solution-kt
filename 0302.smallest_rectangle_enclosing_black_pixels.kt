internal class Solution {
  fun minArea(image: Array<CharArray>, x: Int, y: Int): Int {
    val m = image.size
    val n = image[0].size
    var left = 0
    var right = x
    while (left < right) {
      val mid = left + right shr 1
      var c = 0
      while (c < n && image[mid][c] == '0') {
        ++c
      }
      if (c < n) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    val u = left
    left = x
    right = m - 1
    while (left < right) {
      val mid = left + right + 1 shr 1
      var c = 0
      while (c < n && image[mid][c] == '0') {
        ++c
      }
      if (c < n) {
        left = mid
      } else {
        right = mid - 1
      }
    }
    val d = left
    left = 0
    right = y
    while (left < right) {
      val mid = left + right shr 1
      var r = 0
      while (r < m && image[r][mid] == '0') {
        ++r
      }
      if (r < m) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    val l = left
    left = y
    right = n - 1
    while (left < right) {
      val mid = left + right + 1 shr 1
      var r = 0
      while (r < m && image[r][mid] == '0') {
        ++r
      }
      if (r < m) {
        left = mid
      } else {
        right = mid - 1
      }
    }
    val r = left
    return (d - u + 1) * (r - l + 1)
  }
}
