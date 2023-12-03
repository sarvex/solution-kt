class Solution {
  fun maxSpending(values: Array<IntArray>): Long {
    val m = values.size
    val n = values[0].size
    val pq: PriorityQueue<IntArray> = PriorityQueue { a, b -> a.get(0) - b.get(0) }
    for (i in 0 until m) {
      pq.offer(intArrayOf(values[i][n - 1], i, n - 1))
    }
    var ans: Long = 0
    var d = 1
    while (!pq.isEmpty()) {
      val p: Unit = pq.poll()
      val v: Int = p.get(0)
      val i: Int = p.get(1)
      val j: Int = p.get(2)
      ans += v.toLong() * d
      if (j > 0) {
        pq.offer(intArrayOf(values[i][j - 1], i, j - 1))
      }
      ++d
    }
    return ans
  }
}
