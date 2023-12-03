internal class Solution {
  fun numMusicPlaylists(n: Int, goal: Int, k: Int): Int {
    val mod = 1e9.toInt() + 7
    val f = Array(goal + 1) { LongArray(n + 1) }
    f[0][0] = 1
    for (i in 1..goal) {
      for (j in 1..n) {
        f[i][j] = f[i - 1][j - 1] * (n - j + 1)
        if (j > k) {
          f[i][j] += f[i - 1][j] * (j - k)
        }
        f[i][j] %= mod.toLong()
      }
    }
    return f[goal][n].toInt()
  }
}
