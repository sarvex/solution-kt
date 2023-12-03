class Solution {
  // you need to treat n as an unsigned value
  fun hammingWeight(n: Int): Int {
    var n = n
    var ans = 0
    while (n != 0) {
      n = n and n - 1
      ++ans
    }
    return ans
  }
}
