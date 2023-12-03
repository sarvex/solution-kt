import kotlin.math.min

internal class Solution {
  fun minTransfers(transactions: Array<IntArray>): Int {
    val g = IntArray(12)
    for (t in transactions) {
      g[t[0]] -= t[2]
      g[t[1]] += t[2]
    }
    val nums: List<Int> = ArrayList()
    for (x in g) {
      if (x != 0) {
        nums.add(x)
      }
    }
    val m: Int = nums.size()
    val f = IntArray(1 shl m)
    Arrays.fill(f, 1 shl 29)
    f[0] = 0
    for (i in 1 until (1 shl m)) {
      var s = 0
      for (j in 0 until m) {
        if (i shr j and 1 == 1) {
          s += nums[j]
        }
      }
      if (s == 0) {
        f[i] = Integer.bitCount(i) - 1
        var j = i - 1 and i
        while (j > 0) {
          f[i] = min(f[i].toDouble(), (f[j] + f[i xor j]).toDouble()).toInt()
          j = j - 1 and i
        }
      }
    }
    return f[(1 shl m) - 1]
  }
}
