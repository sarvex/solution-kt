class Solution {
  fun numberOfUniqueGoodSubsequences(binary: String): Int {
    val mod = 1e9.toInt() + 7
    var f = 0
    var g = 0
    var ans = 0
    for (i in 0 until binary.length) {
      if (binary[i] == '0') {
        g = (g + f) % mod
        ans = 1
      } else {
        f = (f + g + 1) % mod
      }
    }
    ans = (ans + f + g) % mod
    return ans
  }
}
