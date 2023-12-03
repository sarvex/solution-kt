import java.util.*
import kotlin.collections.ArrayDeque

class Solution {
  fun finalPrices(prices: IntArray): IntArray {
    val stk: Deque<Int> = ArrayDeque()
    val n = prices.size
    val ans = IntArray(n)
    for (i in 0 until n) {
      ans[i] = prices[i]
      while (!stk.isEmpty() && prices[stk.peek()] >= prices[i]) {
        ans[stk.pop()] -= prices[i]
      }
      stk.push(i)
    }
    return ans
  }
}
