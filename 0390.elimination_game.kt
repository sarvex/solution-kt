internal class Solution {
  fun lastRemaining(n: Int): Int {
    var a1 = 1
    var an = n
    var step = 1
    var i = 0
    var cnt = n
    while (cnt > 1) {
      if (i % 2 == 1) {
        an -= step
        if (cnt % 2 == 1) {
          a1 += step
        }
      } else {
        a1 += step
        if (cnt % 2 == 1) {
          an -= step
        }
      }
      cnt = cnt shr 1
      step = step shl 1
      ++i
    }
    return a1
  }
}
