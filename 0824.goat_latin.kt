internal class Solution {
  fun toGoatLatin(sentence: String): String {
    val ans: List<String> = ArrayList()
    val vowels: Set<Char> = HashSet(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'))
    var i = 1
    for (word in sentence.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()) {
      val t = StringBuilder()
      if (!vowels.contains(word[0])) {
        t.append(word.substring(1))
        t.append(word[0])
      } else {
        t.append(word)
      }
      t.append("ma")
      for (j in 0 until i) {
        t.append("a")
      }
      ++i
      ans.add(t.toString())
    }
    return java.lang.String.join(" ", ans)
  }
}
