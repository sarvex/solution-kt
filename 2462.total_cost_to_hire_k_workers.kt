class Solution {
  fun totalCost(costs: IntArray, k: Int, candidates: Int): Long {
    var k = k
    val q: PriorityQueue<IntArray> = PriorityQueuelabel@{ a, b ->
      if (a.get(0) === b.get(0)) {
        return@label a.get(1) - b.get(1)
      }
      a.get(0) - b.get(0)
    }
    val n = costs.size
    var i = candidates - 1
    var j = n - candidates
    for (h in 0 until candidates) {
      q.offer(intArrayOf(costs[h], h))
    }
    for (h in n - candidates until n) {
      if (h > i) {
        q.offer(intArrayOf(costs[h], h))
      }
    }
    var ans: Long = 0
    while (k-- > 0) {
      val e: Unit = q.poll()
      val c: Int = e.get(0)
      val x: Int = e.get(1)
      ans += c.toLong()
      if (x <= i) {
        if (++i < j) {
          q.offer(intArrayOf(costs[i], i))
        }
      }
      if (x >= j) {
        if (--j > i) {
          q.offer(intArrayOf(costs[j], j))
        }
      }
    }
    return ans
  }
}
