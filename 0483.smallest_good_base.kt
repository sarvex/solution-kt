internal class Solution {
  fun smallestGoodBase(n: String): String {
    val num = n.toLong()
    for (len in 63 downTo 2) {
      val radix = getRadix(len, num)
      if (radix != -1L) {
        return radix.toString()
      }
    }
    return (num - 1).toString()
  }

  private fun getRadix(len: Int, num: Long): Long {
    var l: Long = 2
    var r = num - 1
    while (l < r) {
      val mid = l + r ushr 1
      if (calc(mid, len) >= num) r = mid else l = mid + 1
    }
    return if (calc(r, len) == num) r else -1
  }

  private fun calc(radix: Long, len: Int): Long {
    var p: Long = 1
    var sum: Long = 0
    for (i in 0 until len) {
      if (Long.MAX_VALUE - sum < p) {
        return Long.MAX_VALUE
      }
      sum += p
      if (Long.MAX_VALUE / p < radix) {
        p = Long.MAX_VALUE
      } else {
        p *= radix
      }
    }
    return sum
  }
}
