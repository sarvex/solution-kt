internal class Solution {
  fun findDerangement(n: Int): Int {
    val mod = 1e9.toInt() + 7
    var a: Long = 1
    var b: Long = 0
    for (i in 2..n) {
      val c = (i - 1) * (a + b) % mod
      a = b
      b = c
    }
    return b.toInt()
  }
}
