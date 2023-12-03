class Solution {
  fun canMakeSubsequence(str1: String, str2: String): Boolean {
    var i = 0
    val n = str2.length
    for (c in str1.toCharArray()) {
      val d = if (c == 'z') 'a' else (c.code + 1).toChar()
      if (i < n && (str2[i] == c || str2[i] == d)) {
        ++i
      }
    }
    return i == n
  }
}
