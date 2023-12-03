class Solution {
  fun maximumSafenessFactor(grid: List<List<Int>>): Int {
    val n: Int = grid.size()
    if (grid[0][0] === 1 || grid[n - 1][n - 1] === 1) {
      return 0
    }
    val q: Deque<IntArray> = ArrayDeque()
    val dist = Array(n) { IntArray(n) }
    val inf = 1 shl 30
    for (d in dist) {
      Arrays.fill(d, inf)
    }
    for (i in 0 until n) {
      for (j in 0 until n) {
        if (grid[i][j] === 1) {
          dist[i][j] = 0
          q.offer(intArrayOf(i, j))
        }
      }
    }
    val dirs = intArrayOf(-1, 0, 1, 0, -1)
    while (!q.isEmpty()) {
      val p: IntArray = q.poll()
      val i = p[0]
      val j = p[1]
      for (k in 0..3) {
        val x = i + dirs[k]
        val y = j + dirs[k + 1]
        if (x >= 0 && x < n && y >= 0 && y < n && dist[x][y] == inf) {
          dist[x][y] = dist[i][j] + 1
          q.offer(intArrayOf(x, y))
        }
      }
    }
    val t: List<IntArray> = ArrayList()
    for (i in 0 until n) {
      for (j in 0 until n) {
        t.add(intArrayOf(dist[i][j], i, j))
      }
    }
    t.sort { a, b -> Integer.compare(b.get(0), a.get(0)) }
    val uf = UnionFind(n * n)
    for (p in t) {
      val d = p[0]
      val i = p[1]
      val j = p[2]
      for (k in 0..3) {
        val x = i + dirs[k]
        val y = j + dirs[k + 1]
        if (x >= 0 && x < n && y >= 0 && y < n && dist[x][y] >= d) {
          uf.union(i * n + j, x * n + y)
        }
      }
      if (uf.find(0) == uf.find(n * n - 1)) {
        return d
      }
    }
    return 0
  }
}

internal class UnionFind(n: Int) {
  var p: IntArray
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
