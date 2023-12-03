import kotlin.math.max

class Solution {
  private var g: Array<List<Int>?>
  private var values: IntArray
  fun maximumScoreAfterOperations(edges: Array<IntArray>, values: IntArray): Long {
    val n = values.size
    g = arrayOfNulls(n)
    this.values = values
    Arrays.setAll(g) { k -> ArrayList() }
    for (e in edges) {
      val a = e[0]
      val b = e[1]
      g[a].add(b)
      g[b].add(a)
    }
    return dfs(0, -1)[1]
  }

  private fun dfs(i: Int, fa: Int): LongArray {
    var a: Long = 0
    var b: Long = 0
    var leaf = true
    for (j in g[i]!!) {
      if (j != fa) {
        leaf = false
        val t = dfs(j, i)
        a += t[0]
        b += t[1]
      }
    }
    return if (leaf) {
      longArrayOf(values[i].toLong(), 0)
    } else longArrayOf(
      values[i] + a, max((values[i] + b).toDouble(), a.toDouble())
        .toLong()
    )
  }
}
