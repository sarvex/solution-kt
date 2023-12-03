import kotlin.math.min

internal class Solution {
  private var now = 0
  private var g: Array<List<Int>?>
  private val ans: List<List<Int>> = ArrayList()
  private var dfn: IntArray
  private var low: IntArray
  fun criticalConnections(n: Int, connections: List<List<Int?>>): List<List<Int>> {
    g = arrayOfNulls(n)
    Arrays.setAll(g) { k -> ArrayList() }
    dfn = IntArray(n)
    low = IntArray(n)
    for (e in connections) {
      val a: Int = e[0]
      val b: Int = e[1]
      g[a].add(b)
      g[b].add(a)
    }
    tarjan(0, -1)
    return ans
  }

  private fun tarjan(a: Int, fa: Int) {
    low[a] = ++now
    dfn[a] = low[a]
    for (b in g[a]!!) {
      if (b == fa) {
        continue
      }
      if (dfn[b] == 0) {
        tarjan(b, a)
        low[a] = min(low[a].toDouble(), low[b].toDouble()).toInt()
        if (low[b] > dfn[a]) {
          ans.add(List.of(a, b))
        }
      } else {
        low[a] = min(low[a].toDouble(), dfn[b].toDouble()).toInt()
      }
    }
  }
}
