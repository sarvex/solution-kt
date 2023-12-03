internal class Solution {
  fun uniquePaths(m: Int, n: Int): Int {
    val f = IntArray(n)
    Arrays.fill(f, 1)
    for (i in 1 until m) {
      for (j in 1 until n) {
        f[j] += f[j - 1]
      }
    }
    return f[n - 1]
  }
}
