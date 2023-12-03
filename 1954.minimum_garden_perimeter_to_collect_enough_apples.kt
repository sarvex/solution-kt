class Solution {
  fun minimumPerimeter(neededApples: Long): Long {
    var l: Long = 1
    var r: Long = 100000
    while (l < r) {
      val mid = l + r shr 1
      if (2 * mid * (mid + 1) * (2 * mid + 1) >= neededApples) {
        r = mid
      } else {
        l = mid + 1
      }
    }
    return l * 8
  }
}
