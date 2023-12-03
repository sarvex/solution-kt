class Solution {
  fun maxKelements(nums: IntArray, k: Int): Long {
    var k = k
    val pq: PriorityQueue<Int> = PriorityQueue { a, b -> b - a }
    for (v in nums) {
      pq.offer(v)
    }
    var ans: Long = 0
    while (k-- > 0) {
      val v: Int = pq.poll()
      ans += v.toLong()
      pq.offer((v + 2) / 3)
    }
    return ans
  }
}
