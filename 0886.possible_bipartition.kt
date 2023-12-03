internal class Solution {
  private var p: IntArray
  fun possibleBipartition(n: Int, dislikes: Array<IntArray>): Boolean {
    p = IntArray(n)
    val g: Array<List<Int>?> = arrayOfNulls(n)
    Arrays.setAll(g) { k -> ArrayList() }
    for (i in 0 until n) {
      p[i] = i
    }
    for (e in dislikes) {
      val a = e[0] - 1
      val b = e[1] - 1
      g[a].add(b)
      g[b].add(a)
    }
    for (i in 0 until n) {
      for (j in g[i]!!) {
        if (find(i) == find(j)) {
          return false
        }
        p[find(j)] = find(g[i]!![0])
      }
    }
    return true
  }

  private fun find(x: Int): Int {
    if (p[x] != x) {
      p[x] = find(p[x])
    }
    return p[x]
  }
}
