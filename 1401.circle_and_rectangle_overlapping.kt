class Solution {
  fun checkOverlap(
    radius: Int, xCenter: Int, yCenter: Int, x1: Int, y1: Int, x2: Int, y2: Int
  ): Boolean {
    val a = f(x1, x2, xCenter)
    val b = f(y1, y2, yCenter)
    return a * a + b * b <= radius * radius
  }

  private fun f(i: Int, j: Int, k: Int): Int {
    if (i <= k && k <= j) {
      return 0
    }
    return if (k < i) i - k else k - j
  }
}
