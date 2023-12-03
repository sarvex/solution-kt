class Solution {
  fun assignTasks(servers: IntArray, tasks: IntArray): IntArray {
    val m = tasks.size
    val n = servers.size
    val idle: PriorityQueue<IntArray> =
      PriorityQueue { a, b -> if (a.get(0) === b.get(0)) a.get(1) - b.get(1) else a.get(0) - b.get(0) }
    val busy: PriorityQueue<IntArray> = PriorityQueue label@{ a, b ->
      if (a.get(0) === b.get(0)) {
        return@label if (a.get(1) === b.get(1)) a.get(2) - b.get(2) else a.get(1) - b.get(1)
      }
      a.get(0) - b.get(0)
    }
    for (i in 0 until n) {
      idle.offer(intArrayOf(servers[i], i))
    }
    val res = IntArray(m)
    var j = 0
    for (start in 0 until m) {
      val cost = tasks[start]
      while (!busy.isEmpty() && busy.peek().get(0) <= start) {
        val item: IntArray = busy.poll()
        idle.offer(intArrayOf(item[1], item[2]))
      }
      if (!idle.isEmpty()) {
        val item: IntArray = idle.poll()
        res[j++] = item[1]
        busy.offer(intArrayOf(start + cost, item[0], item[1]))
      } else {
        val item: IntArray = busy.poll()
        res[j++] = item[2]
        busy.offer(intArrayOf(item[0] + cost, item[1], item[2]))
      }
    }
    return res
  }
}
