import kotlin.math.abs

class Solution {
  fun minElements(nums: IntArray, limit: Int, goal: Int): Int {
    // long s = Arrays.stream(nums).asLongStream().sum();
    var s: Long = 0
    for (v in nums) {
      s += v.toLong()
    }
    val d = abs((s - goal).toDouble()).toLong()
    return ((d + limit - 1) / limit).toInt()
  }
}
