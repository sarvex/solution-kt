internal class Solution {
  fun numberOfBoomerangs(points: Array<IntArray>): Int {
    var ans = 0
    for (p in points) {
      val counter: Map<Int, Int> = HashMap()
      for (q in points) {
        val distance = (p[0] - q[0]) * (p[0] - q[0]) + (p[1] - q[1]) * (p[1] - q[1])
        counter.put(distance, (counter[distance] ?: 0) + 1)
      }
      for (`val` in counter.values()) {
        ans += `val` * (`val` - 1)
      }
    }
    return ans
  }
}
