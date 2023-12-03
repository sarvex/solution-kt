import kotlin.math.max

class Solution {
  fun getOrder(tasks: Array<IntArray>): IntArray {
    val n = tasks.size
    val ts = Array(n) { IntArray(3) }
    for (i in 0 until n) {
      ts[i] = intArrayOf(tasks[i][0], tasks[i][1], i)
    }
    Arrays.sort(ts) { a, b -> a.get(0) - b.get(0) }
    val ans = IntArray(n)
    val q: PriorityQueue<IntArray> =
      PriorityQueue { a, b -> if (a.get(0) === b.get(0)) a.get(1) - b.get(1) else a.get(0) - b.get(0) }
    var i = 0
    var t = 0
    var k = 0
    while (!q.isEmpty() || i < n) {
      if (q.isEmpty()) {
        t = max(t.toDouble(), ts[i][0].toDouble()).toInt()
      }
      while (i < n && ts[i][0] <= t) {
        q.offer(intArrayOf(ts[i][1], ts[i][2]))
        ++i
      }
      val p: Unit = q.poll()
      ans[k++] = p.get(1)
      t += p.get(0)
    }
    return ans
  }
}
