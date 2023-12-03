class PersistentUnionFind(n: Int) {
  private val inf = 1 shl 30
  private val rank: IntArray
  private val parent: IntArray
  private val version: IntArray

  init {
    rank = IntArray(n)
    parent = IntArray(n)
    version = IntArray(n)
    for (i in 0 until n) {
      parent[i] = i
      version[i] = inf
    }
  }

  fun find(x: Int, t: Int): Int {
    return if (parent[x] == x || version[x] >= t) {
      x
    } else find(parent[x], t)
  }

  fun union(a: Int, b: Int, t: Int): Boolean {
    val pa = find(a, inf)
    val pb = find(b, inf)
    if (pa == pb) {
      return false
    }
    if (rank[pa] > rank[pb]) {
      version[pb] = t
      parent[pb] = pa
    } else {
      version[pa] = t
      parent[pa] = pb
      if (rank[pa] == rank[pb]) {
        rank[pb]++
      }
    }
    return true
  }
}

class DistanceLimitedPathsExist(n: Int, edgeList: Array<IntArray>) {
  private val puf: PersistentUnionFind

  init {
    puf = PersistentUnionFind(n)
    Arrays.sort(edgeList) { a, b -> a.get(2) - b.get(2) }
    for (e in edgeList) {
      puf.union(e[0], e[1], e[2])
    }
  }

  fun query(p: Int, q: Int, limit: Int): Boolean {
    return puf.find(p, limit) == puf.find(q, limit)
  }
}
