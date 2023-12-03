class ProductOfNumbers {
  private val s: List<Int> = ArrayList()

  init {
    s.add(1)
  }

  fun add(num: Int) {
    if (num == 0) {
      s.clear()
      s.add(1)
      return
    }
    s.add(s[s.size() - 1] * num)
  }

  fun getProduct(k: Int): Int {
    val n: Int = s.size()
    return if (n <= k) 0 else s[n - 1] / s[n - k - 1]
  }
}
