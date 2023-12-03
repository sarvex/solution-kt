class Solution {
  fun sumEvenAfterQueries(nums: IntArray, queries: Array<IntArray>): IntArray {
    var s = 0
    for (x in nums) {
      if (x % 2 == 0) {
        s += x
      }
    }
    val m = queries.size
    val ans = IntArray(m)
    var k = 0
    for (q in queries) {
      val v = q[0]
      val i = q[1]
      if (nums[i] % 2 == 0) {
        s -= nums[i]
      }
      nums[i] += v
      if (nums[i] % 2 == 0) {
        s += nums[i]
      }
      ans[k++] = s
    }
    return ans
  }
}
