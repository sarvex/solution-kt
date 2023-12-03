import java.util.Locale

class Solution {
  fun arrangeWords(text: String): String {
    val words = text.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
    words[0] = words[0].lowercase(Locale.getDefault())
    Arrays.sort(words, Comparator.comparingInt(java.lang.String::length))
    words[0] = words[0].substring(0, 1).uppercase(Locale.getDefault()) + words[0].substring(1)
    return java.lang.String.join(" ", *words)
  }
}
