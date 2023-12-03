internal class Solution {
  private val ans: List<String> = ArrayList()
  private val cnt = IntArray(26)
  private var n = 0
  fun generatePalindromes(s: String): List<String> {
    n = s.length
    for (c in s.toCharArray()) {
      ++cnt[c.code - 'a'.code]
    }
    var mid = ""
    for (i in 0..25) {
      if (cnt[i] % 2 == 1) {
        if ("" != mid) {
          return ans
        }
        mid = (i + 'a'.code).toChar().toString()
      }
    }
    dfs(mid)
    return ans
  }

  private fun dfs(t: String) {
    if (t.length == n) {
      ans.add(t)
      return
    }
    for (i in 0..25) {
      if (cnt[i] > 1) {
        val c = (i + 'a'.code).toChar().toString()
        cnt[i] -= 2
        dfs(c + t + c)
        cnt[i] += 2
      }
    }
  }
}
