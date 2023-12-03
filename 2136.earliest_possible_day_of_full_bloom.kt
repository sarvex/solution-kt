import kotlin.math.max

internal class Solution {
  fun earliestFullBloom(plantTime: IntArray, growTime: IntArray): Int {
    val n = plantTime.size
    val idx = arrayOfNulls<Int>(n)
    for (i in 0 until n) {
      idx[i] = i
    }
    Arrays.sort(idx) { i, j -> growTime[j] - growTime[i] }
    var ans = 0
    var t = 0
    for (i in idx) {
      t += plantTime[i]
      ans = max(ans.toDouble(), (t + growTime[i]).toDouble()).toInt()
    }
    return ans
  }
}
