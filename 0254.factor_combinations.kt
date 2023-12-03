internal class Solution {
  private val t: List<Int> = ArrayList()
  private val ans: List<List<Int>> = ArrayList()
  fun getFactors(n: Int): List<List<Int>> {
    dfs(n, 2)
    return ans
  }

  private fun dfs(n: Int, i: Int) {
    if (!t.isEmpty()) {
      val cp: List<Int> = ArrayList(t)
      cp.add(n)
      ans.add(cp)
    }
    for (j in i..n / j) {
      if (n % j == 0) {
        t.add(j)
        dfs(n / j, j)
        t.remove(t.size() - 1)
      }
    }
  }
}
