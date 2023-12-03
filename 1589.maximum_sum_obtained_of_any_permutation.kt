class Solution {
  fun maxSumRangeQuery(nums: IntArray, requests: Array<IntArray>): Int {
    val n = nums.size
    val d = IntArray(n)
    for (req in requests) {
      val l = req[0]
      val r = req[1]
      d[l]++
      if (r + 1 < n) {
        d[r + 1]--
      }
    }
    for (i in 1 until n) {
      d[i] += d[i - 1]
    }
    Arrays.sort(nums)
    Arrays.sort(d)
    val mod = 1e9.toInt() + 7
    var ans: Long = 0
    for (i in 0 until n) {
      ans = (ans + 1L * nums[i] * d[i]) % mod
    }
    return ans.toInt()
  }
}
