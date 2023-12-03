internal class Solution {
  fun numberOfLines(widths: IntArray, s: String): IntArray {
    var last = 0
    var row = 1
    for (c in s.toCharArray()) {
      val w = widths[c.code - 'a'.code]
      if (last + w <= Solution.Companion.MAX_WIDTH) {
        last += w
      } else {
        ++row
        last = w
      }
    }
    return intArrayOf(row, last)
  }

  companion object {
    private const val MAX_WIDTH = 100
  }
}
