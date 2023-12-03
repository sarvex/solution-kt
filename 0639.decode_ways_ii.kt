internal class Solution {
  fun numDecodings(s: String): Int {
    val n = s.length
    val cs = s.toCharArray()

    // dp[i - 2], dp[i - 1], dp[i]
    var a: Long = 0
    var b: Long = 1
    var c: Long = 0
    for (i in 1..n) {
      // 1 digit
      if (cs[i - 1] == '*') {
        c = 9 * b % Solution.Companion.MOD
      } else if (cs[i - 1] != '0') {
        c = b
      } else {
        c = 0
      }

      // 2 digits
      if (i > 1) {
        if (cs[i - 2] == '*' && cs[i - 1] == '*') {
          c = (c + 15 * a) % Solution.Companion.MOD
        } else if (cs[i - 2] == '*') {
          if (cs[i - 1] > '6') {
            c = (c + a) % Solution.Companion.MOD
          } else {
            c = (c + 2 * a) % Solution.Companion.MOD
          }
        } else if (cs[i - 1] == '*') {
          if (cs[i - 2] == '1') {
            c = (c + 9 * a) % Solution.Companion.MOD
          } else if (cs[i - 2] == '2') {
            c = (c + 6 * a) % Solution.Companion.MOD
          }
        } else if (cs[i - 2] != '0' && (cs[i - 2].code - '0'.code) * 10 + cs[i - 1].code - '0'.code <= 26) {
          c = (c + a) % Solution.Companion.MOD
        }
      }
      a = b
      b = c
    }
    return c.toInt()
  }

  companion object {
    private const val MOD = 1000000007
  }
}
