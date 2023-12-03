class Solution {
  fun minLengthAfterRemovals(nums: List<Int>): Int {
    val cnt: Map<Int, Int> = HashMap()
    for (x in nums) {
      cnt.merge(x, 1) { a: Int, b: Int -> Integer.sum(a, b) }
    }
    val pq: PriorityQueue<Int> = PriorityQueue(Comparator.reverseOrder())
    for (x in cnt.values()) {
      pq.offer(x)
    }
    var ans: Int = nums.size()
    while (pq.size() > 1) {
      var x: Int = pq.poll()
      var y: Int = pq.poll()
      x--
      y--
      if (x > 0) {
        pq.offer(x)
      }
      if (y > 0) {
        pq.offer(y)
      }
      ans -= 2
    }
    return ans
  }
}
