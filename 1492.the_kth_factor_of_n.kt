class Solution {
  fun kthFactor(n: Int, k: Int): Int {
    var k = k
    var i = 1
    while (i < n / i) {
      if (n % i == 0 && --k == 0) {
        return i
      }
      ++i
    }
    if (i * i != n) {
      --i
    }
    while (i > 0) {
      if (n % (n / i) == 0 && --k == 0) {
        return n / i
      }
      --i
    }
    return -1
  }
}
