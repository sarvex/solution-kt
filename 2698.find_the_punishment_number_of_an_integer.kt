class Solution {
  fun punishmentNumber(n: Int): Int {
    var ans = 0
    for (i in 1..n) {
      val x = i * i
      if (check(x.toString() + "", 0, i)) {
        ans += x
      }
    }
    return ans
  }

  private fun check(s: String, i: Int, x: Int): Boolean {
    val m = s.length
    if (i >= m) {
      return x == 0
    }
    var y = 0
    for (j in i until m) {
      y = y * 10 + (s[j].code - '0'.code)
      if (y > x) {
        break
      }
      if (check(s, j + 1, x - y)) {
        return true
      }
    }
    return false
  }
}
