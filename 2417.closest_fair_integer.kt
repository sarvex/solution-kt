class Solution {
  fun closestFair(n: Int): Int {
    var a = 0
    var b = 0
    var k = 0
    var t = n
    while (t > 0) {
      if (t % 10 % 2 == 1) {
        ++a
      } else {
        ++b
      }
      t /= 10
      ++k
    }
    if (k % 2 == 1) {
      val x = 10.pow(k.toDouble()) as Int
      var y = 0
      for (i in 0 until (k shr 1)) {
        y = y * 10 + 1
      }
      return x + y
    }
    return if (a == b) {
      n
    } else closestFair(n + 1)
  }
}
