internal class Solution {
  private val ans: List<List<String>> = ArrayList()
  private var col: IntArray
  private var dg: IntArray
  private var udg: IntArray
  private var g: Array<Array<String?>>
  private var n = 0
  fun solveNQueens(n: Int): List<List<String>> {
    this.n = n
    col = IntArray(n)
    dg = IntArray(n shl 1)
    udg = IntArray(n shl 1)
    g = Array(n) { arrayOfNulls(n) }
    for (i in 0 until n) {
      Arrays.fill(g[i], ".")
    }
    dfs(0)
    return ans
  }

  private fun dfs(i: Int) {
    if (i == n) {
      val t: List<String> = ArrayList()
      for (j in 0 until n) {
        t.add(java.lang.String.join("", *g[j]))
      }
      ans.add(t)
      return
    }
    for (j in 0 until n) {
      if (col[j] + dg[i + j] + udg[n - i + j] == 0) {
        g[i][j] = "Q"
        udg[n - i + j] = 1
        dg[i + j] = udg[n - i + j]
        col[j] = dg[i + j]
        dfs(i + 1)
        udg[n - i + j] = 0
        dg[i + j] = udg[n - i + j]
        col[j] = dg[i + j]
        g[i][j] = "."
      }
    }
  }
}
