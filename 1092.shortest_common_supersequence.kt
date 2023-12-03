import kotlin.math.max

internal class Solution {
  fun shortestCommonSupersequence(str1: String, str2: String): String {
    val m = str1.length
    val n = str2.length
    val f = Array(m + 1) { IntArray(n + 1) }
    for (i in 1..m) {
      for (j in 1..n) {
        if (str1[i - 1] == str2[j - 1]) {
          f[i][j] = f[i - 1][j - 1] + 1
        } else {
          f[i][j] = max(f[i - 1][j].toDouble(), f[i][j - 1].toDouble()).toInt()
        }
      }
    }
    var i = m
    var j = n
    val ans = StringBuilder()
    while (i > 0 || j > 0) {
      if (i == 0) {
        ans.append(str2[--j])
      } else if (j == 0) {
        ans.append(str1[--i])
      } else {
        if (f[i][j] == f[i - 1][j]) {
          ans.append(str1[--i])
        } else if (f[i][j] == f[i][j - 1]) {
          ans.append(str2[--j])
        } else {
          ans.append(str1[--i])
          --j
        }
      }
    }
    return ans.reverse().toString()
  }
}
