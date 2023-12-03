internal class Solution {
  fun shoppingOffers(
    price: List<Int>, special: List<List<Int>>, needs: List<Int>
  ): Int {
    var ans = total(price, needs)
    val t: List<Int> = ArrayList()
    for (offer in special) {
      t.clear()
      for (j in 0 until needs.size()) {
        if (offer[j] > needs[j]) {
          t.clear()
          break
        }
        t.add(needs[j] - offer[j])
      }
      if (!t.isEmpty()) {
        ans = Math.min(
          ans, offer[offer.size() - 1] + shoppingOffers(price, special, t)
        )
      }
    }
    return ans
  }

  private fun total(price: List<Int>, needs: List<Int>): Int {
    var s = 0
    for (i in 0 until price.size()) {
      s += price[i] * needs[i]
    }
    return s
  }
}
