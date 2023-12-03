import kotlin.math.max

class Solution {
  fun numberOfWeakCharacters(properties: Array<IntArray>): Int {
    Arrays.sort(properties) { a, b -> if (b.get(0) - a.get(0) === 0) a.get(1) - b.get(1) else b.get(0) - a.get(0) }
    var ans = 0
    var mx = 0
    for (x in properties) {
      if (x[1] < mx) {
        ++ans
      }
      mx = max(mx.toDouble(), x[1].toDouble()).toInt()
    }
    return ans
  }
}
