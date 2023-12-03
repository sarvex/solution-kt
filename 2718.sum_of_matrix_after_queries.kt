class Solution {
  fun matrixSumQueries(n: Int, queries: Array<IntArray>): Long {
    val row: Set<Int> = HashSet()
    val col: Set<Int> = HashSet()
    val m = queries.size
    var ans: Long = 0
    for (k in m - 1 downTo 0) {
      val q = queries[k]
      val t = q[0]
      val i = q[1]
      val v = q[2]
      if (t == 0) {
        if (row.add(i)) {
          ans += 1L * (n - col.size()) * v
        }
      } else {
        if (col.add(i)) {
          ans += 1L * (n - row.size()) * v
        }
      }
    }
    return ans
  }
}
