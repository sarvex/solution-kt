import kotlin.math.max

class Solution {
  fun busiestServers(k: Int, arrival: IntArray, load: IntArray): List<Int> {
    val cnt = IntArray(k)
    val busy: PriorityQueue<IntArray> = PriorityQueue { a, b -> a.get(0) - b.get(0) }
    val free: TreeSet<Int> = TreeSet()
    for (i in 0 until k) {
      free.add(i)
    }
    for (i in arrival.indices) {
      val start = arrival[i]
      val end = start + load[i]
      while (!busy.isEmpty() && busy.peek().get(0) <= start) {
        free.add(busy.poll().get(1))
      }
      if (free.isEmpty()) {
        continue
      }
      var server: Int = free.ceiling(i % k)
      if (server == null) {
        server = free.first()
      }
      ++cnt[server]
      busy.offer(intArrayOf(end, server))
      free.remove(server)
    }
    var mx = 0
    for (v in cnt) {
      mx = max(mx.toDouble(), v.toDouble()).toInt()
    }
    val ans: List<Int> = ArrayList()
    for (i in 0 until k) {
      if (cnt[i] == mx) {
        ans.add(i)
      }
    }
    return ans
  }
}
