internal class Solution {
  private var m = 0
  private var n = 0
  private var grid: Array<IntArray>
  fun numDistinctIslands2(grid: Array<IntArray>): Int {
    m = grid.size
    n = grid[0].size
    this.grid = grid
    val s: Set<List<List<Int>>> = HashSet()
    for (i in 0 until m) {
      for (j in 0 until n) {
        if (grid[i][j] == 1) {
          val shape: List<Int> = ArrayList()
          dfs(i, j, shape)
          s.add(normalize(shape))
        }
      }
    }
    return s.size()
  }

  private fun normalize(shape: List<Int>): List<List<Int>> {
    val shapes: Array<List<IntArray>?> = arrayOfNulls(8)
    for (i in 0..7) {
      shapes[i] = ArrayList()
    }
    for (e in shape) {
      val i = e / n
      val j = e % n
      shapes[0].add(intArrayOf(i, j))
      shapes[1].add(intArrayOf(i, -j))
      shapes[2].add(intArrayOf(-i, j))
      shapes[3].add(intArrayOf(-i, -j))
      shapes[4].add(intArrayOf(j, i))
      shapes[5].add(intArrayOf(j, -i))
      shapes[6].add(intArrayOf(-j, i))
      shapes[7].add(intArrayOf(-j, -i))
    }
    for (e in shapes) {
      e.sort { a, b ->
        val i1: Int = a.get(0)
        val j1: Int = a.get(1)
        val i2: Int = b.get(0)
        val j2: Int = b.get(1)
        if (i1 == i2) {
          return@sort j1 - j2
        }
        i1 - i2
      }
      val a = e!![0][0]
      val b = e[0][1]
      for (k in e.size() - 1 downTo 0) {
        val i = e[k][0]
        val j = e[k][1]
        e.set(k, intArrayOf(i - a, j - b))
      }
    }
    Arrays.sort(shapes) { a, b ->
      for (k in 0 until a.size()) {
        val i1: Int = a.get(k).get(0)
        val j1: Int = a.get(k).get(1)
        val i2: Int = b.get(k).get(0)
        val j2: Int = b.get(k).get(1)
        if (i1 != i2) {
          return@sort i1 - i2
        }
        if (j1 != j2) {
          return@sort j1 - j2
        }
      }
      0
    }
    val ans: List<List<Int>> = ArrayList()
    for (e in shapes[0]!!) {
      ans.add(Arrays.asList(e[0], e[1]))
    }
    return ans
  }

  private fun dfs(i: Int, j: Int, shape: List<Int>) {
    shape.add(i * n + j)
    grid[i][j] = 0
    val dirs = intArrayOf(-1, 0, 1, 0, -1)
    for (k in 0..3) {
      val x = i + dirs[k]
      val y = j + dirs[k + 1]
      if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
        dfs(x, y, shape)
      }
    }
  }
}
