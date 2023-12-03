import kotlin.math.max

class Solution {
  fun maximumCost(n: Int, highways: Array<IntArray>, k: Int): Int {
    if (k >= n) {
      return -1
    }
    val g: Array<List<IntArray>?> = arrayOfNulls(n)
    Arrays.setAll(g) { h -> ArrayList() }
    for (h in highways) {
      val a = h[0]
      val b = h[1]
      val cost = h[2]
      g[a].add(intArrayOf(b, cost))
      g[b].add(intArrayOf(a, cost))
    }
    val f = Array(1 shl n) { IntArray(n) }
    for (e in f) {
      Arrays.fill(e, -(1 shl 30))
    }
    for (i in 0 until n) {
      f[1 shl i][i] = 0
    }
    var ans = -1
    for (i in 0 until (1 shl n)) {
      for (j in 0 until n) {
        if (i shr j and 1 == 1) {
          for (e in g[j]!!) {
            val h = e[0]
            val cost = e[1]
            if (i shr h and 1 == 1) {
              f[i][j] = max(f[i][j].toDouble(), (f[i xor (1 shl j)][h] + cost).toDouble())
                .toInt()
            }
          }
        }
        if (Integer.bitCount(i) == k + 1) {
          ans = max(ans.toDouble(), f[i][j].toDouble()).toInt()
        }
      }
    }
    return ans
  }
}
