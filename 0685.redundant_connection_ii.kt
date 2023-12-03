internal class Solution {
  fun findRedundantDirectedConnection(edges: Array<IntArray>): IntArray {
    val n = edges.size
    val p = IntArray(n + 1)
    for (i in 0..n) {
      p[i] = i
    }
    val uf = UnionFind(n + 1)
    var conflict = -1
    var cycle = -1
    for (i in 0 until n) {
      val u = edges[i][0]
      val v = edges[i][1]
      if (p[v] != v) {
        conflict = i
      } else {
        p[v] = u
        if (!uf.union(u, v)) {
          cycle = i
        }
      }
    }
    if (conflict == -1) {
      return edges[cycle]
    }
    val v = edges[conflict][1]
    return if (cycle != -1) {
      intArrayOf(p[v], v)
    } else edges[conflict]
  }
}

internal class UnionFind(n: Int) {
  var p: IntArray
  @JvmField
  var n: Int

  init {
    p = IntArray(n)
    for (i in 0 until n) {
      p[i] = i
    }
    this.n = n
  }

  fun union(a: Int, b: Int): Boolean {
    val pa = find(a)
    val pb = find(b)
    if (pa == pb) {
      return false
    }
    p[pa] = pb
    --n
    return true
  }

  fun find(x: Int): Int {
    if (p[x] != x) {
      p[x] = find(p[x])
    }
    return p[x]
  }
}
