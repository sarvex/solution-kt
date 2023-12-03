class Solution {
  fun knightDialer(n: Int): Int {
    var n = n
    if (n == 1) {
      return 10
    }
    val f = LongArray(10)
    Arrays.fill(f, 1)
    while (--n > 0) {
      val t = LongArray(10)
      t[0] = f[4] + f[6]
      t[1] = f[6] + f[8]
      t[2] = f[7] + f[9]
      t[3] = f[4] + f[8]
      t[4] = f[0] + f[3] + f[9]
      t[6] = f[0] + f[1] + f[7]
      t[7] = f[2] + f[6]
      t[8] = f[1] + f[3]
      t[9] = f[2] + f[4]
      for (i in 0..9) {
        f[i] = t[i] % Solution.Companion.MOD
      }
    }
    var ans: Long = 0
    for (v in f) {
      ans = (ans + v) % Solution.Companion.MOD
    }
    return ans.toInt()
  }

  companion object {
    private const val MOD = 1e9.toInt() + 7
  }
}
