class Solution {
  fun countVowelStrings(n: Int): Int {
    val f = intArrayOf(1, 1, 1, 1, 1)
    for (i in 0 until n - 1) {
      var s = 0
      for (j in 0..4) {
        s += f[j]
        f[j] = s
      }
    }
    return Arrays.stream(f).sum()
  }
}
