class Solution {
  fun maxNumberOfFamilies(n: Int, reservedSeats: Array<IntArray>): Int {
    val d: Map<Int, Int> = HashMap()
    for (e in reservedSeats) {
      val i = e[0]
      val j = e[1]
      d.merge(i, 1 shl 10 - j) { x, y -> x or y }
    }
    val masks = intArrayOf(480, 30, 120)
    var ans: Int = (n - d.size()) * 2
    for (x in d.values()) {
      for (mask in masks) {
        if (x and mask == 0) {
          x = x or mask
          ++ans
        }
      }
    }
    return ans
  }
}
