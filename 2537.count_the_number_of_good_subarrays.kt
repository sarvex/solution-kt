class Solution {
  fun countGood(nums: IntArray, k: Int): Long {
    val cnt: Map<Int, Int> = HashMap()
    var ans: Long = 0
    var cur: Long = 0
    var i = 0
    for (x in nums) {
      cur += cnt[x] ?: 0
      cnt.merge(x, 1) { a: Int, b: Int -> Integer.sum(a, b) }
      while (cur - cnt[nums[i]]!! + 1 >= k) {
        cur -= cnt.merge(nums[i++], -1) { a: Int, b: Int -> Integer.sum(a, b) }
      }
      if (cur >= k) {
        ans += (i + 1).toLong()
      }
    }
    return ans
  }
}
