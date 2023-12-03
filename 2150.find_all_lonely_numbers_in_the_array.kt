internal class Solution {
  fun findLonely(nums: IntArray): List<Int> {
    val counter: Map<Int, Int> = HashMap()
    for (num in nums) {
      counter.put(num, (counter[num] ?: 0) + 1)
    }
    val ans: List<Int> = ArrayList()
    counter.forEach { (k, v) ->
      if (v === 1 && !counter.containsKey(k - 1) && !counter.containsKey(k + 1)) {
        ans.add(k)
      }
    }
    return ans
  }
}
