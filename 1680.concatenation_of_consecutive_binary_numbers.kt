class Solution {
  fun concatenatedBinary(n: Int): Int {
    val mod = 1e9.toInt() + 7
    var ans: Long = 0
    var shift = 0
    for (i in 1..n) {
      if (i and i - 1 == 0) {
        ++shift
      }
      ans = (ans shl shift or i.toLong()) % mod
    }
    return ans.toInt()
  }
}
