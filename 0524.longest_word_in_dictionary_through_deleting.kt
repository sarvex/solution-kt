internal class Solution {
  fun findLongestWord(s: String, dictionary: List<String>): String {
    var ans = ""
    for (a in dictionary) {
      if (check(s, a)
        && (ans.length < a.length || ans.length == a.length && a.compareTo(ans) < 0)
      ) {
        ans = a
      }
    }
    return ans
  }

  private fun check(a: String, b: String): Boolean {
    val m = a.length
    val n = b.length
    var i = 0
    var j = 0
    while (i < m && j < n) {
      if (a[i] == b[j]) {
        ++j
      }
      ++i
    }
    return j == n
  }
}
