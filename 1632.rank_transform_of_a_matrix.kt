import kotlin.math.max

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

  fun union(a: Int, b: Int) {
    val pa = find(a)
    val pb = find(b)
    if (pa != pb) {
      if (size[pa] > size[pb]) {
        p[pb] = pa
        size[pa] += size[pb]
      } else {
        p[pa] = pb
        size[pb] += size[pa]
      }
    }
  }

  fun reset(x: Int) {
    p[x] = x
    size[x] = 1
  }
}

internal class Solution {
  fun matrixRankTransform(matrix: Array<IntArray>): Array<IntArray> {
    val m = matrix.size
    val n = matrix[0].size
    val d: TreeMap<Int, List<IntArray>> = TreeMap()
    for (i in 0 until m) {
      for (j in 0 until n) {
        d.computeIfAbsent(matrix[i][j]) { k -> ArrayList() }.add(intArrayOf(i, j))
      }
    }
    val rowMax = IntArray(m)
    val colMax = IntArray(n)
    val ans = Array(m) { IntArray(n) }
    val uf = UnionFind(m + n)
    val rank = IntArray(m + n)
    for (ps in d.values()) {
      for (p in ps) {
        uf.union(p.get(0), p.get(1) + m)
      }
      for (p in ps) {
        val i: Int = p.get(0)
        val j: Int = p.get(1)
        rank[uf.find(i)] = max(rank[uf.find(i)].toDouble(), max(rowMax[i].toDouble(), colMax[j].toDouble()))
          .toInt()
      }
      for (p in ps) {
        val i: Int = p.get(0)
        val j: Int = p.get(1)
        ans[i][j] = 1 + rank[uf.find(i)]
        rowMax[i] = ans[i][j]
        colMax[j] = ans[i][j]
      }
      for (p in ps) {
        uf.reset(p.get(0))
        uf.reset(p.get(1) + m)
      }
    }
    return ans
  }
}
