import kotlin.math.abs
import kotlin.math.min

class Solution {
  fun minimumCost(start: IntArray, target: IntArray, specialRoads: Array<IntArray>): Int {
    var ans = 1 shl 30
    val n = 1000000
    val q: PriorityQueue<IntArray> = PriorityQueue { a, b -> a.get(0) - b.get(0) }
    val vis: Set<Long> = HashSet()
    q.offer(intArrayOf(0, start[0], start[1]))
    while (!q.isEmpty()) {
      val p: Unit = q.poll()
      val x: Int = p.get(1)
      val y: Int = p.get(2)
      val k = 1L * x * n + y
      if (vis.contains(k)) {
        continue
      }
      vis.add(k)
      val d: Int = p.get(0)
      ans = min(ans.toDouble(), (d + dist(x, y, target[0], target[1])).toDouble()).toInt()
      for (r in specialRoads) {
        val x1 = r[0]
        val y1 = r[1]
        val x2 = r[2]
        val y2 = r[3]
        val cost = r[4]
        q.offer(intArrayOf(d + dist(x, y, x1, y1) + cost, x2, y2))
      }
    }
    return ans
  }

  private fun dist(x1: Int, y1: Int, x2: Int, y2: Int): Int {
    return (abs((x1 - x2).toDouble()) + abs((y1 - y2).toDouble())).toInt()
  }
}
