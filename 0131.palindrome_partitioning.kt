internal class Solution {
  private var n = 0
  private var s: String? = null
  private var f: Array<BooleanArray>
  private val t: List<String> = ArrayList()
  private val ans: List<List<String>> = ArrayList()
  fun partition(s: String): List<List<String>> {
    n = s.length
    f = Array(n) { BooleanArray(n) }
    for (i in 0 until n) {
      Arrays.fill(f[i], true)
    }
    for (i in n - 1 downTo 0) {
      for (j in i + 1 until n) {
        f[i][j] = s[i] == s[j] && f[i + 1][j - 1]
      }
    }
    this.s = s
    dfs(0)
    return ans
  }

  private fun dfs(i: Int) {
    if (i == s!!.length) {
      ans.add(ArrayList(t))
      return
    }
    for (j in i until n) {
      if (f[i][j]) {
        t.add(s!!.substring(i, j + 1))
        dfs(j + 1)
        t.remove(t.size() - 1)
      }
    }
  }
}
