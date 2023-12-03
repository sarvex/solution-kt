class Solution {
  fun mostBooked(n: Int, meetings: Array<IntArray>): Int {
    Arrays.sort(meetings) { a, b -> a.get(0) - b.get(0) }
    val busy: PriorityQueue<IntArray> =
      PriorityQueue { a, b -> if (a.get(0) === b.get(0)) a.get(1) - b.get(1) else a.get(0) - b.get(0) }
    val idle: PriorityQueue<Int> = PriorityQueue()
    for (i in 0 until n) {
      idle.offer(i)
    }
    val cnt = IntArray(n)
    for (v in meetings) {
      val s = v[0]
      val e = v[1]
      while (!busy.isEmpty() && busy.peek().get(0) <= s) {
        idle.offer(busy.poll().get(1))
      }
      var i = 0
      if (!idle.isEmpty()) {
        i = idle.poll()
        busy.offer(intArrayOf(e, i))
      } else {
        val x: Unit = busy.poll()
        i = x.get(1)
        busy.offer(intArrayOf(x.get(0) + e - s, i))
      }
      ++cnt[i]
    }
    var ans = 0
    for (i in 0 until n) {
      if (cnt[ans] < cnt[i]) {
        ans = i
      }
    }
    return ans
  }
}
