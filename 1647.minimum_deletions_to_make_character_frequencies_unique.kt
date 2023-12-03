class Solution {
  fun minDeletions(s: String): Int {
    val cnt = IntArray(26)
    for (i in 0 until s.length) {
      ++cnt[s[i].code - 'a'.code]
    }
    Arrays.sort(cnt)
    var ans = 0
    var pre = 1 shl 30
    for (i in 25 downTo 0) {
      val v = cnt[i]
      if (pre == 0) {
        ans += v
      } else if (v >= pre) {
        ans += v - pre + 1
        --pre
      } else {
        pre = v
      }
    }
    return ans
  }
}
