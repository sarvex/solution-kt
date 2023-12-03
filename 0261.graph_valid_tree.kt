internal class Solution {
  private var p: IntArray
  fun validTree(n: Int, edges: Array<IntArray>): Boolean {
    var n = n
    p = IntArray(n)
    for (i in 0 until n) {
      p[i] = i
    }
    for (e in edges) {
      val a = e[0]
      val b = e[1]
      if (find(a) == find(b)) {
        return false
      }
      p[find(a)] = find(b)
      --n
    }
    return n == 1
  }

  private fun find(x: Int): Int {
    if (p[x] != x) {
      p[x] = find(p[x])
    }
    return p[x]
  }
}
