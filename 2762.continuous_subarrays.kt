class Solution {
  fun continuousSubarrays(nums: IntArray): Long {
    var ans: Long = 0
    var i = 0
    val n = nums.size
    val tm: TreeMap<Int, Int> = TreeMap()
    for (j in 0 until n) {
      tm.merge(nums[j], 1) { a: Int, b: Int -> Integer.sum(a, b) }
      while (tm.lastEntry().getKey() - tm.firstEntry().getKey() > 2) {
        tm.merge(nums[i], -1) { a: Int, b: Int -> Integer.sum(a, b) }
        if (tm.get(nums[i]) === 0) {
          tm.remove(nums[i])
        }
        ++i
      }
      ans += (j - i + 1).toLong()
    }
    return ans
  }
}
