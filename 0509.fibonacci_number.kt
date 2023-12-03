internal class Solution {
  fun fib(n: Int): Int {
    var n = n
    var a = 0
    var b = 1
    while (n-- > 0) {
      val c = a + b
      a = b
      b = c
    }
    return a
  }
}
