internal class Solution {
  private var g: Array<List<Int>?>
  private var n = 0
  private var quiet: IntArray
  private var ans: IntArray
  fun loudAndRich(richer: Array<IntArray>, quiet: IntArray): IntArray {
    n = quiet.size
    this.quiet = quiet
    g = arrayOfNulls(n)
    ans = IntArray(n)
    Arrays.fill(ans, -1)
    Arrays.setAll(g) { k -> ArrayList() }
    for (r in richer) {
      g[r[1]].add(r[0])
    }
    for (i in 0 until n) {
      dfs(i)
    }
    return ans
  }

  private fun dfs(i: Int) {
    if (ans[i] != -1) {
      return
    }
    ans[i] = i
    for (j in g[i]!!) {
      dfs(j)
      if (quiet[ans[j]] < quiet[ans[i]]) {
        ans[i] = ans[j]
      }
    }
  }
}
