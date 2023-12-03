import kotlin.math.max

class Solution {
  fun minSwaps(data: IntArray): Int {
    var k = 0
    for (v in data) {
      k += v
    }
    var t = 0
    for (i in 0 until k) {
      t += data[i]
    }
    var mx = t
    for (i in k until data.size) {
      t += data[i]
      t -= data[i - k]
      mx = max(mx.toDouble(), t.toDouble()).toInt()
    }
    return k - mx
  }
}
