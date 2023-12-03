internal class Solution {
  fun findLHS(nums: IntArray): Int {
    val counter: Map<Int, Int> = HashMap()
    for (num in nums) {
      counter.put(num, (counter[num] ?: 0) + 1)
    }
    var ans = 0
    for (num in nums) {
      if (counter.containsKey(num + 1)) {
        ans = Math.max(ans, counter[num]!! + counter[num + 1]!!)
      }
    }
    return ans
  }
}
