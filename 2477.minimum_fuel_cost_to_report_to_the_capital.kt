class Solution {
  private var g: Array<List<Int>?>
  private var ans: Long = 0
  private var seats = 0
  fun minimumFuelCost(roads: Array<IntArray>, seats: Int): Long {
    val n = roads.size + 1
    g = arrayOfNulls(n)
    Arrays.setAll(g) { k -> ArrayList() }
    this.seats = seats
    for (e in roads) {
      val a = e[0]
      val b = e[1]
      g[a].add(b)
      g[b].add(a)
    }
    dfs(0, -1)
    return ans
  }

  private fun dfs(a: Int, fa: Int): Int {
    var size = 1
    for (b in g[a]!!) {
      if (b != fa) {
        val t = dfs(b, a)
        ans += ((t + seats - 1) / seats).toLong()
        size += t
      }
    }
    return size
  }
}
