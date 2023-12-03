class Solution {
  private var p: IntArray
  fun validPath(n: Int, edges: Array<IntArray>, source: Int, destination: Int): Boolean {
    p = IntArray(n)
    for (i in 0 until n) {
      p[i] = i
    }
    for (e in edges) {
      p[find(e[0])] = find(e[1])
    }
    return find(source) == find(destination)
  }

  private fun find(x: Int): Int {
    if (p[x] != x) {
      p[x] = find(p[x])
    }
    return p[x]
  }
}
