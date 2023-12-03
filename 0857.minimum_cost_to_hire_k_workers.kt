import kotlin.math.min

internal class Solution {
  fun mincostToHireWorkers(quality: IntArray, wage: IntArray, k: Int): Double {
    val n = quality.size
    val t = arrayOfNulls<Pair>(n)
    for (i in 0 until n) {
      t[i] = Pair(quality[i], wage[i])
    }
    Arrays.sort(t) { a, b -> java.lang.Double.compare(a.x, b.x) }
    val pq: PriorityQueue<Int> = PriorityQueue { a, b -> b - a }
    var ans = 1e9
    var tot = 0
    for (e in t) {
      tot += e!!.q
      pq.offer(e.q)
      if (pq.size() === k) {
        ans = min(ans, tot * e.x)
        tot -= pq.poll()
      }
    }
    return ans
  }
}

internal class Pair(var q: Int, w: Int) {
  var x: Double

  init {
    x = w.toDouble() / q
  }
}
