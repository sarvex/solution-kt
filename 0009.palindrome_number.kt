internal class Solution {
  fun isPalindrome(x: Int): Boolean {
    var x = x
    if (x < 0 || x > 0 && x % 10 == 0) {
      return false
    }
    var y = 0
    while (y < x) {
      y = y * 10 + x % 10
      x /= 10
    }
    return x == y || x == y / 10
  }
}
