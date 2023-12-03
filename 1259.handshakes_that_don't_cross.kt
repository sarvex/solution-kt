internal class Solution {
  private var f: IntArray
  private val mod = 1e9.toInt() + 7
  fun numberOfWays(numPeople: Int): Int {
    f = IntArray(numPeople + 1)
    return dfs(numPeople)
  }

  private fun dfs(i: Int): Int {
    if (i < 2) {
      return 1
    }
    if (f[i] != 0) {
      return f[i]
    }
    var l = 0
    while (l < i) {
      val r = i - l - 2
      f[i] = ((f[i] + 1L * dfs(l) * dfs(r) % mod) % mod).toInt()
      l += 2
    }
    return f[i]
  }
}
