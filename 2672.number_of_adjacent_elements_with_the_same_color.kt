class Solution {
  fun colorTheArray(n: Int, queries: Array<IntArray>): IntArray {
    val m = queries.size
    val nums = IntArray(n)
    val ans = IntArray(m)
    var k = 0
    var x = 0
    while (k < m) {
      val i = queries[k][0]
      val c = queries[k][1]
      if (i > 0 && nums[i] > 0 && nums[i - 1] == nums[i]) {
        --x
      }
      if (i < n - 1 && nums[i] > 0 && nums[i + 1] == nums[i]) {
        --x
      }
      if (i > 0 && nums[i - 1] == c) {
        ++x
      }
      if (i < n - 1 && nums[i + 1] == c) {
        ++x
      }
      ans[k] = x
      nums[i] = c
      ++k
    }
    return ans
  }
}
