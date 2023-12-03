internal class Solution {
  fun confusingNumber(n: Int): Boolean {
    val d = intArrayOf(0, 1, -1, -1, -1, -1, 9, -1, 8, 6)
    var x = n
    var y = 0
    while (x > 0) {
      val v = x % 10
      if (d[v] < 0) {
        return false
      }
      y = y * 10 + d[v]
      x /= 10
    }
    return y != n
  }
}
