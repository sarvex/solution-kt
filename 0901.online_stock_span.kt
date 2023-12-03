internal class StockSpanner {
  private val stk: Deque<IntArray> = ArrayDeque()
  fun next(price: Int): Int {
    var cnt = 1
    while (!stk.isEmpty() && stk.peek().get(0) <= price) {
      cnt += stk.pop().get(1)
    }
    stk.push(intArrayOf(price, cnt))
    return cnt
  }
}
