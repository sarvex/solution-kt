internal class Solution {
  private val ans: List<List<Int>> = ArrayList()
  private val t: List<Int> = ArrayList()
  private var candidates: IntArray
  fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
    Arrays.sort(candidates)
    this.candidates = candidates
    dfs(0, target)
    return ans
  }

  private fun dfs(i: Int, s: Int) {
    if (s == 0) {
      ans.add(ArrayList(t))
      return
    }
    if (i >= candidates.size || s < candidates[i]) {
      return
    }
    dfs(i + 1, s)
    t.add(candidates[i])
    dfs(i, s - candidates[i])
    t.remove(t.size() - 1)
  }
}
