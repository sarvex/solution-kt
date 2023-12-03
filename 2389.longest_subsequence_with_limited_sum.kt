class Solution {
  fun answerQueries(nums: IntArray, queries: IntArray): IntArray {
    Arrays.sort(nums)
    for (i in 1 until nums.size) {
      nums[i] += nums[i - 1]
    }
    val m = queries.size
    val ans = IntArray(m)
    for (i in 0 until m) {
      ans[i] = search(nums, queries[i])
    }
    return ans
  }

  private fun search(nums: IntArray, x: Int): Int {
    var l = 0
    var r = nums.size
    while (l < r) {
      val mid = l + r shr 1
      if (nums[mid] > x) {
        r = mid
      } else {
        l = mid + 1
      }
    }
    return l
  }
}
