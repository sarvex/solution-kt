class Solution {
  fun countExcellentPairs(nums: IntArray, k: Int): Long {
    val s: Set<Int> = HashSet()
    for (v in nums) {
      s.add(v)
    }
    var ans: Long = 0
    val cnt = IntArray(32)
    for (v in s) {
      val t = Integer.bitCount(v)
      ++cnt[t]
    }
    for (v in s) {
      val t = Integer.bitCount(v)
      for (i in 0..31) {
        if (t + i >= k) {
          ans += cnt[i].toLong()
        }
      }
    }
    return ans
  }
}
