class Solution {
  fun makeIntegerBeautiful(n: Long, target: Int): Long {
    var x: Long = 0
    while (f(n + x) > target) {
      var y = n + x
      var p: Long = 10
      while (y % 10 == 0L) {
        y /= 10
        p *= 10
      }
      x = (y / 10 + 1) * p - n
    }
    return x
  }

  private fun f(x: Long): Int {
    var x = x
    var y = 0
    while (x > 0) {
      y += (x % 10).toInt()
      x /= 10
    }
    return y
  }
}
