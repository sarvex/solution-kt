internal class Solution {
  fun maxEnvelopes(envelopes: Array<IntArray>): Int {
    Arrays.sort(envelopes) { a, b -> if (a.get(0) === b.get(0)) b.get(1) - a.get(1) else a.get(0) - b.get(0) }
    val n = envelopes.size
    val d = IntArray(n + 1)
    d[1] = envelopes[0][1]
    var size = 1
    for (i in 1 until n) {
      val x = envelopes[i][1]
      if (x > d[size]) {
        d[++size] = x
      } else {
        var left = 1
        var right = size
        while (left < right) {
          val mid = left + right shr 1
          if (d[mid] >= x) {
            right = mid
          } else {
            left = mid + 1
          }
        }
        val p = if (d[left] >= x) left else 1
        d[p] = x
      }
    }
    return size
  }
}
