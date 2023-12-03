class Solution {
  fun minStoneSum(piles: IntArray, k: Int): Int {
    var k = k
    val q: PriorityQueue<Int> = PriorityQueue { a, b -> b - a }
    for (p in piles) {
      q.offer(p)
    }
    while (k-- > 0) {
      val p: Int = q.poll()
      q.offer(p + 1 shr 1)
    }
    var ans = 0
    while (!q.isEmpty()) {
      ans += q.poll()
    }
    return ans
  }
}
