internal class Solution {
  fun minimizeError(prices: Array<String>, target: Int): String {
    var mi = 0
    val arr: List<Double> = ArrayList()
    for (p in prices) {
      val price = p.toDouble()
      mi += price.toInt()
      val d = price - price.toInt()
      if (d > 0) {
        arr.add(d)
      }
    }
    if (target < mi || target > mi + arr.size()) {
      return "-1"
    }
    val d = target - mi
    arr.sort(Collections.reverseOrder())
    var ans = d.toDouble()
    for (i in 0 until d) {
      ans -= arr[i]
    }
    for (i in d until arr.size()) {
      ans += arr[i]
    }
    val df = DecimalFormat("#0.000")
    return df.format(ans)
  }
}
