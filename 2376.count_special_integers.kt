class Solution {
  fun countSpecialNumbers(n: Int): Int {
    var n = n
    val digits: List<Int> = ArrayList()
    while (n != 0) {
      digits.add(n % 10)
      n /= 10
    }
    val m: Int = digits.size()
    var ans = 0
    for (i in 1 until m) {
      ans += 9 * A(9, i - 1)
    }
    val vis = BooleanArray(10)
    for (i in m - 1 downTo 0) {
      val v = digits[i]
      for (j in if (i == m - 1) 1 else 0 until v) {
        if (vis[j]) {
          continue
        }
        ans += A(10 - (m - i), i)
      }
      if (vis[v]) {
        break
      }
      vis[v] = true
      if (i == 0) {
        ++ans
      }
    }
    return ans
  }

  private fun A(m: Int, n: Int): Int {
    return if (n == 0) 1 else A(m, n - 1) * (m - n + 1)
  }
}
