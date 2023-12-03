internal class Solution {
  private var p: IntArray
  fun countComponents(n: Int, edges: Array<IntArray>): Int {
    p = IntArray(n)
    for (i in 0 until n) {
      p[i] = i
    }
    for (e in edges) {
      val a = e[0]
      val b = e[1]
      p[find(a)] = find(b)
    }
    var ans = 0
    for (i in 0 until n) {
      if (i == find(i)) {
        ++ans
      }
    }
    return ans
  }

  private fun find(x: Int): Int {
    if (p[x] != x) {
      p[x] = find(p[x])
    }
    return p[x]
  }
}
