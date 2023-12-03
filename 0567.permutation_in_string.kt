internal class Solution {
  fun checkInclusion(s1: String, s2: String): Boolean {
    val n = s1.length
    val m = s2.length
    if (n > m) {
      return false
    }
    val cnt = IntArray(26)
    for (i in 0 until n) {
      --cnt[s1[i].code - 'a'.code]
      ++cnt[s2[i].code - 'a'.code]
    }
    var diff = 0
    for (x in cnt) {
      if (x != 0) {
        ++diff
      }
    }
    if (diff == 0) {
      return true
    }
    for (i in n until m) {
      val a = s2[i - n].code - 'a'.code
      val b = s2[i].code - 'a'.code
      if (cnt[b] == 0) {
        ++diff
      }
      if (++cnt[b] == 0) {
        --diff
      }
      if (cnt[a] == 0) {
        ++diff
      }
      if (--cnt[a] == 0) {
        --diff
      }
      if (diff == 0) {
        return true
      }
    }
    return false
  }
}
