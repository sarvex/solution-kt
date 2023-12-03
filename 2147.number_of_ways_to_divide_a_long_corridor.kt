class Solution {
  private var s: String? = null
  private var n = 0
  private var f: Array<IntArray>
  fun numberOfWays(corridor: String?): Int {
    s = corridor
    n = s!!.length
    f = Array(n) { IntArray(3) }
    for (e in f) {
      Arrays.fill(e, -1)
    }
    return dfs(0, 0)
  }

  private fun dfs(i: Int, cnt: Int): Int {
    var cnt = cnt
    if (i == n) {
      return if (cnt == 2) 1 else 0
    }
    cnt += if (s!![i] == 'S') 1 else 0
    if (cnt > 2) {
      return 0
    }
    if (f[i][cnt] != -1) {
      return f[i][cnt]
    }
    var ans = dfs(i + 1, cnt)
    if (cnt == 2) {
      ans += dfs(i + 1, 0)
      ans %= Solution.Companion.MOD
    }
    f[i][cnt] = ans
    return ans
  }

  companion object {
    private const val MOD = 1e9.toInt() + 7
  }
}
