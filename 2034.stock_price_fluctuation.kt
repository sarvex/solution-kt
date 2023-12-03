import kotlin.math.max

internal class StockPrice {
  private val d: Map<Int, Int> = HashMap()
  private val ls: TreeMap<Int, Int> = TreeMap()
  private var last = 0
  fun update(timestamp: Int, price: Int) {
    if (d.containsKey(timestamp)) {
      val old = d[timestamp]!!
      if (ls.merge(old, -1) { a: Int, b: Int -> Integer.sum(a, b) } === 0) {
        ls.remove(old)
      }
    }
    d.put(timestamp, price)
    ls.merge(price, 1) { a: Int, b: Int -> Integer.sum(a, b) }
    last = max(last.toDouble(), timestamp.toDouble()).toInt()
  }

  fun current(): Int {
    return d[last]!!
  }

  fun maximum(): Int {
    return ls.lastKey()
  }

  fun minimum(): Int {
    return ls.firstKey()
  }
}
