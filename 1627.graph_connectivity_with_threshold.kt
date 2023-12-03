class UnionFind(n: Int) {
  private val p: IntArray
  private val size: IntArray

  init {
    p = IntArray(n)
    size = IntArray(n)
    for (i in 0 until n) {
      p[i] = i
      size[i] = 1
    }
  }

  fun find(x: Int): Int {
    if (p[x] != x) {
      p[x] = find(p[x])
    }
    return p[x]
  }

  fun union(a: Int, b: Int): Boolean {
    val pa = find(a)
    val pb = find(b)
    if (pa == pb) {
      return false
    }
    if (size[pa] > size[pb]) {
      p[pb] = pa
      size[pa] += size[pb]
    } else {
      p[pa] = pb
      size[pb] += size[pa]
    }
    return true
  }
}

internal class Solution {
  fun areConnected(n: Int, threshold: Int, queries: Array<IntArray>): List<Boolean> {
    val uf = UnionFind(n + 1)
    for (a in threshold + 1..n) {
      var b = a + a
      while (b <= n) {
        uf.union(a, b)
        b += a
      }
    }
    val ans: List<Boolean> = ArrayList()
    for (q in queries) {
      ans.add(uf.find(q[0]) == uf.find(q[1]))
    }
    return ans
  }
}
