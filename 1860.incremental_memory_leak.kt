import kotlin.math.max

class Solution {
  fun memLeak(memory1: Int, memory2: Int): IntArray {
    var memory1 = memory1
    var memory2 = memory2
    var i = 1
    while (i <= max(memory1.toDouble(), memory2.toDouble())) {
      if (memory1 >= memory2) {
        memory1 -= i
      } else {
        memory2 -= i
      }
      ++i
    }
    return intArrayOf(i, memory1, memory2)
  }
}
