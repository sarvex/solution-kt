class Solution {
  fun countQuadruples(firstString: String, secondString: String): Int {
    val last = IntArray(26)
    for (i in 0 until secondString.length) {
      last[secondString[i].code - 'a'.code] = i + 1
    }
    var ans = 0
    var mi = 1 shl 30
    for (i in 0 until firstString.length) {
      val j = last[firstString[i].code - 'a'.code]
      if (j > 0) {
        val t = i - j
        if (mi > t) {
          mi = t
          ans = 1
        } else if (mi == t) {
          ++ans
        }
      }
    }
    return ans
  }
}
