class Cashier(private val n: Int, private val discount: Int, products: IntArray, prices: IntArray) {
  private var i = 0
  private val d: Map<Int, Int> = HashMap()

  init {
    for (j in products.indices) {
      d.put(products[j], prices[j])
    }
  }

  fun getBill(product: IntArray, amount: IntArray): Double {
    val dis = if (++i % n == 0) discount else 0
    var ans = 0.0
    for (j in product.indices) {
      val p = product[j]
      val a = amount[j]
      val x = d[p]!! * a
      ans += x - dis * x / 100.0
    }
    return ans
  }
}
