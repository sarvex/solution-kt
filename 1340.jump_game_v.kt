import kotlin.math.max

class Solution {
  fun maxJumps(arr: IntArray, d: Int): Int {
    val n = arr.size
    val idx = arrayOfNulls<Int>(n)
    for (i in 0 until n) {
      idx[i] = i
    }
    Arrays.sort(idx) { i, j -> arr[i] - arr[j] }
    val f = IntArray(n)
    Arrays.fill(f, 1)
    var ans = 0
    for (i in idx) {
      for (j in i - 1 downTo 0) {
        if (i - j > d || arr[j] >= arr[i]) {
          break
        }
        f[i] = max(f[i].toDouble(), (1 + f[j]).toDouble()).toInt()
      }
      for (j in i + 1 until n) {
        if (j - i > d || arr[j] >= arr[i]) {
          break
        }
        f[i] = max(f[i].toDouble(), (1 + f[j]).toDouble()).toInt()
      }
      ans = max(ans.toDouble(), f[i].toDouble()).toInt()
    }
    return ans
  }
}
