import kotlin.math.max

class Solution {
  fun maxConsecutive(bottom: Int, top: Int, special: IntArray): Int {
    Arrays.sort(special)
    val n = special.size
    var ans = max((special[0] - bottom).toDouble(), (top - special[n - 1]).toDouble()).toInt()
    for (i in 1 until n) {
      ans = max(ans.toDouble(), (special[i] - special[i - 1] - 1).toDouble()).toInt()
    }
    return ans
  }
}
