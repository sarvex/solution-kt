import kotlin.math.min

class Solution {
  fun minCost(nums: IntArray, costs: IntArray): Long {
    val n = nums.size
    val g: Array<List<Int>?> = arrayOfNulls(n)
    Arrays.setAll(g) { k -> ArrayList() }
    val stk: Deque<Int> = ArrayDeque()
    for (i in n - 1 downTo 0) {
      while (!stk.isEmpty() && nums[stk.peek()] < nums[i]) {
        stk.pop()
      }
      if (!stk.isEmpty()) {
        g[i].add(stk.peek())
      }
      stk.push(i)
    }
    stk.clear()
    for (i in n - 1 downTo 0) {
      while (!stk.isEmpty() && nums[stk.peek()] >= nums[i]) {
        stk.pop()
      }
      if (!stk.isEmpty()) {
        g[i].add(stk.peek())
      }
      stk.push(i)
    }
    val f = LongArray(n)
    Arrays.fill(f, 1L shl 60)
    f[0] = 0
    for (i in 0 until n) {
      for (j in g[i]!!) {
        f[j] = min(f[j].toDouble(), (f[i] + costs[j]).toDouble()).toLong()
      }
    }
    return f[n - 1]
  }
}
