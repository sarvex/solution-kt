import kotlin.math.max

internal class Solution {
  fun rearrangeBarcodes(barcodes: IntArray): IntArray {
    val n = barcodes.size
    val t = arrayOfNulls<Int>(n)
    var mx = 0
    for (i in 0 until n) {
      t[i] = barcodes[i]
      mx = max(mx.toDouble(), barcodes[i].toDouble()).toInt()
    }
    val cnt = IntArray(mx + 1)
    for (x in barcodes) {
      ++cnt[x]
    }
    Arrays.sort(t) { a, b -> if (cnt[a] == cnt[b]) a - b else cnt[b] - cnt[a] }
    val ans = IntArray(n)
    var k = 0
    var j = 0
    while (k < 2) {
      var i = k
      while (i < n) {
        ans[i] = t[j++]!!
        i += 2
      }
      ++k
    }
    return ans
  }
}
