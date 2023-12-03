internal class Solution {
  private val g: Map<Int, List<Int>> = HashMap()
  private val ans: List<Int> = ArrayList()
  fun killProcess(pid: List<Int?>, ppid: List<Int?>, kill: Int): List<Int> {
    val n: Int = pid.size()
    for (i in 0 until n) {
      g.computeIfAbsent(ppid[i]) { k -> ArrayList() }.add(pid[i])
    }
    dfs(kill)
    return ans
  }

  private fun dfs(i: Int) {
    ans.add(i)
    for (j in g[i] ?: Collections.emptyList()) {
      dfs(j)
    }
  }
}
