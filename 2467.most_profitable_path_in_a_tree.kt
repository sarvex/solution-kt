import kotlin.math.max
import kotlin.math.min

class Solution {
  private var g: Array<List<Int>?>
  private var amount: IntArray
  private var ts: IntArray
  private var ans = Int.MIN_VALUE
  fun mostProfitablePath(edges: Array<IntArray>, bob: Int, amount: IntArray): Int {
    val n = edges.size + 1
    g = arrayOfNulls(n)
    ts = IntArray(n)
    this.amount = amount
    Arrays.setAll(g) { k -> ArrayList() }
    Arrays.fill(ts, n)
    for (e in edges) {
      val a = e[0]
      val b = e[1]
      g[a].add(b)
      g[b].add(a)
    }
    dfs1(bob, -1, 0)
    ts[bob] = 0
    dfs2(0, -1, 0, 0)
    return ans
  }

  private fun dfs1(i: Int, fa: Int, t: Int): Boolean {
    if (i == 0) {
      ts[i] = min(ts[i].toDouble(), t.toDouble()).toInt()
      return true
    }
    for (j in g[i]!!) {
      if (j != fa && dfs1(j, i, t + 1)) {
        ts[j] = min(ts[j].toDouble(), (t + 1).toDouble()).toInt()
        return true
      }
    }
    return false
  }

  private fun dfs2(i: Int, fa: Int, t: Int, v: Int) {
    var v = v
    if (t == ts[i]) {
      v += amount[i] shr 1
    } else if (t < ts[i]) {
      v += amount[i]
    }
    if (g[i]!!.size() === 1 && g[i]!![0] === fa) {
      ans = max(ans.toDouble(), v.toDouble()).toInt()
      return
    }
    for (j in g[i]!!) {
      if (j != fa) {
        dfs2(j, i, t + 1, v)
      }
    }
  }
}
