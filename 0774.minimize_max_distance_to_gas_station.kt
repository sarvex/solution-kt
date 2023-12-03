internal class Solution {
  fun minmaxGasDist(stations: IntArray, k: Int): Double {
    var left = 0.0
    var right = 1e8
    while (right - left > 1e-6) {
      val mid = (left + right) / 2.0
      if (check(mid, stations, k)) {
        right = mid
      } else {
        left = mid
      }
    }
    return left
  }

  private fun check(x: Double, stations: IntArray, k: Int): Boolean {
    var s = 0
    for (i in 0 until stations.size - 1) {
      s += ((stations[i + 1] - stations[i]) / x).toInt()
    }
    return s <= k
  }
}
