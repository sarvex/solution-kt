class Solution {
  fun canConstruct(s: String, k: Int): Boolean {
    val n = s.length
    if (n < k) {
      return false
    }
    val cnt = IntArray(26)
    for (i in 0 until n) {
      ++cnt[s[i].code - 'a'.code]
    }
    var x = 0
    for (v in cnt) {
      x += v and 1
    }
    return x <= k
  }
}
