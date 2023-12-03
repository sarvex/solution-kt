internal class Solution {
  fun wordBreak(s: String, wordDict: List<String?>?): Boolean {
    val words: Set<String> = HashSet(wordDict)
    val n = s.length
    val f = BooleanArray(n + 1)
    f[0] = true
    for (i in 1..n) {
      for (j in 0 until i) {
        if (f[j] && words.contains(s.substring(j, i))) {
          f[i] = true
          break
        }
      }
    }
    return f[n]
  }
}
