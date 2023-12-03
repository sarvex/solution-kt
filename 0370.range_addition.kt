internal class Solution {
  fun getModifiedArray(length: Int, updates: Array<IntArray>): IntArray {
    val d = IntArray(length)
    for (e in updates) {
      val l = e[0]
      val r = e[1]
      val c = e[2]
      d[l] += c
      if (r + 1 < length) {
        d[r + 1] -= c
      }
    }
    for (i in 1 until length) {
      d[i] += d[i - 1]
    }
    return d
  }
}
