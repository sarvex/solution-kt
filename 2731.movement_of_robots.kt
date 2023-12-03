class Solution {
  fun sumDistance(nums: IntArray, s: String, d: Int): Int {
    val n = nums.size
    val arr = LongArray(n)
    for (i in 0 until n) {
      arr[i] = nums[i].toLong() + if (s[i] == 'L') -d else d
    }
    Arrays.sort(arr)
    var ans: Long = 0
    var sum: Long = 0
    val mod = 1e9.toInt() + 7
    for (i in 0 until n) {
      ans = (ans + i * arr[i] - sum) % mod
      sum += arr[i]
    }
    return ans.toInt()
  }
}
