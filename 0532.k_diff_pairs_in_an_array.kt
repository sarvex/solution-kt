internal class Solution {
  fun findPairs(nums: IntArray, k: Int): Int {
    val vis: Set<Int> = HashSet()
    val ans: Set<Int> = HashSet()
    for (v in nums) {
      if (vis.contains(v - k)) {
        ans.add(v - k)
      }
      if (vis.contains(v + k)) {
        ans.add(v)
      }
      vis.add(v)
    }
    return ans.size()
  }
}
