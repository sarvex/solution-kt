class Solution {
  fun fixedRatio(s: String, num1: Int, num2: Int): Long {
    var n0: Long = 0
    var n1: Long = 0
    var ans: Long = 0
    val cnt: Map<Long, Long> = HashMap()
    cnt.put(0L, 1L)
    for (c in s.toCharArray()) {
      n0 += (if (c == '0') 1 else 0).toLong()
      n1 += (if (c == '1') 1 else 0).toLong()
      val x = n1 * num1 - n0 * num2
      ans += cnt[x] ?: 0L
      cnt.put(x, (cnt[x] ?: 0L) + 1)
    }
    return ans
  }
}
