internal class Solution {
  fun maxPoints(points: Array<IntArray>): Int {
    val n = points.size
    var ans = 1
    for (i in 0 until n) {
      val x1 = points[i][0]
      val y1 = points[i][1]
      val cnt: Map<String, Int> = HashMap()
      for (j in i + 1 until n) {
        val x2 = points[j][0]
        val y2 = points[j][1]
        val dx = x2 - x1
        val dy = y2 - y1
        val g = gcd(dx, dy)
        val k = (dx / g).toString() + "." + dy / g
        cnt.put(k, (cnt[k] ?: 0) + 1)
        ans = Math.max(ans, cnt[k]!! + 1)
      }
    }
    return ans
  }

  private fun gcd(a: Int, b: Int): Int {
    return if (b == 0) a else gcd(b, a % b)
  }
}
