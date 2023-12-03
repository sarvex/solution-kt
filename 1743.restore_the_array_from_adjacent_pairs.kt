class Solution {
  fun restoreArray(adjacentPairs: Array<IntArray>): IntArray {
    val n = adjacentPairs.size + 1
    val g: Map<Int, List<Int>> = HashMap()
    for (e in adjacentPairs) {
      val a = e[0]
      val b = e[1]
      g.computeIfAbsent(a) { k -> ArrayList() }.add(b)
      g.computeIfAbsent(b) { k -> ArrayList() }.add(a)
    }
    val ans = IntArray(n)
    for (entry in g.entrySet()) {
      if (entry.getValue().size() === 1) {
        ans[0] = entry.getKey()
        ans[1] = entry.getValue().get(0)
        break
      }
    }
    for (i in 2 until n) {
      val v = g[ans[i - 1]]!!
      ans[i] = if (v[1] === ans[i - 2]) v[0] else v[1]
    }
    return ans
  }
}
