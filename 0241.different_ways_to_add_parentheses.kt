internal class Solution {
  fun diffWaysToCompute(expression: String): List<Int> {
    return dfs(expression)
  }

  private fun dfs(exp: String): List<Int> {
    if (Solution.Companion.memo.containsKey(exp)) {
      return Solution.Companion.memo.get(exp)
    }
    val ans: List<Int> = ArrayList()
    if (exp.length < 3) {
      ans.add(exp.toInt())
      return ans
    }
    for (i in 0 until exp.length) {
      val c = exp[i]
      if (c == '-' || c == '+' || c == '*') {
        val left = dfs(exp.substring(0, i))
        val right = dfs(exp.substring(i + 1))
        for (a in left) {
          for (b in right) {
            if (c == '-') {
              ans.add(a - b)
            } else if (c == '+') {
              ans.add(a + b)
            } else {
              ans.add(a * b)
            }
          }
        }
      }
    }
    Solution.Companion.memo.put(exp, ans)
    return ans
  }

  companion object {
    private val memo: Map<String, List<Int>> = HashMap()
  }
}
