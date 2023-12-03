class Solution {
  fun minOperations(nums: IntArray, queries: IntArray): List<Long> {
    Arrays.sort(nums)
    val n = nums.size
    val s = LongArray(n + 1)
    for (i in 0 until n) {
      s[i + 1] = s[i] + nums[i]
    }
    val ans: List<Long> = ArrayList()
    for (x in queries) {
      var i = search(nums, x + 1)
      var t = s[n] - s[i] - 1L * (n - i) * x
      i = search(nums, x)
      t += 1L * x * i - s[i]
      ans.add(t)
    }
    return ans
  }

  private fun search(nums: IntArray, x: Int): Int {
    var l = 0
    var r = nums.size
    while (l < r) {
      val mid = l + r shr 1
      if (nums[mid] >= x) {
        r = mid
      } else {
        l = mid + 1
      }
    }
    return l
  }
}
