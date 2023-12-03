internal class Solution {
  private val vis: Set<Int> = HashSet()
  private val ans = StringBuilder()
  private var mod = 0
  fun crackSafe(n: Int, k: Int): String {
    mod = 10.pow((n - 1).toDouble()) as Int
    dfs(0, k)
    ans.append("0".repeat(n - 1))
    return ans.toString()
  }

  private fun dfs(u: Int, k: Int) {
    for (x in 0 until k) {
      val e = u * 10 + x
      if (vis.add(e)) {
        val v = e % mod
        dfs(v, k)
        ans.append(x)
      }
    }
  }
}
