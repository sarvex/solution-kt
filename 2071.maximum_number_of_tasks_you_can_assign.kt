import kotlin.math.min

internal class Solution {
  private var tasks: IntArray
  private var workers: IntArray
  private var strength = 0
  private var pills = 0
  private var m = 0
  private var n = 0
  fun maxTaskAssign(tasks: IntArray, workers: IntArray, pills: Int, strength: Int): Int {
    Arrays.sort(tasks)
    Arrays.sort(workers)
    this.tasks = tasks
    this.workers = workers
    this.strength = strength
    this.pills = pills
    n = tasks.size
    m = workers.size
    var left = 0
    var right = min(m.toDouble(), n.toDouble()).toInt()
    while (left < right) {
      val mid = left + right + 1 shr 1
      if (check(mid)) {
        left = mid
      } else {
        right = mid - 1
      }
    }
    return left
  }

  private fun check(x: Int): Boolean {
    var i = 0
    val q: Deque<Int> = ArrayDeque()
    var p = pills
    for (j in m - x until m) {
      while (i < x && tasks[i] <= workers[j] + strength) {
        q.offer(tasks[i++])
      }
      if (q.isEmpty()) {
        return false
      }
      if (q.peekFirst() <= workers[j]) {
        q.pollFirst()
      } else if (p == 0) {
        return false
      } else {
        --p
        q.pollLast()
      }
    }
    return true
  }
}
