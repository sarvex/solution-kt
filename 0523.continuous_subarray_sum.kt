internal class Solution {
  fun checkSubarraySum(nums: IntArray, k: Int): Boolean {
    val mp: Map<Int, Int> = HashMap()
    mp.put(0, -1)
    var s = 0
    for (i in nums.indices) {
      s += nums[i]
      val r = s % k
      if (mp.containsKey(r) && i - mp[r]!! >= 2) {
        return true
      }
      if (!mp.containsKey(r)) {
        mp.put(r, i)
      }
    }
    return false
  }
}
