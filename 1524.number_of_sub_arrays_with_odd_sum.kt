class Solution {
  fun numOfSubarrays(arr: IntArray): Int {
    val mod = 1e9.toInt() + 7
    val cnt = intArrayOf(1, 0)
    var ans = 0
    var s = 0
    for (x in arr) {
      s += x
      ans = (ans + cnt[s and 1 xor 1]) % mod
      ++cnt[s and 1]
    }
    return ans
  }
}
