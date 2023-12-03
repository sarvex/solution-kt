import kotlin.math.sqrt

class Solution {
  fun pickGifts(gifts: IntArray, k: Int): Long {
    var k = k
    val pq: PriorityQueue<Int> = PriorityQueue { a, b -> b - a }
    for (v in gifts) {
      pq.offer(v)
    }
    while (k-- > 0) {
      pq.offer(sqrt(pq.poll()).toInt())
    }
    var ans: Long = 0
    for (v in pq) {
      ans += v.toLong()
    }
    return ans
  }
}
