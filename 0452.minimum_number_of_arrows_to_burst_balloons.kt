internal class Solution {
  fun findMinArrowShots(points: Array<IntArray>): Int {
    Arrays.sort(points, Comparator.comparingInt { a -> a.get(1) })
    var ans = 0
    var last = -(1L shl 60)
    for (p in points) {
      val a = p[0]
      val b = p[1]
      if (a > last) {
        ++ans
        last = b.toLong()
      }
    }
    return ans
  }
}
