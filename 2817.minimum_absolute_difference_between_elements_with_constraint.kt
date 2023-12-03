class Solution {
  fun minAbsoluteDifference(nums: List<Int>, x: Int): Int {
    val tm: TreeMap<Int, Int> = TreeMap()
    var ans = 1 shl 30
    for (i in x until nums.size()) {
      tm.merge(nums[i - x], 1) { a: Int, b: Int -> Integer.sum(a, b) }
      var key: Int = tm.ceilingKey(nums[i])
      if (key != null) {
        ans = Math.min(ans, key - nums[i])
      }
      key = tm.floorKey(nums[i])
      if (key != null) {
        ans = Math.min(ans, nums[i] - key)
      }
    }
    return ans
  }
}
