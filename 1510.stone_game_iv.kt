class Solution {
  private var f: Array<Boolean>
  fun winnerSquareGame(n: Int): Boolean {
    f = arrayOfNulls(n + 1)
    return dfs(n)
  }

  private fun dfs(i: Int): Boolean {
    if (i <= 0) {
      return false
    }
    if (f[i] != null) {
      return f[i]
    }
    for (j in 1..i / j) {
      if (!dfs(i - j * j)) {
        return true.also { f[i] = it }
      }
    }
    return false.also { f[i] = it }
  }
}
