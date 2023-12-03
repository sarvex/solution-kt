internal class Solution {
  fun equalizeWater(buckets: IntArray, loss: Int): Double {
    var l = 0.0
    var r: Double = Arrays.stream(buckets).max().getAsInt()
    while (r - l > 1e-5) {
      val mid = (l + r) / 2
      if (check(buckets, loss, mid)) {
        l = mid
      } else {
        r = mid
      }
    }
    return l
  }

  private fun check(buckets: IntArray, loss: Int, v: Double): Boolean {
    var a = 0.0
    var b = 0.0
    for (x in buckets) {
      if (x > v) {
        a += x - v
      } else {
        b += (v - x) * 100 / (100 - loss)
      }
    }
    return a >= b
  }
}
