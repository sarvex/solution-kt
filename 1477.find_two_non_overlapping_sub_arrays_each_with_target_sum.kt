import kotlin.math.min

class Solution {
  fun minSumOfLengths(arr: IntArray, target: Int): Int {
    val d: Map<Int, Int> = HashMap()
    d.put(0, 0)
    val n = arr.size
    val f = IntArray(n + 1)
    val inf = 1 shl 30
    f[0] = inf
    var s = 0
    var ans = inf
    for (i in 1..n) {
      val v = arr[i - 1]
      s += v
      f[i] = f[i - 1]
      if (d.containsKey(s - target)) {
        val j = d[s - target]!!
        f[i] = min(f[i].toDouble(), (i - j).toDouble()).toInt()
        ans = min(ans.toDouble(), (f[j] + i - j).toDouble()).toInt()
      }
      d.put(s, i)
    }
    return if (ans > n) -1 else ans
  }
}
