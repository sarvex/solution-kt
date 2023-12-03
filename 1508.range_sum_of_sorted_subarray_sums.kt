class Solution {
  fun rangeSum(nums: IntArray, n: Int, left: Int, right: Int): Int {
    val arr = IntArray(n * (n + 1) / 2)
    run {
      var i = 0
      var k = 0
      while (i < n) {
        var s = 0
        for (j in i until n) {
          s += nums[j]
          arr[k++] = s
        }
        ++i
      }
    }
    Arrays.sort(arr)
    var ans = 0
    val mod = 1e9.toInt() + 7
    for (i in left - 1 until right) {
      ans = (ans + arr[i]) % mod
    }
    return ans
  }
}
