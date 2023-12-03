class Solution {
  fun countSymmetricIntegers(low: Int, high: Int): Int {
    var ans = 0
    for (x in low..high) {
      ans += f(x)
    }
    return ans
  }

  private fun f(x: Int): Int {
    val s = "" + x
    val n = s.length
    if (n % 2 == 1) {
      return 0
    }
    var a = 0
    var b = 0
    for (i in 0 until n / 2) {
      a += s[i].code - '0'.code
    }
    for (i in n / 2 until n) {
      b += s[i].code - '0'.code
    }
    return if (a == b) 1 else 0
  }
}
