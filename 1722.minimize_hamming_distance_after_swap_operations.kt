class Solution {
  private var p: IntArray
  fun minimumHammingDistance(source: IntArray, target: IntArray, allowedSwaps: Array<IntArray>): Int {
    val n = source.size
    p = IntArray(n)
    for (i in 0 until n) {
      p[i] = i
    }
    for (e in allowedSwaps) {
      p[find(e[0])] = find(e[1])
    }
    val mp: Map<Int, Map<Int, Int>> = HashMap()
    for (i in 0 until n) {
      val root = find(i)
      mp.computeIfAbsent(root) { k -> HashMap() }
        .put(source[i], (mp[root]!![source[i]] ?: 0) + 1)
    }
    var res = 0
    for (i in 0 until n) {
      val root = find(i)
      if (mp[root]!![target[i]] ?: 0 > 0) {
        mp[root].put(target[i], mp[root]!![target[i]]!! - 1)
      } else {
        ++res
      }
    }
    return res
  }

  private fun find(x: Int): Int {
    if (p[x] != x) {
      p[x] = find(p[x])
    }
    return p[x]
  }
}
