class Solution {
  fun minGroups(intervals: Array<IntArray>): Int {
    Arrays.sort(intervals) { a, b -> a.get(0) - b.get(0) }
    val q: PriorityQueue<Int> = PriorityQueue()
    for (e in intervals) {
      if (!q.isEmpty() && q.peek() < e[0]) {
        q.poll()
      }
      q.offer(e[1])
    }
    return q.size()
  }
}
