internal class Solution {
  fun removeVowels(s: String): String {
    val ans = StringBuilder()
    for (i in 0 until s.length) {
      val c = s[i]
      if (!(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')) {
        ans.append(c)
      }
    }
    return ans.toString()
  }
}
