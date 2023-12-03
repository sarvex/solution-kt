import kotlin.math.max

class Solution {
  fun maximumScore(scores: IntArray, edges: Array<IntArray>): Int {
    val n = scores.size
    val g: Array<List<Int>?> = arrayOfNulls(n)
    Arrays.setAll(g) { k -> ArrayList() }
    for (e in edges) {
      val a = e[0]
      val b = e[1]
      g[a].add(b)
      g[b].add(a)
    }
    for (i in 0 until n) {
      g[i].sort { a, b -> scores[b] - scores[a] }
      g[i] = g[i]!!.subList(0, Math.min(3, g[i]!!.size()))
    }
    var ans = -1
    for (e in edges) {
      val a = e[0]
      val b = e[1]
      for (c in g[a]!!) {
        for (d in g[b]!!) {
          if (c != b && c != d && a != d) {
            val t = scores[a] + scores[b] + scores[c] + scores[d]
            ans = max(ans.toDouble(), t.toDouble()).toInt()
          }
        }
      }
    }
    return ans
  }
}
