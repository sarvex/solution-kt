internal class Solution {
  fun lastStoneWeight(stones: IntArray): Int {
    val q: PriorityQueue<Int> = PriorityQueue { a, b -> b - a }
    for (x in stones) {
      q.offer(x)
    }
    while (q.size() > 1) {
      val y: Int = q.poll()
      val x: Int = q.poll()
      if (x != y) {
        q.offer(y - x)
      }
    }
    return if (q.isEmpty()) 0 else q.poll()
  }
}
