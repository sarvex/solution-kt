internal class Solution {
  private var s: String? = null
  private var n = 0
  private val ans: Set<String> = HashSet()
  fun removeInvalidParentheses(s: String): List<String> {
    this.s = s
    n = s.length
    var l = 0
    var r = 0
    for (c in s.toCharArray()) {
      if (c == '(') {
        ++l
      } else if (c == ')') {
        if (l > 0) {
          --l
        } else {
          ++r
        }
      }
    }
    dfs(0, l, r, 0, 0, "")
    return ArrayList(ans)
  }

  private fun dfs(i: Int, l: Int, r: Int, lcnt: Int, rcnt: Int, t: String) {
    if (i == n) {
      if (l == 0 && r == 0) {
        ans.add(t)
      }
      return
    }
    if (n - i < l + r || lcnt < rcnt) {
      return
    }
    val c = s!![i]
    if (c == '(' && l > 0) {
      dfs(i + 1, l - 1, r, lcnt, rcnt, t)
    }
    if (c == ')' && r > 0) {
      dfs(i + 1, l, r - 1, lcnt, rcnt, t)
    }
    val x = if (c == '(') 1 else 0
    val y = if (c == ')') 1 else 0
    dfs(i + 1, l, r, lcnt + x, rcnt + y, t + c)
  }
}
