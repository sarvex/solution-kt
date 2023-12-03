class Solution {
  fun findMinFibonacciNumbers(k: Int): Int {
    if (k < 2) {
      return k
    }
    var a = 1
    var b = 1
    while (b <= k) {
      b = a + b
      a = b - a
    }
    return 1 + findMinFibonacciNumbers(k - a)
  }
}
