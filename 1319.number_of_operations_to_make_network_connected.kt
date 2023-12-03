class Solution {
  private var p: IntArray
  fun makeConnected(n: Int, connections: Array<IntArray>): Int {
    var n = n
    p = IntArray(n)
    for (i in 0 until n) {
      p[i] = i
    }
    var cnt = 0
    for (e in connections) {
      val a = e[0]
      val b = e[1]
      if (find(a) == find(b)) {
        ++cnt
      } else {
        p[find(a)] = find(b)
        --n
      }
    }
    return if (n - 1 > cnt) -1 else n - 1
  }

  private fun find(x: Int): Int {
    if (p[x] != x) {
      p[x] = find(p[x])
    }
    return p[x]
  }
}
