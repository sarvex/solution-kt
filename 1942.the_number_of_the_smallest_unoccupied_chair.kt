class Solution {
  fun smallestChair(times: Array<IntArray>, targetFriend: Int): Int {
    val n = times.size
    val ts = Array(n) { IntArray(3) }
    val q: PriorityQueue<Int> = PriorityQueue()
    val busy: PriorityQueue<IntArray> = PriorityQueue { a, b -> a.get(0) - b.get(0) }
    for (i in 0 until n) {
      ts[i] = intArrayOf(times[i][0], times[i][1], i)
      q.offer(i)
    }
    Arrays.sort(ts) { a, b -> a.get(0) - b.get(0) }
    for (t in ts) {
      val a = t[0]
      val b = t[1]
      val i = t[2]
      while (!busy.isEmpty() && busy.peek().get(0) <= a) {
        q.offer(busy.poll().get(1))
      }
      val c: Int = q.poll()
      if (i == targetFriend) {
        return c
      }
      busy.offer(intArrayOf(b, c))
    }
    return -1
  }
}
