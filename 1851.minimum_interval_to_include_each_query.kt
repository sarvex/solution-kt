class Solution {
  fun minInterval(intervals: Array<IntArray>, queries: IntArray): IntArray {
    val n = intervals.size
    val m = queries.size
    Arrays.sort(intervals) { a, b -> a.get(0) - b.get(0) }
    val qs = Array(m) { IntArray(0) }
    for (i in 0 until m) {
      qs[i] = intArrayOf(queries[i], i)
    }
    Arrays.sort(qs) { a, b -> a.get(0) - b.get(0) }
    val ans = IntArray(m)
    Arrays.fill(ans, -1)
    val pq: PriorityQueue<IntArray> = PriorityQueue { a, b -> a.get(0) - b.get(0) }
    var i = 0
    for (q in qs) {
      while (i < n && intervals[i][0] <= q[0]) {
        val a = intervals[i][0]
        val b = intervals[i][1]
        pq.offer(intArrayOf(b - a + 1, b))
        ++i
      }
      while (!pq.isEmpty() && pq.peek().get(1) < q[0]) {
        pq.poll()
      }
      if (!pq.isEmpty()) {
        ans[q[1]] = pq.peek().get(0)
      }
    }
    return ans
  }
}
