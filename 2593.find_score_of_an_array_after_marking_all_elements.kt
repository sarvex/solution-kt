class Solution {
  fun findScore(nums: IntArray): Long {
    val n = nums.size
    val vis = BooleanArray(n)
    val q: PriorityQueue<IntArray> =
      PriorityQueue { a, b -> if (a.get(0) === b.get(0)) a.get(1) - b.get(1) else a.get(0) - b.get(0) }
    for (i in 0 until n) {
      q.offer(intArrayOf(nums[i], i))
    }
    var ans: Long = 0
    while (!q.isEmpty()) {
      val p: Unit = q.poll()
      ans += p.get(0)
      vis[p.get(1)] = true
      for (j in List.of(p.get(1) - 1, p.get(1) + 1)) {
        if (j >= 0 && j < n) {
          vis[j] = true
        }
      }
      while (!q.isEmpty() && vis[q.peek().get(1)]) {
        q.poll()
      }
    }
    return ans
  }
}
