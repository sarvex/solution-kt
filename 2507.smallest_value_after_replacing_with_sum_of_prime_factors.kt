class Solution {
  fun smallestValue(n: Int): Int {
    var n = n
    while (true) {
      val t = n
      var s = 0
      for (i in 2..n / i) {
        while (n % i == 0) {
          s += i
          n /= i
        }
      }
      if (n > 1) {
        s += n
      }
      if (s == t) {
        return s
      }
      n = s
    }
  }
}
