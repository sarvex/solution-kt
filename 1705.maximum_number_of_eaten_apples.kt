class Solution {
  fun eatenApples(apples: IntArray, days: IntArray): Int {
    val q: PriorityQueue<IntArray> = PriorityQueue(Comparator.comparingInt { a -> a.get(0) })
    val n = days.size
    var ans = 0
    var i = 0
    while (i < n || !q.isEmpty()) {
      if (i < n && apples[i] > 0) {
        q.offer(intArrayOf(i + days[i] - 1, apples[i]))
      }
      while (!q.isEmpty() && q.peek().get(0) < i) {
        q.poll()
      }
      if (!q.isEmpty()) {
        val p: Unit = q.poll()
        ++ans
        if (--p.get(1) > 0 && p.get(0) > i) {
          q.offer(p)
        }
      }
      ++i
    }
    return ans
  }
}
