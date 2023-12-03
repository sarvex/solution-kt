import kotlin.math.max

internal class Solution {
  fun maxLength(arr: List<String>): Int {
    var ans = 0
    val masks: List<Int> = ArrayList()
    masks.add(0)
    for (s in arr) {
      var mask = 0
      for (i in 0 until s.length()) {
        val j: Int = s.charAt(i) - 'a'
        if (mask shr j and 1 == 1) {
          mask = 0
          break
        }
        mask = mask or (1 shl j)
      }
      if (mask == 0) {
        continue
      }
      val n: Int = masks.size()
      for (i in 0 until n) {
        val m = masks[i]
        if (m and mask == 0) {
          masks.add(m or mask)
          ans = max(ans.toDouble(), Integer.bitCount(m or mask).toDouble()).toInt()
        }
      }
    }
    return ans
  }
}
