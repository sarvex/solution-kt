class Solution {
  private var s: String? = null
  fun splitString(s: String?): Boolean {
    this.s = s
    return dfs(0, -1, 0)
  }

  private fun dfs(i: Int, x: Long, k: Int): Boolean {
    if (i == s!!.length) {
      return k > 1
    }
    var y: Long = 0
    for (j in i until s!!.length) {
      y = y * 10 + (s!![j].code - '0'.code)
      if ((x == -1L || x - y == 1L) && dfs(j + 1, y, k + 1)) {
        return true
      }
    }
    return false
  }
}
