import kotlin.math.max

internal class Solution {
  fun maxSumAfterPartitioning(arr: IntArray, k: Int): Int {
    val n = arr.size
    val f = IntArray(n + 1)
    for (i in 1..n) {
      var mx = 0
      for (j in i downTo (max(0.0, (i - k).toDouble()) + 1).toInt()) {
        mx = max(mx.toDouble(), arr[j - 1].toDouble()).toInt()
        f[i] = max(f[i].toDouble(), (f[j - 1] + mx * (i - j + 1)).toDouble()).toInt()
      }
    }
    return f[n]
  }
}
