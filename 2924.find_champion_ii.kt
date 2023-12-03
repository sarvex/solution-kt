class Solution {
  fun findChampion(n: Int, edges: Array<IntArray>): Int {
    val indeg = IntArray(n)
    for (e in edges) {
      ++indeg[e[1]]
    }
    var ans = -1
    var cnt = 0
    for (i in 0 until n) {
      if (indeg[i] == 0) {
        ++cnt
        ans = i
      }
    }
    return if (cnt == 1) ans else -1
  }
}
