class Solution {
  fun prefixCount(words: Array<String>, pref: String?): Int {
    var ans = 0
    for (w in words) {
      if (w.startsWith(pref!!)) {
        ++ans
      }
    }
    return ans
  }
}
