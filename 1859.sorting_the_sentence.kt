class Solution {
  fun sortSentence(s: String): String {
    val words = s.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
    val ans = arrayOfNulls<String>(words.size)
    for (w in words) {
      val i = w[w.length - 1].code - '1'.code
      ans[i] = w.substring(0, w.length - 1)
    }
    return java.lang.String.join(" ", *ans)
  }
}
