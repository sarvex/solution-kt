class Solution {
  private var path: IntArray
  private var cnt: IntArray
  private var n = 0
  fun constructDistancedSequence(n: Int): IntArray {
    this.n = n
    path = IntArray(n * 2)
    cnt = IntArray(n * 2)
    Arrays.fill(cnt, 2)
    cnt[1] = 1
    dfs(1)
    val ans = IntArray(n * 2 - 1)
    for (i in ans.indices) {
      ans[i] = path[i + 1]
    }
    return ans
  }

  private fun dfs(u: Int): Boolean {
    if (u == n * 2) {
      return true
    }
    if (path[u] > 0) {
      return dfs(u + 1)
    }
    for (i in n downTo 2) {
      if (cnt[i] > 0 && u + i < n * 2 && path[u + i] == 0) {
        cnt[i] = 0
        path[u] = i
        path[u + i] = i
        if (dfs(u + 1)) {
          return true
        }
        cnt[i] = 2
        path[u] = 0
        path[u + i] = 0
      }
    }
    if (cnt[1] > 0) {
      path[u] = 1
      cnt[1] = 0
      if (dfs(u + 1)) {
        return true
      }
      cnt[1] = 1
      path[u] = 0
    }
    return false
  }
}
