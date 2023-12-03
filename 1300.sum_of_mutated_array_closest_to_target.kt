import kotlin.math.abs
import kotlin.math.max

class Solution {
  fun findBestValue(arr: IntArray, target: Int): Int {
    Arrays.sort(arr)
    val n = arr.size
    val s = IntArray(n + 1)
    var mx = 0
    for (i in 0 until n) {
      s[i + 1] = s[i] + arr[i]
      mx = max(mx.toDouble(), arr[i].toDouble()).toInt()
    }
    var ans = 0
    var diff = 1 shl 30
    for (value in 0..mx) {
      val i = search(arr, value)
      val d = abs((s[i] + (n - i) * value - target).toDouble()).toInt()
      if (diff > d) {
        diff = d
        ans = value
      }
    }
    return ans
  }

  private fun search(arr: IntArray, x: Int): Int {
    var left = 0
    var right = arr.size
    while (left < right) {
      val mid = left + right shr 1
      if (arr[mid] > x) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    return left
  }
}
