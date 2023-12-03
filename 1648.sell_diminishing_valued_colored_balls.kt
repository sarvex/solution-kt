class Solution {
  fun maxProfit(inventory: IntArray, orders: Int): Int {
    var orders = orders
    Arrays.sort(inventory)
    val n = inventory.size
    run {
      var i = 0
      var j = n - 1
      while (i < j) {
        val t = inventory[i]
        inventory[i] = inventory[j]
        inventory[j] = t
        ++i
        --j
      }
    }
    var ans: Long = 0
    var i = 0
    while (orders > 0) {
      while (i < n && inventory[i] >= inventory[0]) {
        ++i
      }
      val nxt = if (i < n) inventory[i] else 0
      val cnt = i
      val x = (inventory[0] - nxt).toLong()
      val tot = cnt * x
      if (tot > orders) {
        val decr = orders / cnt
        val a1 = (inventory[0] - decr + 1).toLong()
        val an = inventory[0].toLong()
        ans += (a1 + an) * decr / 2 * cnt
        ans += (a1 - 1) * (orders % cnt)
      } else {
        val a1 = (nxt + 1).toLong()
        val an = inventory[0].toLong()
        ans += (a1 + an) * x / 2 * cnt
        inventory[0] = nxt
      }
      orders -= tot.toInt()
      ans %= Solution.Companion.MOD.toLong()
    }
    return ans.toInt()
  }

  companion object {
    private const val MOD = 1e9.toInt() + 7
  }
}
