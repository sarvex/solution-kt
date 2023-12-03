internal class Solution {
  private var p: IntArray
  fun earliestAcq(logs: Array<IntArray>, n: Int): Int {
    var n = n
    Arrays.sort(logs) { a, b -> a.get(0) - b.get(0) }
    p = IntArray(n)
    for (i in 0 until n) {
      p[i] = i
    }
    for (log in logs) {
      val t = log[0]
      val x = log[1]
      val y = log[2]
      if (find(x) == find(y)) {
        continue
      }
      p[find(x)] = find(y)
      if (--n == 1) {
        return t
      }
    }
    return -1
  }

  private fun find(x: Int): Int {
    if (p[x] != x) {
      p[x] = find(p[x])
    }
    return p[x]
  }
}
