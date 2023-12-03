import kotlin.math.max
import kotlin.math.min

internal class Solution {
  fun kConcatenationMaxSum(arr: IntArray, k: Int): Int {
    var s: Long = 0
    var mxPre: Long = 0
    var miPre: Long = 0
    var mxSub: Long = 0
    for (x in arr) {
      s += x.toLong()
      mxPre = max(mxPre.toDouble(), s.toDouble()).toLong()
      miPre = min(miPre.toDouble(), s.toDouble()).toLong()
      mxSub = max(mxSub.toDouble(), (s - miPre).toDouble()).toLong()
    }
    var ans = mxSub
    val mod = 1e9.toInt() + 7
    if (k == 1) {
      return (ans % mod).toInt()
    }
    val mxSuf = s - miPre
    ans = max(ans.toDouble(), (mxPre + mxSuf).toDouble()).toLong()
    if (s > 0) {
      ans = max(ans.toDouble(), ((k - 2) * s + mxPre + mxSuf).toDouble()).toLong()
    }
    return (ans % mod).toInt()
  }
}
