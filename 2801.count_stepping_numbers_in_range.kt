import java.math.BigInteger
import kotlin.math.abs

internal class Solution {
  private val mod = 1e9.toInt() + 7
  private var num: String? = null
  private var f: Array<Array<Int>>
  fun countSteppingNumbers(low: String?, high: String): Int {
    f = Array(high.length + 1) { arrayOfNulls(10) }
    num = high
    val a = dfs(0, -1, true, true)
    f = Array(high.length + 1) { arrayOfNulls(10) }
    num = BigInteger(low).subtract(BigInteger.ONE).toString()
    val b = dfs(0, -1, true, true)
    return (a - b + mod) % mod
  }

  private fun dfs(pos: Int, pre: Int, lead: Boolean, limit: Boolean): Int {
    if (pos >= num!!.length) {
      return if (lead) 0 else 1
    }
    if (!lead && !limit && f[pos][pre] != null) {
      return f[pos][pre]
    }
    var ans = 0
    val up = if (limit) num!![pos].code - '0'.code else 9
    for (i in 0..up) {
      if (i == 0 && lead) {
        ans += dfs(pos + 1, pre, true, limit && i == up)
      } else if (pre == -1 || abs((pre - i).toDouble()) == 1) {
        ans += dfs(pos + 1, i, false, limit && i == up)
      }
      ans %= mod
    }
    if (!lead && !limit) {
      f[pos][pre] = ans
    }
    return ans
  }
}
