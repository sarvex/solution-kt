internal class Solution {
  fun primePalindrome(n: Int): Int {
    var n = n
    while (true) {
      if (reverse(n) == n && isPrime(n)) {
        return n
      }
      if (n > 10000000 && n < 100000000) {
        n = 100000000
      }
      ++n
    }
  }

  private fun isPrime(x: Int): Boolean {
    if (x < 2) {
      return false
    }
    var v = 2
    while (v * v <= x) {
      if (x % v == 0) {
        return false
      }
      ++v
    }
    return true
  }

  private fun reverse(x: Int): Int {
    var x = x
    var res = 0
    while (x != 0) {
      res = res * 10 + x % 10
      x /= 10
    }
    return res
  }
}
