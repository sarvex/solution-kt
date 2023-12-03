import java.util.regex.Pattern

internal class Solution {
  fun splitWordsBySeparator(words: List<String>, separator: Char): List<String> {
    val ans: List<String> = ArrayList()
    for (w in words) {
      for (s in w.split(Pattern.quote(separator.toString()))) {
        if (s.length() > 0) {
          ans.add(s)
        }
      }
    }
    return ans
  }
}
