class Solution {
  fun mergeAlternately(word1: String, word2: String): String {
    val m = word1.length
    val n = word2.length
    val ans = StringBuilder()
    var i = 0
    while (i < m || i < n) {
      if (i < m) {
        ans.append(word1[i])
      }
      if (i < n) {
        ans.append(word2[i])
      }
      ++i
    }
    return ans.toString()
  }
}
