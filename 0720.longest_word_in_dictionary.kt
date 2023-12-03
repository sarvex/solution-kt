internal class Solution {
  private var s: Set<String>? = null
  fun longestWord(words: Array<String?>?): String {
    s = HashSet(Arrays.asList(words))
    var cnt = 0
    var ans = ""
    for (w in s!!) {
      val n = w.length
      if (check(w)) {
        if (cnt < n) {
          cnt = n
          ans = w
        } else if (cnt == n && w.compareTo(ans) < 0) {
          ans = w
        }
      }
    }
    return ans
  }

  private fun check(word: String): Boolean {
    var i = 1
    val n = word.length
    while (i < n) {
      if (!s!!.contains(word.substring(0, i))) {
        return false
      }
      ++i
    }
    return true
  }
}
