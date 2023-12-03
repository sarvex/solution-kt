internal class Solution {
  fun dailyTemperatures(temperatures: IntArray): IntArray {
    val n = temperatures.size
    val ans = IntArray(n)
    val stk: Deque<Int> = ArrayDeque()
    for (i in 0 until n) {
      while (!stk.isEmpty() && temperatures[stk.peek()] < temperatures[i]) {
        val j: Int = stk.pop()
        ans[j] = i - j
      }
      stk.push(i)
    }
    return ans
  }
}
