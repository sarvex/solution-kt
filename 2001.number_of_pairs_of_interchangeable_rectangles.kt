internal class Solution {
  fun interchangeableRectangles(rectangles: Array<IntArray>): Long {
    var ans: Long = 0
    val n = rectangles.size + 1
    val cnt: Map<Long, Int> = HashMap()
    for (e in rectangles) {
      var w = e[0]
      var h = e[1]
      val g = gcd(w, h)
      w /= g
      h /= g
      val x = w.toLong() * n + h
      ans += cnt[x] ?: 0
      cnt.merge(x, 1) { a: Int, b: Int -> Integer.sum(a, b) }
    }
    return ans
  }

  private fun gcd(a: Int, b: Int): Int {
    return if (b == 0) a else gcd(b, a % b)
  }
}
