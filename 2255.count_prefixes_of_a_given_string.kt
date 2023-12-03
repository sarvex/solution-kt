class Solution {
  fun countPrefixes(words: Array<String?>, s: String): Int {
    var ans = 0
    for (w in words) {
      if (s.startsWith(w!!)) {
        ++ans
      }
    }
    return ans
  }
}
