class Solution {
  fun goodBinaryStrings(minLength: Int, maxLength: Int, oneGroup: Int, zeroGroup: Int): Int {
    val mod = 1e9.toInt() + 7
    val f = IntArray(maxLength + 1)
    f[0] = 1
    for (i in 1..maxLength) {
      if (i - oneGroup >= 0) {
        f[i] = (f[i] + f[i - oneGroup]) % mod
      }
      if (i - zeroGroup >= 0) {
        f[i] = (f[i] + f[i - zeroGroup]) % mod
      }
    }
    var ans = 0
    for (i in minLength..maxLength) {
      ans = (ans + f[i]) % mod
    }
    return ans
  }
}
