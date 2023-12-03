import kotlin.math.abs

internal class Solution {
  fun divide(a: Int, b: Int): Int {
    var sign = 1
    if (a < 0 != b < 0) {
      sign = -1
    }
    var x = abs(a.toLong().toDouble()).toLong()
    val y = abs(b.toLong().toDouble()).toLong()
    var tot: Long = 0
    while (x >= y) {
      var cnt = 0
      while (x >= y shl cnt + 1) {
        cnt++
      }
      tot += 1L shl cnt
      x -= y shl cnt
    }
    val ans = sign * tot
    return if (ans >= Int.MIN_VALUE && ans <= Int.MAX_VALUE) {
      ans.toInt()
    } else Int.MAX_VALUE
  }
}
