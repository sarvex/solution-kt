internal class Solution {
  private val ans: List<List<Int>> = ArrayList()
  private val t: List<Int> = ArrayList()
  private var candidates: IntArray
  fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
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
    for (j in i until candidates.size) {
      if (j > i && candidates[j] == candidates[j - 1]) {
        continue
      }
      t.add(candidates[j])
      dfs(j + 1, s - candidates[j])
      t.remove(t.size() - 1)
    }
  }
}
