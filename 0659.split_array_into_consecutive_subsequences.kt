internal class Solution {
  fun isPossible(nums: IntArray): Boolean {
    val d: Map<Int, PriorityQueue<Int>> = HashMap()
    for (v in nums) {
      if (d.containsKey(v - 1)) {
        val q: Unit = d[v - 1]
        d.computeIfAbsent(v) { k -> PriorityQueue() }.offer(q.poll() + 1)
        if (q.isEmpty()) {
          d.remove(v - 1)
        }
      } else {
        d.computeIfAbsent(v) { k -> PriorityQueue() }.offer(1)
      }
    }
    for (v in d.values()) {
      if (v.peek() < 3) {
        return false
      }
    }
    return true
  }
}
