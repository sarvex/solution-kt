class Solution {
  fun findCriticalAndPseudoCriticalEdges(n: Int, edges: Array<IntArray>): List<List<Int>> {
    for (i in edges.indices) {
      val e = edges[i]
      val t = IntArray(4)
      System.arraycopy(e, 0, t, 0, 3)
      t[3] = i
      edges[i] = t
    }
    Arrays.sort(edges, Comparator.comparingInt { a -> a.get(2) })
    var v = 0
    var uf = UnionFind(n)
    for (e in edges) {
      val f = e[0]
      val t = e[1]
      val w = e[2]
      if (uf.union(f, t)) {
        v += w
      }
    }
    val ans: List<List<Int>> = ArrayList()
    for (i in 0..1) {
      ans.add(ArrayList())
    }
    for (e in edges) {
      val f = e[0]
      val t = e[1]
      val w = e[2]
      val i = e[3]
      uf = UnionFind(n)
      var k = 0
      for (ne in edges) {
        val x = ne[0]
        val y = ne[1]
        val z = ne[2]
        val j = ne[3]
        if (j != i && uf.union(x, y)) {
          k += z
        }
      }
      if (uf.getN() > 1 || uf.getN() == 1 && k > v) {
        ans[0].add(i)
        continue
      }
      uf = UnionFind(n)
      uf.union(f, t)
      k = w
      for (ne in edges) {
        val x = ne[0]
        val y = ne[1]
        val z = ne[2]
        val j = ne[3]
        if (j != i && uf.union(x, y)) {
          k += z
        }
      }
      if (k == v) {
        ans[1].add(i)
      }
    }
    return ans
  }
}

internal class UnionFind(n: Int) {
  private val p: IntArray
  var n: Int
    private set

  init {
    p = IntArray(n)
    this.n = n
    for (i in 0 until n) {
      p[i] = i
    }
  }

  fun union(a: Int, b: Int): Boolean {
    if (find(a) == find(b)) {
      return false
    }
    p[find(a)] = find(b)
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
