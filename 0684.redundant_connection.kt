internal class Solution {
  private var p: IntArray
  fun findRedundantConnection(edges: Array<IntArray>): IntArray? {
    p = IntArray(1010)
    for (i in p.indices) {
      p[i] = i
    }
    for (e in edges) {
      val a = e[0]
      val b = e[1]
      if (find(a) == find(b)) {
        return e
      }
      p[find(a)] = find(b)
    }
    return null
  }

  private fun find(x: Int): Int {
    if (p[x] != x) {
      p[x] = find(p[x])
    }
    return p[x]
  }
}
