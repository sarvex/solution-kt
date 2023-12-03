internal class Solution {
  private val ans: List<List<Int>> = ArrayList()
  private val t: List<Int> = ArrayList()
  private var n = 0
  private var k = 0
  fun combine(n: Int, k: Int): List<List<Int>> {
    this.n = n
    this.k = k
    dfs(1)
    return ans
  }

  private fun dfs(i: Int) {
    if (t.size() === k) {
      ans.add(ArrayList(t))
      return
    }
    if (i > n) {
      return
    }
    t.add(i)
    dfs(i + 1)
    t.remove(t.size() - 1)
    dfs(i + 1)
  }
}
