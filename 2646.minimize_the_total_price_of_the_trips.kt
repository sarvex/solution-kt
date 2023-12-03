import kotlin.math.min

class Solution {
  private var g: Array<List<Int>?>
  private var price: IntArray
  private var cnt: IntArray
  fun minimumTotalPrice(n: Int, edges: Array<IntArray>, price: IntArray, trips: Array<IntArray>): Int {
    this.price = price
    cnt = IntArray(n)
    g = arrayOfNulls(n)
    Arrays.setAll(g) { k -> ArrayList() }
    for (e in edges) {
      val a = e[0]
      val b = e[1]
      g[a].add(b)
      g[b].add(a)
    }
    for (t in trips) {
      val start = t[0]
      val end = t[1]
      dfs(start, -1, end)
    }
    val ans = dfs2(0, -1)
    return min(ans[0].toDouble(), ans[1].toDouble()).toInt()
  }

  private fun dfs(i: Int, fa: Int, k: Int): Boolean {
    ++cnt[i]
    if (i == k) {
      return true
    }
    var ok = false
    for (j in g[i]!!) {
      if (j != fa) {
        ok = dfs(j, i, k)
        if (ok) {
          break
        }
      }
    }
    if (!ok) {
      --cnt[i]
    }
    return ok
  }

  private fun dfs2(i: Int, fa: Int): IntArray {
    var a = cnt[i] * price[i]
    var b = a shr 1
    for (j in g[i]!!) {
      if (j != fa) {
        val t = dfs2(j, i)
        (a += min(t[0].toDouble(), t[1].toDouble())).toInt()
        b += t[0]
      }
    }
    return intArrayOf(a, b)
  }
}
