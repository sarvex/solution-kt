internal class Solution {
  fun minSteps(n: Int): Int {
    var n = n
    var res = 0
    var i = 2
    while (n > 1) {
      while (n % i == 0) {
        res += i
        n /= i
      }
      ++i
    }
    return res
  }
}
