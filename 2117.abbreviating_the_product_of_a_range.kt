import kotlin.math.min

internal class Solution {
  fun abbreviateProduct(left: Int, right: Int): String {
    var cnt2 = 0
    var cnt5 = 0
    for (i in left..right) {
      var x = i
      while (x % 2 == 0) {
        ++cnt2
        x /= 2
      }
      while (x % 5 == 0) {
        ++cnt5
        x /= 5
      }
    }
    val c = min(cnt2.toDouble(), cnt5.toDouble()).toInt()
    cnt5 = c
    cnt2 = cnt5
    var suf: Long = 1
    var pre = 1.0
    var gt = false
    for (i in left..right) {
      suf *= i.toLong()
      while (cnt2 > 0 && suf % 2 == 0L) {
        --cnt2
        suf /= 2
      }
      while (cnt5 > 0 && suf % 5 == 0L) {
        --cnt5
        suf /= 5
      }
      if (suf >= 1e10.toLong()) {
        gt = true
        suf %= 1e10.toLong()
      }
      pre *= i.toDouble()
      while (pre > 1e5) {
        pre /= 10.0
      }
    }
    return if (gt) {
      pre.toInt().toString() + "..." + String.format("%05d", suf % 1e5.toInt()) + "e" + c
    } else suf.toString() + "e" + c
  }
}
