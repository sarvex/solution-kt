class Solution {
  fun rearrangeSticks(n: Int, k: Int): Int {
    val mod = 1e9.toInt() + 7
    val f = IntArray(k + 1)
    f[0] = 1
    for (i in 1..n) {
      for (j in k downTo 1) {
        f[j] = ((f[j] * (i - 1L) + f[j - 1]) % mod).toInt()
      }
      f[0] = 0
    }
    return f[k]
  }
}
