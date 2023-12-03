internal class Solution {
  private val ans: List<String> = ArrayList()
  private var t: CharArray
  fun letterCasePermutation(s: String): List<String> {
    t = s.toCharArray()
    dfs(0)
    return ans
  }

  private fun dfs(i: Int) {
    if (i >= t.size) {
      ans.add(String(t))
      return
    }
    dfs(i + 1)
    if (t[i] >= 'A') {
      t[i] = (t[i].code xor 32).toChar()
      dfs(i + 1)
    }
  }
}
