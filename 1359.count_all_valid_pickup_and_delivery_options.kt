class Solution {
  fun countOrders(n: Int): Int {
    val mod = 1e9.toInt() + 7
    var f: Long = 1
    for (i in 2..n) {
      f = f * i * (2 * i - 1) % mod
    }
    return f.toInt()
  }
}
