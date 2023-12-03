class Solution {
  private var g: Array<List<IntArray>?>
  private val cnt: Map<Int, Int> = HashMap()
  private var ans: Long = 0
  fun countPalindromePaths(parent: List<Int>, s: String): Long {
    val n: Int = parent.size()
    g = arrayOfNulls(n)
    cnt.put(0, 1)
    Arrays.setAll(g) { k -> ArrayList() }
    for (i in 1 until n) {
      val p = parent[i]
      g[p].add(intArrayOf(i, 1 shl s[i].code - 'a'.code))
    }
    dfs(0, 0)
    return ans
  }

  private fun dfs(i: Int, xor: Int) {
    for (e in g[i]!!) {
      val j = e[0]
      val v = e[1]
      val x = xor xor v
      ans += cnt[x] ?: 0
      for (k in 0..25) {
        ans += cnt[x xor (1 shl k)] ?: 0
      }
      cnt.merge(x, 1) { a: Int, b: Int -> Integer.sum(a, b) }
      dfs(j, x)
    }
  }
}
