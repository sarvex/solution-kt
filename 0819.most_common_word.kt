import java.util.*
import java.util.regex.Matcher
import java.util.regex.Pattern

internal class Solution {
  fun mostCommonWord(paragraph: String, banned: Array<String?>): String? {
    val bannedWords: Set<String> = HashSet()
    for (word in banned) {
      bannedWords.add(word)
    }
    val counter: Map<String, Int> = HashMap()
    val matcher: Matcher = Solution.Companion.pattern.matcher(paragraph.lowercase(Locale.getDefault()))
    while (matcher.find()) {
      val word = matcher.group()
      if (bannedWords.contains(word)) {
        continue
      }
      counter.put(word, (counter[word] ?: 0) + 1)
    }
    var max = Int.MIN_VALUE
    var ans: String? = null
    for (entry in counter.entrySet()) {
      if (entry.getValue() > max) {
        max = entry.getValue()
        ans = entry.getKey()
      }
    }
    return ans
  }

  companion object {
    private val pattern = Pattern.compile("[a-z]+")
  }
}
