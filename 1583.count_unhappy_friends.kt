class Solution {
  fun unhappyFriends(n: Int, preferences: Array<IntArray>, pairs: Array<IntArray>): Int {
    val d = Array(n) { IntArray(n) }
    for (i in 0 until n) {
      for (j in 0 until n - 1) {
        d[i][preferences[i][j]] = j
      }
    }
    val p = IntArray(n)
    for (e in pairs) {
      val x = e[0]
      val y = e[1]
      p[x] = y
      p[y] = x
    }
    var ans = 0
    for (x in 0 until n) {
      val y = p[x]
      var find = 0
      for (i in 0 until d[x][y]) {
        val u = preferences[x][i]
        if (d[u][x] < d[u][p[u]]) {
          find = 1
          break
        }
      }
      ans += find
    }
    return ans
  }
}
