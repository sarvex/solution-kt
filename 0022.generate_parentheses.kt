internal class Solution {
  private val ans: List<String> = ArrayList()
  private var n = 0
  fun generateParenthesis(n: Int): List<String> {
    this.n = n
    dfs(0, 0, "")
    return ans
  }

  private fun dfs(l: Int, r: Int, t: String) {
    if (l > n || r > n || l < r) {
      return
    }
    if (l == n && r == n) {
      ans.add(t)
      return
    }
    dfs(l + 1, r, "$t(")
    dfs(l, r + 1, "$t)")
  }
}
