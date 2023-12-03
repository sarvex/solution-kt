internal class Solution {
  fun uniqueMorseRepresentations(words: Array<String>): Int {
    val codes = arrayOf(
      ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....",
      "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-",
      "..-", "...-", ".--", "-..-", "-.--", "--.."
    )
    val s: Set<String> = HashSet()
    for (word in words) {
      val t = StringBuilder()
      for (c in word.toCharArray()) {
        t.append(codes[c.code - 'a'.code])
      }
      s.add(t.toString())
    }
    return s.size()
  }
}
