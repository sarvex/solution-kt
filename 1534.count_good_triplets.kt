import kotlin.math.abs

class Solution {
  fun countGoodTriplets(arr: IntArray, a: Int, b: Int, c: Int): Int {
    val n = arr.size
    var ans = 0
    for (i in 0 until n) {
      for (j in i + 1 until n) {
        for (k in j + 1 until n) {
          if (abs((arr[i] - arr[j]).toDouble()) <= a && abs((arr[j] - arr[k]).toDouble()) <= b && abs((arr[i] - arr[k]).toDouble()) <= c) {
            ++ans
          }
        }
      }
    }
    return ans
  }
}
