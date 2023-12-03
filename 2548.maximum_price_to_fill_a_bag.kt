import kotlin.math.min

class Solution {
  fun maxPrice(items: Array<IntArray>, capacity: Int): Double {
    var capacity = capacity
    Arrays.sort(items) { a, b -> a.get(1) * b.get(0) - a.get(0) * b.get(1) }
    var ans = 0.0
    for (e in items) {
      val p = e[0]
      val w = e[1]
      val v = min(w.toDouble(), capacity.toDouble()).toInt()
      ans += v * 1.0 / w * p
      capacity -= v
    }
    return if (capacity > 0) -1 else ans
  }
}
