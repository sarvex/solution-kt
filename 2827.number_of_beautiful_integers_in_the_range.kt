class Solution {
  private var s: String? = null
  private var k = 0
  private var f = Array<Array<Array<Int>>>(11) { Array<Array<Int?>>(21) { arrayOfNulls(21) } }
  fun numberOfBeautifulIntegers(low: Int, high: Int, k: Int): Int {
    this.k = k
    s = high.toString()
    val a = dfs(0, 0, 10, true, true)
    s = (low - 1).toString()
    f = Array(11) { Array<Array<Int?>>(21) { arrayOfNulls(21) } }
    val b = dfs(0, 0, 10, true, true)
    return a - b
  }

  private fun dfs(pos: Int, mod: Int, diff: Int, lead: Boolean, limit: Boolean): Int {
    if (pos >= s!!.length) {
      return if (mod == 0 && diff == 10) 1 else 0
    }
    if (!lead && !limit && f[pos][mod][diff] != null) {
      return f[pos][mod][diff]
    }
    var ans = 0
    val up = if (limit) s!![pos].code - '0'.code else 9
    for (i in 0..up) {
      ans += if (i == 0 && lead) {
        dfs(pos + 1, mod, diff, true, limit && i == up)
      } else {
        val nxt = diff + if (i % 2 == 1) 1 else -1
        dfs(pos + 1, (mod * 10 + i) % k, nxt, false, limit && i == up)
      }
    }
    if (!lead && !limit) {
      f[pos][mod][diff] = ans
    }
    return ans
  }
}
