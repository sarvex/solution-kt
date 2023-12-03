class Solution {
  fun isPossible(n: Int, edges: List<List<Int?>>): Boolean {
    val g: Array<Set<Int>?> = arrayOfNulls(n + 1)
    Arrays.setAll(g) { k -> HashSet() }
    for (e in edges) {
      val a: Int = e[0]
      val b: Int = e[1]
      g[a].add(b)
      g[b].add(a)
    }
    val vs: List<Int> = ArrayList()
    for (i in 1..n) {
      if (g[i]!!.size() % 2 === 1) {
        vs.add(i)
      }
    }
    if (vs.size() === 0) {
      return true
    }
    if (vs.size() === 2) {
      val a = vs[0]
      val b = vs[1]
      if (!g[a]!!.contains(b)) {
        return true
      }
      for (c in 1..n) {
        if (a != c && b != c && !g[a]!!.contains(c) && !g[c]!!.contains(b)) {
          return true
        }
      }
      return false
    }
    if (vs.size() === 4) {
      val a = vs[0]
      val b = vs[1]
      val c = vs[2]
      val d = vs[3]
      if (!g[a]!!.contains(b) && !g[c]!!.contains(d)) {
        return true
      }
      if (!g[a]!!.contains(c) && !g[b]!!.contains(d)) {
        return true
      }
      return if (!g[a]!!.contains(d) && !g[b]!!.contains(c)) {
        true
      } else false
    }
    return false
  }
}
