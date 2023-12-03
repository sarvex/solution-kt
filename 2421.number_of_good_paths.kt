class Solution {
  private var p: IntArray
  fun numberOfGoodPaths(vals: IntArray, edges: Array<IntArray>): Int {
    val n = vals.size
    p = IntArray(n)
    val arr = Array(n) { IntArray(2) }
    val g: Array<List<Int>?> = arrayOfNulls(n)
    Arrays.setAll(g) { k -> ArrayList() }
    for (e in edges) {
      val a = e[0]
      val b = e[1]
      g[a].add(b)
      g[b].add(a)
    }
    val size: Map<Int, Map<Int, Int>> = HashMap()
    for (i in 0 until n) {
      p[i] = i
      arr[i] = intArrayOf(vals[i], i)
      size.computeIfAbsent(i) { k -> HashMap() }.put(vals[i], 1)
    }
    Arrays.sort(arr) { a, b -> a.get(0) - b.get(0) }
    var ans = n
    for (e in arr) {
      val v = e[0]
      val a = e[1]
      for (b in g[a]!!) {
        if (vals[b] > v) {
          continue
        }
        val pa = find(a)
        val pb = find(b)
        if (pa != pb) {
          ans += (size[pa]!![v] ?: 0) * (size[pb]!![v] ?: 0)
          p[pa] = pb
          size[pb].put(
            v, (size[pb]!![v] ?: 0) + (size[pa]!![v] ?: 0)
          )
        }
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
