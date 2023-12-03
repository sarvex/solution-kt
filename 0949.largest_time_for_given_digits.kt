import kotlin.math.max

class Solution {
  fun largestTimeFromDigits(arr: IntArray): String {
    var ans = -1
    for (i in 0..3) {
      for (j in 0..3) {
        for (k in 0..3) {
          if (i != j && j != k && i != k) {
            val h = arr[i] * 10 + arr[j]
            val m = arr[k] * 10 + arr[6 - i - j - k]
            if (h < 24 && m < 60) {
              ans = max(ans.toDouble(), (h * 60 + m).toDouble()).toInt()
            }
          }
        }
      }
    }
    return if (ans < 0) "" else String.format("%02d:%02d", ans / 60, ans % 60)
  }
}
