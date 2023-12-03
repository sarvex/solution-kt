class Solution {
  fun countCompleteSubarrays(nums: IntArray): Int {
    val d: Map<Int, Int> = HashMap()
    for (x in nums) {
      d.put(x, 1)
    }
    val cnt: Int = d.size()
    var ans = 0
    val n = nums.size
    d.clear()
    var i = 0
    var j = 0
    while (j < n) {
      d.merge(nums[j], 1) { a: Int, b: Int -> Integer.sum(a, b) }
      while (d.size() === cnt) {
        ans += n - j
        if (d.merge(nums[i], -1) { a: Int, b: Int -> Integer.sum(a, b) } === 0) {
          d.remove(nums[i])
        }
        ++i
      }
      ++j
    }
    return ans
  }
}
