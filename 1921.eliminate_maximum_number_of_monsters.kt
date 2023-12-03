class Solution {
  fun eliminateMaximum(dist: IntArray, speed: IntArray): Int {
    val n = dist.size
    val times = IntArray(n)
    for (i in 0 until n) {
      times[i] = (dist[i] - 1) / speed[i]
    }
    Arrays.sort(times)
    for (i in 0 until n) {
      if (times[i] < i) {
        return i
      }
    }
    return n
  }
}
