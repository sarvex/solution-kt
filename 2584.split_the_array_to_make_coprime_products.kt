import kotlin.math.max

class Solution {
  fun findValidSplit(nums: IntArray): Int {
    val first: Map<Int, Int> = HashMap()
    val n = nums.size
    val last = IntArray(n)
    for (i in 0 until n) {
      last[i] = i
    }
    for (i in 0 until n) {
      var x = nums[i]
      for (j in 2..x / j) {
        if (x % j == 0) {
          if (first.containsKey(j)) {
            last[first[j]!!] = i
          } else {
            first.put(j, i)
          }
          while (x % j == 0) {
            x /= j
          }
        }
      }
      if (x > 1) {
        if (first.containsKey(x)) {
          last[first[x]!!] = i
        } else {
          first.put(x, i)
        }
      }
    }
    var mx = last[0]
    for (i in 0 until n) {
      if (mx < i) {
        return mx
      }
      mx = max(mx.toDouble(), last[i].toDouble()).toInt()
    }
    return -1
  }
}
