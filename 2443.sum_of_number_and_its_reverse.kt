class Solution {
  fun sumOfNumberAndReverse(num: Int): Boolean {
    for (x in 0..num) {
      var k = x
      var y = 0
      while (k > 0) {
        y = y * 10 + k % 10
        k /= 10
      }
      if (x + y == num) {
        return true
      }
    }
    return false
  }
}
