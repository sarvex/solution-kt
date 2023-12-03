class Solution {
  fun getNumberOfBacklogOrders(orders: Array<IntArray>): Int {
    val buy: PriorityQueue<IntArray> = PriorityQueue { a, b -> b.get(0) - a.get(0) }
    val sell: PriorityQueue<IntArray> = PriorityQueue { a, b -> a.get(0) - b.get(0) }
    for (e in orders) {
      val p = e[0]
      var a = e[1]
      val t = e[2]
      if (t == 0) {
        while (a > 0 && !sell.isEmpty() && sell.peek().get(0) <= p) {
          val q: Unit = sell.poll()
          val x: Int = q.get(0)
          val y: Int = q.get(1)
          if (a >= y) {
            a -= y
          } else {
            sell.offer(intArrayOf(x, y - a))
            a = 0
          }
        }
        if (a > 0) {
          buy.offer(intArrayOf(p, a))
        }
      } else {
        while (a > 0 && !buy.isEmpty() && buy.peek().get(0) >= p) {
          val q: Unit = buy.poll()
          val x: Int = q.get(0)
          val y: Int = q.get(1)
          if (a >= y) {
            a -= y
          } else {
            buy.offer(intArrayOf(x, y - a))
            a = 0
          }
        }
        if (a > 0) {
          sell.offer(intArrayOf(p, a))
        }
      }
    }
    var ans: Long = 0
    val mod = 1e9.toInt() + 7
    while (!buy.isEmpty()) {
      ans += buy.poll().get(1)
    }
    while (!sell.isEmpty()) {
      ans += sell.poll().get(1)
    }
    return (ans % mod).toInt()
  }
}
