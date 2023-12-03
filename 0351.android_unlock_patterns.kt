internal class Solution {
  private var m = 0
  private var n = 0
  private val cross = Array(10) { IntArray(10) }
  private val vis = BooleanArray(10)
  fun numberOfPatterns(m: Int, n: Int): Int {
    this.m = m
    this.n = n
    cross[3][1] = 2
    cross[1][3] = cross[3][1]
    cross[7][1] = 4
    cross[1][7] = cross[7][1]
    cross[9][1] = 5
    cross[1][9] = cross[9][1]
    cross[8][2] = 5
    cross[2][8] = cross[8][2]
    cross[7][3] = 5
    cross[3][7] = cross[7][3]
    cross[9][3] = 6
    cross[3][9] = cross[9][3]
    cross[6][4] = 5
    cross[4][6] = cross[6][4]
    cross[9][7] = 8
    cross[7][9] = cross[9][7]
    return dfs(1, 1) * 4 + dfs(2, 1) * 4 + dfs(5, 1)
  }

  private fun dfs(i: Int, cnt: Int): Int {
    if (cnt > n) {
      return 0
    }
    vis[i] = true
    var ans = if (cnt >= m) 1 else 0
    for (j in 1..9) {
      val x = cross[i][j]
      if (!vis[j] && (x == 0 || vis[x])) {
        ans += dfs(j, cnt + 1)
      }
    }
    vis[i] = false
    return ans
  }
}
