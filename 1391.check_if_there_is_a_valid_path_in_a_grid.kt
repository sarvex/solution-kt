class Solution {
  private var p: IntArray
  private var grid: Array<IntArray>
  private var m = 0
  private var n = 0
  fun hasValidPath(grid: Array<IntArray>): Boolean {
    this.grid = grid
    m = grid.size
    n = grid[0].size
    p = IntArray(m * n)
    for (i in p.indices) {
      p[i] = i
    }
    for (i in 0 until m) {
      for (j in 0 until n) {
        val e = grid[i][j]
        if (e == 1) {
          left(i, j)
          right(i, j)
        } else if (e == 2) {
          up(i, j)
          down(i, j)
        } else if (e == 3) {
          left(i, j)
          down(i, j)
        } else if (e == 4) {
          right(i, j)
          down(i, j)
        } else if (e == 5) {
          left(i, j)
          up(i, j)
        } else {
          right(i, j)
          up(i, j)
        }
      }
    }
    return find(0) == find(m * n - 1)
  }

  private fun find(x: Int): Int {
    if (p[x] != x) {
      p[x] = find(p[x])
    }
    return p[x]
  }

  private fun left(i: Int, j: Int) {
    if (j > 0 && (grid[i][j - 1] == 1 || grid[i][j - 1] == 4 || grid[i][j - 1] == 6)) {
      p[find(i * n + j)] = find(i * n + j - 1)
    }
  }

  private fun right(i: Int, j: Int) {
    if (j < n - 1 && (grid[i][j + 1] == 1 || grid[i][j + 1] == 3 || grid[i][j + 1] == 5)) {
      p[find(i * n + j)] = find(i * n + j + 1)
    }
  }

  private fun up(i: Int, j: Int) {
    if (i > 0 && (grid[i - 1][j] == 2 || grid[i - 1][j] == 3 || grid[i - 1][j] == 4)) {
      p[find(i * n + j)] = find((i - 1) * n + j)
    }
  }

  private fun down(i: Int, j: Int) {
    if (i < m - 1 && (grid[i + 1][j] == 2 || grid[i + 1][j] == 5 || grid[i + 1][j] == 6)) {
      p[find(i * n + j)] = find((i + 1) * n + j)
    }
  }
}
