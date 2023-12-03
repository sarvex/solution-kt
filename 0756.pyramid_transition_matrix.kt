internal class Solution {
  private val f = Array(7) { IntArray(7) }
  private val dp: Map<String, Boolean> = HashMap()
  fun pyramidTransition(bottom: String, allowed: List<String>): Boolean {
    for (s in allowed) {
      val a = s[0].code - 'A'.code
      val b = s[1].code - 'A'.code
      f[a][b] = f[a][b] or (1 shl s[2].code - 'A'.code)
    }
    return dfs(bottom, StringBuilder())
  }

  fun dfs(s: String, t: StringBuilder): Boolean {
    if (s.length == 1) {
      return true
    }
    if (t.length + 1 == s.length) {
      return dfs(t.toString(), StringBuilder())
    }
    val k = "$s.$t"
    if (dp.containsKey(k)) {
      return dp[k]!!
    }
    val a = s[t.length].code - 'A'.code
    val b = s[t.length + 1].code - 'A'.code
    val cs = f[a][b]
    for (i in 0..6) {
      if (cs shr i and 1 == 1) {
        t.append(('A'.code + i).toChar())
        if (dfs(s, t)) {
          dp.put(k, true)
          return true
        }
        t.deleteCharAt(t.length - 1)
      }
    }
    dp.put(k, false)
    return false
  }
}
