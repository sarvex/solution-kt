internal class Solution {
  private var n = 0
  fun gridIllumination(n: Int, lamps: Array<IntArray>, queries: Array<IntArray>): IntArray {
    this.n = n
    val s: Set<Long> = HashSet()
    val row: Map<Int, Int> = HashMap()
    val col: Map<Int, Int> = HashMap()
    val diag1: Map<Int, Int> = HashMap()
    val diag2: Map<Int, Int> = HashMap()
    for (lamp in lamps) {
      val i = lamp[0]
      val j = lamp[1]
      if (s.add(f(i.toLong(), j.toLong()))) {
        merge(row, i, 1)
        merge(col, j, 1)
        merge(diag1, i - j, 1)
        merge(diag2, i + j, 1)
      }
    }
    val m = queries.size
    val ans = IntArray(m)
    for (k in 0 until m) {
      val i = queries[k][0]
      val j = queries[k][1]
      if (exist(row, i) || exist(col, j) || exist(diag1, i - j) || exist(diag2, i + j)) {
        ans[k] = 1
      }
      for (x in i - 1..i + 1) {
        for (y in j - 1..j + 1) {
          if (x < 0 || x >= n || y < 0 || y >= n || !s.contains(f(x.toLong(), y.toLong()))) {
            continue
          }
          s.remove(f(x.toLong(), y.toLong()))
          merge(row, x, -1)
          merge(col, y, -1)
          merge(diag1, x - y, -1)
          merge(diag2, x + y, -1)
        }
      }
    }
    return ans
  }

  private fun merge(cnt: Map<Int, Int>, x: Int, d: Int) {
    if (cnt.merge(x, d) { a: Int, b: Int -> Integer.sum(a, b) } === 0) {
      cnt.remove(x)
    }
  }

  private fun exist(cnt: Map<Int, Int>, x: Int): Boolean {
    return cnt[x] ?: 0 > 0
  }

  private fun f(i: Long, j: Long): Long {
    return i * n + j
  }
}
