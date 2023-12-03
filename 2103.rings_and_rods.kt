internal class Solution {
  fun countPoints(rings: String): Int {
    val d = IntArray('Z')
    d['R'.code] = 1
    d['G'.code] = 2
    d['B'.code] = 4
    val mask = IntArray(10)
    var i = 0
    val n = rings.length
    while (i < n) {
      val c = rings[i].code
      val j = rings[i + 1].code - '0'.code
      mask[j] = mask[j] or d[c]
      i += 2
    }
    var ans = 0
    for (x in mask) {
      if (x == 7) {
        ++ans
      }
    }
    return ans
  }
}
