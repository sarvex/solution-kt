class Solution {
  fun makeTheIntegerZero(num1: Int, num2: Int): Int {
    var k: Long = 1
    while (true) {
      val x = num1 - k * num2
      if (x < 0) {
        break
      }
      if (java.lang.Long.bitCount(x) <= k && k <= x) {
        return k.toInt()
      }
      ++k
    }
    return -1
  }
}
