import kotlin.math.max

class Solution {
  fun distinctIntegers(n: Int): Int {
    return max(1.0, (n - 1).toDouble()).toInt()
  }
}
