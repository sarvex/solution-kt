class Solution {
  fun maxSum(nums: List<Int>, k: Int): Int {
    var k = k
    val mod = 1e9.toInt() + 7
    val cnt = IntArray(31)
    for (x in nums) {
      for (i in 0..30) {
        if (x shr i and 1 == 1) {
          ++cnt[i]
        }
      }
    }
    var ans: Long = 0
    while (k-- > 0) {
      var x = 0
      for (i in 0..30) {
        if (cnt[i] > 0) {
          x = x or (1 shl i)
          --cnt[i]
        }
      }
      ans = (ans + 1L * x * x) % mod
    }
    return ans.toInt()
  }
}
