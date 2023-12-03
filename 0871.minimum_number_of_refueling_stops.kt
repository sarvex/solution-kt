internal class Solution {
  fun minRefuelStops(target: Int, startFuel: Int, stations: Array<IntArray>): Int {
    var startFuel = startFuel
    val q: PriorityQueue<Int> = PriorityQueue { a, b -> b - a }
    val n = stations.size
    var prev = 0
    var ans = 0
    for (i in 0 until n + 1) {
      val d = (if (i < n) stations[i][0] else target) - prev
      startFuel -= d
      while (startFuel < 0 && !q.isEmpty()) {
        startFuel += q.poll()
        ++ans
      }
      if (startFuel < 0) {
        return -1
      }
      if (i < n) {
        q.offer(stations[i][1])
        prev = stations[i][0]
      }
    }
    return ans
  }
}
