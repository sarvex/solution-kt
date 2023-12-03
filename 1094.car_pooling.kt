internal class Solution {
  fun carPooling(trips: Array<IntArray>, capacity: Int): Boolean {
    val d = IntArray(1001)
    for (trip in trips) {
      val x = trip[0]
      val f = trip[1]
      val t = trip[2]
      d[f] += x
      d[t] -= x
    }
    var s = 0
    for (x in d) {
      s += x
      if (s > capacity) {
        return false
      }
    }
    return true
  }
}
