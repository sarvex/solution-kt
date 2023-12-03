class Solution {
  fun minSizeSubarray(nums: IntArray, target: Int): Int {
    var target = target
    val s: Long = Arrays.stream(nums).sum()
    val n = nums.size
    var a = 0
    if (target > s) {
      a = n * (target / s.toInt())
      target -= (target / s * s).toInt()
    }
    if (target.toLong() == s) {
      return n
    }
    val pos: Map<Long, Int> = HashMap()
    pos.put(0L, -1)
    var pre: Long = 0
    var b = 1 shl 30
    for (i in 0 until n) {
      pre += nums[i].toLong()
      if (pos.containsKey(pre - target)) {
        b = Math.min(b, i - pos[pre - target]!!)
      }
      if (pos.containsKey(pre - (s - target))) {
        b = Math.min(b, n - (i - pos[pre - (s - target)]!!))
      }
      pos.put(pre, i)
    }
    return if (b == 1 shl 30) -1 else a + b
  }
}
