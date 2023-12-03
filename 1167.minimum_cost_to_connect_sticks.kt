internal class Solution {
  fun connectSticks(sticks: IntArray): Int {
    val pq: PriorityQueue<Int> = PriorityQueue()
    for (x in sticks) {
      pq.offer(x)
    }
    var ans = 0
    while (pq.size() > 1) {
      val z: Int = pq.poll() + pq.poll()
      ans += z
      pq.offer(z)
    }
    return ans
  }
}
