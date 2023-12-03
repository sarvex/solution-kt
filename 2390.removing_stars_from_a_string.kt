class Solution {
  fun removeStars(s: String): String {
    val ans = StringBuilder()
    for (i in 0 until s.length) {
      if (s[i] == '*') {
        ans.deleteCharAt(ans.length - 1)
      } else {
        ans.append(s[i])
      }
    }
    return ans.toString()
  }
}
