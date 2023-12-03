internal class Solution {
  fun numSmallerByFrequency(queries: Array<String>, words: Array<String>): IntArray {
    val n = words.size
    val nums = IntArray(n)
    for (i in 0 until n) {
      nums[i] = f(words[i])
    }
    Arrays.sort(nums)
    val m = queries.size
    val ans = IntArray(m)
    for (i in 0 until m) {
      val x = f(queries[i])
      var l = 0
      var r = n
      while (l < r) {
        val mid = l + r shr 1
        if (nums[mid] > x) {
          r = mid
        } else {
          l = mid + 1
        }
      }
      ans[i] = n - l
    }
    return ans
  }

  private fun f(s: String): Int {
    val cnt = IntArray(26)
    for (i in 0 until s.length) {
      ++cnt[s[i].code - 'a'.code]
    }
    for (x in cnt) {
      if (x > 0) {
        return x
      }
    }
    return 0
  }
}
