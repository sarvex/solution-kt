class Solution {
  fun countPalindromes(s: String): Int {
    val n = s.length
    val pre = Array(n + 2) { Array(10) { IntArray(10) } }
    val suf = Array(n + 2) { Array(10) { IntArray(10) } }
    val t = IntArray(n)
    for (i in 0 until n) {
      t[i] = s[i].code - '0'.code
    }
    var c = IntArray(10)
    for (i in 1..n) {
      val v = t[i - 1]
      for (j in 0..9) {
        for (k in 0..9) {
          pre[i][j][k] = pre[i - 1][j][k]
        }
      }
      for (j in 0..9) {
        pre[i][j][v] += c[j]
      }
      c[v]++
    }
    c = IntArray(10)
    for (i in n downTo 1) {
      val v = t[i - 1]
      for (j in 0..9) {
        for (k in 0..9) {
          suf[i][j][k] = suf[i + 1][j][k]
        }
      }
      for (j in 0..9) {
        suf[i][j][v] += c[j]
      }
      c[v]++
    }
    var ans: Long = 0
    for (i in 1..n) {
      for (j in 0..9) {
        for (k in 0..9) {
          ans += pre[i - 1][j][k].toLong() * suf[i + 1][j][k]
          ans %= Solution.Companion.MOD.toLong()
        }
      }
    }
    return ans.toInt()
  }

  companion object {
    private const val MOD = 1e9.toInt() + 7
  }
}
