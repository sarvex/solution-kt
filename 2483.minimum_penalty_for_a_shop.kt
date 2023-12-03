class Solution {
  fun bestClosingTime(customers: String): Int {
    val n = customers.length
    val s = IntArray(n + 1)
    for (i in 0 until n) {
      s[i + 1] = s[i] + if (customers[i] == 'Y') 1 else 0
    }
    var ans = 0
    var cost = 1 shl 30
    for (j in 0..n) {
      val t = j - s[j] + s[n] - s[j]
      if (cost > t) {
        ans = j
        cost = t
      }
    }
    return ans
  }
}
