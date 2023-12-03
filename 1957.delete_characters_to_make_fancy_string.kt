class Solution {
  fun makeFancyString(s: String): String {
    val ans = StringBuilder()
    for (c in s.toCharArray()) {
      val n = ans.length
      if (n > 1 && ans[n - 1] == c && ans[n - 2] == c) {
        continue
      }
      ans.append(c)
    }
    return ans.toString()
  }
}
