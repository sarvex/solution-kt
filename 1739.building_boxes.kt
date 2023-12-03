class Solution {
  fun minimumBoxes(n: Int): Int {
    var s = 0
    var k = 1
    while (s + k * (k + 1) / 2 <= n) {
      s += k * (k + 1) / 2
      ++k
    }
    --k
    var ans = k * (k + 1) / 2
    k = 1
    while (s < n) {
      ++ans
      s += k
      ++k
    }
    return ans
  }
}
