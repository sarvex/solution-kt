class Solution {
  fun countDigits(num: Int): Int {
    var ans = 0
    var x = num
    while (x > 0) {
      if (num % (x % 10) == 0) {
        ++ans
      }
      x /= 10
    }
    return ans
  }
}
