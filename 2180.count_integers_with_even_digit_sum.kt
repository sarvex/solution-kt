class Solution {
  fun countEven(num: Int): Int {
    var ans = 0
    for (i in 1..num) {
      var s = 0
      var x = i
      while (x > 0) {
        s += x % 10
        x /= 10
      }
      if (s % 2 == 0) {
        ++ans
      }
    }
    return ans
  }
}
