import kotlin.math.min

internal class Solution {
  fun flipLights(n: Int, presses: Int): Int {
    var n = n
    val ops = intArrayOf(63, 21, 42, 36)
    val vis: Set<Int> = HashSet()
    n = min(n.toDouble(), 6.0).toInt()
    for (mask in 0 until (1 shl 4)) {
      val cnt = Integer.bitCount(mask)
      if (cnt <= presses && cnt % 2 == presses % 2) {
        var t = 0
        for (i in 0..3) {
          if (mask shr i and 1 == 1) {
            t = t xor ops[i]
          }
        }
        t = t and (1 shl 6) - 1
        t = t shr 6 - n
        vis.add(t)
      }
    }
    return vis.size()
  }
}
