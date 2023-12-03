class Solution {
  private val ans: List<String> = ArrayList()
  fun getHappyString(n: Int, k: Int): String {
    dfs("", n)
    return if (ans.size() < k) "" else ans[k - 1]
  }

  private fun dfs(t: String, n: Int) {
    if (t.length == n) {
      ans.add(t)
      return
    }
    for (c in "abc".toCharArray()) {
      if (t.length > 0 && t[t.length - 1] == c) {
        continue
      }
      dfs(t + c, n)
    }
  }
}
