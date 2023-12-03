class Solution {
  private var k = 0
  fun buildMatrix(k: Int, rowConditions: Array<IntArray>, colConditions: Array<IntArray>): Array<IntArray> {
    this.k = k
    val row = f(rowConditions)
    val col = f(colConditions)
    if (row == null || col == null) {
      return Array(0) { IntArray(0) }
    }
    val ans = Array(k) { IntArray(k) }
    val m = IntArray(k + 1)
    for (i in 0 until k) {
      m[col[i]] = i
    }
    for (i in 0 until k) {
      ans[i][m[row[i]]] = row[i]
    }
    return ans
  }

  private fun f(cond: Array<IntArray>): List<Int>? {
    val g: Array<List<Int>?> = arrayOfNulls(k + 1)
    Arrays.setAll(g) { key -> ArrayList() }
    val indeg = IntArray(k + 1)
    for (e in cond) {
      val a = e[0]
      val b = e[1]
      g[a].add(b)
      ++indeg[b]
    }
    val q: Deque<Int> = ArrayDeque()
    for (i in 1 until indeg.size) {
      if (indeg[i] == 0) {
        q.offer(i)
      }
    }
    val res: List<Int> = ArrayList()
    while (!q.isEmpty()) {
      for (n in q.size() downTo 1) {
        val i: Int = q.pollFirst()
        res.add(i)
        for (j in g[i]!!) {
          if (--indeg[j] == 0) {
            q.offer(j)
          }
        }
      }
    }
    return if (res.size() === k) res else null
  }
}
