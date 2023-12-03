internal class Solution {
  private val c: List<Int> = ArrayList()
  private val areas: List<List<Int>> = ArrayList()
  private val boundaries: List<Set<Int>> = ArrayList()
  private var infected: Array<IntArray>
  private var vis: Array<BooleanArray>
  private var m = 0
  private var n = 0
  fun containVirus(isInfected: Array<IntArray>): Int {
    infected = isInfected
    m = infected.size
    n = infected[0].size
    vis = Array(m) { BooleanArray(n) }
    var ans = 0
    while (true) {
      for (row in vis) {
        Arrays.fill(row, false)
      }
      c.clear()
      areas.clear()
      boundaries.clear()
      for (i in 0 until m) {
        for (j in 0 until n) {
          if (infected[i][j] == 1 && !vis[i][j]) {
            c.add(0)
            areas.add(ArrayList())
            boundaries.add(HashSet())
            dfs(i, j)
          }
        }
      }
      if (areas.isEmpty()) {
        break
      }
      val idx = max(boundaries)
      ans += c[idx]
      for (t in 0 until areas.size()) {
        if (t == idx) {
          for (v in areas[t]) {
            val i = v / n
            val j = v % n
            infected[i][j] = -1
          }
        } else {
          for (v in areas[t]) {
            val i = v / n
            val j = v % n
            for (k in 0..3) {
              val x: Int = i + Solution.Companion.DIRS.get(k)
              val y: Int = j + Solution.Companion.DIRS.get(k + 1)
              if (x >= 0 && x < m && y >= 0 && y < n && infected[x][y] == 0) {
                infected[x][y] = 1
              }
            }
          }
        }
      }
    }
    return ans
  }

  private fun max(boundaries: List<Set<Int>>): Int {
    var idx = 0
    var mx: Int = boundaries[0].size()
    for (i in 1 until boundaries.size()) {
      val t: Int = boundaries[i].size()
      if (mx < t) {
        mx = t
        idx = i
      }
    }
    return idx
  }

  private fun dfs(i: Int, j: Int) {
    vis[i][j] = true
    val idx: Int = areas.size() - 1
    areas[idx].add(i * n + j)
    for (k in 0..3) {
      val x: Int = i + Solution.Companion.DIRS.get(k)
      val y: Int = j + Solution.Companion.DIRS.get(k + 1)
      if (x >= 0 && x < m && y >= 0 && y < n) {
        if (infected[x][y] == 1 && !vis[x][y]) {
          dfs(x, y)
        } else if (infected[x][y] == 0) {
          c.set(idx, c[idx] + 1)
          boundaries[idx].add(x * n + y)
        }
      }
    }
  }

  companion object {
    private val DIRS = intArrayOf(-1, 0, 1, 0, -1)
  }
}
