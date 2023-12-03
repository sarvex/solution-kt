import java.math.BigInteger

internal class Solution {
  private val mod = 1e9.toInt() + 7
  private var f: Array<Array<Int>>
  private var num: String? = null
  private var min = 0
  private var max = 0
  fun count(num1: String?, num2: String?, min_sum: Int, max_sum: Int): Int {
    min = min_sum
    max = max_sum
    num = num2
    f = Array(23) { arrayOfNulls(220) }
    var ans = dfs(0, 0, true)
    num = BigInteger(num1).subtract(BigInteger.ONE).toString()
    f = Array(23) { arrayOfNulls(220) }
    ans = (ans - dfs(0, 0, true) + mod) % mod
    return ans
  }

  private fun dfs(pos: Int, s: Int, limit: Boolean): Int {
    if (pos >= num!!.length) {
      return if (s >= min && s <= max) 1 else 0
    }
    if (!limit && f[pos][s] != null) {
      return f[pos][s]
    }
    var ans = 0
    val up = if (limit) num!![pos].code - '0'.code else 9
    for (i in 0..up) {
      ans = (ans + dfs(pos + 1, s + i, limit && i == up)) % mod
    }
    if (!limit) {
      f[pos][s] = ans
    }
    return ans
  }
}
