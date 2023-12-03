internal class Solution {
  fun reverseWords(s: String): String {
    val words: List<String> = Arrays.asList(s.trim { it <= ' ' }.split("\\s+".toRegex()).dropLastWhile { it.isEmpty() }
      .toTypedArray())
    Collections.reverse(words)
    return java.lang.String.join(" ", words)
  }
}
