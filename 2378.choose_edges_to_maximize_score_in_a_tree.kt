import kotlin.math.max

class Solution {
  private var g: Array<List<IntArray>?>
  fun maxScore(edges: Array<IntArray>): Long {
    val n = edges.size
    g = arrayOfNulls(n)
    Arrays.setAll(g) { k -> ArrayList() }
    for (i in 1 until n) {
      val p = edges[i][0]
      val w = edges[i][1]
      g[p].add(intArrayOf(i, w))
    }
    return dfs(0)[1]
  }

  private fun dfs(i: Int): LongArray {
    var a: Long = 0
    var b: Long = 0
    var t: Long = 0
    for (nxt in g[i]!!) {
      val j = nxt[0]
      val w = nxt[1]
      val s = dfs(j)
      a += s[1]
      b += s[1]
      t = max(t.toDouble(), (s[0] - s[1] + w).toDouble()).toLong()
    }
    b += t
    return longArrayOf(a, b)
  }
}
