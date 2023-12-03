import kotlin.math.max

class BinaryIndexedTree(private val n: Int) {
  private val c: IntArray

  init {
    c = IntArray(n + 1)
  }

  fun update(x: Int, v: Int) {
    var x = x
    while (x <= n) {
      c[x] = max(c[x].toDouble(), v.toDouble()).toInt()
      x += x and -x
    }
  }

  fun query(x: Int): Int {
    var x = x
    var mx = 0
    while (x > 0) {
      mx = max(mx.toDouble(), c[x].toDouble()).toInt()
      x -= x and -x
    }
    return mx
  }
}

internal class Solution {
  fun maxProfit(prices: IntArray, profits: IntArray): Int {
    val n = prices.size
    val left = IntArray(n)
    val right = IntArray(n)
    var m = 0
    for (x in prices) {
      m = max(m.toDouble(), x.toDouble()).toInt()
    }
    val tree1 = BinaryIndexedTree(m + 1)
    val tree2 = BinaryIndexedTree(m + 1)
    for (i in 0 until n) {
      val x = prices[i]
      left[i] = tree1.query(x - 1)
      tree1.update(x, profits[i])
    }
    for (i in n - 1 downTo 0) {
      val x = m + 1 - prices[i]
      right[i] = tree2.query(x - 1)
      tree2.update(x, profits[i])
    }
    var ans = -1
    for (i in 0 until n) {
      if (left[i] > 0 && right[i] > 0) {
        ans = max(ans.toDouble(), (left[i] + profits[i] + right[i]).toDouble()).toInt()
      }
    }
    return ans
  }
}
