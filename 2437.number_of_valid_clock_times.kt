class Solution {
  fun countTime(time: String): Int {
    return f(time.substring(0, 2), 24) * f(time.substring(3), 60)
  }

  private fun f(s: String, m: Int): Int {
    var cnt = 0
    for (i in 0 until m) {
      val a = s[0] == '?' || s[0].code - '0'.code == i / 10
      val b = s[1] == '?' || s[1].code - '0'.code == i % 10
      cnt += if (a && b) 1 else 0
    }
    return cnt
  }
}
