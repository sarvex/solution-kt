class Solution {
  private var tree: IntArray
  fun numberOfNodes(n: Int, queries: IntArray): Int {
    tree = IntArray(n + 1)
    val cnt = IntArray(n + 1)
    for (v in queries) {
      ++cnt[v]
    }
    for (i in 0 until n + 1) {
      if (cnt[i] % 2 == 1) {
        dfs(i)
      }
    }
    var ans = 0
    for (i in 0 until n + 1) {
      ans += tree[i]
    }
    return ans
  }

  private fun dfs(i: Int) {
    if (i >= tree.size) {
      return
    }
    tree[i] = tree[i] xor 1
    dfs(i shl 1)
    dfs(i shl 1 or 1)
  }
}
