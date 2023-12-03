class Solution {
  fun checkWays(pairs: Array<IntArray>): Int {
    val g = Array(510) { BooleanArray(510) }
    val v: Array<List<Int>?> = arrayOfNulls(510)
    Arrays.setAll(v) { k -> ArrayList() }
    for (p in pairs) {
      val x = p[0]
      val y = p[1]
      g[x][y] = true
      g[y][x] = true
      v[x].add(y)
      v[y].add(x)
    }
    val nodes: List<Int> = ArrayList()
    for (i in 0..509) {
      if (!v[i]!!.isEmpty()) {
        nodes.add(i)
        g[i][i] = true
      }
    }
    nodes.sort(Comparator.comparingInt { a -> v[a]!!.size() })
    var equal = false
    var root = 0
    for (i in 0 until nodes.size()) {
      val x = nodes[i]
      var j = i + 1
      while (j < nodes.size() && !g[x][nodes[j]]) {
        ++j
      }
      if (j < nodes.size()) {
        val y = nodes[j]
        if (v[x]!!.size() === v[y]!!.size()) {
          equal = true
        }
        for (z in v[x]!!) {
          if (!g[y][z]) {
            return 0
          }
        }
      } else {
        ++root
      }
    }
    if (root > 1) {
      return 0
    }
    return if (equal) 2 else 1
  }
}
