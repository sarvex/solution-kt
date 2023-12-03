class Solution {
  fun monkeyMove(n: Int): Int {
    val mod = 1e9.toInt() + 7
    return (qpow(2, n, mod) - 2 + mod) % mod
  }

  private fun qpow(a: Long, n: Int, mod: Int): Int {
    var a = a
    var n = n
    var ans: Long = 1
    while (n > 0) {
      if (n and 1 == 1) {
        ans = ans * a % mod
      }
      a = a * a % mod
      n = n shr 1
    }
    return ans.toInt()
  }
}
