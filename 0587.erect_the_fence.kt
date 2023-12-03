internal class Solution {
  fun outerTrees(trees: Array<IntArray>): Array<IntArray> {
    val n = trees.size
    if (n < 4) {
      return trees
    }
    Arrays.sort(trees) { a, b -> if (a.get(0) === b.get(0)) a.get(1) - b.get(1) else a.get(0) - b.get(0) }
    val vis = BooleanArray(n)
    val stk = IntArray(n + 10)
    var cnt = 1
    for (i in 1 until n) {
      while (cnt > 1 && cross(trees[stk[cnt - 1]], trees[stk[cnt - 2]], trees[i]) < 0) {
        vis[stk[--cnt]] = false
      }
      vis[i] = true
      stk[cnt++] = i
    }
    val m = cnt
    for (i in n - 1 downTo 0) {
      if (vis[i]) {
        continue
      }
      while (cnt > m && cross(trees[stk[cnt - 1]], trees[stk[cnt - 2]], trees[i]) < 0) {
        --cnt
      }
      stk[cnt++] = i
    }
    val ans = Array(cnt - 1) { IntArray(2) }
    for (i in ans.indices) {
      ans[i] = trees[stk[i]]
    }
    return ans
  }

  private fun cross(a: IntArray, b: IntArray, c: IntArray): Int {
    return (b[0] - a[0]) * (c[1] - b[1]) - (b[1] - a[1]) * (c[0] - b[0])
  }
}
