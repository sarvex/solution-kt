class Solution {
  fun restoreString(s: String, indices: IntArray): String {
    val n = s.length
    val ans = CharArray(n)
    for (i in 0 until n) {
      ans[indices[i]] = s[i]
    }
    return String(ans)
  }
}
