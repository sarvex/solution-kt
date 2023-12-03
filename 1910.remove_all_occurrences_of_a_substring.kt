class Solution {
  fun removeOccurrences(s: String, part: String): String {
    var s = s
    while (s.contains(part)) {
      s = s.replaceFirst(part.toRegex(), "")
    }
    return s
  }
}
