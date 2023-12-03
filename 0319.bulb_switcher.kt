import kotlin.math.sqrt

internal class Solution {
  fun bulbSwitch(n: Int): Int {
    return sqrt(n.toDouble()).toInt()
  }
}
