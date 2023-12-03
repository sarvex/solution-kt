class Solution {
  fun sumBase(n: Int, k: Int): Int {
    var n = n
    var ans = 0
    while (n != 0) {
      ans += n % k
      n /= k
    }
    return ans
  }
}
