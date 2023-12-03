import kotlin.math.min

internal class Solution {
  fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, k: Int): Int {
    val dist = IntArray(n)
    val backup = IntArray(n)
    Arrays.fill(dist, Solution.Companion.INF)
    dist[src] = 0
    for (i in 0 until k + 1) {
      System.arraycopy(dist, 0, backup, 0, n)
      for (e in flights) {
        val f = e[0]
        val t = e[1]
        val p = e[2]
        dist[t] = min(dist[t].toDouble(), (backup[f] + p).toDouble()).toInt()
      }
    }
    return if (dist[dst] == Solution.Companion.INF) -1 else dist[dst]
  }

  companion object {
    private const val INF = 0x3f3f3f3f
  }
}
