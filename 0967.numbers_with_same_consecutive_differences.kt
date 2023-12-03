class Solution {
  fun numsSameConsecDiff(n: Int, k: Int): IntArray {
    val res: List<Int> = ArrayList()
    for (i in 1..9) {
      dfs(n - 1, k, i, res)
    }
    val ans = IntArray(res.size())
    for (i in 0 until res.size()) {
      ans[i] = res[i]
    }
    return ans
  }

  private fun dfs(n: Int, k: Int, t: Int, res: List<Int>) {
    if (n == 0) {
      res.add(t)
      return
    }
    val last = t % 10
    if (last + k <= 9) {
      dfs(n - 1, k, t * 10 + last + k, res)
    }
    if (last - k >= 0 && k != 0) {
      dfs(n - 1, k, t * 10 + last - k, res)
    }
  }
}
