internal class Solution {
  fun preimageSizeFZF(k: Int): Int {
    return g(k + 1) - g(k)
  }

  private fun g(k: Int): Int {
    var left: Long = 0
    var right = (5 * k).toLong()
    while (left < right) {
      val mid = left + right shr 1
      if (f(mid) >= k) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    return left.toInt()
  }

  private fun f(x: Long): Int {
    return if (x == 0L) {
      0
    } else (x / 5).toInt() + f(x / 5)
  }
}
