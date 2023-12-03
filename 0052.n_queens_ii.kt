internal class Solution {
  private var n = 0
  private var ans = 0
  private val cols = BooleanArray(10)
  private val dg = BooleanArray(20)
  private val udg = BooleanArray(20)
  fun totalNQueens(n: Int): Int {
    this.n = n
    dfs(0)
    return ans
  }

  private fun dfs(i: Int) {
    if (i == n) {
      ++ans
      return
    }
    for (j in 0 until n) {
      val a = i + j
      val b = i - j + n
      if (cols[j] || dg[a] || udg[b]) {
        continue
      }
      cols[j] = true
      dg[a] = true
      udg[b] = true
      dfs(i + 1)
      cols[j] = false
      dg[a] = false
      udg[b] = false
    }
  }
}
