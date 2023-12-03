internal class Solution {
  fun subarraySum(nums: IntArray, k: Int): Int {
    val counter: Map<Int, Int> = HashMap()
    counter.put(0, 1)
    var ans = 0
    var s = 0
    for (num in nums) {
      s += num
      ans += counter[s - k] ?: 0
      counter.put(s, (counter[s] ?: 0) + 1)
    }
    return ans
  }
}
