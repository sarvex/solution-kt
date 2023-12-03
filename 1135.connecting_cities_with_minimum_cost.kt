internal class Solution {
  private var p: IntArray
  fun minimumCost(n: Int, connections: Array<IntArray>): Int {
    var n = n
    Arrays.sort(connections, Comparator.comparingInt { a -> a.get(2) })
    p = IntArray(n)
    for (i in 0 until n) {
      p[i] = i
    }
    var ans = 0
    for (e in connections) {
      val x = e[0] - 1
      val y = e[1] - 1
      val cost = e[2]
      if (find(x) == find(y)) {
        continue
      }
      p[find(x)] = find(y)
      ans += cost
      if (--n == 1) {
        return ans
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
