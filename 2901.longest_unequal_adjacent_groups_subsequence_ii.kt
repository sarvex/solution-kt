import kotlin.math.max

class Solution {
  fun getWordsInLongestSubsequence(n: Int, words: Array<String>, groups: IntArray): List<String> {
    val f = IntArray(n)
    val g = IntArray(n)
    Arrays.fill(f, 1)
    Arrays.fill(g, -1)
    var mx = 1
    for (i in 0 until n) {
      for (j in 0 until i) {
        if (groups[i] != groups[j] && f[i] < f[j] + 1 && check(words[i], words[j])) {
          f[i] = f[j] + 1
          g[i] = j
          mx = max(mx.toDouble(), f[i].toDouble()).toInt()
        }
      }
    }
    val ans: List<String> = ArrayList()
    for (i in 0 until n) {
      if (f[i] == mx) {
        var j = i
        while (j >= 0) {
          ans.add(words[j])
          j = g[j]
        }
        break
      }
    }
    Collections.reverse(ans)
    return ans
  }

  private fun check(s: String, t: String): Boolean {
    if (s.length != t.length) {
      return false
    }
    var cnt = 0
    for (i in 0 until s.length) {
      if (s[i] != t[i]) {
        ++cnt
      }
    }
    return cnt == 1
  }
}
