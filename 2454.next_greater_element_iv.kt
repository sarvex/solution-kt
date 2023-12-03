class Solution {
  fun secondGreaterElement(nums: IntArray): IntArray {
    val stk: Deque<Int> = ArrayDeque()
    val q: PriorityQueue<IntArray> = PriorityQueue { a, b -> a.get(0) - b.get(0) }
    val n = nums.size
    val ans = IntArray(n)
    Arrays.fill(ans, -1)
    for (i in 0 until n) {
      val v = nums[i]
      while (!q.isEmpty() && q.peek().get(0) < v) {
        ans[q.peek().get(1)] = v
        q.poll()
      }
      while (!stk.isEmpty() && nums[stk.peek()] < v) {
        q.offer(intArrayOf(nums[stk.peek()], stk.pop()))
      }
      stk.push(i)
    }
    return ans
  }
}
