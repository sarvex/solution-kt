class Solution {
  fun maximumProduct(nums: IntArray, k: Int): Int {
    var k = k
    val q: PriorityQueue<Int> = PriorityQueue()
    for (v in nums) {
      q.offer(v)
    }
    while (k-- > 0) {
      q.offer(q.poll() + 1)
    }
    var ans: Long = 1
    while (!q.isEmpty()) {
      ans = ans * q.poll() % Solution.Companion.MOD
    }
    return ans.toInt()
  }

  companion object {
    private const val MOD = 1e9.toInt() + 7
  }
}
