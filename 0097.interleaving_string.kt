internal class Solution {
  fun isInterleave(s1: String, s2: String, s3: String): Boolean {
    val m = s1.length
    val n = s2.length
    if (m + n != s3.length) {
      return false
    }
    val f = BooleanArray(n + 1)
    f[0] = true
    for (i in 0..m) {
      for (j in 0..n) {
        val k = i + j - 1
        if (i > 0) {
          f[j] = f[j] and (s1[i - 1] == s3[k])
        }
        if (j > 0) {
          f[j] = f[j] or (f[j - 1] and (s2[j - 1] == s3[k]))
        }
      }
    }
    return f[n]
  }
}
