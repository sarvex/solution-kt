class Solution {
  fun findLeastNumOfUniqueInts(arr: IntArray, k: Int): Int {
    var k = k
    val cnt: Map<Int, Int> = HashMap()
    for (x in arr) {
      cnt.merge(x, 1) { a: Int, b: Int -> Integer.sum(a, b) }
    }
    val nums: List<Int> = ArrayList(cnt.values())
    Collections.sort(nums)
    var i = 0
    val m: Int = nums.size()
    while (i < m) {
      k -= nums[i]
      if (k < 0) {
        return m - i
      }
      ++i
    }
    return 0
  }
}
