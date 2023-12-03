internal class Solution {
  fun scheduleCourse(courses: Array<IntArray>): Int {
    Arrays.sort(courses) { a, b -> a.get(1) - b.get(1) }
    val pq: PriorityQueue<Int> = PriorityQueue { a, b -> b - a }
    var s = 0
    for (e in courses) {
      val duration = e[0]
      val last = e[1]
      pq.offer(duration)
      s += duration
      while (s > last) {
        s -= pq.poll()
      }
    }
    return pq.size()
  }
}
