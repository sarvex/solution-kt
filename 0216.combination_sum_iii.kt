internal class Solution {
  private val ans: List<List<Int>> = ArrayList()
  private val t: List<Int> = ArrayList()
  private var k = 0
  fun combinationSum3(k: Int, n: Int): List<List<Int>> {
    this.k = k
    dfs(1, n)
    return ans
  }

  private fun dfs(i: Int, s: Int) {
    if (s == 0) {
      if (t.size() === k) {
        ans.add(ArrayList(t))
      }
      return
    }
    if (i > 9 || i > s || t.size() >= k) {
      return
    }
    t.add(i)
    dfs(i + 1, s - i)
    t.remove(t.size() - 1)
    dfs(i + 1, s)
  }
}
