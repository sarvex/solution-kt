internal class Solution {
  fun countArrangement(N: Int): Int {
    val maxn = 1 shl N
    val f = IntArray(maxn)
    f[0] = 1
    for (i in 0 until maxn) {
      var s = 1
      for (j in 0 until N) {
        s += i shr j and 1
      }
      for (j in 1..N) {
        if (i shr j - 1 and 1 == 0 && (s % j == 0 || j % s == 0)) {
          f[i or (1 shl j - 1)] += f[i]
        }
      }
    }
    return f[maxn - 1]
  }
}
