class Solution {
  private val mod = 1000000007
  fun countGoodNumbers(n: Long): Int {
    return (myPow(5, n + 1 shr 1) * myPow(4, n shr 1) % mod).toInt()
  }

  private fun myPow(x: Long, n: Long): Long {
    var x = x
    var n = n
    var res: Long = 1
    while (n != 0L) {
      if (n and 1L == 1L) {
        res = res * x % mod
      }
      x = x * x % mod
      n = n shr 1
    }
    return res
  }
}
