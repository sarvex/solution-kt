import kotlin.math.min

class Solution {
  private var f: Array<Array<Array<Int>>>
  private var words: Array<String>
  private var n = 0
  fun minimizeConcatenatedLength(words: Array<String>): Int {
    n = words.size
    this.words = words
    f = Array(n) { Array<Array<Int?>>(26) { arrayOfNulls(26) } }
    return (words[0].length
        + dfs(1, words[0][0].code - 'a'.code, words[0][words[0].length - 1].code - 'a'.code))
  }

  private fun dfs(i: Int, a: Int, b: Int): Int {
    if (i >= n) {
      return 0
    }
    if (f[i][a][b] != null) {
      return f[i][a][b]
    }
    val s = words[i]
    val m = s.length
    val x = dfs(i + 1, a, s[m - 1].code - 'a'.code) - if (s[0].code - 'a'.code == b) 1 else 0
    val y = dfs(i + 1, s[0].code - 'a'.code, b) - if (s[m - 1].code - 'a'.code == a) 1 else 0
    return (m + min(x.toDouble(), y.toDouble())).also { f[i][a][b] = it.toInt() }.toInt().toInt()
  }
}
