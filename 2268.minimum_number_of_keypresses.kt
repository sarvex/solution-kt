class Solution {
  fun minimumKeypresses(s: String): Int {
    val cnt = IntArray(26)
    for (c in s.toCharArray()) {
      ++cnt[c.code - 'a'.code]
    }
    Arrays.sort(cnt)
    var ans = 0
    var i = 1
    var j = 1
    while (i <= 26) {
      ans += j * cnt[26 - i]
      if (i % 9 == 0) {
        ++j
      }
      ++i
    }
    return ans
  }
}
