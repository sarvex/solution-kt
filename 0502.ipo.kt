internal class Solution {
  fun findMaximizedCapital(k: Int, w: Int, profits: IntArray, capital: IntArray): Int {
    var k = k
    var w = w
    val n = capital.size
    val q1: PriorityQueue<IntArray> = PriorityQueue { a, b -> a.get(0) - b.get(0) }
    for (i in 0 until n) {
      q1.offer(intArrayOf(capital[i], profits[i]))
    }
    val q2: PriorityQueue<Int> = PriorityQueue { a, b -> b - a }
    while (k-- > 0) {
      while (!q1.isEmpty() && q1.peek().get(0) <= w) {
        q2.offer(q1.poll().get(1))
      }
      if (q2.isEmpty()) {
        break
      }
      w += q2.poll()
    }
    return w
  }
}
