internal class Solution {
  fun hasGroupsSizeX(deck: IntArray): Boolean {
    val cnt = IntArray(10000)
    for (v in deck) {
      ++cnt[v]
    }
    var g = -1
    for (v in cnt) {
      if (v > 0) {
        g = if (g == -1) v else gcd(g, v)
      }
    }
    return g >= 2
  }

  private fun gcd(a: Int, b: Int): Int {
    return if (b == 0) a else gcd(b, a % b)
  }
}
