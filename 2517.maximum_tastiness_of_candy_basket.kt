class Solution {
  fun maximumTastiness(price: IntArray, k: Int): Int {
    Arrays.sort(price)
    var l = 0
    var r = price[price.size - 1] - price[0]
    while (l < r) {
      val mid = l + r + 1 shr 1
      if (check(price, k, mid)) {
        l = mid
      } else {
        r = mid - 1
      }
    }
    return l
  }

  private fun check(price: IntArray, k: Int, x: Int): Boolean {
    var cnt = 0
    var pre = -x
    for (cur in price) {
      if (cur - pre >= x) {
        pre = cur
        ++cnt
      }
    }
    return cnt >= k
  }
}
