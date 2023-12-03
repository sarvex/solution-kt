class Solution {
  fun findSmallestSetOfVertices(n: Int, edges: List<List<Int?>>): List<Int> {
    val cnt = IntArray(n)
    for (e in edges) {
      ++cnt[e[1]]
    }
    val ans: List<Int> = ArrayList()
    for (i in 0 until n) {
      if (cnt[i] == 0) {
        ans.add(i)
      }
    }
    return ans
  }
}
