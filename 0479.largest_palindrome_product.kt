internal class Solution {
  fun largestPalindrome(n: Int): Int {
    val mx = 10.pow(n.toDouble()) as Int - 1
    for (a in mx downTo mx / 10 + 1) {
      var b = a
      var x = a.toLong()
      while (b != 0) {
        x = x * 10 + b % 10
        b /= 10
      }
      var t = mx.toLong()
      while (t * t >= x) {
        if (x % t == 0L) {
          return (x % 1337).toInt()
        }
        --t
      }
    }
    return 9
  }
}
