internal class Solution {
  private val s: TreeSet<String> = TreeSet()
  fun braceExpansionII(expression: String): List<String> {
    dfs(expression)
    return ArrayList(s)
  }

  private fun dfs(exp: String) {
    val j = exp.indexOf('}')
    if (j == -1) {
      s.add(exp)
      return
    }
    val i = exp.lastIndexOf('{', j)
    val a = exp.substring(0, i)
    val c = exp.substring(j + 1)
    for (b in exp.substring(i + 1, j).split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()) {
      dfs(a + b + c)
    }
  }
}
