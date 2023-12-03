import kotlin.math.max

class Solution {
  fun maxJump(stones: IntArray): Int {
    var ans = stones[1] - stones[0]
    for (i in 2 until stones.size) {
      ans = max(ans.toDouble(), (stones[i] - stones[i - 2]).toDouble()).toInt()
    }
    return ans
  }
}
