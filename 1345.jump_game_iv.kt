import java.util.*

class Solution {
  fun minJumps(arr: IntArray): Int {
    val idx: Map<Int, List<Int>> = HashMap()
    val n = arr.size
    for (i in 0 until n) {
      idx.computeIfAbsent(arr[i]) { k -> ArrayList() }.add(i)
    }
    val q: Deque<IntArray> = LinkedList()
    val vis: Set<Int> = HashSet()
    vis.add(0)
    q.offer(intArrayOf(0, 0))
    while (!q.isEmpty()) {
      val e = q.pollFirst()
      val i = e[0]
      var step = e[1]
      if (i == n - 1) {
        return step
      }
      val v = arr[i]
      ++step
      for (j in idx[v] ?: ArrayList()) {
        if (!vis.contains(j)) {
          vis.add(j)
          q.offer(intArrayOf(j, step))
        }
      }
      idx.remove(v)
      if (i + 1 < n && !vis.contains(i + 1)) {
        vis.add(i + 1)
        q.offer(intArrayOf(i + 1, step))
      }
      if (i - 1 >= 0 && !vis.contains(i - 1)) {
        vis.add(i - 1)
        q.offer(intArrayOf(i - 1, step))
      }
    }
    return -1
  }
}
