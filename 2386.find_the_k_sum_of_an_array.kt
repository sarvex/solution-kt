class Solution {
  fun kSum(nums: IntArray, k: Int): Long {
    var k = k
    var mx: Long = 0
    val n = nums.size
    for (i in 0 until n) {
      if (nums[i] > 0) {
        mx += nums[i].toLong()
      } else {
        nums[i] *= -1
      }
    }
    Arrays.sort(nums)
    val pq: PriorityQueue<Pair<Long, Int>> = PriorityQueue(Comparator.comparing(Pair::getKey))
    pq.offer(Pair(0L.toInt(), 0))
    while (--k > 0) {
      val p: Unit = pq.poll()
      val s: Long = p.getKey()
      val i: Int = p.getValue()
      if (i < n) {
        pq.offer(Pair((s + nums[i]).toInt(), i + 1))
        if (i > 0) {
          pq.offer(Pair((s + nums[i] - nums[i - 1]).toInt(), i + 1))
        }
      }
    }
    return mx - pq.peek().getKey()
  }
}
