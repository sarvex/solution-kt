class Solution {
  private val mod = 1e9.toInt() + 7
  fun countKSubsequencesWithMaxBeauty(s: String, k: Int): Int {
    var k = k
    val f = IntArray(26)
    val n = s.length
    var cnt = 0
    for (i in 0 until n) {
      if (++f[s[i].code - 'a'.code] == 1) {
        ++cnt
      }
    }
    if (cnt < k) {
      return 0
    }
    val vs: Array<Int> = arrayOfNulls(cnt)
    run {
      var i = 0
      var j = 0
      while (i < 26) {
        if (f[i] > 0) {
          vs[j++] = f[i]
        }
        ++i
      }
    }
    Arrays.sort(vs) { a, b -> b - a }
    var ans: Long = 1
    val `val` = vs[k - 1]
    var x = 0
    for (v in vs) {
      if (v == `val`) {
        ++x
      }
    }
    for (v in vs) {
      if (v == `val`) {
        break
      }
      --k
      ans = ans * v % mod
    }
    val c = Array(x + 1) { IntArray(x + 1) }
    for (i in 0..x) {
      c[i][0] = 1
      for (j in 1..i) {
        c[i][j] = (c[i - 1][j - 1] + c[i - 1][j]) % mod
      }
    }
    ans = ans * c[x][k] % mod * qpow(`val`.toLong(), k) % mod
    return ans.toInt()
  }

  private fun qpow(a: Long, n: Int): Long {
    var a = a
    var n = n
    var ans: Long = 1
    while (n > 0) {
      if (n and 1 == 1) {
        ans = ans * a % mod
      }
      a = a * a % mod
      n = n shr 1
    }
    return ans
  }
}
