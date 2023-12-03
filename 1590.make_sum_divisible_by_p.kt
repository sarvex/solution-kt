class Solution {
  fun minSubarray(nums: IntArray, p: Int): Int {
    var k = 0
    for (x in nums) {
      k = (k + x) % p
    }
    if (k == 0) {
      return 0
    }
    val last: Map<Int, Int> = HashMap()
    last.put(0, -1)
    val n = nums.size
    var ans = n
    var cur = 0
    for (i in 0 until n) {
      cur = (cur + nums[i]) % p
      val target = (cur - k + p) % p
      if (last.containsKey(target)) {
        ans = Math.min(ans, i - last[target]!!)
      }
      last.put(cur, i)
    }
    return if (ans == n) -1 else ans
  }
}
