internal class Solution {
  fun isPowerOfFour(n: Int): Boolean {
    return n > 0 && n and n - 1 == 0 && n and -0x55555556 == 0
  }
}
