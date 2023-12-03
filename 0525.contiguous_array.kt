internal class Solution {
  fun findMaxLength(nums: IntArray): Int {
    val mp: Map<Int, Int> = HashMap()
    mp.put(0, -1)
    var s = 0
    var ans = 0
    for (i in nums.indices) {
      s += if (nums[i] == 1) 1 else -1
      if (mp.containsKey(s)) {
        ans = Math.max(ans, i - mp[s]!!)
      } else {
        mp.put(s, i)
      }
    }
    return ans
  }
}
